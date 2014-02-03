package graficos.visao.mediator;

import graficos.visao.gui.DialogoSombreamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import componentes.modelo.graficos.ConstantesSombras;

public class MediatorSombreamento {
	private MediatorGraficos mediatorPrincipal;
	private DialogoSombreamento janela;
	private int opcaoGrafico;

	public MediatorSombreamento(DialogoSombreamento janela, MediatorGraficos mediatorPrincipal, int opcaoGrafico) {
		this.mediatorPrincipal = mediatorPrincipal;
		this.janela = janela;
		this.opcaoGrafico = opcaoGrafico;
		
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

				mediatorPrincipal.getTabelaSombreamentos().get(opcaoGrafico).addAll(listaOpcoes);
				janela.dispose();
				mediatorPrincipal.acumularPercentagem(opcaoGrafico);
			}
		});
		
		janela.getBtnCancelar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
				mediatorPrincipal.desabilitarCheckBox(opcaoGrafico);
			}
		});
		
	}

	private List<Integer> obterOpcoes() {
		// Declaração de variáveis
		List<Integer> listaOpcoes;
		
		listaOpcoes = new ArrayList<Integer>();
		if (janela.getChkBarraPontual().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_PONTUAL_BARRA);
		if (janela.getChkCircularPontual().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_PONTUAL_PIZZA);
		if (janela.getChkCircular().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_CIRCULAR);
		if (janela.getChkDiagonalNegativaConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_CONSTANTE);
		if (janela.getChkDiagonalNegativaVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_VARIAVEL);
		if (janela.getChkDiagonalPositivaConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_CONSTANTE);
		if (janela.getChkDiagonalPositivaVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_VARIAVEL);		if (janela.getChkHorizontalConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_HORIZONTAL_CONSTANTE);
		if (janela.getChkHorizontalVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_HORIZONTAL_VARIAVEL);
		if (janela.getChkRadial().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_RADIAL);
		if (janela.getChkVerticalConstante().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_VERTICAL_CONSTANTE);
		if (janela.getChkVerticalVariavel().isSelected())
			listaOpcoes.add(ConstantesSombras.SOMBRA_VERTICAL_VARIAVEL);
		
		return listaOpcoes;
	}

}
