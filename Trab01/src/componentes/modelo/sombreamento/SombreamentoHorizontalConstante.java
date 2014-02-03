package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class SombreamentoHorizontalConstante implements SombreamentoBarra {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n,
			List<FormaDesenhavel> listaFormasPlotaveis) {
		// Declaração de variáveis
		int yPasso, y;
		
		yPasso = (int)(pontoFinal.getY()-pontoInicial.getY())/(n+1);
		y = pontoInicial.getY() + yPasso;

		while (y < pontoFinal.getY())
		{
			listaFormasPlotaveis.add(new Segmento(new Ponto(pontoInicial.getX(), y), new Ponto(pontoFinal.getX(), y)));
			y += yPasso;
		}
	}
}
