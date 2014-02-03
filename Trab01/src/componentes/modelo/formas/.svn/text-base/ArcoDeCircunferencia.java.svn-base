package componentes.modelo.formas;

import java.util.LinkedList;
import java.util.List;

import componentes.modelo.sombreamento.SombreamentoPizza;

/**
 * Forma desenhavel de um arco de circunferência.
 */
public class ArcoDeCircunferencia extends FormaPlotavel
{
	// Atributos
	/** 
	 * Ponto central.
	 */
	private Ponto centro;
	/**
	 * Raio. 
	 */
	private int raio;
	/**
	 * Ângulo inicial, em radianos.
	 */
	private double anguloInicial;
	/**
	 * Ângula final, em radianos.
	 */
	private double anguloFinal;	
	
	private boolean borda;

	// Construtores
	/**
	 * Construtor com os ângulos em radianos.
	 * @param borda 
	 */
	public ArcoDeCircunferencia(Ponto centro, int raio, double anguloInicial,
	      double anguloFinal, boolean borda)
	{
		this.centro = centro;
		this.raio = raio;
		this.anguloInicial = anguloInicial;
		this.anguloFinal = anguloFinal;
		this.borda = borda;

		if (anguloInicial > Math.PI * 2) this.anguloInicial -= Math.PI * 2;
		if (anguloFinal > Math.PI * 2) this.anguloFinal -= Math.PI * 2;
		
		// Calcula os pontos, e armazena na lista.
		this.listaPontos = preencheLista();		
	}

	/**
	 * Construtor com os ângulos em graus.
	 */
	public ArcoDeCircunferencia(Ponto centro, int raio, int anguloInicial,
	      int anguloFinal, boolean borda)
	{
		this(centro, raio, Math.toRadians(anguloInicial), Math
		      .toRadians(anguloFinal), borda);
	}
	
	/**
	 * Construtor com pontos.
	 */
	public ArcoDeCircunferencia(Ponto centro, int raio, Ponto pontoInicial,
			Ponto pontoFinal, boolean borda)
	{
		this(centro, raio, 
				Operacoes.anguloDeArco(centro, raio, pontoInicial), 
				Operacoes.anguloDeArco(centro, raio, pontoFinal), borda);
	}

	// Metodos
	/**
	 * Preenche a lista de pontos.
	 * Utiliza o algoritmo incremental.
	 */
	private List<Ponto> preencheLista()
	{
		//	Declaracao de variaveis.
		List<Ponto> lista;		
		Ponto p;
		int x, y, xCentro, yCentro;
		double teta, dX, dY, dXtemp, dYtemp, varSen, varCos, inc;

		// Inicializacao.
		lista = new LinkedList<Ponto>();
		
		xCentro = centro.getX();
		yCentro = centro.getY();
		
		p = null;
		inc = 1.0 / raio;
		varSen = Math.sin(inc);
		varCos = Math.cos(inc);

		dX = x = (int) Math.round(raio*Math.cos(anguloInicial));
		dY = y = (int) Math.round(raio*Math.sin(anguloInicial));
		
		if (anguloInicial == anguloFinal)
		{
			if (borda)
			{
				p = new Ponto(xCentro+x, yCentro-y);
				lista.addAll(new Segmento(centro, p).getListaPontos());
			}
			
			return lista;
		}
		
		if (borda)
		{
			p = new Ponto(xCentro+x, yCentro-y);
			lista.addAll(new Segmento(centro, p).getListaPontos());
		}

		// Determina o percurso do preenchimento.
		// Percurso do ângulo inicial ao final.
		if (anguloInicial < anguloFinal)
		{
			// Percorre os ângulos e preenche.
			for (teta = anguloInicial; teta <= anguloFinal; teta += inc)
			{
				p = new Ponto(xCentro + x, yCentro - y);
				lista.add(p);
				
				dXtemp = dX * varCos - dY * varSen;
				dYtemp = dY * varCos + dX * varSen;

				dX = dXtemp;
				dY = dYtemp;

				x = (int) dX;
				y = (int) dY;
			}
			
			if (borda)
				lista.addAll(new Segmento(centro, p).getListaPontos());
			
			return lista;
		}

		// Percurso do ângulo final ao inicial.
		
		// Percorre os ângulos e preenche.		
		for (teta = 0; teta <= anguloFinal; teta += inc)
		{
			p = new Ponto(xCentro + x, yCentro - y);
			lista.add(p);
			
			dXtemp = dX * varCos - dY * varSen;
			dYtemp = dY * varCos + dX * varSen;

			dX = dXtemp;
			dY = dYtemp;

			x = (int) dX;
			y = (int) dY;
		}		
		for (teta = anguloInicial; teta < 2 * Math.PI; teta += inc)
		{
			p = new Ponto(xCentro + x, yCentro - y);
			lista.add(p);
			
			dXtemp = dX * varCos - dY * varSen;
			dYtemp = dY * varCos + dX * varSen;

			dX = dXtemp;
			dY = dYtemp;

			x = (int) dX;
			y = (int) dY;
		}
		
		if (borda)
			lista.addAll(new Segmento(centro, p).getListaPontos());
		
		return lista;	
	}

	public Ponto getCentro()
	{
		return centro;
	}

	public int getRaio()
	{
		return raio;
	}
	
	public void addSombreamento(SombreamentoPizza sombreamento, int n)
	{
		sombreamento.sombrear(centro, raio, anguloInicial, anguloFinal, n, listaPontos);
	}
	
}
