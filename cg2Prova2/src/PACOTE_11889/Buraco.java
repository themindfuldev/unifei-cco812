/**
 * Buraco.java
 */
package PACOTE_11889;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Buraco {
	private int x;

	private int y;

	private int tam;

	/**
	 * Construtor da classe
	 * 
	 * @param x
	 * @param y
	 * @param tam
	 */
	public Buraco(int x, int y, int tam) {
		this.x = x;
		this.y = y;
		this.tam = tam;
	}

	public void imprimeBuraco(Graphics desenho) {
		desenho.setColor(Color.BLACK);
		desenho.fillRect(x, y, tam, tam);
	}

	/**
	 * @return Returns the tam.
	 */
	public int getTam() {
		return tam;
	}

	/**
	 * @param tam
	 *            The tam to set.
	 */
	public void setTam(int tam) {
		this.tam = tam;
	}

	/**
	 * @return Returns the x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            The x to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Returns the y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            The y to set.
	 */
	public void setY(int y) {
		this.y = y;
	}

}
