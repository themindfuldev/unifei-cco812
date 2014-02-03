package componentes.modelo.graficos;

import java.util.HashMap;

import componentes.modelo.sombreamento.Sombreamento;
import componentes.modelo.sombreamento.SombreamentoCircular;
import componentes.modelo.sombreamento.SombreamentoDiagonalNegativaConstante;
import componentes.modelo.sombreamento.SombreamentoDiagonalNegativaVariavel;
import componentes.modelo.sombreamento.SombreamentoDiagonalPositivaConstante;
import componentes.modelo.sombreamento.SombreamentoDiagonalPositivaVariavel;
import componentes.modelo.sombreamento.SombreamentoHorizontalConstante;
import componentes.modelo.sombreamento.SombreamentoHorizontalVariavel;
import componentes.modelo.sombreamento.SombreamentoPontualBarra;
import componentes.modelo.sombreamento.SombreamentoPontualPizza;
import componentes.modelo.sombreamento.SombreamentoRadial;
import componentes.modelo.sombreamento.SombreamentoVerticalConstante;
import componentes.modelo.sombreamento.SombreamentoVerticalVariavel;

public class ConstantesSombras {
	// Gráficos de barras
	public final static int SOMBRA_HORIZONTAL_CONSTANTE = 100;
	public final static int SOMBRA_VERTICAL_CONSTANTE = 101;
	public final static int SOMBRA_DIAGONAL_NEGATIVA_CONSTANTE = 102;
	public final static int SOMBRA_DIAGONAL_POSITIVA_CONSTANTE = 103;
	public final static int SOMBRA_HORIZONTAL_VARIAVEL = 104;
	public final static int SOMBRA_VERTICAL_VARIAVEL = 105;
	public final static int SOMBRA_DIAGONAL_NEGATIVA_VARIAVEL = 106;
	public final static int SOMBRA_DIAGONAL_POSITIVA_VARIAVEL = 107;
	public final static int SOMBRA_PONTUAL_BARRA = 108;
	
	// Gráficos de pizza
	public final static int SOMBRA_RADIAL = 109;
	public final static int SOMBRA_CIRCULAR = 110;
	public final static int SOMBRA_PONTUAL_PIZZA = 111;
	
	// Tabela de Sombras
	public static HashMap<Integer, Sombreamento> tabelaSombras;
	
	static {
		tabelaSombras = new HashMap<Integer, Sombreamento>();
		tabelaSombras.put(ConstantesSombras.SOMBRA_HORIZONTAL_CONSTANTE, new SombreamentoHorizontalConstante());
		tabelaSombras.put(ConstantesSombras.SOMBRA_HORIZONTAL_VARIAVEL, new SombreamentoHorizontalVariavel());
		tabelaSombras.put(ConstantesSombras.SOMBRA_VERTICAL_CONSTANTE, new SombreamentoVerticalConstante());
		tabelaSombras.put(ConstantesSombras.SOMBRA_VERTICAL_VARIAVEL, new SombreamentoVerticalVariavel());
		tabelaSombras.put(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_CONSTANTE, new SombreamentoDiagonalNegativaConstante());
		tabelaSombras.put(ConstantesSombras.SOMBRA_DIAGONAL_NEGATIVA_VARIAVEL, new SombreamentoDiagonalNegativaVariavel());
		tabelaSombras.put(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_CONSTANTE, new SombreamentoDiagonalPositivaConstante());
		tabelaSombras.put(ConstantesSombras.SOMBRA_DIAGONAL_POSITIVA_VARIAVEL, new SombreamentoDiagonalPositivaVariavel());
		tabelaSombras.put(ConstantesSombras.SOMBRA_PONTUAL_BARRA, new SombreamentoPontualBarra());
		tabelaSombras.put(ConstantesSombras.SOMBRA_CIRCULAR, new SombreamentoCircular());
		tabelaSombras.put(ConstantesSombras.SOMBRA_RADIAL, new SombreamentoRadial());
		tabelaSombras.put(ConstantesSombras.SOMBRA_PONTUAL_PIZZA, new SombreamentoPontualPizza());

	}
}
