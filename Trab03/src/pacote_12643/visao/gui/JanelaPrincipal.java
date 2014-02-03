package pacote_12643.visao.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pacote_12643.visao.mediator.MediatorPrincipal;

/**
 * Janela Principal do sistema
 */
@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame{
	// Componentes GUI
	private PanelDesenho pnlAreaDesenho;

	public JanelaPrincipal()
	{
		super("Preenchimento de polígonos por scan lines");
		
		// Inicializacao do GUI
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,700);
		setLocation((d.width-getWidth())/2, (d.height-getHeight())/2);
		setResizable(false);

		pnlAreaDesenho = new PanelDesenho();
		
		Container c = getContentPane();
		c.removeAll();
		c.setLayout(new BorderLayout());
		c.add(pnlAreaDesenho, BorderLayout.CENTER);
		
		new MediatorPrincipal(this);
		setVisible(true);
	}

	public PanelDesenho getPnlAreaDesenho() {
		return pnlAreaDesenho;
	}

}

