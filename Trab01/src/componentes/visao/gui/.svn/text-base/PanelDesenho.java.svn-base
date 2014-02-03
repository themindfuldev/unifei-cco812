package componentes.visao.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.FormaPlotavel;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Retangulo;

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
	private List<FormaDesenhavel> listaDesenhavel;

	// Construtor
	public PanelDesenho() {
		listaDesenhavel = new ArrayList<FormaDesenhavel>();
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
	public void adicionarFormaDesenhavel(FormaDesenhavel forma) {
		listaDesenhavel.add(forma);
	}

	/**
	 * Adiciona uma lista de formas desenhaveis a lista.
	 * 
	 * @param lista
	 *            Lista de formas desenhaveis a ser adicionada.
	 */
	public void adicionarListaDeFormaDesenhavel(
			Collection<? extends FormaDesenhavel> lista) {
		listaDesenhavel.addAll(lista);
	}

	/**
	 * Executa os procedimentos de desenho deste componente.
	 */
	public void paint(Graphics desenho) {
		super.paint(desenho);
		//desenho.clearRect(0, 0, this.getWidth(), this.getHeight());

		// Percorre a lista de formas desenhaveis.
		for (FormaDesenhavel forma : listaDesenhavel)
			forma.desenhar(desenho, cor);
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

	public void verificarFuro(Retangulo retangulo) {
		List<Ponto> listaFurada;
		FormaPlotavel formaPlotavel;
		
		for (FormaDesenhavel forma : listaDesenhavel) {
			if (forma instanceof Retangulo) {
				for (FormaDesenhavel formaDesenhavel: ((Retangulo) forma).getFormas()) {
					if (formaDesenhavel instanceof FormaPlotavel) {
						listaFurada = new ArrayList<Ponto>();
						formaPlotavel = (FormaPlotavel)formaDesenhavel;
						
						for (Ponto ponto: formaPlotavel.getListaPontos())
							if (ponto.pertence(retangulo) == false)
								listaFurada.add(ponto);
						
						formaPlotavel.getListaPontos().clear();
						formaPlotavel.getListaPontos().addAll(listaFurada);	
					}
				}
				
			}
		}
	}
}
