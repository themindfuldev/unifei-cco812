import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelAnimacao extends JPanel implements Runnable {

	int xP, yP, raio, anguloInicial, anguloTotal, largura;
	boolean direita;
	private boolean continuar;

	public PanelAnimacao() {

		xP = 200;
		yP = 200;
		raio = 300;
		anguloInicial = 0;
		anguloTotal = 90;
		direita = true;
		largura = 0;
		continuar = true;
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		if (largura == 0)
			largura = g.getClipBounds().width;

		for (int i = 0; i <= raio; i += raio / 5) {
			g.drawArc(xP - i / 2, yP - i / 2, i, i, anguloInicial, anguloTotal);
		}

		for (int i = anguloInicial; i <= anguloTotal + anguloInicial; i += anguloTotal / 5)
			g.drawLine(xP, yP, (int) (xP + raio / 2 * Math.cos(Math.toRadians(-i))), (int) (yP + raio / 2 * Math.sin(Math.toRadians(-i))));
	}

	public void run() {
		this.repaint();
		while (continuar) {
			anguloInicial = anguloInicial + 10;
			if (direita) {
				xP = xP + 2;
				if (xP + raio/2 >= largura)
					direita = !direita;
			}
			else {
				xP = xP - 2;
				if (xP - raio/2 <= 0)
					direita = !direita;
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.err.println("Erro no Sleep");
			}
			this.repaint();
		}
	}

}
