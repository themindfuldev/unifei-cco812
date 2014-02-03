package formas.visao.mediator;

import formas.visao.gui.DialogoSombreamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import componentes.modelo.graficos.ConstantesSombras;

public class MediatorSombreamento {
	private DialogoSombreamento janela;
	private List<Integer> listaSombreamento;

	public MediatorSombreamento(DialogoSombreamento janela) {
		this.janela = janela;
		
		registraEventos();
	}

	private void registraEventos() {
		// Botões
		janela.getBtnOk().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Declaração de variáveis
				List<Integer> listaOpcoes;

				// Obtém opções
				listaOpcoes = obterOpcoes();
				if (listaOpcoes.size() == 0)
				{
					JOptionPane.showMessageDialog(janela, "Escolha ao menos uma opção!", "Erro!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				listaSombreamento = listaOpcoes;
				janela.dispose();
			}
		});
		
		janela.getBtnCancelar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
			}
		});
		
	}

	private List<Integer> obterOpcoes() {
		// Declaração de variáveis
		List<Integer> listaOpcoes;
		
		listaOpcoes = new ArrayList<Integer>();
		if (janela.getChkBarraPontual().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_PONTUAL_BARRA);
		if (janela.getChkDiagonalNegativaConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_CONSTANTE);
		if (janela.getChkDiagonalNegativaVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_VARIAVEL);
		if (janela.getChkDiagonalPositivaConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_CONSTANTE);
		if (janela.getChkDiagonalPositivaVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_VARIAVEL);
		if (janela.getChkHorizontalConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_HORIZONTAL_CONSTANTE);
		if (janela.getChkHorizontalVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_HORIZONTAL_VARIAVEL);
		if (janela.getChkVerticalConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_VERTICAL_CONSTANTE);
		if (janela.getChkVerticalVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_VERTICAL_VARIAVEL);
		
		return listaOpcoes;
	}

	public List<Integer> getListaSombreamento() {
		return listaSombreamento;
	}
	
}
