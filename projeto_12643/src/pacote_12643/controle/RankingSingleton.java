package pacote_12643.controle;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import pacote_12643.modelo.Recorde;

/**
 * Tabela singleton do ranking das pontuações.
 * @author Tiago
 */
public class RankingSingleton {
	// Design pattern Singleton
	private static RankingSingleton instance = new RankingSingleton();
	
	public static RankingSingleton getInstance() {
		return instance;
	}
	
	/**
	 * Conjunto de rankings. 
	 */
	private Set<Recorde> ranking;

	/**
	 * Construtor
	 */
	public RankingSingleton() {
		ranking = new TreeSet<Recorde>();
	}
	
	/**
	 * Insere registro no ranking. 
	 * @param nome
	 * @param pontuacao
	 */
	public void inserir(String nome, int pontuacao) {
		ranking.add(new Recorde(nome, pontuacao));
	}
	
	/**
	 * Obtém descrição dos 5 melhores colocados no ranking.
	 * @return
	 */
	public String top5() {
		// Declaração de variáveis
		StringBuilder sb = new StringBuilder();
		Iterator<Recorde> iterador;
		Recorde recorde;
		int i, tam;
		
		// Constrói a mensagem.
		sb.append("Ranking top 5:\n\n");
		
		if (ranking.size() > 5) tam = 5;
		else tam = ranking.size(); 
		
		iterador = ranking.iterator();
		for (i=0; i<tam; i++) {
			recorde = iterador.next();
			sb.append(i + ") " + recorde.getNome() + " - " + recorde.getPontuacao() + "\n");
		}
		
		return sb.toString();
	}
	
}
