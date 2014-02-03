/**
 * TreadBola.java
 */
package PACOTE_11889;

import javax.swing.JOptionPane;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class ThreadAnima extends Thread {
	private Bola bolaBranca, bolaPreta;

	private Seta seta;

	private Painel painel;

	private Buraco buraco1;

	private Buraco buraco2;

	private Buraco buraco3;

	private Buraco buraco4;

	private Buraco buraco5;

	private Buraco buraco6;

	private Controle controle;

	private double posBrancaX;

	private double posBrancaY;

	private double dBrancaX;

	private double dBrancaY;

	private double posPretaX;

	private double posPretaY;

	private double dPretaX;

	private double dPretaY;

	private int colisoesTabela;

	private boolean colisao;

	/**
	 * Construtor da classe
	 * 
	 * @param bolaBranca
	 * @param bolaPreta
	 * @param seta
	 * @param painel
	 * @param buraco1
	 * @param buraco2
	 * @param buraco3
	 * @param buraco4
	 * @param buraco5
	 * @param buraco6
	 */
	public ThreadAnima(Bola bolaBranca, Bola bolaPreta, Seta seta,
			Painel painel, Buraco buraco1, Buraco buraco2, Buraco buraco3,
			Buraco buraco4, Buraco buraco5, Buraco buraco6) {
		this.bolaBranca = bolaBranca;
		this.bolaPreta = bolaPreta;
		this.seta = seta;
		this.painel = painel;
		this.buraco1 = buraco1;
		this.buraco2 = buraco2;
		this.buraco3 = buraco3;
		this.buraco4 = buraco4;
		this.buraco5 = buraco5;
		this.buraco6 = buraco6;

		dBrancaX = 0.0;
		dBrancaY = 0.0;

		dPretaX = 0.0;
		dPretaY = 0.0;
		colisoesTabela = 0;
		colisao = false;

	}

	public void run() {
		painel.setImprimeSeta(false);

		posBrancaX = bolaBranca.getCentral().getX();
		posBrancaY = bolaBranca.getCentral().getY();

		dBrancaX = (double) (bolaBranca.getCentral().getX() - seta.getXF())
				/ (seta.getTamanho() / 5.0);
		dBrancaY = (double) (bolaBranca.getCentral().getY() - seta.getYF())
				/ (seta.getTamanho() / 5.0);

		posPretaX = bolaPreta.getCentral().getX();
		posPretaY = bolaPreta.getCentral().getY();

		for (;;) {
			posBrancaX += dBrancaX;
			posBrancaY += dBrancaY;

			posPretaX += dPretaX;
			posPretaY += dPretaY;

			// verificaColisaoBolas
			verificaColisaoBola();
			// verificaColisaoCantos
			verificaColisaoCantos();
			if (colisoesTabela == 5) {
				painel.setImprimeSeta(true);
				controle.setAnimando(false);
				painel.repaint();
				JOptionPane.showMessageDialog(null, "Atire novamente");
				return;
			}

			// verificaColisoesBuracos
			if (verificaColisoesBuracos(buraco1)
					|| verificaColisoesBuracos(buraco2)
					|| verificaColisoesBuracos(buraco3)
					|| verificaColisoesBuracos(buraco4)
					|| verificaColisoesBuracos(buraco5)
					|| verificaColisoesBuracos(buraco6)) {
				painel.setImprimeSeta(true);
				painel.repaint();
				controle.setAnimando(false);
				controle.posicionaBolas();
				return;
			}

			bolaBranca.setCentral(new Ponto((int) Math.round(posBrancaX),
					(int) Math.round(posBrancaY)));
			bolaPreta.setCentral(new Ponto((int) Math.round(posPretaX),
					(int) Math.round(posPretaY)));
			painel.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private boolean verificaColisoesBuracos(Buraco buraco) {

		int ladoX1 = bolaPreta.getCentral().getX() - bolaPreta.getRaio();
		int ladoX2 = bolaPreta.getCentral().getX() + bolaPreta.getRaio();
		int ladoY1 = bolaPreta.getCentral().getY() - bolaPreta.getRaio();
		int ladoY2 = bolaPreta.getCentral().getY() + bolaPreta.getRaio();

		// possibilidades colisao
		if ((ladoX1 > buraco.getX())
				&& (ladoX1 < buraco.getX() + buraco.getTam())) {
			if ((ladoY1 > buraco.getY())
					&& (ladoY1 < buraco.getY() + buraco.getTam())) {
				// houve colisao
				colisao = true;
			} else if ((ladoY2 > buraco.getY())
					&& (ladoY2 < buraco.getY() + buraco.getTam())) {
				// houve colisao
				colisao = true;
			}
		} else if ((ladoX2 > buraco.getX())
				&& (ladoX2 < buraco.getX() + buraco.getTam())) {
			if ((ladoY1 > buraco.getY())
					&& (ladoY1 < buraco.getY() + buraco.getTam())) {
				// houve colisao
				colisao = true;
			} else if ((ladoY2 > buraco.getY())
					&& (ladoY2 < buraco.getY() + buraco.getTam())) {
				// houve colisao
			}
		}

		if (colisao == true) {
			dPretaX = 0;
			dPretaY = 0;
			posPretaX = -50;
			posPretaY = -50;
			bolaPreta.setCentral(new Ponto((int) Math.round(posPretaX),
					(int) Math.round(posPretaY)));
			painel.repaint();
			JOptionPane.showMessageDialog(null,
					"Parabéns, você acertou. Jogo reiniciado.");
		}
		return colisao;
	}

	private void verificaColisaoBola() {
		double dRaios;

		double dX = (posBrancaX - posPretaX) * (posBrancaX - posPretaX);
		double dY = (posBrancaY - posPretaY) * (posBrancaY - posPretaY);

		dRaios = Math.sqrt(dX + dY);

		if (dRaios < 2 * bolaBranca.getRaio()) {
			if ((dBrancaX != 0) || (dBrancaY != 0)) {

				dPretaX = (double) (bolaPreta.getCentral().getX() - bolaBranca
						.getCentral().getX())
						/ (seta.getTamanho() / 10.0);
				dPretaY = (double) (bolaPreta.getCentral().getY() - bolaBranca
						.getCentral().getY())
						/ (seta.getTamanho() / 10.0);

				dBrancaX = 0;
				dBrancaY = 0;
			} else {
				dPretaX = (double) (bolaPreta.getCentral().getX() - bolaBranca
						.getCentral().getX())
						/ (seta.getTamanho() / 10.0);
				dPretaY = (double) (bolaPreta.getCentral().getY() - bolaBranca
						.getCentral().getY())
						/ (seta.getTamanho() / 10.0);
			}
		}
	}

	private void verificaColisaoCantos() {
		if ((posBrancaX + bolaBranca.getRaio() > painel.getWidth())
				|| (posBrancaX - bolaBranca.getRaio() < 0)) {
			dBrancaX = -dBrancaX;
		}

		if ((posBrancaY + bolaBranca.getRaio() > painel.getHeight())
				|| (posBrancaY - bolaBranca.getRaio() < 0)) {
			dBrancaY = -dBrancaY;
		}

		if ((posPretaX + bolaPreta.getRaio() > painel.getWidth())
				|| (posPretaX - bolaPreta.getRaio() < 0)) {
			dPretaX = -dPretaX;
			colisoesTabela++;
		}

		if ((posPretaY + bolaPreta.getRaio() > painel.getHeight())
				|| (posPretaY - bolaPreta.getRaio() < 0)) {
			dPretaY = -dPretaY;
			colisoesTabela++;
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
	 * @return Returns the painel.
	 */
	public Painel getPainel() {
		return painel;
	}

	/**
	 * @param painel
	 *            The painel to set.
	 */
	public void setPainel(Painel painel) {
		this.painel = painel;
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
	 * @return Returns the controle.
	 */
	public Controle getControle() {
		return controle;
	}

	/**
	 * @param controle
	 *            The controle to set.
	 */
	public void setControle(Controle controle) {
		this.controle = controle;
	}

}
