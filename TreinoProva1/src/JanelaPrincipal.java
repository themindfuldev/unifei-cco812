import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JanelaPrincipal extends JFrame {
	public JanelaPrincipal() {
		final PanelDesenho panel = new PanelDesenho();
		JButton btnRotacionar, btnAnimar;
		
		btnRotacionar = new JButton("Rotacionar");
		btnRotacionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String anguloStr = JOptionPane.showInputDialog("Entre com o angulo:");
				if (anguloStr == null) return;
				
				int angulo;
				try {
					angulo = Integer.parseInt(anguloStr);
					panel.angulo = angulo + panel.angulo;
					panel.repaint();
				} catch (NumberFormatException e) {
					return;
				}
			}
		}); 
		
		btnAnimar = new JButton("Animar");
		btnAnimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.desenhar = !panel.desenhar;
			}
		});
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(btnRotacionar, BorderLayout.LINE_START);
		getContentPane().add(btnAnimar, BorderLayout.LINE_END);
		
		
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread t = new Thread(panel);
		t.start();
	}
	
	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
