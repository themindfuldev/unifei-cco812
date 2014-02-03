package formas.visao.gui;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import formas.visao.mediator.MediatorSombreamento;

@SuppressWarnings("serial")
public class DialogoSombreamento extends JDialog {
	private JPanel pnlSombreamentoBarra;	
	private JCheckBox chkHorizontalConstante;
	private JCheckBox chkVerticalConstante;
	private JCheckBox chkDiagonalNegativaConstante;
	private JCheckBox chkDiagonalPositivaConstante;
	private JCheckBox chkHorizontalVariavel;
	private JCheckBox chkVerticalVariavel;
	private JCheckBox chkDiagonalNegativaVariavel;
	private JCheckBox chkDiagonalPositivaVariavel;
	private JCheckBox chkBarraPontual;
	private JPanel pnlBotoes;
	private JButton btnOk;
	private JButton btnCancelar;
	private MediatorSombreamento mediator;
	
	public DialogoSombreamento(JFrame pai){
		this(pai, false);
	}
	
	public DialogoSombreamento(JFrame pai, boolean variavel){
		super(pai, "Escolher Sombreamento", true);
		initComponents(variavel);
		mediator = new MediatorSombreamento(this);
		
		this.setLayout(new FlowLayout());
		this.setSize(300,310);
		
		// Posicionamento
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int posX = (d.width - this.getWidth()) / 2;
		int posY = (d.height - this.getHeight()) / 2;
		setLocation(posX, posY);
		
		setVisible(true);
	}

	private void initComponents(boolean variavel){
		pnlSombreamentoBarra = new JPanel();
		pnlSombreamentoBarra.setBorder(BorderFactory.createTitledBorder("Barra"));
		
		chkHorizontalConstante= new JCheckBox("Horizontal Constante   ");
		chkVerticalConstante = new JCheckBox("Vertical Constante");
		chkDiagonalPositivaConstante = new JCheckBox("Diagonal Positiva Constante");
		chkDiagonalNegativaConstante = new JCheckBox("Diagonal Negativa Constante");
		chkHorizontalVariavel = new JCheckBox("Horizontal Variavel");
		chkVerticalVariavel = new JCheckBox("Vertical Variavel");
		chkDiagonalPositivaVariavel = new JCheckBox("Diagonal Positiva Variavel");
		chkDiagonalNegativaVariavel = new JCheckBox("Diagonal Negativa Variavel");
		chkBarraPontual = new JCheckBox("Barra Pontual");
						
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
		
		if (variavel == false)
		{
			chkDiagonalNegativaVariavel.setEnabled(false);
			chkDiagonalPositivaVariavel.setEnabled(false);
			chkHorizontalVariavel.setEnabled(false);
			chkVerticalVariavel.setEnabled(false);
		}
		
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

	public JCheckBox getChkHorizontalConstante() {
		return chkHorizontalConstante;
	}

	public JCheckBox getChkHorizontalVariavel() {
		return chkHorizontalVariavel;
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
	
	public List<Integer> getListaSombreamento() {
		return mediator.getListaSombreamento();
	}	
}
 