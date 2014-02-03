/**
 * Painel.java
 */
package PACOTE_11889;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Painel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int largura;

	private int altura;

	private int px;

	private int py;

	private Color corFundo;

	private Bola bolaBranca;

	private Bola bolaPreta;

	private Seta seta;

	private Buraco buraco1;

	private Buraco buraco2;

	private Buraco buraco3;

	private Buraco buraco4;

	private Buraco buraco5;

	private Buraco buraco6;

	private boolean imprimeSeta;

	/**
	 * Construtor da classe
	 * 
	 * @param arg0
	 * @param arg1
	 * @param largura
	 * @param altura
	 * @param px
	 * @param py
	 * @param corFundo
	 */
	public Painel(int largura, int altura, int px, int py, Color corFundo) {
		this.largura = largura;
		this.altura = altura;
		this.px = px;
		this.py = py;
		this.corFundo = corFundo;
		imprimeSeta = true;

		this.setPreferredSize(new Dimension(largura, altura));
		this.setBackground(corFundo);
		this.setLocation(px, py);
	}

	public void paint(Graphics desenho) {

		super.paint(desenho);

		if ((seta != null) && (imprimeSeta)) {
			seta.imprimeSeta(desenho);
		}

		if (buraco1 != null) {
			buraco1.imprimeBuraco(desenho);
		}

		if (buraco2 != null) {
			buraco2.imprimeBuraco(desenho);
		}

		if (buraco3 != null) {
			buraco3.imprimeBuraco(desenho);
		}

		if (buraco4 != null) {
			buraco4.imprimeBuraco(desenho);
		}

		if (buraco5 != null) {
			buraco5.imprimeBuraco(desenho);
		}

		if (buraco6 != null) {
			buraco6.imprimeBuraco(desenho);
		}

		if (bolaBranca != null) {
			bolaBranca.imprimeBola(desenho);
		}

		if (bolaPreta != null) {
			bolaPreta.imprimeBola(desenho);
		}

	}

	/**
	 * @return Returns the altura.
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura
	 *            The altura to set.
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return Returns the corFundo.
	 */
	public Color getCorFundo() {
		return corFundo;
	}

	/**
	 * @param corFundo
	 *            The corFundo to set.
	 */
	public void setCorFundo(Color corFundo) {
		this.corFundo = corFundo;
	}

	/**
	 * @return Returns the largura.
	 */
	public int getLargura() {
		return largura;
	}

	/**
	 * @param largura
	 *            The largura to set.
	 */
	public void setLargura(int largura) {
		this.largura = largura;
	}

	/**
	 * @return Returns the px.
	 */
	public int getPx() {
		return px;
	}

	/**
	 * @param px
	 *            The px to set.
	 */
	public void setPx(int px) {
		this.px = px;
	}

	/**
	 * @return Returns the py.
	 */
	public int getPy() {
		return py;
	}

	/**
	 * @param py
	 *            The py to set.
	 */
	public void setPy(int py) {
		this.py = py;
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
	 * @return Returns the bolaPreta.
	 */
	public Bola getBolaPreta() {
		return bolaPreta;
	}

	/**
	 * @param bolaPreta
	 *            The bolaPreta to set.
	 */
	public void setBolaPreta(Bola bolaPreta) {
		this.bolaPreta = bolaPreta;
	}

	/**
	 * @return Returns the buraco1.
	 */
	public Buraco getBuraco1() {
		return buraco1;
	}

	/**
	 * @param buraco1
	 *            The buraco1 to set.
	 */
	public void setBuraco1(Buraco buraco1) {
		this.buraco1 = buraco1;
	}

	/**
	 * @return Returns the buraco2.
	 */
	public Buraco getBuraco2() {
		return buraco2;
	}

	/**
	 * @param buraco2
	 *            The buraco2 to set.
	 */
	public void setBuraco2(Buraco buraco2) {
		this.buraco2 = buraco2;
	}

	/**
	 * @return Returns the buraco3.
	 */
	public Buraco getBuraco3() {
		return buraco3;
	}

	/**
	 * @param buraco3
	 *            The buraco3 to set.
	 */
	public void setBuraco3(Buraco buraco3) {
		this.buraco3 = buraco3;
	}

	/**
	 * @return Returns the buraco4.
	 */
	public Buraco getBuraco4() {
		return buraco4;
	}

	/**
	 * @param buraco4
	 *            The buraco4 to set.
	 */
	public void setBuraco4(Buraco buraco4) {
		this.buraco4 = buraco4;
	}

	/**
	 * @return Returns the buraco5.
	 */
	public Buraco getBuraco5() {
		return buraco5;
	}

	/**
	 * @param buraco5
	 *            The buraco5 to set.
	 */
	public void setBuraco5(Buraco buraco5) {
		this.buraco5 = buraco5;
	}

	/**
	 * @return Returns the buraco6.
	 */
	public Buraco getBuraco6() {
		return buraco6;
	}

	/**
	 * @param buraco6
	 *            The buraco6 to set.
	 */
	public void setBuraco6(Buraco buraco6) {
		this.buraco6 = buraco6;
	}

	/**
	 * @return Returns the seta.
	 */
	public Seta getSeta() {
		return seta;
	}

	/**
	 * @param seta
	 *            The seta to set.
	 */
	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	/**
	 * @return Returns the imprimeSeta.
	 */
	public boolean isImprimeSeta() {
		return imprimeSeta;
	}

	/**
	 * @param imprimeSeta
	 *            The imprimeSeta to set.
	 */
	public void setImprimeSeta(boolean imprimeSeta) {
		this.imprimeSeta = imprimeSeta;
	}

}
