package pacote_12643.visao.mediator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pacote_12643.modelo.Forma;
import pacote_12643.modelo.Linha3D;
import pacote_12643.modelo.Poligono3D;
import pacote_12643.modelo.Ponto3D;
import pacote_12643.visao.gui.JanelaPrincipal;

/**
 * Mediator para a Janela Pricipal
 */
public class MediatorPrincipal {
	public MediatorPrincipal(JanelaPrincipal janelaFormas) {
		
		List<Forma> lista = null;
		try {
			lista = lerArquivo();
			janelaFormas.getPnlAreaDesenho().adicionarListaDeFormaDesenhavel(lista);
			janelaFormas.getPnlAreaDesenho().repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Forma> lerArquivo() throws IOException {
		BufferedReader br;
		List<Forma> lista;
		String linha;
		String[] linhaRepartida;
		Poligono3D poligono3d;
		Ponto3D ponto = null, pontof = null;
		int i, x, y, z;
		
		br = new BufferedReader(new FileReader("figura.dat"));
		lista = new ArrayList<Forma>();
		
		while ((linha = br.readLine()) != null) {
			linhaRepartida = linha.split(" ");
			
			if (linhaRepartida.length == 6) {
				for (i=0; i<linhaRepartida.length; i+=3) {
					x = Integer.parseInt(linhaRepartida[i]);
					y = Integer.parseInt(linhaRepartida[i+1]);
					z = Integer.parseInt(linhaRepartida[i+2]);
					
					if (i==0)
						ponto = new Ponto3D(x, y, z);	
					else
						pontof = new Ponto3D(x, y, z);
				}
				lista.add(new Linha3D(ponto.traduzir(), pontof.traduzir()));
			}
			else {
				poligono3d = new Poligono3D();
				for (i=0; i<linhaRepartida.length; i+=3) {
					x = Integer.parseInt(linhaRepartida[i]);
					y = Integer.parseInt(linhaRepartida[i+1]);
					z = Integer.parseInt(linhaRepartida[i+2]);
					
					ponto = new Ponto3D(x, y, z);	
					poligono3d.adicionarPonto(ponto.traduzir());
				}
				lista.add(poligono3d);
			}
		}
		
		return lista;
	}

}
