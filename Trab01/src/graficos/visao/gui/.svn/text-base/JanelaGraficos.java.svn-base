package graficos.visao.gui;

import graficos.visao.mediator.MediatorGraficos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import componentes.visao.gui.PanelDesenho;


@SuppressWarnings("serial")
public class JanelaGraficos extends JFrame {
	private JPanel pnlTipoGrafico, pnlSuperior;	
	private JRadioButton rdoBarraUnica;
	private JRadioButton rdoBarrasDiferentes;
	private JRadioButton rdoPizza;
	private JRadioButton rdoPizzaExplodida;
	private ButtonGroup rdgTipoGrafico;
	
	private JPanel pnlOpcoes;
	private JCheckBox chkPares;
	private JCheckBox chkImpares;
	private JCheckBox chkPrimos;
	private JCheckBox chkEsparsidade;
	private JCheckBox chkMenoresMedia;
	
	private JPanel pnlBotoes;
	private JButton btnVisualizarGraficos;
	private JButton btnSair;
	
	private PanelDesenho pnlGraficos;
	private JButton btnGerarDistribuicao;
	
	public JanelaGraficos(){
		super("Sombreamento de Graficos");
		initComponents();
		new MediatorGraficos(this);
	}
	
	public void initComponents(){		
		pnlSuperior = new JPanel();
		
		//Caixa de tipo de grafico
		pnlTipoGrafico = new JPanel();
		pnlTipoGrafico.setBorder(BorderFactory.createTitledBorder("Tipo de grafico"));
		
		rdoBarraUnica = new JRadioButton("Barra unica") ;
		rdoBarraUnica.setSelected(true);
		rdoBarrasDiferentes = new JRadioButton("Barras diferentes");
		rdoPizza = new  JRadioButton("Pizza");
		rdoPizzaExplodida = new JRadioButton("Pizza Explodida");
		rdgTipoGrafico = new ButtonGroup();
		
		rdgTipoGrafico.add(rdoBarraUnica);
		rdgTipoGrafico.add(rdoBarrasDiferentes);
		rdgTipoGrafico.add(rdoPizza);
		rdgTipoGrafico.add(rdoPizzaExplodida);
		
		pnlTipoGrafico.add(rdoBarraUnica);
		pnlTipoGrafico.add(rdoBarrasDiferentes);
		pnlTipoGrafico.add(rdoPizza);
		pnlTipoGrafico.add(rdoPizzaExplodida);
		pnlTipoGrafico.setLayout(new GridLayout(4,1));
		
		pnlSuperior.add(pnlTipoGrafico);
		
		//Instancia e inicializa a caixa de opcoes de representacao
		pnlOpcoes = new JPanel();
		GridBagConstraints c;
		
		pnlOpcoes.setBorder(BorderFactory.createTitledBorder("Opcoes de representacao"));
		
		chkPares = new JCheckBox("Pares");
		chkImpares = new JCheckBox("Impares");
		chkPrimos = new JCheckBox("Primos");
		chkEsparsidade = new JCheckBox("Esparsidade");
		chkMenoresMedia = new JCheckBox("Menores que a media          ");		
		
		pnlOpcoes.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.anchor = GridBagConstraints.WEST;
		pnlOpcoes.add(chkPares, c);
		
		c = new GridBagConstraints();
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		pnlOpcoes.add(chkImpares, c);
		
		c = new GridBagConstraints();
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		pnlOpcoes.add(chkPrimos, c);
		
		c = new GridBagConstraints();
		c.gridy = 3;
		c.anchor = GridBagConstraints.WEST;
		pnlOpcoes.add(chkEsparsidade, c);
		
		c = new GridBagConstraints();
		c.gridy = 4;
		c.anchor = GridBagConstraints.WEST;
		pnlOpcoes.add(chkMenoresMedia, c);
		
		pnlSuperior.add(pnlOpcoes);
		
		//Instancia e inicializa os botoes de Gerar/Sair
		pnlBotoes = new JPanel();
		btnVisualizarGraficos = new JButton("Visualizar grafico");
		btnSair = new JButton("Sair");	
		btnGerarDistribuicao = new JButton("Gerar distribuicao");
		
		pnlBotoes.add(btnGerarDistribuicao);
		pnlBotoes.add(btnVisualizarGraficos);
		pnlBotoes.add(btnSair);
		pnlSuperior.add(pnlBotoes);
		
		pnlGraficos = new PanelDesenho();
		
		// Configurando o layout
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(pnlSuperior, BorderLayout.NORTH);
		con.add(pnlGraficos, BorderLayout.CENTER);
		
		//Setando configuracoes da janela
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,550);
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setResizable(false);
		setVisible(true);
	}

	public JButton getBtnVisualizarGraficos() {
		return btnVisualizarGraficos;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public JCheckBox getChkEsparsidade() {
		return chkEsparsidade;
	}

	public JCheckBox getChkImpares() {
		return chkImpares;
	}

	public JCheckBox getChkMenoresMedia() {
		return chkMenoresMedia;
	}

	public JCheckBox getChkPares() {
		return chkPares;
	}

	public JCheckBox getChkPrimos() {
		return chkPrimos;
	}

	public ButtonGroup getRdgTipoGrafico() {
		return rdgTipoGrafico;
	}

	public JRadioButton getRdoBarrasDiferentes() {
		return rdoBarrasDiferentes;
	}

	public JRadioButton getRdoBarraUnica() {
		return rdoBarraUnica;
	}

	public JRadioButton getRdoPizza() {
		return rdoPizza;
	}

	public JRadioButton getRdoPizzaExplodida() {
		return rdoPizzaExplodida;
	}

	public JButton getBtnGerarDistribuicao() {
		return btnGerarDistribuicao;
	}

	public PanelDesenho getPnlGraficos() {
		return pnlGraficos;
	}
	 
	 
}
 