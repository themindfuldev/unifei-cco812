/**
 * Bola.java
 */
package PACOTE_11889;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Bola {

	private Ponto central;

	private int raio;

	private Color cInterior;

	private Color cExterior;

	/**
	 * Construtor da classe
	 * 
	 * @param central
	 * @param raio
	 * @param interior
	 * @param exterior
	 */
	public Bola(Ponto central, int raio, Color interior, Color exterior) {
		// TODO Auto-generated constructor stub
		this.central = central;
		this.raio = raio;
		cInterior = interior;
		cExterior = exterior;
	}

	public void imprimeBola(Graphics desenho) {
		// pinta o preenchimento
		desenho.setColor(cInterior);
		desenho.fillOval(central.getX() - raio, central.getY() - raio,
				raio * 2, raio * 2);

		// pinta a linha exterior
		desenho.setColor(cExterior);
		desenho.drawOval(central.getX() - raio, central.getY() - raio,
				raio * 2, raio * 2);
	}

	/**
	 * @return Returns the central.
	 */
	public Ponto getCentral() {
		return central;
	}

	/**
	 * @param central
	 *            The central to set.
	 */
	public void setCentral(Ponto central) {
		this.central = central;
	}

	/**
	 * @return Returns the cExterior.
	 */
	public Color getCExterior() {
		return cExterior;
	}

	/**
	 * @param exterior
	 *            The cExterior to set.
	 */
	public void setCExterior(Color exterior) {
		cExterior = exterior;
	}

	/**
	 * @return Returns the cInterior.
	 */
	public Color getCInterior() {
		return cInterior;
	}

	/**
	 * @param interior
	 *            The cInterior to set.
	 */
	public void setCInterior(Color interior) {
		cInterior = interior;
	}

	/**
	 * @return Returns the raio.
	 */
	public int getRaio() {
		return raio;
	}

	/**
	 * @param raio
	 *            The raio to set.
	 */
	public void setRaio(int raio) {
		this.raio = raio;
	}

}
