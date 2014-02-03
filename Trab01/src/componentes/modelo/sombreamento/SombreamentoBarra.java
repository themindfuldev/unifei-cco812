package componentes.modelo.sombreamento;

import java.util.List;

import componentes.modelo.formas.FormaDesenhavel;
import componentes.modelo.formas.Ponto;

public interface SombreamentoBarra extends Sombreamento {
	public void sombrear(Ponto pontoInicial, Ponto pontoFinal, int n, List<FormaDesenhavel> listaFormasPlotaveis);
}
