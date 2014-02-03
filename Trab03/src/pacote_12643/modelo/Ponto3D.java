package pacote_12643.modelo;

import java.awt.Point;

public class Ponto3D {
	private int x, y, z;
	private static double angulo = Math.toRadians(40);
	
	public Ponto3D(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
	public static double getAngulo() {
		return angulo;
	}

	public static void setAngulo(double angulo) {
		Ponto3D.angulo = angulo;
	}

	public Point traduzir() {
		int novoX;
		int novoY;
		
		novoX = x + (int) Math.round(z*Math.cos(angulo));
		novoY = y + (int) Math.round(z*Math.sin(angulo));
		
		return new Point(novoX, novoY);
	}
	
}
