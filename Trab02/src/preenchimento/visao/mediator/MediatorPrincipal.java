package preenchimento.visao.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import preenchimento.visao.gui.JanelaPrincipal;

import componentes.modelo.formas.Poligono;
import componentes.modelo.formas.Ponto;
import componentes.modelo.formas.Segmento;

/**
 * Mediator para a Janela Pricipal
 */
public class MediatorPrincipal {
	private JanelaPrincipal janelaFormas;
	private ArrayList<Ponto> listaArestas;	

	public MediatorPrincipal(JanelaPrincipal janelaFormas) {
		super();
		this.janelaFormas = janelaFormas;
		listaArestas = new ArrayList<Ponto>();
	}

	/**
	 * Registra os eventos de interface
	 */
	public void registraEventos() {
		janelaFormas.getBtnCriarPoligono().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				criarPoligono();				
			}
		});
		janelaFormas.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				cancelar();			
			}
		});
		janelaFormas.getBtnFinalizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				finalizarPoligono();			
			}
		});
		janelaFormas.getBtnSair().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	protected void cancelar() {
		janelaFormas.getPnlAreaDesenho().limpar();
		janelaFormas.getPnlAreaDesenho().repaint();
		resetarInterface();
	}

	protected void finalizarPoligono() {
		Poligono poligono; 
		
		if (listaArestas.size() < 3)
		{
			JOptionPane.showMessageDialog(janelaFormas, "Insira ao menos 3 pontos para o poligono!", "Erro", JOptionPane.ERROR_MESSAGE);
			cancelar();
			return;
		}
		
		// Instanciar objeto
		poligono = new Poligono(listaArestas, 1);
		
		// Desenhar
		if (poligono.getFormas().size() == 0)
		{
			JOptionPane.showMessageDialog(janelaFormas, "Nao foi possivel formar poligono com esta sequencia de pontos!", "Erro", JOptionPane.ERROR_MESSAGE);
			resetarInterface();
			return;
		}
		
		janelaFormas.getPnlAreaDesenho().adicionarFormaDesenhavel(poligono);
		janelaFormas.getPnlAreaDesenho().repaint();
		
		resetarInterface();
	}

	private void resetarInterface() {
		janelaFormas.getPnlAreaDesenho().removeMouseListener(janelaFormas.getPnlAreaDesenho().getMouseListeners()[0]);
		janelaFormas.getPnlAreaDesenho().removeMouseMotionListener(janelaFormas.getPnlAreaDesenho().getMouseMotionListeners()[0]);

		listaArestas.clear();	
		janelaFormas.getBtnCancelar().setEnabled(false);
		janelaFormas.getBtnFinalizar().setEnabled(false);
		janelaFormas.getBtnCriarPoligono().setEnabled(true);
		janelaFormas.getLblPosicao().setText("(000,000)");
		janelaFormas.getBtnCriarPoligono().requestFocusInWindow();
	}

	/**
	 * Cria um poligono 
	 */
	private void criarPoligono() {
		// Obter parâmetros do objeto
		JOptionPane.showMessageDialog(janelaFormas, "Insira ao menos 3 pontos e não feche o polígono.\nQuando terminar clique no botão Terminar.\nPara cancelar, clique no botão Cancelar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		
		listaArestas.clear();	
		janelaFormas.getBtnCancelar().setEnabled(true);
		janelaFormas.getBtnFinalizar().setEnabled(true);
		janelaFormas.getBtnCriarPoligono().setEnabled(false);
		
		janelaFormas.getPnlAreaDesenho().limpar();
		janelaFormas.getPnlAreaDesenho().repaint();
		
		janelaFormas.getPnlAreaDesenho().addMouseListener(new EventoMouse());
		janelaFormas.getPnlAreaDesenho().addMouseMotionListener(new EventoMovimentoMouse());
	}
	
	private class EventoMouse extends MouseAdapter {
		private Ponto pAnterior;
		
		public void mouseReleased(MouseEvent e) {
			Segmento seg;
			Ponto p = new Ponto(e.getX(), e.getY());
			listaArestas.add(p);
			
			if (pAnterior != null) {
				seg = new Segmento(pAnterior, p);
				janelaFormas.getPnlAreaDesenho().adicionarFormaDesenhavel(seg);
				janelaFormas.getPnlAreaDesenho().repaint();
			}
				
			pAnterior = p;
		}
	}
	
	private class EventoMovimentoMouse extends MouseMotionAdapter {
		public void mouseMoved(MouseEvent e) {
			janelaFormas.getLblPosicao().setText(String.format("(%03d,%03d)", e.getX(), e.getY()));
		}
	}
}
