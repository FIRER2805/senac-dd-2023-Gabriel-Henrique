package model.dao.vacinas.vo;

import java.time.LocalDate;

public class VacinaVO {

	private int id;
	private String paisDeOrigem;
	private EstagioPesquisaVacina estagioDaPesquisa;
	private LocalDate dataDeInicioDaPesquisa;
	private PessoaVO pesquisadorResponsavel;
	
	public VacinaVO() {
		super();
	}
	
	public VacinaVO(int id, String paisDeOrigem, EstagioPesquisaVacina estagioDaPesquisa, LocalDate dataDeInicioDaPesquisa,
			PessoaVO pesquisadorResponsavel) {
		super();
		this.id = id;
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataDeInicioDaPesquisa = dataDeInicioDaPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	
	public VacinaVO(String paisDeOrigem, EstagioPesquisaVacina estagioDaPesquisa, LocalDate dataDeInicioDaPesquisa,
			PessoaVO pesquisadorResponsavel) {
		super();
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataDeInicioDaPesquisa = dataDeInicioDaPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}
	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}
	public EstagioPesquisaVacina getEstagioDaPesquisa() {
		return estagioDaPesquisa;
	}
	public void setEstagioDaPesquisa(EstagioPesquisaVacina estagioDaPesquisa) {
		this.estagioDaPesquisa = estagioDaPesquisa;
	}
	public LocalDate getDataDeInicioDaPesquisa() {
		return dataDeInicioDaPesquisa;
	}
	public void setDataDeInicioDaPesquisa(LocalDate dataDeInicioDaPesquisa) {
		this.dataDeInicioDaPesquisa = dataDeInicioDaPesquisa;
	}
	public PessoaVO getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}
	public void setPesquisadorResponsavel(PessoaVO pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

}