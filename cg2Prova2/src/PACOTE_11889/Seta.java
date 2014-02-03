/**
 * Seta.java
 */
package PACOTE_11889;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Seta {
	private Bola bolaBranca;

	private int tamanho;

	private int angulo;

	private int xF;

	private int yF;

	/**
	 * Construtor da classe
	 * 
	 * @param centralBranco
	 */
	public Seta(Bola bolaBranca) {
		this.bolaBranca = bolaBranca;
		this.tamanho = 50;
		this.angulo = 0;
	}

	public void imprimeSeta(Graphics desenho) {

		desenho.setColor(Color.RED);
		xF = (int) Math.round(tamanho * Math.cos(Math.toRadians(angulo)));
		yF = (int) Math.round(-tamanho * Math.sin(Math.toRadians(angulo)));

		xF = bolaBranca.getCentral().getX() + xF;
		yF = bolaBranca.getCentral().getY() + yF;

		desenho.drawLine(bolaBranca.getCentral().getX(), bolaBranca
				.getCentral().getY(), xF, yF);
	}

	/**
	 * @return Returns the angulo.
	 */
	public int getAngulo() {
		return angulo;
	}

	/**
	 * @param angulo
	 *            The angulo to set.
	 */
	public void setAngulo(int angulo) {
		if (angulo >= 360) {
			this.angulo = angulo - 360;
		} else if (angulo <= 0) {
			this.angulo = angulo + 360;
		} else {
			this.angulo = angulo;
		}
	}

	/**
	 * @return Returns the bolaBranca.
	 */
	public Bola getBolaBranca() {
		return bolaBranca;
	}

	/**
	 * @param bolaBranca
	 *            The bolaBranca to set.
	 */
	public void setBolaBranca(Bola bolaBranca) {
		this.bolaBranca = bolaBranca;
	}

	/**
	 * @return Returns the tamanho.
	 */
	public int getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho
	 *            The tamanho to set.
	 */
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * @return Returns the xF.
	 */
	public int getXF() {
		return xF;
	}

	/**
	 * @param xf The xF to set.
	 */
	public void setXF(int xf) {
		xF = xf;
	}

	/**
	 * @return Returns the yF.
	 */
	public int getYF() {
		return yF;
	}

	/**
	 * @param yf The yF to set.
	 */
	public void setYF(int yf) {
		yF = yf;
	}

}
