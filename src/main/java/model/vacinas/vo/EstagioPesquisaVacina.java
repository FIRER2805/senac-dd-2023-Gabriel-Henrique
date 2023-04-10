package model.vacinas.vo;

public enum EstagioPesquisaVacina {
	INICIAL (1),
	TESTES (2),
	APLICACAO_EM_MASSA (3);
	
	private int valor;
	
	private EstagioPesquisaVacina(int valor)
	{
		this.valor = valor;
	}
	
	public int getValor()
	{
		return this.valor;
	}
	
	public static EstagioPesquisaVacina pegarEstagioPesquisaPorValor(int valor)
	{
		EstagioPesquisaVacina retorno = null;
		for(EstagioPesquisaVacina elemento: EstagioPesquisaVacina.values())
		{
			if(elemento.getValor() == valor)
			{
				retorno = elemento;
			}
		}
		return retorno;
	}
}
