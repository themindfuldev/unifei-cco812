package pacote_12643.modelo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Elemento desenh�vel Obst�culo.
 * @author Tiago
 */
public class Obstaculo implements Desenho{
	/**
	 * Tamanho do obst�culo.
	 */
	public static final int TAMANHO = 10;
	
	/**
	 * Posi��o do obst�culo.
	 */
	private Point posicao;
	/**
	 * Imagem do obst�culo.
	 */
	private Image imagem;
	/**
	 * Raio do obst�culo.
	 */
	private int raio = TAMANHO/2;
	
	/**
	 * Construtor
	 */
	public Obstaculo() {
		imagem = new ImageIcon("img/obstaculo.gif").getImage();
	}

	// M�todos get-set
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
