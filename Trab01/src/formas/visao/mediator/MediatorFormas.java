package formas.visao.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import componentes.modelo.formas.PoligonoRegular;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Retangulo;
import componentes.modelo.graficos.ConstantesSombras;
import componentes.modelo.sombreamento.SombreamentoBarra;

import formas.visao.gui.DialogoPonto;
import formas.visao.gui.DialogoSombreamento;
import formas.visao.gui.JanelaFormas;

public class MediatorFormas {
	private JanelaFormas janelaFormas;

	public MediatorFormas(JanelaFormas janelaFormas) {
		super();
		this.janelaFormas = janelaFormas;
	}

	public void registraEventos() {
		janelaFormas.getCmbFormas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcao;

				// Obter seleção
				opcao = janelaFormas.getCmbFormas().getSelectedIndex();
				desenharForma(opcao);
				janelaFormas.getCmbFormas().setSelectedIndex(0);
			}
		});
		janelaFormas.getBtnSair().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	private void desenharForma(int opcao) {
		switch (opcao) {
		case 1:
			criarQuadrado();
			break;
			
		case 2:
			criarRetangulo();
			break;
			
		case 3:
			criarPoligono();
			break;
		}
	}

	private void criarQuadrado() {
		// Obter parâmetros do objeto
		DialogoSombreamento janelaSombreamento;
		List<Integer> listaSombreamento;
		Retangulo quadrado;
		DialogoPonto dialogoPonto;
		Ponto pontoInicial,
		pontoFinal;
		String ladoStr;
		int lado;

		// Obter parâmetros
		dialogoPonto = new DialogoPonto(janelaFormas,
				"Entre com o ponto inicial.");
		pontoInicial = dialogoPonto.getPonto();
		if (pontoInicial == null)
			return;

		ladoStr = JOptionPane.showInputDialog(janelaFormas,
				"Entre com o lado", "Novo quadrado", JOptionPane.PLAIN_MESSAGE);
		if (ladoStr == null)
			return;

		try {
			lado = Integer.parseInt(ladoStr);
		} catch (NumberFormatException e) {
			return;
		}
		
		pontoFinal = new Ponto(pontoInicial.getX()+lado, pontoInicial.getY()+lado);

		// Instanciar objeto
		quadrado = new Retangulo(pontoInicial, pontoFinal);

		// Adicionar sombreamento
		janelaSombreamento = new DialogoSombreamento(janelaFormas);
		listaSombreamento = janelaSombreamento.getListaSombreamento();
		if (listaSombreamento == null) return;
		
		for (Integer sombra: listaSombreamento)
			quadrado.addSombreamento((SombreamentoBarra)ConstantesSombras.tabelaSombras.get(sombra), (int) lado/10);

		// Desenhar
		janelaFormas.getPnlAreaDesenho().verificarFuro(quadrado);
		janelaFormas.getPnlAreaDesenho().adicionarFormaDesenhavel(quadrado);
		janelaFormas.getPnlAreaDesenho().repaint();
	}

	private void criarRetangulo() {
		DialogoSombreamento janelaSombreamento;
		List<Integer> listaSombreamento;
		Retangulo retangulo;
		DialogoPonto dialogoPontoSuperiorEsquerdo;
		DialogoPonto dialogoPontoInferiorDireito;
		Ponto pontoSuperiorEsquerdo,pontoInferiorDireito;
		int base, altura;

		// Obter parâmetros
		dialogoPontoSuperiorEsquerdo = new DialogoPonto(janelaFormas,
				"Entre com o ponto superior esquerdo.");
		pontoSuperiorEsquerdo = dialogoPontoSuperiorEsquerdo.getPonto();
		if (pontoSuperiorEsquerdo == null)
			return;
		
		dialogoPontoInferiorDireito = new DialogoPonto(janelaFormas,
			"Entre com o ponto inferior direito.");
		pontoInferiorDireito = dialogoPontoInferiorDireito.getPonto();
		if (pontoInferiorDireito == null)
			return;

		// Instanciar objeto
		retangulo = new Retangulo(pontoSuperiorEsquerdo, pontoInferiorDireito);
		
		// Instanciando base e altura do retangulo
		base = pontoInferiorDireito.getX() - pontoSuperiorEsquerdo.getX();
		altura= pontoInferiorDireito.getY() - pontoSuperiorEsquerdo.getY();
		
		// Adicionar sombreamento
		janelaSombreamento = new DialogoSombreamento(janelaFormas);
		listaSombreamento = janelaSombreamento.getListaSombreamento();
		
		if (listaSombreamento == null) return;
		
		for (Integer sombra: listaSombreamento)
			retangulo.addSombreamento((SombreamentoBarra)ConstantesSombras.tabelaSombras.get(sombra), (int) Math.min(base, altura)/10);

		// Desenhar
		janelaFormas.getPnlAreaDesenho().verificarFuro(retangulo);
		janelaFormas.getPnlAreaDesenho().adicionarFormaDesenhavel(retangulo);
		janelaFormas.getPnlAreaDesenho().repaint();
	}
	
	private void criarPoligono() {
		// Obter parâmetros do objeto
		DialogoSombreamento janelaSombreamento;		
		ArrayList<Ponto> listaArestas;	
		List<Integer> listaSombreamento;
		DialogoPonto dialogoPonto;
		Ponto ponto;
		PoligonoRegular poligono;

		listaArestas = new ArrayList<Ponto>();
		// Obter parâmetros
		do{
			dialogoPonto = new DialogoPonto(janelaFormas,
					"Entre com uma aresta do polígono.", "Adicionar", "Terminar");
			ponto = dialogoPonto.getPonto();
			if(ponto!=null)
				listaArestas.add(ponto);
		}while(ponto != null);

		if (listaArestas.size() < 2)
		{
			JOptionPane.showMessageDialog(janelaFormas, "Insira ao menos 3 pontos para o poligono!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		// Instanciar objeto
		poligono = new PoligonoRegular(listaArestas, 10);
		
		janelaSombreamento = new DialogoSombreamento(janelaFormas, false);
		listaSombreamento = janelaSombreamento.getListaSombreamento();
		
		if (listaSombreamento == null) return;
		
		for (Integer sombra: listaSombreamento)
			poligono.addSombreamento((SombreamentoBarra)ConstantesSombras.tabelaSombras.get(sombra), 1);

		// Desenhar
		if (poligono.getFormas().size() == 0)
		{
			JOptionPane.showMessageDialog(janelaFormas, "Nao foi possivel formar poligono com esta sequencia de pontos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//janelaFormas.getPnlAreaDesenho().verificarFuro(retangulo);
		janelaFormas.getPnlAreaDesenho().adicionarFormaDesenhavel(poligono);
		janelaFormas.getPnlAreaDesenho().repaint();
		
	}
}
