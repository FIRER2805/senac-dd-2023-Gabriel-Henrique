package model.dao.vacinas.vo;

import java.time.LocalDate;

public class VacinaVO {

	private int id;
	private String paisDeOrigem;
	private int estagioDaPesquisa;
	private LocalDate dataDeInicioDaPesquisa;
	private String pesquisadorResponsavel;
	
	public VacinaVO() {
		super();
	}
	
	public VacinaVO(int id, String paisDeOrigem, int estagioDaPesquisa, LocalDate dataDeInicioDaPesquisa,
			String pesquisadorResponsavel) {
		super();
		this.id = id;
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataDeInicioDaPesquisa = dataDeInicioDaPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	
	public VacinaVO(String paisDeOrigem, int estagioDaPesquisa, LocalDate dataDeInicioDaPesquisa,
			String pesquisadorResponsavel) {
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
	public int getEstagioDaPesquisa() {
		return estagioDaPesquisa;
	}
	public void setEstagioDaPesquisa(int estagioDaPesquisa) {
		this.estagioDaPesquisa = estagioDaPesquisa;
	}
	public LocalDate getDataDeInicioDaPesquisa() {
		return dataDeInicioDaPesquisa;
	}
	public void setDataDeInicioDaPesquisa(LocalDate dataDeInicioDaPesquisa) {
		this.dataDeInicioDaPesquisa = dataDeInicioDaPesquisa;
	}
	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}
	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

}