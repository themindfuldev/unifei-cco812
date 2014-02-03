package pacote_12643.visao;

import static pacote_12643.modelo.Parametrizacao.ALTURA;
import static pacote_12643.modelo.Parametrizacao.LARGURA;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pacote_12643.controle.ContextoJogo;
import pacote_12643.controle.RankingSingleton;
import pacote_12643.controle.ThreadAdicionarBolasDemo;
import pacote_12643.controle.ThreadMovimento;
import pacote_12643.controle.ThreadSom;
import pacote_12643.modelo.Bola;
import pacote_12643.modelo.Desenho;
import pacote_12643.modelo.Parametrizacao;

/**
 * Panel cenário para o jogo.
 * @author Tiago
 */
@SuppressWarnings("serial")
public class PanelTabuleiro extends JPanel {
	/**
	 * Parametrização corrente. 
	 */
	private Parametrizacao parametrizacao;
	/**
	 * Contexto corrente.
	 */
	private ContextoJogo contexto;
	/**
	 * Strings das pontuações.
	 */
	private String[] pontuacao = new String[] {"10", "20", "30", "20", "10"};
	/**
	 * Janela principal.
	 */
	private JanelaPrincipal janelaPrincipal;
	/**
	 * Imagem de fundo.
	 */
	private Image fundo;
	/**
	 * Thread de movimentação.
	 */
	private ThreadMovimento t;
	/**
	 * Cor de desenho.
	 */
	private Color cor;
	/**
	 * Bola flutuante.
	 */
	private Bola bolaFlutuante;
	/**
	 * Lado esquerdo para inserir bolas.
	 */
	private boolean ladoInsercao;
	/**
	 * Indicador para a exibição de PAUSADO.
	 */
	private boolean pausado;
	
	/**
	 * Construtor.
	 * @param janelaPrincipal
	 */
	public PanelTabuleiro(JanelaPrincipal janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		fundo = new ImageIcon("img/mesa.jpg").getImage();
		setSize(LARGURA, ALTURA);
	}
	
	// Métodos get
	public ContextoJogo getContexto() {
		return contexto;
	}

	public Parametrizacao getParametrizacao() {
		return parametrizacao;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(fundo,0,0,null);
		
		// Linha de largada
		g.setColor(Color.WHITE);
		g.drawLine(0, 26, LARGURA, 26);
		g.drawLine(0, 27, LARGURA, 27);
		
		// Canaletas
		int div = LARGURA/5;
		int[] pont = ContextoJogo.getVetorPontuacao();
		int divCor = 8;
		for (int i=0; i<5; i++) {
			g.setColor(new Color(0, 128, pont[i]*divCor));
			g.fillRect(i*div, 550, div, 50);
			g.setColor(Color.WHITE);
			g.drawString(pontuacao[i], (int)(i*div+div/2-5), 545);
		}
		
		// Grid
		cor = Color.WHITE;
		for (int i=0; i<25; i+=5) {
			for (int j=0; j<LARGURA; j+=6) {
				g.setColor(trocaCor());
				g.fillRect(j, i, 5, 5);
			}
		}
		
		// Objetos
		if (contexto != null) {
			try {
				for (Desenho d: contexto.getListaDesenhos())
					d.desenhar(g);
			} catch (RuntimeException e) {
			}
		}
		
		// Bola flutuante
		if (bolaFlutuante != null)
			bolaFlutuante.desenhar(g);
		
		// Pausado
		if (pausado == true) {
			g.setColor(Color.BLACK);
			g.fillRect(100, 200, 135, 50);
			g.setColor(Color.GREEN);
			g.drawRect(100, 200, 135, 50);
			g.setColor(Color.WHITE);
			g.drawString("PAUSE!", 150, 220);
			g.drawString("F3 para continuar", 120, 240);
		}
	}
	
	/**
	 * Troca a cor viagente. 
	 * @return
	 */
	private Color trocaCor() {
		if (cor.equals(Color.WHITE)) cor = Color.BLACK;
		else if (cor.equals(Color.BLACK)) cor = Color.WHITE; 
		return cor;
	}

	/**
	 * Inicia novo jogo.
	 * @param parametrizacao
	 */
	public void novoJogo(Parametrizacao parametrizacao) {
		this.parametrizacao = parametrizacao;
		
		// Novo contexto.
		contexto = new ContextoJogo();
		pausado = false;
		
		// Prepara o contexto
		parametrizacao.adicionaObstaculos(contexto);
		PanelTabuleiro.this.repaint();
		adicionarBolas(contexto);
		
		// Inicia thread de movimentação.
		t = new ThreadMovimento(this);
		t.start();
		
		janelaPrincipal.travarMenus(true);
	}
	
	/**
	 * Inicia adição de bolas
	 * @param contexto
	 */
	private void adicionarBolas(final ContextoJogo contexto) {
		bolaFlutuante = new Bola(contexto);
		bolaFlutuante.setPosicao(new Point(LARGURA/2, 10));
		ladoInsercao = false;
		
		// Adiciona listener para inserir bola
		addMouseListener(new MouseAdapter(){
			int contador = 0;
			int total = parametrizacao.getNumeroBolas();
			
			public void mouseReleased(MouseEvent e) {
				if (contador < total && pausado == false) {
					// Adiciona bola
					Bola b = new Bola(contexto);
					b.setPosicao(new Point(e.getX(), 30));
					b.setCoef(0);
					
					contexto.addBola(b);
					contador++;
					
					if (contador == total)
						bolaFlutuante = null;
					else
						randomizaPosicao();
				}
				PanelTabuleiro.this.repaint();
			}
		});
		
		// Adiciona listener para visualizar bola.
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e) {
				if (bolaFlutuante != null && pausado == false) {
					// Exibe bola
					bolaFlutuante.setPosicao(new Point(e.getX(), 10));
					PanelTabuleiro.this.repaint();
				}
			}
		});
		randomizaPosicao();
	}

	/**
	 * Randomiza a posição do X e move o ponteiro do mouse.
	 */
	protected void randomizaPosicao() {
		try {
			int x = (int) (Math.random()*(Parametrizacao.LARGURA-50)/2 + 10);
			
			if (ladoInsercao) 
				x += (Parametrizacao.LARGURA-50)/2;
			
			new Robot().mouseMove(janelaPrincipal.getX()+x+10, janelaPrincipal.getY()+65);
			
			ladoInsercao = !ladoInsercao;
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}

	public void demo(Parametrizacao parametrizacao) {
		this.parametrizacao = parametrizacao;
		
		// Novo contexto
		contexto = new ContextoJogo();
		pausado = false;
		
		// Prepara o contexto
		parametrizacao.adicionaObstaculos(contexto);
		
		// Inicia thread de movimentação.
		t = new ThreadMovimento(this);
		t.start();
		
		adicionarBolasDemo(contexto);
		
		janelaPrincipal.travarMenus(true);
	}

	/**
	 * Prepara próxima fase.
	 */
	public void proximaFase() {
		// Atualiza status.
		janelaPrincipal.getJPanelStatus().fimDeFase(parametrizacao);
		janelaPrincipal.getJPanelStatus().repaint();
		
		// Avisa usuário
		ThreadSom somThread = new ThreadSom("snd/vitoria.wav");
		try {
			somThread.start();
		} catch (RuntimeException e) {
		}
		JOptionPane.showMessageDialog(null, "Você passou de fase!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
		
		// Novo contexto.
		contexto = new ContextoJogo();
		pausado = false;
		
		// Prepara contexto
		parametrizacao.adicionaObstaculos(contexto);
		PanelTabuleiro.this.repaint();
		
		if (parametrizacao.isDemo())
			adicionarBolasDemo(contexto);
		else
			adicionarBolas(contexto);
		
		// Inicia thread de movimentação.
		t = new ThreadMovimento(this);
		t.start();
	}

	/**
	 * Inicia adição de bolas na demonstração.
	 * @param contexto
	 */
	private void adicionarBolasDemo(ContextoJogo contexto) {
		new ThreadAdicionarBolasDemo(contexto, parametrizacao).start();
	}

	/**
	 * Termina o jogo.
	 */
	public void fimDeJogo() {
		// Atualiza status.
		janelaPrincipal.getJPanelStatus().fimDeFase(parametrizacao);
		janelaPrincipal.getJPanelStatus().repaint();
		
		// Prepara fim de jogo.
		bolaFlutuante = null;
		janelaPrincipal.travarMenus(false);
		t = null;
		
		// Insere recorde
		RankingSingleton.getInstance().inserir(parametrizacao.getNomeJogador(), parametrizacao.getPontuacao());
		
		// Avisa derrota
		ThreadSom somThread = new ThreadSom("snd/perda.wav");
		try {
			somThread.start();
		} catch (RuntimeException e) {
		}
		JOptionPane.showMessageDialog(null, "Você perdeu!", "Derrota", JOptionPane.INFORMATION_MESSAGE);
		
		// Remove listeners
		for (MouseListener l: getMouseListeners()) {
			removeMouseListener(l);
		}
		for (MouseMotionListener l: getMouseMotionListeners()) {
			removeMouseMotionListener(l);
		}
	}
	
	/**
	 * Interrompe jogo.
	 */
	public void parar() {
		t.setContinuar(false);
		t = null;
		bolaFlutuante = null;
	}
	
	/**
	 * Sai do jogo.
	 */
	public void sair() {
		if (t != null) {
			t.setContinuar(false);
			t.setSair(true);
		}
		bolaFlutuante = null;
		t = null;
	}

	/**
	 * Alterna pause.
	 */
	public void alternarPause() {
		if (t != null) {
			this.pausado = !pausado;
			t.setPausado(pausado);
			this.repaint();
		}
	}
	
}
