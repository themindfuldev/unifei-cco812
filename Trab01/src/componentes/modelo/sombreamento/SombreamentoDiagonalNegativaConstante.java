package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class SombreamentoDiagonalNegativaConstante implements SombreamentoBarra {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n,
			List<FormaDesenhavel> listaFormasPlotaveis) {
			
		int i, x1, x2, y1, y2,xPasso, yPasso;
		
		n /=2;
		
		x1 = pontoInicial.getX();
		x2 = pontoFinal.getX();
		y1 = pontoInicial.getY();
		y2 = pontoFinal.getY();
		listaFormasPlotaveis.add(new Segmento(new Ponto(x1,y1), new Ponto(x2,y2)));
		xPasso = (x2 - x1)/(n + 1);
		yPasso = (y2 - y1)/(n + 1);
		
		//triangulo inferior
		for (i = 0; i < n; i++) {
			x1 += xPasso;
			y2 -= yPasso;
			listaFormasPlotaveis.add(new Segmento(new Ponto(x1,y1), new Ponto(x2,y2)));			
		}
		
		x1 = pontoInicial.getX();
		x2 = pontoFinal.getX();
		y1 = pontoInicial.getY();
		y2 = pontoFinal.getY();
		//triangulo superior
		for (i = 1; i <= n; i++) {
			y1 += yPasso;
			x2 -= xPasso;
			listaFormasPlotaveis.add(new Segmento(new Ponto(x1,y1), new Ponto(x2,y2)));			
		}
		
	}

}
