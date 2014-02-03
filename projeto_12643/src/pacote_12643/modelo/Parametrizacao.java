package pacote_12643.modelo;

import java.awt.Point;

import pacote_12643.controle.ContextoJogo;

/**
 * Parametrização de uma fase.
 * @author Tiago
 */
public class Parametrizacao {
	/**
	 * Largura do tabuleiro.
	 */
	public static int LARGURA = 350;
	/**
	 * Altura do tabuleiro. 
	 */
	public static int ALTURA = 600;
	
	/**
	 * Nome do jogador.
	 */
	private String nomeJogador;
	/**
	 * Número de bolas.
	 */
	private int numeroBolas;
	/**
	 * Pontuação atual.
	 */
	private int pontuacao;
	/**
	 * Nível de dificuldade.
	 */
	private Nivel nivelDificuldade;
	/**
	 * Número de linhas.
	 */
	private int numeroLinhas;
	/**
	 * Pontuação necessária para passar de fase.
	 */
	private int pontuacaoNecessaria;
	/**
	 * Indicador se o modo é interativo ou demonstração.
	 */
	private boolean demo;
	
	/**
	 * Construtor.
	 * @param nomeJogador
	 * @param numeroBolas
	 * @param nivelDificuldade
	 * @param demo
	 */
	public Parametrizacao(String nomeJogador, int numeroBolas,
			Nivel nivelDificuldade, boolean demo) {
		super();
		this.nomeJogador = nomeJogador;
		this.numeroBolas = numeroBolas;
		this.nivelDificuldade = nivelDificuldade;
		this.pontuacao = 0;
		this.numeroLinhas = 4;
		this.demo = demo;
		calculaPontuacaoNecessaria();
	}
	
	// Métodos get-is
	public String getNomeJogador() {
		return nomeJogador;
	}

	public int getNumeroBolas() {
		return numeroBolas;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public Nivel getNivelDificuldade() {
		return nivelDificuldade;
	}

	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public int getPontuacaoNecessaria() {
		return pontuacaoNecessaria;
	}
	
	public boolean isDemo() {
		return demo;
	}
	
	/**
	 * Prepara para a próxima fase.
	 */
	private void proximaFase() {
		// Incrementa número de linhas e calcula pontuação necessária.
		if (numeroLinhas < 8) { 
			numeroLinhas++;
			
			calculaPontuacaoNecessaria(); 
		}
	}

	/**
	 * Calcula a pontuação necessária para passar de fase.
	 */
	private void calculaPontuacaoNecessaria() {
		pontuacaoNecessaria = 3*numeroLinhas*numeroBolas;
	}
	
	/**
	 * Prepara fim de fase.
	 * @param pontuacaoFase
	 * @return
	 */
	public boolean fimDeFase(int pontuacaoFase) {
		boolean sucesso = false;
		
		// Soma pontuação e verifica próxima fase.
		pontuacao += pontuacaoFase;
		if (pontuacaoFase >= pontuacaoNecessaria) {
			sucesso = true;
			proximaFase();
		}
			
		return sucesso;
	}

	/**
	 * Adiciona os obstáculos a um contexto.
	 * @param contexto
	 */
	public void adicionaObstaculos(ContextoJogo contexto) {
		// Declaração de variáveis
		int i, n, div, obstaculos, passo;
		Obstaculo o;
		
		obstaculos = nivelDificuldade.getPeso();
		div = LARGURA/obstaculos;

		// Para cada linha, distribui os obstáculos.
		for (n=1; n<=numeroLinhas; n++) {
			if ((n & 1) == 1) {
				passo = Bola.TAMANHO-10;
				
				// Cria obstáculos e adiciona
				o = new Obstaculo();
				o.setPosicao(new Point(0, 50*n));
				contexto.addObstaculo(o);
				
				for (i=1; i<obstaculos; i++) {
					o = new Obstaculo();
					o.setPosicao(new Point((int)(passo+i*div+variacao()), 50*n));
					contexto.addObstaculo(o);
				}
			}
			else {
				passo = Bola.TAMANHO-5;
				
				// Cria obstáculos e adiciona
				o = new Obstaculo();
				o.setPosicao(new Point(LARGURA-Bola.TAMANHO/2, 50*n));
				contexto.addObstaculo(o);
				
				for (i=1; i<obstaculos; i++) {
					o = new Obstaculo();
					o.setPosicao(new Point((int)(LARGURA-passo-i*div-variacao()), 50*n));
					contexto.addObstaculo(o);
				}
			}
		}
	}
	
	/**
	 * Retorna uma variação relativa a cada nível.
	 * @return
	 */
	private int variacao() {
		// Declaração de variáveis
		int var=0;
		
		switch (nivelDificuldade) {
		case FACIL:
			var = (int) (Math.random()*40-20);
			break;
		case MEDIO:
			var = (int) (Math.random()*30-15);
			break;
		case DIFICIL:
			var = (int) (Math.random()*20-10);
			break;
		}
		return var;
	}
	
	/**
	 * Enumera os níveis de dificuldade.
	 * @author Tiago
	 */
	public enum Nivel {
		// Constantes
		FACIL(5), MEDIO(6), DIFICIL(7);

		/**
		 * Peso de obstáculos deste nível
		 */
		private int peso;
		
		/**
		 * Construtor
		 * @param p
		 */
		private Nivel(int p) {
			peso = p;
		}

		// Método get.
		public int getPeso() {
			return peso;
		}
	}
	
}
