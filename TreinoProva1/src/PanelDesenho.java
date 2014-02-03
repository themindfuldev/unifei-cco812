import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class PanelDesenho extends JPanel implements Runnable {
	int xMov, angulo, raio; 
	boolean direita, desenhar;

	public PanelDesenho() {
		setSize(500, 400);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		preencheArco(g, new Point(xMov, g.getClipBounds().height/2), raio, 45+angulo, 205+angulo);
	}

	@Override
	public void run() {
		xMov = 100;
		angulo = 0;
		direita = true;
		raio = 50;
		repaint();
		desenhar = false;
		
		while (true) {
			if (desenhar) {
				if (direita) {
					xMov += 2;
					if (xMov + raio >= this.getWidth())
						direita = !direita;
				}
				else {
					xMov -= 2;
					if (xMov - raio <= 0)
						direita = !direita;
				}
				
				angulo += 10;
				
				repaint();
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void preencheArco(Graphics g, Point point, int raio, int anguloInicial, int anguloFinal) {
		double anguloIteracao, angulo, raioIteracao, raioPasso;
		int x, y;
		
		x = (int) Math.round(raio*Math.cos(Math.toRadians(anguloInicial)));
		y = (int) Math.round(raio*Math.sin(Math.toRadians(anguloInicial)));
		g.drawLine(point.x, point.y, point.x+x, point.y-y);
		
		anguloIteracao = (anguloFinal-anguloInicial)/5.0;
		angulo = anguloInicial + anguloIteracao;
		while (angulo <= anguloFinal) {
			x = (int) Math.round(raio*Math.cos(Math.toRadians(angulo)));
			y = (int) Math.round(raio*Math.sin(Math.toRadians(angulo)));
			
			g.drawLine(point.x, point.y, point.x+x, point.y-y);
			
			angulo += anguloIteracao;
		}
		
		raioIteracao = raioPasso = raio/5.0;
		while (raioIteracao <= raio) {
			g.drawArc((int)(point.x-raioIteracao), (int)(point.y-raioIteracao), (int)raioIteracao*2, (int)raioIteracao*2, anguloInicial, anguloFinal-anguloInicial);
			
			raioIteracao += raioPasso;
		}
		
	}
	
}
