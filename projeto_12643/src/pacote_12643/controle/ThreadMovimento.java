package pacote_12643.controle;

import pacote_12643.modelo.Bola;
import pacote_12643.modelo.Parametrizacao;
import pacote_12643.visao.PanelTabuleiro;

/**
 * Thread responsável pelo movimento no jogo.
 * @author Tiago
 */
public class ThreadMovimento extends Thread {
	/**
	 * Panel tabuleiro.
	 */
	private PanelTabuleiro panelTabuleiro;
	/**
	 * Indicador se o movimento deve continuar ou parar.
	 */
	private boolean continuar;
	/**
	 * Indicador se o jogo está saindo.
	 */
	private boolean sair;
	/**
	 * Indicador se o jogo está pausado.
	 */
	private boolean pausado;
	/**
	 * Indicador se o jogo foi interrompido.
	 */
	private boolean interrompido;

	/**
	 * Construtor.
	 * @param panelTabuleiro
	 */
	public ThreadMovimento(PanelTabuleiro panelTabuleiro) {
		this.panelTabuleiro = panelTabuleiro;
	}
	
	// Métodos set
	public void setContinuar(boolean continuar) {
		this.continuar = continuar;
		this.interrompido = !continuar;
	}

	public void setSair(boolean sair) {
		this.sair = sair;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		// Declaração de variáveis
		boolean movimento;
		int pontuacao = 0;
		
		continuar = true;
		interrompido = false;
		pausado = false;
		
		// Repete enquanto deve continuar.
		while (continuar) {
			movimento = false;
			
			// Espera da animação.
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			
			// Se não houverem bolas, salta.
			if (panelTabuleiro.getContexto().getListaBolas().size() == 0)
				continue;
			
			// Se não estiver pausado, incrementa cada bola.
			if (pausado == false) {
				synchronized (panelTabuleiro.getContexto()) {
					for (Bola bo: panelTabuleiro.getContexto().getListaBolas()) {
						if (bo.getY() < Parametrizacao.ALTURA-Bola.TAMANHO*2) { 
							bo.incrementarMovimento();
							movimento = true;
						}
					}
				}
				
				// Se não houver mais movimento ou bolas, pára o jogo.
				if (movimento == false && panelTabuleiro.getContexto().getListaBolas().size() == panelTabuleiro.getParametrizacao().getNumeroBolas())
					continuar = false;
				
				panelTabuleiro.repaint();
			}
		}
		
		// Se não foi interrompido, calcula pontuação.
		if (interrompido == false)
			pontuacao = panelTabuleiro.getContexto().getPontuacao();
			
		// Se não houver pontuação, sai do jogo.
		if (pontuacao == 0) {
			if (sair == false) panelTabuleiro.fimDeJogo();
			return;
		}
		
		// Termina a fase, sucedendo próxima fase ou fim de jogo.
		boolean sucesso = panelTabuleiro.getParametrizacao().fimDeFase(pontuacao);
		if (sucesso) 
			panelTabuleiro.proximaFase();
		else
			panelTabuleiro.fimDeJogo();
	}

}
