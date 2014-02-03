package componentes.modelo.formas;

public class RetanguloCelula extends Retangulo {
	private boolean interno;

	public RetanguloCelula(Ponto pontoInicial, Ponto pontoFinal) {
		super(pontoInicial, pontoFinal, false);
	}
	
	public RetanguloCelula(Ponto pontoInicial, Ponto pontoFinal, boolean borda) {
		super(pontoInicial, pontoFinal, borda);
	}

	public boolean isInterno() {
		return interno;
	}

	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	
}
