package pacote_12643.modelo;

/**
 * Recorde a figurar no ranking.
 * @author Tiago
 */
public class Recorde implements Comparable<Recorde> {
	/**
	 * Nome do jogador.
	 */
	private String nome;
	/**
	 * Pontuação do jogador.
	 */
	private int pontuacao;
	
	/**
	 * Construtor.
	 * @param nome
	 * @param pontuacao
	 */
	public Recorde(String nome, int pontuacao) {
		super();
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	// Métodos get
	public String getNome() {
		return nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Recorde o) {
		return o.pontuacao-pontuacao;
	}
	
}
