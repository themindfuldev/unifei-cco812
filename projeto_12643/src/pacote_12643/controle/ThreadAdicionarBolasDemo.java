package pacote_12643.controle;

import java.awt.Point;

import pacote_12643.modelo.Bola;
import pacote_12643.modelo.Parametrizacao;

/**
 * Thread para adicionar bolas no modo Demonstração.
 * @author Tiago
 */
public class ThreadAdicionarBolasDemo extends Thread {
	/**
	 * Contexto da fase.
	 */
	private ContextoJogo contexto;
	/**
	 * Parametrização da fase.
	 */
	private Parametrizacao parametrizacao;

	/**
	 * Construtor.
	 * @param contexto
	 * @param parametrizacao
	 */
	public ThreadAdicionarBolasDemo(ContextoJogo contexto, Parametrizacao parametrizacao) {
		this.contexto = contexto;
		this.parametrizacao = parametrizacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		// Declaração de variáveis
		int contador, x;
		int bolas = parametrizacao.getNumeroBolas();
		boolean ladoInsercao = false;
		
		// Adiciona cada bola.
		for (contador=0; contador<bolas; contador++) {
			// Espera entre bolas.
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
			}
			
			// Randomiza posição X da bola.
			x = (int) (Math.random()*(Parametrizacao.LARGURA-50)/2 + 10);
			if (ladoInsercao) 
				x += (Parametrizacao.LARGURA-50)/2;
			
			// Cria a bola e insere no contexto.
			Bola b = new Bola(contexto);
			b.setPosicao(new Point(x, 10));
			b.setCoef(0);
			contexto.addBola(b);
			
			// Inverte o lado.
			ladoInsercao = !ladoInsercao;
		}
	}

}
