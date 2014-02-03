package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;

public class SombreamentoPontualBarra implements SombreamentoBarra {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n,
			List<FormaDesenhavel> listaFormasPlotaveis) {
		// Declaração de variáveis
		int i, x, y;
		n*=50;
		for (i = 0; i < n; i++) {
			x = (int) (Math.random() * (pontoFinal.getX()-pontoInicial.getX())) + pontoInicial.getX();
			y = (int) (Math.random() * (pontoFinal.getY()-pontoInicial.getY())) + pontoInicial.getY();
			listaFormasPlotaveis.add(new Ponto(x, y));
		}

	}
}
