package graficos.visao.mediator;

import graficos.modelo.NumerosAleatorios;
import graficos.visao.gui.JanelaGraficos;
import graficos.visao.gui.DialogoSombreamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import componentes.modelo.graficos.GraficoDeBarraUnica;
import componentes.modelo.graficos.GraficoDeBarrasDiferentes;
import componentes.modelo.graficos.GraficoDePizza;
import componentes.modelo.graficos.GraficoDePizzaExplodida;

public class MediatorGraficos {
	private JanelaGraficos janela;
	private List<List<Integer>> tabelaSombreamentos;
	private NumerosAleatorios numeros;
	private double acumuladorGrafico;

	public MediatorGraficos(JanelaGraficos janela) {
		this.janela = janela;
		this.tabelaSombreamentos = new ArrayList<List<Integer>>();
		numeros = new NumerosAleatorios(1000);
		
		for (int i=0; i<5; i++)
			tabelaSombreamentos.add(new ArrayList<Integer>());

		registraEventos();
	}

	private void registraEventos() {
		// Botões
		janela.getBtnSair().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				 System.exit(0);
			}
		});
		janela.getBtnVisualizarGraficos().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Barra Única
				if (janela.getRdoBarrasDiferentes().isSelected())
				{
					float[] dados = obterDados();
					GraficoDeBarrasDiferentes grafico = new GraficoDeBarrasDiferentes(300, tabelaSombreamentos, dados);
					
					janela.getPnlGraficos().limpar();
					janela.getPnlGraficos().adicionarFormaDesenhavel(grafico);
					janela.getPnlGraficos().repaint();
					
				}
				// Barras Diferentes
				else if (janela.getRdoBarraUnica().isSelected())
				{
					float[] dados = obterDados();
					GraficoDeBarraUnica grafico = new GraficoDeBarraUnica(300, tabelaSombreamentos, dados);
					
					janela.getPnlGraficos().limpar();
					janela.getPnlGraficos().adicionarFormaDesenhavel(grafico);
					janela.getPnlGraficos().repaint();
				}
				// Pizza
				else if (janela.getRdoPizza().isSelected())
				{
					float[] dados = obterDados();
					GraficoDePizza grafico = new GraficoDePizza(150, tabelaSombreamentos, dados);
					
					janela.getPnlGraficos().limpar();
					janela.getPnlGraficos().adicionarFormaDesenhavel(grafico);
					janela.getPnlGraficos().repaint();
				}
				// Pizza Explodida
				else 
				{
					float[] dados = obterDados();
					GraficoDePizzaExplodida grafico = new GraficoDePizzaExplodida(150, 20, tabelaSombreamentos, dados);
					
					janela.getPnlGraficos().limpar();
					janela.getPnlGraficos().adicionarFormaDesenhavel(grafico);
					janela.getPnlGraficos().repaint();
				}
			}
		});
		
		janela.getBtnGerarDistribuicao().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				numeros.novaDistribuicao();
			}
		});
		
		// Checkboxes
		janela.getChkPares().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				incluirOpcao(0);
			}
		});
		janela.getChkImpares().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				incluirOpcao(1);
			}
		});
		janela.getChkPrimos().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				incluirOpcao(2);
			}
		});
		janela.getChkMenoresMedia().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				incluirOpcao(4);
			}
		});
		janela.getChkEsparsidade().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				incluirOpcao(3);
			}
		});
		janela.getRdoBarraUnica().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novoTipoDeGrafico();
			}
		});
		janela.getRdoBarrasDiferentes().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novoTipoDeGrafico();
			}
		});
		janela.getRdoPizza().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novoTipoDeGrafico();
			}
		});
		janela.getRdoPizzaExplodida().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				novoTipoDeGrafico();
			}
		});

	}
	
	private void apagarSombreamento(int i) {
		tabelaSombreamentos.get(i).clear();
	}

	private boolean getTipoGraficoBarra()
	{
		if (janela.getRdoBarraUnica().isSelected() || janela.getRdoBarrasDiferentes().isSelected())
			return true;
		else
			return false;
	}

	public List<List<Integer>> getTabelaSombreamentos() {
		return tabelaSombreamentos;
	}

	public void desabilitarCheckBox(int opcaoGrafico) {
		switch(opcaoGrafico)
		{
			case 0:
				janela.getChkPares().setSelected(false);
				break;
				
			case 1:
				janela.getChkImpares().setSelected(false);
				break;
				
			case 2:
				janela.getChkPrimos().setSelected(false);
				break;
				
			case 3:
				janela.getChkEsparsidade().setSelected(false);
				break;
				
			case 4:
				janela.getChkMenoresMedia().setSelected(false);
				break;
		}
	}

	private float[] obterDados() {
		// Declaração de variáveis
		boolean[] coluna;
		float[] dados;
		
		// Colunas
		coluna = new boolean[5];
		coluna[0] = janela.getChkPares().isSelected();
		coluna[1] = janela.getChkImpares().isSelected();
		coluna[2] = janela.getChkPrimos().isSelected();
		coluna[3] = janela.getChkEsparsidade().isSelected();
		coluna[4] = janela.getChkMenoresMedia().isSelected();
		
		// Dados
		dados = new float[5];
		for (int i=0; i<5; i++)
			if (coluna[i])
				dados[i] = numeros.getPercentagem(i);
			else
				dados[i] = -1.0f;
		
		return dados;
	}

	private void incluirOpcao(int indice) {
		if (getCheckBox(indice).isSelected())
		{
			if (janela.getRdoBarrasDiferentes().isSelected() == false &&
					acumuladorGrafico+numeros.getPercentagem(indice) > 1.0)
			{
				JOptionPane.showMessageDialog(janela, "Esta opção não caberá no gráfico.\nPor favor, remova outra opção para incluir esta.", "ERRO!", JOptionPane.ERROR_MESSAGE);
				desabilitarCheckBox(indice);
				return;
			}
			apagarSombreamento(indice);
			new DialogoSombreamento(janela, getTipoGraficoBarra(), this, indice);
		}				
		else
		{
			acumuladorGrafico -= numeros.getPercentagem(indice);
			apagarSombreamento(indice);
		}
	}

	public void acumularPercentagem(int indice) {
		acumuladorGrafico += numeros.getPercentagem(indice);
	}
	
	private JCheckBox getCheckBox(int indice) {
		JCheckBox chkBox = null;
		
		switch(indice)
		{
			case 0:
				chkBox = janela.getChkPares();
				break;
				
			case 1:
				chkBox = janela.getChkImpares();
				break;
				
			case 2:
				chkBox = janela.getChkPrimos();
				break;
				
			case 3:
				chkBox = janela.getChkEsparsidade();
				break;
				
			case 4:
				chkBox = janela.getChkMenoresMedia();
				break;
		}
		
		return chkBox;
	}

	private void novoTipoDeGrafico() {
		acumuladorGrafico = 0.0f;
		for (int i=0; i<5; i++)
		{
			apagarSombreamento(i);
			getCheckBox(i).setSelected(false);
		}
	}

}
