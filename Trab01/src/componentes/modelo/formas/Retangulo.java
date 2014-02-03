package componentes.modelo.formas;

import componentes.modelo.sombreamento.SombreamentoBarra;

public class Retangulo extends Figura {
	private Ponto pontoInicial, pontoFinal;
	
	public Retangulo(Ponto pontoInicial, Ponto pontoFinal)
	{
		//Inicialização dos atributos
		this.pontoInicial = pontoInicial;
		this.pontoFinal = pontoFinal;
		
		preencherBorda(pontoInicial, pontoFinal);	
	}

	public Retangulo(Ponto pontoInicial, Ponto pontoFinal, boolean borda)
	{
		//Inicialização dos atributos
		this.pontoInicial = pontoInicial;
		this.pontoFinal = pontoFinal;

		if (borda)
			preencherBorda(pontoInicial, pontoFinal);	
	}
	
	public void addSombreamento(SombreamentoBarra sombreamento, int n)
	{
		sombreamento.sombrear(pontoInicial, pontoFinal, n, listaFormasPlotaveis);
	}

	public Ponto getPontoInicial() {
		return pontoInicial;
	}

	public Ponto getPontoFinal() {
		return pontoFinal;
	}
	
	private void preencherBorda(Ponto pontoInicial, Ponto pontoFinal) {
		// Declaração de variáveis
		Ponto p1, p2;
		Segmento segmento;
		
		// Criação do retângulo
		// Segmento superior
		p1 = pontoInicial;
		p2 = new Ponto(pontoFinal.getX(), pontoInicial.getY());
		segmento = new Segmento(p1, p2);
		listaFormasPlotaveis.add(segmento);
		
		// Segmento direita
		p1 = p2;
		p2 = pontoFinal;
		segmento = new Segmento(p1, p2);
		listaFormasPlotaveis.add(segmento);
		
		// Segmento inferior
		p1 = p2;
		p2 = new Ponto(pontoInicial.getX(), pontoFinal.getY());
		segmento = new Segmento(p1, p2);
		listaFormasPlotaveis.add(segmento);
		
		// Segmento esquerda
		p1 = p2;
		p2 = pontoInicial;
		segmento = new Segmento(p1, p2);
		listaFormasPlotaveis.add(segmento);
	}
	
}
