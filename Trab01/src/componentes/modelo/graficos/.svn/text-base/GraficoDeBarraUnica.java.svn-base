package componentes.modelo.graficos;

import java.util.List;

import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Retangulo;
import componentes.modelo.sombreamento.SombreamentoBarra;

public class GraficoDeBarraUnica extends GraficoDeBarra {

	public GraficoDeBarraUnica(int altura, List<List<Integer>> tabelaSombreamentos,
			float[] dados) {
		super(altura, 120);
		
		// Declaração de variáveis
		int tamanhoDaBarra, yBarra, i;
		float dado;
		Retangulo barra;
		
		yBarra = 40+altura;
		for(i=0; i<5; i++)
		{
			dado = dados[i];
			if (dado < 0.0f) continue;
			
			tamanhoDaBarra = (int) Math.round(dado*altura);
			
			barra = new Retangulo(new Ponto(35, yBarra-tamanhoDaBarra), new Ponto(85, yBarra));
			
			for (Integer sombra: tabelaSombreamentos.get(i))
				barra.addSombreamento((SombreamentoBarra)ConstantesSombras.tabelaSombras.get(sombra), (int) tamanhoDaBarra/10);
			
			listaFormasPlotaveis.add(barra);
			
			yBarra -= tamanhoDaBarra;
		}
	}

}
