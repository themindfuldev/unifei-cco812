package graficos.modelo;

public class NumerosAleatorios  {
	private int[] vetorNumeros;
	private int quantidade;
	
	public NumerosAleatorios(int quantidade)
	{
		this.quantidade = quantidade;
		
		// Inicialização
		vetorNumeros = new int[quantidade];

		novaDistribuicao();
	}

	public void novaDistribuicao() {
		// Declarações de variáveis
		int i;
		
		// Povoamento do vetor
		for (i=0; i<quantidade; i++)
			vetorNumeros[i] = (int) Math.round(Math.random()*1000);
	}
	
	public float getPercentagemPares()
	{
		// Declarações de variáveis
		int i, contador;
		float percentagem;
		
		// Inicialização
		contador = 0;

		// Cálculo
		for (i=0; i<vetorNumeros.length; i++)
			if (vetorNumeros[i]%2 == 0) contador++;
		percentagem = (float)contador/vetorNumeros.length;
		
		return percentagem;
	}
	
	public float getPercentagemImpares()
	{
		// Declarações de variáveis
		int i, contador;
		float percentagem;
		
		// Inicialização
		contador = 0;

		// Cálculo
		for (i=0; i<vetorNumeros.length; i++)
			if (vetorNumeros[i]%2 == 1) contador++;
		percentagem = (float)contador/vetorNumeros.length;
		
		return percentagem;
	}
	
	public float getPercentagemPrimos()
	{
		// Declarações de variáveis
		int i, j, contador;
		float percentagem;
		boolean primo, laco;
		
		// Inicialização
		contador = 0;

		// Cálculo
		for (i=0; i<vetorNumeros.length; i++)
		{
			primo = true;
			laco = true;
			
			for (j=1; j<vetorNumeros[i] && laco; j++)
			{
				if (mdc(vetorNumeros[i], j) != 1)
				{
					primo = false;
					laco = false;
				}
			}
			if (primo == true) contador++;
		}
		percentagem = (float)contador/vetorNumeros.length;
		
		return percentagem;
	}
	
	public float getPercentagemEsparsidade()
	{
		// Declarações de variáveis
		int i, contador;
		float percentagem;
		
		// Inicialização
		contador = 0;

		// Cálculo
		for (i=0; i<vetorNumeros.length; i++)
			if (vetorNumeros[i] == 0) contador++;
		percentagem = (float)contador/vetorNumeros.length;
		
		return percentagem;
	}
	
	public float getPercentagemMenorMedia()
	{
		// Declarações de variáveis
		int i, contador, soma, media;
		float percentagem;
		
		// Inicialização
		contador = 0;
		soma = 0;

		// Média
		for (i=0; i<vetorNumeros.length; i++)
			soma += vetorNumeros[i];
		media = (int) soma/vetorNumeros.length;
		
		// Cálculo
		for (i=0; i<vetorNumeros.length; i++)
			if (vetorNumeros[i] < media) contador++;
		percentagem = (float)contador/vetorNumeros.length;
		
		return percentagem;
	}
	
	private int mdc(int m, int n)
	{
		// Declarações de variáveis
		int x, y, r;
		
		// Inicialização
		x = m;
		y = n;
		
		do
		{
			r = x % y;
			x = y;
			y = r;
		} while (r > 0);
		
		return x;
	}
	
	public float getPercentagem(int i)
	{
		// Dispara o método adequado para a iteração.
		switch (i)
		{
			case 0: return getPercentagemPares();
			case 1: return getPercentagemImpares();
			case 2: return getPercentagemPrimos();
			case 3: return getPercentagemEsparsidade();
			case 4: return getPercentagemMenorMedia();
			
			default: return -1;
		}
		
	}
	
}
