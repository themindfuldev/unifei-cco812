package componentes.modelo.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma figura como um conjunto de formas desenháveis.
 */
public class Figura implements FormaDesenhavel
{
	/**
	 * Conjunto de segmentos.
	 */
	protected List<FormaDesenhavel> listaFormasPlotaveis;

	// Construtor
	public Figura()
	{
		listaFormasPlotaveis = new ArrayList<FormaDesenhavel>();
	}

	// Metodos
	/**
	 * Adiciona um novo segmento ao conjunto.
	 */
	public boolean add(FormaPlotavel forma)
	{
		return listaFormasPlotaveis.add(forma);
	}

	/**
	 * @return O conjunto de segmentos.
	 */
	public List<FormaDesenhavel> getFormas()
	{
		return listaFormasPlotaveis;
	}

	public void desenhar(Graphics desenho, Color cor)
	{
		for (FormaDesenhavel forma : listaFormasPlotaveis)
			forma.desenhar(desenho, cor);
	}

}
