package pacote_12643.visao.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import pacote_12643.modelo.Forma;

/**
 * Panel para o desenho das formas desenháveis desejadas.
 */
@SuppressWarnings("serial")
public class PanelDesenho extends JPanel {
	// Atributos
	/**
	 * Cor que o desenho sera pintado.
	 */
	private Color cor;

	// Relacionamentos
	/**
	 * Lista de Formas Desenhaveis a ser desenhada em cada chamada do metodo
	 * paint().
	 */
	private List<Forma> listaDesenhavel;

	// Construtor
	public PanelDesenho() {
		listaDesenhavel = new ArrayList<Forma>();
		cor = Color.BLACK;

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.WHITE);
	}

	// Metodos
	/**
	 * Limpa a lista existente.
	 */
	public void limpar() {
		listaDesenhavel.clear();
	}

	/**
	 * Adiciona uma forma desenhavel a lista.
	 * 
	 * @param forma
	 *            Forma desenhavel a ser adicionada.
	 */
	public void adicionarFormaDesenhavel(Forma forma) {
		listaDesenhavel.add(forma);
	}

	/**
	 * Adiciona uma lista de formas desenhaveis a lista.
	 * 
	 * @param lista
	 *            Lista de formas desenhaveis a ser adicionada.
	 */
	public void adicionarListaDeFormaDesenhavel(
			Collection<? extends Forma> lista) {
		listaDesenhavel.addAll(lista);
	}

	/**
	 * Executa os procedimentos de desenho deste componente.
	 */
	public void paint(Graphics desenho) {
		super.paint(desenho);
		
		desenho.setColor(cor);

		// Percorre a lista de formas desenhaveis.
		for (Forma forma : listaDesenhavel)
			forma.desenhar(desenho);
	}

	/**
	 * Executa um procedimento de alterar a cor de todas as formas desenhaveis.
	 * 
	 * @param cor
	 *            Cor a ser assumida.
	 */
	public void mudarCor(Color cor) {
		// Percorre a lista de formas desenhaveis.
		this.cor = cor;

		// Redesenha.
		repaint();
	}

}
