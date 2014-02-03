package componentes.modelo.graficos;

import componentes.modelo.formas.Figura;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class GraficoDeBarra extends Figura {
	public GraficoDeBarra(int altura, int largura)
	{
		super();
		
		// Segmentos
		Ponto pontoInicial, pontoFinal;
		
		pontoInicial = new Ponto(20, 20);
		pontoFinal = new Ponto(20, 40+altura);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		
		pontoInicial = pontoFinal;
		pontoFinal = new Ponto(20+largura, 40+altura);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		
		// Setas
		pontoInicial = new Ponto(20, 20);
		pontoFinal = new Ponto(15, 25);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		pontoFinal = new Ponto(25, 25);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		
		pontoInicial = new Ponto(20+largura, 40+altura);
		pontoFinal = new Ponto(15+largura, 35+altura);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		pontoFinal = new Ponto(15+largura, 45+altura);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));

		// Marcação
		pontoInicial = new Ponto(15, 40);
		pontoFinal = new Ponto(25, 40);
		listaFormasPlotaveis.add(new Segmento(pontoInicial, pontoFinal));
		
	}

}
