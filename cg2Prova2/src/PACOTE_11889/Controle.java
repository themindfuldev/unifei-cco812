/**
 * Controle.java
 */
package PACOTE_11889;

import java.awt.Color;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Controle {

	private Bola bolaBranca;

	private Bola bolaPreta;

	private Painel painelSinuca;

	private Buraco buraco1;

	private Buraco buraco2;

	private Buraco buraco3;

	private Buraco buraco4;

	private Buraco buraco5;

	private Buraco buraco6;

	private Interface tela;

	private Seta seta;

	private boolean animando;

	private ThreadAnima threadAnimacao;

	/**
	 * 
	 * Método que tem por função inicializar a classe de controle
	 * 
	 */
	public void inicializa() {

		// cria a interface
		tela = new Interface(800, 600, 10, 10, "Prova CG2");
		tela.inicializa();
		tela.setControle(this);

		// cria as bolas
		bolaBranca = new Bola(new Ponto(10, 10), 10, Color.WHITE, Color.BLACK);
		bolaPreta = new Bola(new Ponto(10, 50), 10, Color.BLACK, Color.BLACK);

		painelSinuca = tela.getPainelSinuca();

		// setando as bolas
		painelSinuca.setBolaBranca(bolaBranca);
		painelSinuca.setBolaPreta(bolaPreta);

		// criando os buracos
		criaBuracos();

		// criando a seta
		criaSeta();

		// posiciona as bolas
		posicionaBolas();

		tela.requestFocus();

		animando = false;

	}

	private void criaSeta() {
		seta = new Seta(bolaBranca);
		painelSinuca.setSeta(seta);
	}

	/**
	 * 
	 * Método que tem por função criar e posicionar os buracos
	 * 
	 */
	private void criaBuracos() {
		buraco1 = new Buraco(1, 0, 40);
		painelSinuca.setBuraco1(buraco1);

		buraco2 = new Buraco(400 - 20, 0, 40);
		painelSinuca.setBuraco2(buraco2);

		buraco3 = new Buraco(800 - 50, 0, 40);
		painelSinuca.setBuraco3(buraco3);

		buraco4 = new Buraco(1, 600 - 70, 40);
		painelSinuca.setBuraco4(buraco4);

		buraco5 = new Buraco(400 - 20, 600 - 70, 40);
		painelSinuca.setBuraco5(buraco5);

		buraco6 = new Buraco(800 - 50, 600 - 70, 40);
		painelSinuca.setBuraco6(buraco6);
	}

	/**
	 * 
	 * Método que tem por função posicionar as bolinas de forma aleatória;
	 * 
	 */
	public void posicionaBolas() {
		int x, y;

		double d;

		x = (int) Math.round(Math.random() * 700.0 + 40.0);
		y = (int) Math.round(Math.random() * 480.0 + 40.0);

		Ponto pBranco = new Ponto(x, y);
		Ponto pPreto;
		bolaBranca.setCentral(pBranco);

		do {
			x = (int) Math.round(Math.random() * 700.0 + 40.0);
			y = (int) Math.round(Math.random() * 500.0 + 40.0);

			pPreto = new Ponto(x, y);

			d = distanciaPontos(pBranco, pPreto);

		} while (d < 2 * bolaBranca.getRaio());

		bolaPreta.setCentral(pPreto);

		painelSinuca.repaint();
	}

	private double distanciaPontos(Ponto p1, Ponto p2) {
		double y, x;

		x = (p2.getX() - p1.getX()) * (p2.getX() - p1.getX());
		y = (p2.getY() - p1.getY()) * (p2.getY() - p1.getY());

		return Math.sqrt(x + y);
	}

	/**
	 * 
	 * Método que tem por função setar o novo angulo da seta
	 * 
	 */
	public void diminuiAngulo() {
		int novoAngulo = seta.getAngulo() - 1;
		seta.setAngulo(novoAngulo);
		painelSinuca.repaint();
	}

	/**
	 * 
	 * Método que tem por função setar o novo angulo da seta
	 * 
	 */
	public void aumentaAngulo() {
		int novoAngulo = seta.getAngulo() + 1;
		seta.setAngulo(novoAngulo);
		painelSinuca.repaint();
	}

	public void atiraBranca() {
		if (animando == false) {
			threadAnimacao = new ThreadAnima(bolaBranca, bolaPreta, seta,
					painelSinuca, buraco1, buraco2, buraco3, buraco4, buraco5,
					buraco6);
			threadAnimacao.setControle(this);
			threadAnimacao.start();
			animando = true;
		}
	}

	/**
	 * @return Returns the animando.
	 */
	public boolean isAnimando() {
		return animando;
	}

	/**
	 * @param animando
	 *            The animando to set.
	 */
	public void setAnimando(boolean animando) {
		this.animando = animando;
	}

}
