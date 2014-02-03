package graficos.visao.gui;
import graficos.visao.mediator.MediatorGraficos;
import graficos.visao.mediator.MediatorSombreamento;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DialogoSombreamento extends JDialog {
	private JPanel pnlSombreamentoBarra;	
	private JCheckBox chkHorizontalConstante;
	private JCheckBox chkVerticalConstante;
	private JCheckBox chkHorizontalVariavel;
	private JCheckBox chkVerticalVariavel;
	private JCheckBox chkDiagonalNegativaVariavel;
	private JCheckBox chkDiagonalPositivaVariavel;
	private JCheckBox chkDiagonalNegativaConstante;
	private JCheckBox chkDiagonalPositivaConstante;
	private JCheckBox chkBarraPontual;
		
	private JPanel pnlSombreamentoCircular;
	private JCheckBox chkRadial;
	private JCheckBox chkCircular;
	private JCheckBox chkCircularPontual;
		
	private JPanel pnlBotoes;
	private JButton btnOk;
	private JButton btnCancelar;
	
	public DialogoSombreamento(JFrame pai, boolean tipoGraficoBarra, MediatorGraficos mediatorPrincipal, int opcaoGrafico){
		super(pai, "Escolher Sombreamento", true);
		initComponents(mediatorPrincipal);
		new MediatorSombreamento(this, mediatorPrincipal, opcaoGrafico);
		selecionar(tipoGraficoBarra);
		
		this.setLayout(new FlowLayout());
		this.setSize(380,310);
		
		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);
		
		this.setVisible(true);	
	}
	
	private void selecionar(boolean tipoGraficoBarra) {
		if (tipoGraficoBarra)
			for (Component componente: pnlSombreamentoCircular.getComponents())
				componente.setEnabled(false);
		else
			for (Component componente: pnlSombreamentoBarra.getComponents())
				componente.setEnabled(false);
	}

	private void initComponents(MediatorGraficos mediatorPrincipal){
		pnlSombreamentoBarra = new JPanel();
		pnlSombreamentoBarra.setBorder(BorderFactory.createTitledBorder("Barra"));
		
		chkHorizontalConstante= new JCheckBox("Horizontal Constante   ");
		chkVerticalConstante = new JCheckBox("Vertical Constante");
		chkHorizontalVariavel = new JCheckBox("Horizontal Variavel");
		chkVerticalVariavel = new JCheckBox("Vertical Variavel");
		chkBarraPontual = new JCheckBox("Barra Pontual");
		chkDiagonalPositivaConstante = new JCheckBox("Diagonal Positiva Constante");
		chkDiagonalNegativaConstante = new JCheckBox("Diagonal Negativa Constante");
		chkDiagonalPositivaVariavel = new JCheckBox("Diagonal Positiva Variavel");
		chkDiagonalNegativaVariavel = new JCheckBox("Diagonal Negativa Variavel");

						
		pnlSombreamentoBarra.add(chkHorizontalConstante);
		pnlSombreamentoBarra.add(chkVerticalConstante);
		pnlSombreamentoBarra.add(chkDiagonalPositivaConstante);
		pnlSombreamentoBarra.add(chkDiagonalNegativaConstante);
		pnlSombreamentoBarra.add(chkHorizontalVariavel);
		pnlSombreamentoBarra.add(chkVerticalVariavel);
		pnlSombreamentoBarra.add(chkDiagonalPositivaVariavel);
		pnlSombreamentoBarra.add(chkDiagonalNegativaVariavel);
		pnlSombreamentoBarra.add(chkBarraPontual);		
		
		pnlSombreamentoBarra.setLayout(new GridLayout(9,1));
		
		this.add(pnlSombreamentoBarra);
		
		pnlSombreamentoCircular = new JPanel();
		pnlSombreamentoCircular.setBorder(BorderFactory.createTitledBorder("Circular"));		
		
		chkRadial = new JCheckBox("Radial");
		chkCircular = new JCheckBox("Circular              ");
		chkCircularPontual = new JCheckBox("Pontual");
		
		pnlSombreamentoCircular.add(chkRadial);
		pnlSombreamentoCircular.add(chkCircular);
		pnlSombreamentoCircular.add(chkCircularPontual);
		
				
		
		pnlSombreamentoCircular.setLayout(new GridLayout(3,1));
		this.add(pnlSombreamentoCircular);
				
		btnOk = new JButton("OK");
		btnCancelar = new JButton("Cancelar");
		pnlBotoes = new JPanel();
		
		pnlBotoes.add(btnOk);
		pnlBotoes.add(btnCancelar);
		this.add(pnlBotoes);
	
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JCheckBox getChkBarraPontual() {
		return chkBarraPontual;
	}

	public JCheckBox getChkCircular() {
		return chkCircular;
	}

	public JCheckBox getChkCircularPontual() {
		return chkCircularPontual;
	}

	public JCheckBox getChkHorizontalConstante() {
		return chkHorizontalConstante;
	}

	public JCheckBox getChkHorizontalVariavel() {
		return chkHorizontalVariavel;
	}

	public JCheckBox getChkRadial() {
		return chkRadial;
	}

	public JCheckBox getChkVerticalConstante() {
		return chkVerticalConstante;
	}

	public JCheckBox getChkVerticalVariavel() {
		return chkVerticalVariavel;
	}
	
	public JCheckBox getChkDiagonalNegativaConstante() {
		return chkDiagonalNegativaConstante;
	}

	public JCheckBox getChkDiagonalPositivaConstante() {
		return chkDiagonalPositivaConstante;
	}

	public JCheckBox getChkDiagonalNegativaVariavel() {
		return chkDiagonalNegativaVariavel;
	}

	public JCheckBox getChkDiagonalPositivaVariavel() {
		return chkDiagonalPositivaVariavel;
	}
	
}
 