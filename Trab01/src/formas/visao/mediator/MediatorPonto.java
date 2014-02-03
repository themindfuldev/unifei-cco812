package formas.visao.mediator;

import componentes.modelo.formas.Ponto;

/**
 * Mediator para o dialogo de translacao.
 */
public class MediatorPonto {
	// Atributos
	private Ponto ponto;

	// Metodos
	public void setPonto(int x, int y) {
		ponto = new Ponto(x, y);
	}
	
	public Ponto getPonto()
	{
		return ponto;
	}
}
