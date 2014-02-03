/**
 * Ponto.java
 */
package PACOTE_11889;

/**
 * @author Thiago Comicio 11889
 * @prova CG2
 *
 */
public class Ponto {
	private int x;
	
	private int y;

	/**
	 * Construtor da classe
	 * @param x
	 * @param y
	 */
	public Ponto(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto ponto){
		this.x = ponto.getX();
		this.y = ponto.getY();
	}

	/**
	 * @return Returns the x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x The x to set.
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
	 * @param y The y to set.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
}
