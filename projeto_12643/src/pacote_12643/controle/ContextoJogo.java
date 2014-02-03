package pacote_12643.controle;

import java.util.HashSet;
import java.util.Set;

import pacote_12643.modelo.Bola;
import pacote_12643.modelo.Desenho;
import pacote_12643.modelo.Obstaculo;
import pacote_12643.modelo.Parametrizacao;

/**
 * Contexto que controla todos os eventos e elementos de um jogo em ação.
 * @author Tiago
 */
public class ContextoJogo {
	/**
	 * Lista de bolas em ação.
	 */
	private Set<Bola> listaBolas;
	/**
	 * Lista de obstáculos da fase.
	 */
	private Set<Obstaculo> listaObstaculos;
	/**
	 * Lista total de desenhos da fase.
	 */
	private Set<Desenho> listaDesenhos;
	/**
	 * Vetor de pontuações de cada canaleta.
	 */
	private static int[] pontuacao = new int[] {10, 20, 30, 20, 10, 0};
	
	/**
	 * Construtor.
	 */
	public ContextoJogo() {
		listaBolas = new HashSet<Bola>();
		listaObstaculos = new HashSet<Obstaculo>();
		listaDesenhos = new HashSet<Desenho>();
	}
	
	// Métodos set-get
	public synchronized Set<Desenho> getListaDesenhos() {
		return listaDesenhos;
	}

	public void setListaDesenhos(Set<Desenho> listaDesenhos) {
		this.listaDesenhos = listaDesenhos;
	}

	public synchronized Set<Bola> getListaBolas() {
		return listaBolas;
	}

	public Set<Obstaculo> getListaObstaculos() {
		return listaObstaculos;
	}
	
	public static int[] getVetorPontuacao() {
		return pontuacao;
	}
	
	/**
	 * Adiciona uma bola.
	 * @param b
	 */
	public synchronized void addBola(Bola b) {
		listaBolas.add(b);
		listaDesenhos.add(b);
	}
	
	/**
	 * Adiciona um obstáculo.
	 * @param o
	 */
	public void addObstaculo(Obstaculo o) {
		listaObstaculos.add(o);
		listaDesenhos.add(o);
	}
	
	/**
	 * Verifica colisões para uma bola.
	 * @param b
	 * @return
	 */
	public synchronized boolean verificarColisoes(Bola b) {
		// Declaração de variáveis
		int xCentroBola, yCentroBola, xCentroObs=0, yCentroObs=0, inc, soma=0;
		boolean retorno = false;
		double d, coef, dX, dY;
		
		xCentroBola = (int)b.getX();
		yCentroBola = (int)b.getY();
		
		// Verifica colisoes 
		for (Desenho o: listaDesenhos) {
			if (o == b) continue;
			
			if (o instanceof Obstaculo) {
				xCentroObs = (int) ((Obstaculo)o).getX();
				yCentroObs = (int) ((Obstaculo)o).getY();
				soma = Bola.TAMANHO/2+Obstaculo.TAMANHO/2;
			}
			else if (o instanceof Bola) {
				xCentroObs = (int) ((Bola)o).getX();
				yCentroObs = (int) ((Bola)o).getY();
				soma = Bola.TAMANHO;
				
				// Pára a bola 
				if (yCentroObs >= Parametrizacao.ALTURA-Bola.TAMANHO*4)
					continue;
			}
			
			// Calcula a distancia entre objetos.
			d = Math.sqrt(Math.pow(xCentroBola-xCentroObs, 2)+Math.pow(yCentroBola-yCentroObs, 2));
			
			// Colisão
			if (d < soma) {
				// Toca som da colisão.
				ThreadSom somThread = null;
				if (o instanceof Obstaculo) 
					somThread = new ThreadSom("snd/obstac.wav");
				else if (o instanceof Bola) 
					somThread = new ThreadSom("snd/bola.wav");
				
				try {
					somThread.start();
				} catch (RuntimeException e) {
				}
				
				// Ajusta coeficiente.
				if (yCentroObs >= yCentroBola)
					dY = yCentroBola-yCentroObs;
				else
					dY = yCentroObs-yCentroBola;
				
				dX = xCentroBola-xCentroObs;
				coef = -1.0/(dX/dY);
				
				// Caso que coef é 0
				if (coef == 0.0) {
					if (xCentroBola <= xCentroObs)
						dX = xCentroBola-xCentroObs;
					else
						dX = xCentroObs-xCentroBola;
					
					coef = -1.0/dX;
				}
				
				// Caso que coef é infinito (mov. vertical)
				if (Double.isInfinite(coef) == true) {
					int rand = (int)(Math.random()*10);
					if ((rand & 1) == 1)
						inc = 1;
					else
						inc = -1;
					
					xCentroBola += inc;
					coef = -1.0/(((double)xCentroBola-xCentroObs)/(yCentroBola-yCentroObs));
					while (Double.isInfinite(coef) == true) {
						xCentroBola += inc;
					}
				}
				
				// Seta coeficiente.
				b.setCoef(coef);
				retorno = true;
				
				// Incrementa X.
				b.incrementarX();
				xCentroBola = (int)b.getX();
				
				// Reflete outra bola.
				if (o instanceof Bola) {
					((Bola)o).setCoef(-1.0/coef);
					((Bola)o).incrementarX();
					xCentroObs = (int) ((Bola)o).getX();
				}
				
				// Ajusta posição pós-colisão.
				d = Math.abs(xCentroBola-xCentroObs);
				
				while (d < soma) {
					b.incrementarX();
					xCentroBola = (int)b.getX();
					if (o instanceof Bola) {
						((Bola)o).incrementarX();
						xCentroObs = (int)((Bola)o).getX();
					}
					d = Math.abs(xCentroBola-xCentroObs);
				}
				
				break;
			}
		}
		
		return retorno;
	}
	
	/**
	 * Obtém pontuação calculada.
	 * @return
	 */
	public int getPontuacao() {
		// Declaração de variáveis
		int total = 0;
		
		// Calcula pontuação.
		for (Bola b: listaBolas) {
			total += pontuacao[b.getFaixa()];
		}
		
		return total;
	}
	
}
