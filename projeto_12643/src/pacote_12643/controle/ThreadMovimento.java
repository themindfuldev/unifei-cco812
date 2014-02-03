package pacote_12643.controle;

import pacote_12643.modelo.Bola;
import pacote_12643.modelo.Parametrizacao;
import pacote_12643.visao.PanelTabuleiro;

/**
 * Thread respons�vel pelo movimento no jogo.
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
	 * Indicador se o jogo est� saindo.
	 */
	private boolean sair;
	/**
	 * Indicador se o jogo est� pausado.
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
	
	// M�todos set
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
		// Declara��o de vari�veis
		boolean movimento;
		int pontuacao = 0;
		
		continuar = true;
		interrompido = false;
		pausado = false;
		
		// Repete enquanto deve continuar.
		while (continuar) {
			movimento = false;
			
			// Espera da anima��o.
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			
			// Se n�o houverem bolas, salta.
			if (panelTabuleiro.getContexto().getListaBolas().size() == 0)
				continue;
			
			// Se n�o estiver pausado, incrementa cada bola.
			if (pausado == false) {
				synchronized (panelTabuleiro.getContexto()) {
					for (Bola bo: panelTabuleiro.getContexto().getListaBolas()) {
						if (bo.getY() < Parametrizacao.ALTURA-Bola.TAMANHO*2) { 
							bo.incrementarMovimento();
							movimento = true;
						}
					}
				}
				
				// Se n�o houver mais movimento ou bolas, p�ra o jogo.
				if (movimento == false && panelTabuleiro.getContexto().getListaBolas().size() == panelTabuleiro.getParametrizacao().getNumeroBolas())
					continuar = false;
				
				panelTabuleiro.repaint();
			}
		}
		
		// Se n�o foi interrompido, calcula pontua��o.
		if (interrompido == false)
			pontuacao = panelTabuleiro.getContexto().getPontuacao();
			
		// Se n�o houver pontua��o, sai do jogo.
		if (pontuacao == 0) {
			if (sair == false) panelTabuleiro.fimDeJogo();
			return;
		}
		
		// Termina a fase, sucedendo pr�xima fase ou fim de jogo.
		boolean sucesso = panelTabuleiro.getParametrizacao().fimDeFase(pontuacao);
		if (sucesso) 
			panelTabuleiro.proximaFase();
		else
			panelTabuleiro.fimDeJogo();
	}

}
