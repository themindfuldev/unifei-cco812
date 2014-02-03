package pacote_12643.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import pacote_12643.controle.RankingSingleton;
import pacote_12643.controle.ThreadSom;
import pacote_12643.modelo.Parametrizacao;
import pacote_12643.modelo.Parametrizacao.Nivel;

/**
 * Mediator principal de eventos da janela.
 * @author Tiago
 */
public class MediatorPrincipal {
	/**
	 * Janela principal.
	 */
	private JanelaPrincipal janela;

	/**
	 * Construtor.
	 * @param janela
	 */
	public MediatorPrincipal(JanelaPrincipal janela) {
		this.janela = janela;
		
		registrarEventos();
	}

	/**
	 * Registra eventos da interface.
	 */
	private void registrarEventos() {
		janela.getJMenuItemSair().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
			}
		});
		janela.getJMenuItemNovoJogo().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Declara��o de vari�veis.
				DialogoParametrizacao dialogo = new DialogoParametrizacao(janela);
				Parametrizacao parametrizacao = dialogo.getParametrizacao();
				
				// Se houver parametriza��o, inicia novo jogo.
				if (parametrizacao != null) {
					somInicial();

					janela.getJPanelJogo().novoJogo(parametrizacao);
					janela.getJPanelStatus().novoJogo(parametrizacao);
				}
			}
		});
		janela.getJMenuItemTerminar().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Interrompe jogo.
				janela.getJPanelJogo().parar();
				janela.travarMenus(false);
			}
		});
		janela.getJMenuItemDemo().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Declara��o de vari�veis.
				Parametrizacao parametrizacao = new Parametrizacao("Demo", 3, Nivel.MEDIO, true);
				
				// Inicia demo.
				somInicial();
				
				janela.getJPanelJogo().demo(parametrizacao);
				janela.getJPanelStatus().novoJogo(parametrizacao);
			}
		});
		janela.getJMenuItemVisualizarRanking().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Declara��o de vari�veis.
				String ranking = RankingSingleton.getInstance().top5();
				
				// Visualiza��o.
				JOptionPane.showMessageDialog(janela, ranking, "Ranking", JOptionPane.WARNING_MESSAGE);
			}
		});
		janela.getJMenuItemSobre().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(janela, "Projeto final de CCO812\nAluno: Tiago Romero Garcia - 12643", "Cr�ditos", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		janela.getJMenuItemAjuda().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// Declara��o de vari�veis.
				String ajuda = 
						"Este jogo representa uma mesa inclinada, onde bolas rolam abaixo, colidindo" +
						"\ncom os obst�culos e com outras bolas, atingindo ao final canaletas que con-" +
						"\n-ferem uma determinada pontua��o.\n\n" +
						"Para iniciar um jogo, v� ao menu Jogo / Novo jogo. Entre com os dados da pa-" +
						"\n-rametriza��o inicial do jogo, e a primeira fase se iniciar�. Primeiramente," +
						"\nclique nas posi��es que deseja deixar cada bola para rolar abaixo. Ap�s to-" +
						"\n-das as bolas rolarem abaixo, a contabilidade da pontua��o � realizada e, " +
						"\ndependendo de seu resultado, uma nova fase pode aparecer.\n" +
						"\nO jogo pode ser terminado a qualquer momento no menu Jogo / Terminar jogo, " +
						"\ne pode ser pausado pela tecla F3.\n" +
						"\nPara ver uma demonstra��o do jogo, v� ao menu Jogo / Demonstra��o.\n" +
						"\nPara visualizar os rankings, v� ao meno Jogo / Visualizar ranking.";
				
				// Visualiza��o.
				JOptionPane.showMessageDialog(janela, ajuda, "Ajuda", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		janela.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
				// Invoca PAUSE.
				if (e.getKeyCode() == KeyEvent.VK_F3) {
					janela.getJPanelJogo().alternarPause();
				}
			}
			public void keyTyped(KeyEvent e) {
				
			}
		});
	}

	/**
	 * Dispara som inicial. 
	 */
	void somInicial() {
		ThreadSom somThread = new ThreadSom("snd/obstac.wav");
		try {
			somThread.start();
		} catch (RuntimeException e) {
		}
	}
	
}
