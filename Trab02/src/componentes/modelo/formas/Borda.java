package componentes.modelo.formas;

/**
 * Representa uma borda do algoritmo de Scan Lines
 */
public class Borda implements Comparable<Borda>{
	private int yTopo;
	private Double incremento, x;
	private boolean necessitaAjuste;

	public Borda(int topo, Double min, Double incremento) {
		super();
		yTopo = topo;
		x = min;
		this.incremento = incremento;
	}

	public int getYTopo() {
		return yTopo;
	}

	public Double getX() {
		return x;
	}

	public Double getIncremento() {
		return incremento;
	}

	public int compareTo(Borda borda) {		
		return (x>borda.x? 1: x<borda.x? -1: 0);
	}
	
	/**
	 * Cria uma nova borda, incrementando.
	 * 
	 * @param yLinha
	 * @param passo
	 * @return
	 */
	public Borda incrementar(int yLinha, int passo) {
		Borda borda = null;
		
		if (incremento.isInfinite() == true)
			return null;
		
		if (yLinha < yTopo)
			borda = new Borda(yTopo, x+passo*incremento, incremento);
			
		return borda;
	}

	public int getXint() {
		return (int) Math.round(x);
	}

	@Override
	public String toString() {
		return "\nYtopo: " + yTopo + ", X: " + x + ", inc: " + incremento ;
	}

	public void setNecessitaAjuste(int passo) {
		this.necessitaAjuste = true;
		x += passo*incremento;
	}

	public boolean necessitaAjuste() {
		return necessitaAjuste;
	}
	
	public Borda copiar() {
		return new Borda(yTopo, x, incremento);
	}
	
}
