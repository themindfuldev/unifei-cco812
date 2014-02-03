package componentes.modelo.formas;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe que representa um ponto.
 */
public class Ponto implements FormaDesenhavel, Comparable<Ponto>
{
	/**
	 * Coordenadas x e y do ponto.
	 */
	private int x, y;
	
	// Construtores
	public Ponto(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	// Metodos
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	/**
	 * Compara dois objetos.
	 */
	public boolean equals(Object pontoObj)
	{
		boolean retorno = false;

		if (pontoObj instanceof Ponto)
		{
			// Verifica se os objetos possuem os mesmos atributos.
			Ponto ponto = (Ponto) pontoObj;
			if ((this.x == ponto.x) && (this.y == ponto.y))
				retorno = true;
		}

		return retorno;
	}

	/**
	 * Compara dois objetos mensuraveis.
	 */
	public int compareTo(Ponto ponto)
	{
		int retorno = 0;

		// Compara os objetos quanto aos atributos.
		if (this.y > ponto.y)
			retorno = 1;
		else if (this.y == ponto.y && this.x > ponto.y)
			retorno = 1;
		else if (this.y == ponto.y && this.x == ponto.x)
			retorno = 0;
		else
			retorno = -1;
		
		return retorno;
	}

	public void desenhar(Graphics desenho, Color cor)
	{
		desenho.setColor(cor);
		desenho.drawLine(x, y, x, y);
	}

}
