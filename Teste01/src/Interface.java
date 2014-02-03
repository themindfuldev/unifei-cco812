import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Interface extends JFrame {
	
	private PanelAnimacao panelAnimacao;
	private Thread thread;
	
	public Interface() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(800,600);		
		this.initComponents();
		this.setVisible(true);
		thread = new Thread(panelAnimacao);
		thread.start();
	}

	private void initComponents() {
		panelAnimacao = new PanelAnimacao();
		
		this.setLayout(new BorderLayout());
		this.add(panelAnimacao, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new Interface();
	}

}
