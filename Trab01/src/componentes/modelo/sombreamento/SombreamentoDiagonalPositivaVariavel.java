package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class SombreamentoDiagonalPositivaVariavel implements SombreamentoBarra {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n,
			List<FormaDesenhavel> listaFormasPlotaveis) {
			
		int i, x1, x2, y1, y2,xPasso, yPasso;
		
		n /=2;
		
		if (n == 0) n++;
		
		x1 = pontoFinal.getX();
		x2 = pontoInicial.getX();		
		y1 = pontoInicial.getY();
		y2 = pontoFinal.getY();
		
		xPasso = (x2 -  x1)/(n + 1);
		yPasso = (y2 -  y1)/(n + 1);
		
		//triangulo inferior
		for (i = 0; i <= n; i++) {
			x1 += xPasso*2*i/n;
			y2 -= yPasso*2*i/n;
			listaFormasPlotaveis.add(new Segmento(new Ponto(x1,y1), new Ponto(x2,y2)));			
		}
		
		x1 = pontoFinal.getX();
		x2 = pontoInicial.getX();		
		y1 = pontoInicial.getY();
		y2 = pontoFinal.getY();
		//triangulo superior
		for (i = 1; i <= n; i++) {
			y1 += yPasso*2*i/n;
			x2 -= xPasso*2*i/n;
			listaFormasPlotaveis.add(new Segmento(new Ponto(x1,y1), new Ponto(x2,y2)));			
		}
		
	
	}
}
