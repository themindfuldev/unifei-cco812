package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

public class SombreamentoRadial implements SombreamentoPizza {
	public void sombrear(Ponto centro, int raio, double anguloInicial,
			double anguloFinal, int n, List<Ponto> listaPontos) {
		// Declaracao de variaveis.
		Ponto p;
		int x, y, xCentro, yCentro;
		double teta, dX, dY, dXtemp, dYtemp, varSen, varCos, inc, anguloIteracao, anguloRadial;

		// Inicializacao.
		xCentro = centro.getX();
		yCentro = centro.getY();

		inc = 1.0 / raio;
		varSen = Math.sin(inc);
		varCos = Math.cos(inc);

		dX = x = (int) Math.round(raio * Math.cos(anguloInicial));
		dY = y = (int) Math.round(raio * Math.sin(anguloInicial));
		
		if (anguloInicial == anguloFinal)
			return;
		
		anguloIteracao = (anguloFinal-anguloInicial)/n;
		anguloRadial = anguloIteracao;

		// Determina o percurso do preenchimento.
		// Percurso do ângulo inicial ao final.
		if (anguloInicial < anguloFinal) {
			// Percorre os ângulos e preenche.
			for (teta = 0; teta <= anguloFinal-anguloInicial; teta += inc) {
				
				if (teta >= anguloRadial)
				{
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontos.addAll(new Segmento(new Ponto(xCentro, yCentro), p).getListaPontos());
					anguloRadial += anguloIteracao;
				}

				dXtemp = dX * varCos - dY * varSen;
				dYtemp = dY * varCos + dX * varSen;

				dX = dXtemp;
				dY = dYtemp;

				x = (int) dX;
				y = (int) dY;
			}
		}
		// Percurso do ângulo final ao inicial.
		else {
			// Percorre os ângulos e preenche.
			for (teta = 0; teta <= anguloFinal; teta += inc) {
				if (teta >= anguloRadial)
				{
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontos.addAll(new Segmento(new Ponto(xCentro, yCentro), p).getListaPontos());
					anguloRadial += anguloIteracao;
				}

				dXtemp = dX * varCos - dY * varSen;
				dYtemp = dY * varCos + dX * varSen;

				dX = dXtemp;
				dY = dYtemp;

				x = (int) dX;
				y = (int) dY;
			}
			for (teta = anguloInicial; teta < 2 * Math.PI; teta += inc) {
				if (teta >= anguloRadial)
				{
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontos.addAll(new Segmento(new Ponto(xCentro, yCentro), p).getListaPontos());
					anguloRadial += anguloIteracao;
				}

				dXtemp = dX * varCos - dY * varSen;
				dYtemp = dY * varCos + dX * varSen;

				dX = dXtemp;
				dY = dYtemp;

				x = (int) dX;
				y = (int) dY;
			}
		}
	}
}
