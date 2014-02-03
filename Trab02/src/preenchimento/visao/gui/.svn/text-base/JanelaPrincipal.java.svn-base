package preenchimento.visao.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import preenchimento.visao.mediator.MediatorPrincipal;

import componentes.visao.gui.PanelDesenho;

/**
 * Janela Principal do sistema
 */
@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame{
	// Componentes GUI
	private JPanel pnlMenuSuperior;
	private PanelDesenho pnlAreaDesenho;
	private JButton btnCriarPoligono, btnFinalizar, btnCancelar, btnSair;	
	private MediatorPrincipal mediatorFormas;
	private JLabel lblPosicao;

	public JanelaPrincipal()
	{
		super("Preenchimento de polígonos por scan lines");
		mediatorFormas = new MediatorPrincipal(this);
		
		// Inicializacao do GUI
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,550);
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setResizable(false);

		pnlMenuSuperior = new JPanel();
		pnlAreaDesenho = new PanelDesenho();
		
		pnlMenuSuperior.setLayout(new FlowLayout());		
		btnCriarPoligono = new JButton("Criar Polígono");
		btnFinalizar = new JButton("Finalizar");
		btnCancelar = new JButton("Cancelar");
		btnSair = new JButton("Sair");
		lblPosicao = new JLabel("(000,000)");

		//Tornando invisiveis os botoes
		btnFinalizar.setEnabled(false);
		btnCancelar.setEnabled(false);
		
		// Inserindo os itens no menu superior
		pnlMenuSuperior.add(lblPosicao);
		pnlMenuSuperior.add(Box.createRigidArea(new Dimension(150, 20)));
		pnlMenuSuperior.add(btnCriarPoligono);
		pnlMenuSuperior.add(btnFinalizar);
		pnlMenuSuperior.add(btnCancelar);
		pnlMenuSuperior.add(Box.createRigidArea(new Dimension(150, 20)));
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
	
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnCriarPoligono() {
		return btnCriarPoligono;
	}

	public PanelDesenho getPnlAreaDesenho() {
		return pnlAreaDesenho;
	}

	public JLabel getLblPosicao() {
		return lblPosicao;
	}
	
}

