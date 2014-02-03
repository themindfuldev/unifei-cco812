package pacote_12643.modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Poligono3D implements Forma {
	private List<Point> listaPontos;

	public Poligono3D() {
		listaPontos = new ArrayList<Point>();
	}
	
	public void adicionarPonto(Point p) {
		listaPontos.add(p);
	}

	@Override
	public void desenhar(Graphics g) {
		int i;
		Point ini, fim;
		
		ini = listaPontos.get(0);
		for (i=1; i<=listaPontos.size(); i++) {
			if (i==listaPontos.size())
				fim = listaPontos.get(0);
			else
				fim = listaPontos.get(i);
			
			g.drawLine(ini.x, ini.y, fim.x, fim.y);
			ini = fim;
		}
		
	}
	
}
