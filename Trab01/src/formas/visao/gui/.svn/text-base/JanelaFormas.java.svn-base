package formas.visao.gui;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import componentes.visao.gui.PanelDesenho;

import formas.visao.mediator.MediatorFormas;



@SuppressWarnings("serial")
public class JanelaFormas extends JFrame {
	// Componentes GUI
	private JLabel lblFormas;
	private JComboBox cmbFormas;
	private JPanel pnlMenuSuperior;
	private PanelDesenho pnlAreaDesenho;
	private JButton btnSair;	
	private MediatorFormas mediatorFormas;

	public JanelaFormas()
	{
		super("Sombreamento de formas regulares");
		mediatorFormas = new MediatorFormas(this);
		
		// Inicializacao do GUI
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,550);
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setResizable(false);

		pnlMenuSuperior = new JPanel();
		pnlAreaDesenho = new PanelDesenho();
		
		String[] formas = {"", "Quadrado", "Retangulo", "Polígono" };
		lblFormas = new JLabel("Tipos de forma:");
		cmbFormas = new JComboBox(formas);
		
		pnlMenuSuperior.setLayout(new FlowLayout());		
		
		btnSair = new JButton("Sair");

		// Inserindo os itens no menu superior
		pnlMenuSuperior.add(lblFormas);
		pnlMenuSuperior.add(cmbFormas);
		pnlMenuSuperior.add(btnSair);	
	
		
		Container c = getContentPane();
		c.removeAll();
		c.setLayout(new BorderLayout());
		c.add(pnlMenuSuperior, BorderLayout.NORTH);
		c.add(pnlAreaDesenho, BorderLayout.CENTER);
		
		mediatorFormas.registraEventos();
		setVisible(true);
		
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public JComboBox getCmbFormas() {
		return cmbFormas;
	}

	public PanelDesenho getPnlAreaDesenho() {
		return pnlAreaDesenho;
	}

}

