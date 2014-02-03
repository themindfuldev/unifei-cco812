/**
 * Interface.java
 */
package PACOTE_11889;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 * 
 */
public class Interface extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container container;

	Painel painelSinuca;

	Controle controle;

	public Interface(int largura, int altura, int px, int py, String titulo) {
		this.setSize(largura, altura);
		this.setLocation(px, py);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(titulo);
		this.setFocusable(true);

		this.addKeyListener(this);

		container = getContentPane();
	}

	public void inicializa() {
		painelSinuca = new Painel(800, 600, 0, 0, Color.GREEN);
		container.add(painelSinuca);

		this.setVisible(true);
	}

	public Painel getPainelSinuca() {
		return this.painelSinuca;
	}

	public void keyTyped(KeyEvent evento) {
	}

	public void keyPressed(KeyEvent evento) {
		if (evento.getKeyCode() == 40) {
			controle.diminuiAngulo();
		} else if (evento.getKeyCode() == 38) {
			controle.aumentaAngulo();
		}
	}

	public void keyReleased(KeyEvent evento) {
		if (evento.getKeyCode() == 32) {
			controle.atiraBranca();
		}
	}

	/**
	 * @param controle
	 *            The controle to set.
	 */
	public void setControle(Controle controle) {
		this.controle = controle;
	}

}
