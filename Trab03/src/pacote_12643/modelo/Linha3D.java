package pacote_12643.modelo;

import java.awt.Graphics;
import java.awt.Point;

public class Linha3D implements Forma {
	private Point ini, fim;

	public Linha3D(Point ini, Point fim) {
		this.ini = ini;
		this.fim = fim;
	}
	
	/* (non-Javadoc)
	 * @see pacote_12643.modelo.Forma#desenhar(java.awt.Graphics)
	 */
	public void desenhar(Graphics g) {
		g.drawLine(ini.x, ini.y, fim.x, fim.y);
	}
	
}
