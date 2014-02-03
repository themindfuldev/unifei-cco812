package componentes.modelo.graficos;

import java.util.List;

import componentes.modelo.formas.ArcoDeCircunferencia;
import componentes.modelo.formas.Figura;
import componentes.modelo.formas.Ponto;
import componentes.modelo.sombreamento.SombreamentoPizza;

public class GraficoDePizza extends Figura {
	public GraficoDePizza(int raio, List<List<Integer>> tabelaSombreamentos,
			float[] dados) {
		// Declaração de variáveis
		int i;
		float dado;
		Ponto pontoCentral;
		ArcoDeCircunferencia arco;
		double anguloInicial, anguloFinal;
		
		anguloFinal = 0.0;
		pontoCentral = new Ponto(raio+50, raio+50);
		for(i=0; i<5; i++)
		{
			dado = dados[i];
			if (dado < 0.0f) continue;
			
			anguloInicial = anguloFinal;
			anguloFinal = anguloInicial + dado*2*Math.PI;
			
			arco = new ArcoDeCircunferencia(pontoCentral, raio, anguloInicial, anguloFinal, true);
			
			for (Integer sombra: tabelaSombreamentos.get(i))
				arco.addSombreamento((SombreamentoPizza)ConstantesSombras.tabelaSombras.get(sombra), (int) 10);
			
			listaFormasPlotaveis.add(arco);
		}
	}

}
