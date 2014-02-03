package componentes.modelo.sombreamento;

import java.util.ArrayList;
import java.util.List;

import componentes.modelo.formas.Ponto;

public class SombreamentoPontualPizza implements SombreamentoPizza {
	public void sombrear(Ponto centro, int raio, double anguloInicial,
			double anguloFinal, int n, List<Ponto> listaPontos) {
		// Declaracao de variaveis.
		Ponto p;
		int k, x, y, xCentro, yCentro, raioIteracao;
		double teta, dX, dY, dXtemp, dYtemp, varSen, varCos, inc;
		List<Ponto> listaPontosArco;

		// Inicializacao.
		xCentro = centro.getX();
		yCentro = centro.getY();
		
		if (anguloInicial == anguloFinal)
			return;

		for (k = 1; k < raio; k++) {
			listaPontosArco = new ArrayList<Ponto>();
			raioIteracao = k;

			inc = 1.0 / raioIteracao;
			varSen = Math.sin(inc);
			varCos = Math.cos(inc);

			dX = x = (int) Math.round(raioIteracao * Math.cos(anguloInicial));
			dY = y = (int) Math.round(raioIteracao * Math.sin(anguloInicial));

			// Determina o percurso do preenchimento.
			// Percurso do ângulo inicial ao final.
			if (anguloInicial < anguloFinal) {
				// Percorre os ângulos e preenche.
				for (teta = anguloInicial; teta <= anguloFinal; teta += inc) {
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontosArco.add(p);

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
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontosArco.add(p);

					dXtemp = dX * varCos - dY * varSen;
					dYtemp = dY * varCos + dX * varSen;

					dX = dXtemp;
					dY = dYtemp;

					x = (int) dX;
					y = (int) dY;
				}
				for (teta = anguloInicial; teta < 2 * Math.PI; teta += inc) {
					p = new Ponto(xCentro + x, yCentro - y);
					listaPontosArco.add(p);

					dXtemp = dX * varCos - dY * varSen;
					dYtemp = dY * varCos + dX * varSen;

					dX = dXtemp;
					dY = dYtemp;

					x = (int) dX;
					y = (int) dY;
				}
			}
			
			removerPontos(listaPontosArco, n);
			listaPontos.addAll(listaPontosArco);
		}
	}

	private void removerPontos(List<Ponto> lista, int n) {
		int posicao;
		
		while (lista.size() > n)
		{
			posicao = (int) (Math.random()*lista.size());
			lista.remove(posicao);
		}
		
	}
}
