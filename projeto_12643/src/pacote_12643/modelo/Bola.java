package pacote_12643.modelo;

import static pacote_12643.modelo.Parametrizacao.LARGURA;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import pacote_12643.controle.ContextoJogo;
import pacote_12643.controle.ThreadSom;

/**
 * Elemento desenhável Bola.
 * @author Tiago
 */
public class Bola implements Desenho {
	/**
	 * Aceleração do movimento.
	 */
	private static final double ACELERACAO = 1.015;
	/**
	 * Tamanho da bola.
	 */
	public static final int TAMANHO = 20;

	/**
	 * Contexto do jogo associado.
	 */
	private ContextoJogo contexto;
	/**
	 * Velocidade instantânea.
	 */
	private double velocidade;
	/**
	 * Coeficiente de movimentação.
	 */
	private double coef;
	/**
	 * Posição em X.
	 */
	private float x;
	/**
	 * Posição em Y.
	 */
	private float y;
	/**
	 * Espaço divisório entre canaletas.
	 */
	private int div;
	/**
	 * Numero da canaleta atingida.
	 */
	private int faixa;
	/**
	 * Indicador de fim de movimento.
	 */
	private boolean fim;
	/**
	 * Raio da bola.
	 */
	private int raio = TAMANHO/2;
	/**
	 * Imagem da bola.
	 */
	private Image imagem;
	
	/**
	 * Construtor.
	 * @param contexto
	 */
	public Bola(ContextoJogo contexto) {
		velocidade = 2;
		this.contexto = contexto;
		imagem = new ImageIcon("img/bola.gif").getImage();
		faixa = 5;
	}

	// Métodos get-set
	public void setPosicao(Point posicao) {
		this.x = posicao.x;
		this.y = posicao.y;
	}
	
	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getFaixa() {
		return faixa;
	}

	public void setFaixa(int faixa) {
		this.faixa = faixa;
	}

	/* (non-Javadoc)
	 * @see pacote_12643.modelo.Desenho#desenhar(java.awt.Graphics)
	 */
	public void desenhar(Graphics g) {
		g.drawImage(imagem,(int)x-raio,(int)y-raio,null);
	}
	
	/**
	 * Incrementa o movimento da bola. 
	 */
	public void incrementarMovimento() {
		// Incrementa velocidade.
		velocidade *= ACELERACAO;
		
		// Incrementa X e Y
		incrementarX();
		y += velocidade;
		
		// Verifica colisões da nova posição.
		contexto.verificarColisoes(this);
	}

	/**
	 *  Incrementa posição em X.
	 */
	public void incrementarX() {
		// Incremento.
		x += coef;
		
		// Se houver colisão com as paredes leterais, toca som e inverte o coeficiente. 
		if (x < TAMANHO/2) {
			ThreadSom somThread = new ThreadSom("snd/obstac.wav");
			try {
				somThread.start();
			} catch (RuntimeException e) {
			}
			
			coef = -1.0/coef;
			x = TAMANHO/2;
		}
		else if (x > Parametrizacao.LARGURA-TAMANHO) {
			ThreadSom somThread = new ThreadSom("snd/obstac.wav");
			try {
				somThread.start();
			} catch (RuntimeException e) {
			}
			
			coef = -1.0/coef;
			x = Parametrizacao.LARGURA-TAMANHO;
		}
		
		// Se o Y atingir o fim do tabuleiro. 
		if (y >= 550-TAMANHO/2 && fim == false) {
			ThreadSom somThread = new ThreadSom("snd/fim.wav");
			somThread.start();
			
			// Fim do movimento.
			fim = true;
			
			// Ajusta colisões com paredes das canaletas.
			div = LARGURA/5;
			for (int i=div; i<LARGURA; i+=div)
				if (Math.abs(x-i) <= TAMANHO) {
					if (x < i) x = i-TAMANHO/2;
					else x = i+TAMANHO/2;
				}
			
			// Obtém faixa.
			faixa = (int) ((5*x)/LARGURA);
			coef = 0;
		}
	}

	/**
	 * Complementa coeficiente.
	 */
	public void complementoCoef() {
		coef = -1/coef;
	}

}