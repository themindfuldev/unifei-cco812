package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class SombreamentoVerticalConstante implements SombreamentoBarra {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n,
			List<FormaDesenhavel> listaFormasPlotaveis) {
		//Declaração de variáveis
		int xPasso, x;
		
		xPasso = (int)(pontoFinal.getX()-pontoInicial.getX())/(n+1);
		x = pontoInicial.getX() + xPasso;

		while (x < pontoFinal.getX())
		{
			listaFormasPlotaveis.add(new Segmento(new Ponto(x, pontoInicial.getY()), new Ponto(x, pontoFinal.getY())));
			x += xPasso;
		}
		
	}
}
