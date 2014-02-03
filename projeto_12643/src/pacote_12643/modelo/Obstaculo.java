package pacote_12643.modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Elemento desenhável Obstáculo.
 * @author Tiago
 */
public class Obstaculo implements Desenho{
	/**
	 * Tamanho do obstáculo.
	 */
	public static final int TAMANHO = 10;
	
	/**
	 * Posição do obstáculo.
	 */
	private Point posicao;
	/**
	 * Imagem do obstáculo.
	 */
	private Image imagem;
	/**
	 * Raio do obstáculo.
	 */
	private int raio = TAMANHO/2;
	
	/**
	 * Construtor
	 */
	public Obstaculo() {
		imagem = new ImageIcon("img/obstaculo.gif").getImage();
	}

	// Métodos get-set
	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}
	
	public float getX() {
		return posicao.x;
	}

	public float getY() {
		return posicao.y;
	}

	/* (non-Javadoc)
	 * @see pacote_12643.modelo.Desenho#desenhar(java.awt.Graphics)
	 */
	public void desenhar(Graphics g) {
		g.drawImage(imagem,(int)posicao.x-raio,(int)posicao.y-raio,null);
	}
	
}
