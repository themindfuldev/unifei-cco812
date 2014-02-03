package principal;

import javax.swing.JOptionPane;

import formas.visao.gui.JanelaFormas;
import graficos.visao.gui.JanelaGraficos;

public class Principal {

	public static void main(String[] args) {
		Object[] possibleValues = {"", "Sombreamento de Gráficos",
				"Sombreamento de Formas Regulares" };
		Object selectedValue = JOptionPane.showInputDialog(null,
				"Escolha o módulo a ser executado:", "Trabalho 01 de CCO812",
				JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);

		if (selectedValue == possibleValues[1])
			new JanelaGraficos();
		else if (selectedValue == possibleValues[2])
			new JanelaFormas();
	}

}
