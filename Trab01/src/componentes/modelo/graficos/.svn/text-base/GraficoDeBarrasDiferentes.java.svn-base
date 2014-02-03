package componentes.modelo.graficos;

import java.util.List;

import javax.swing.JOptionPane;

import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Retangulo;
import componentes.modelo.sombreamento.SombreamentoBarra;

public class GraficoDeBarrasDiferentes extends GraficoDeBarra {

	public GraficoDeBarrasDiferentes(int altura, List<List<Integer>> tabelaSombreamentos,
			float[] dados) {
		super(altura, obterTamanho(dados));
		
		// Declaração de variáveis
		int tamanhoDaBarra, xBarra, i;
		float dado;
		Retangulo barra;
		
		xBarra = 60;
		for(i=0; i<5; i++)
		{
			dado = dados[i];
			if (dado < 0.0f) continue;
			
			tamanhoDaBarra = (int) Math.round(dado*altura);
			
			barra = new Retangulo(new Ponto(xBarra, 40+altura-tamanhoDaBarra), new Ponto(xBarra+50, 40+altura));
			
			if(tamanhoDaBarra!=0){
				for (Integer sombra: tabelaSombreamentos.get(i))
					barra.addSombreamento((SombreamentoBarra)ConstantesSombras.tabelaSombras.get(sombra), (int) tamanhoDaBarra/10);
			}
			else
				JOptionPane.showMessageDialog(null,"A porcentagem da esparsidade é igual a zero!", "Valor de esparsidade nulo",JOptionPane.WARNING_MESSAGE);
			listaFormasPlotaveis.add(barra);
			
			xBarra += 120;
		}
	}

	private static int obterTamanho(float[] dados) {
		int contador = 0;
		
		for(float dado: dados)
			if (dado >= 0.0f)
				contador++;
		
		return contador*120;
	}

}
