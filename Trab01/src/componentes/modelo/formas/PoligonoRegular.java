package componentes.modelo.formas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import componentes.modelo.sombreamento.SombreamentoBarra;

public class PoligonoRegular extends Figura {
	private List<Ponto> listaVertices;
	private Retangulo retanguloExterno;
	private RetanguloCelula[][] grade;
	private int tamanhoCelula;
	
	public PoligonoRegular(List<Ponto>listaVertices, int tamanhoCelula) {
		this.listaVertices = listaVertices;
		this.tamanhoCelula = tamanhoCelula;
		
		constroiRetanguloExterno();
		preencheCelulas();
	}

	private void preencheCelulas() {
		// Declaração de variáveis
		List<Segmento> listaArestas;
		int dimensaoX, dimensaoY, i, j, k;
		int[] contadorIntersecoes;
		Ponto pontoCentral;
		Segmento segmentoIntersecao;
		boolean isInterno;
		
		// Constroi arestas
		listaArestas = new ArrayList<Segmento>();
		for (i=0; i<listaVertices.size()-1; i++)
			listaArestas.add(new Segmento(listaVertices.get(i), listaVertices.get(i+1)));
		listaArestas.add(new Segmento(listaVertices.get(listaVertices.size()-1), listaVertices.get(0)));
		
		// Constroi grade
		dimensaoX = (retanguloExterno.getPontoFinal().getX()-retanguloExterno.getPontoInicial().getX())/tamanhoCelula;
		dimensaoY = (retanguloExterno.getPontoFinal().getY()-retanguloExterno.getPontoInicial().getY())/tamanhoCelula;
		grade = new RetanguloCelula[dimensaoY][dimensaoX];
		
		for (i=0; i<dimensaoY; i++)
		{
			grade[i] = new RetanguloCelula[dimensaoX];
			for (j=0; j<dimensaoX; j++)
			{
				grade[i][j] = new RetanguloCelula(
						new Ponto(retanguloExterno.getPontoInicial().getY()+j*tamanhoCelula, retanguloExterno.getPontoInicial().getX()+i*tamanhoCelula), 
						new Ponto(retanguloExterno.getPontoInicial().getY()+(j+1)*tamanhoCelula, retanguloExterno.getPontoInicial().getX()+(i+1)*tamanhoCelula));
				pontoCentral = new Ponto((grade[i][j].getPontoInicial().getX()+grade[i][j].getPontoFinal().getX())/2,
						(grade[i][j].getPontoInicial().getY()+grade[i][j].getPontoFinal().getY())/2);
				
				// Verificar interseções
				contadorIntersecoes = new int[4];

				// Superior
				segmentoIntersecao = new Segmento(pontoCentral, new Ponto(pontoCentral.getX(), retanguloExterno.getPontoInicial().getY()));
				contadorIntersecoes[0] = 0;
				for (Segmento aresta: listaArestas)
					if (Segmento.haIntersecao(segmentoIntersecao, aresta))
						contadorIntersecoes[0]++;
				
				// Inferior
				segmentoIntersecao = new Segmento(pontoCentral, new Ponto(pontoCentral.getX(), retanguloExterno.getPontoFinal().getY()));
				contadorIntersecoes[1] = 0;
				for (Segmento aresta: listaArestas)
					if (Segmento.haIntersecao(segmentoIntersecao, aresta))
						contadorIntersecoes[1]++;

				// Esquerdo
				segmentoIntersecao = new Segmento(pontoCentral, new Ponto(retanguloExterno.getPontoInicial().getX(), pontoCentral.getY()));
				contadorIntersecoes[2] = 0;
				for (Segmento aresta: listaArestas)
					if (Segmento.haIntersecao(segmentoIntersecao, aresta))
						contadorIntersecoes[2]++;

				// Direito
				segmentoIntersecao = new Segmento(pontoCentral, new Ponto(retanguloExterno.getPontoFinal().getX(), pontoCentral.getY()));
				contadorIntersecoes[3] = 0;
				for (Segmento aresta: listaArestas)
					if (Segmento.haIntersecao(segmentoIntersecao, aresta))
						contadorIntersecoes[3]++;
				
				isInterno = true;
				for (k=0; k<4; k++)
					isInterno &= (contadorIntersecoes[k]%2 == 1);
				
				grade[i][j].setInterno(isInterno);
			}
		}
		
	}

	private void constroiRetanguloExterno() {
		// Declaração de variáveis
		int xMin, xMax, yMin, yMax;
		Dimension d;
		
		// Obtenção do retângulo externo
		d = Toolkit.getDefaultToolkit().getScreenSize();
		xMax=0;
		yMax=0;
		xMin=d.width;
		yMin=d.height;
		
		for (Ponto ponto: listaVertices)
		{
			if (ponto.getX() < xMin)
				xMin = ponto.getX();
			else if (ponto.getX() > xMax)
				xMax = ponto.getX();
			
			if (ponto.getY() < yMin)
				yMin = ponto.getY();
			else if (ponto.getY() > yMax)
				yMax = ponto.getY();

		}

		// Ajusta pontos para caber na grade
		while ((xMax-xMin)%tamanhoCelula != 0)
			xMax++;
		while ((yMax-yMin)%tamanhoCelula != 0)
			yMax++;
		
		retanguloExterno = new Retangulo(new Ponto(xMin, yMin), new Ponto(xMax, yMax), false);
	}
	
	public void addSombreamento(SombreamentoBarra sombreamento, int n)
	{
		int i, j;
		
		for (i=0; i<grade.length; i++)
		{
			for (j=0; j<grade[i].length; j++)
			{
				if (grade[i][j].isInterno())
					sombreamento.sombrear(grade[i][j].getPontoInicial(), grade[i][j].getPontoFinal(), n, listaFormasPlotaveis);			
			}
		}
	}
	
}
