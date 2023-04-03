package controller.telefonia;

import java.util.List;

import model.bo.EnderecoBO;
import model.dao.telefonia.exceptions.EnderecoInvalidoException;
import model.dao.telefonia.vo.Endereco;

public class EnderecoController {

	private EnderecoBO bo = new EnderecoBO();
	
	public Endereco inserir(Endereco novoEndereco) {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.inserir(novoEndereco);
	}
	
	public boolean atualizar(Endereco enderecoAlterado){
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.atualizar(enderecoAlterado);
	}
	
	public boolean excluir(int id) throws EnderecoInvalidoException {
		return bo.excluir(id);
	}
	
	public Endereco consultarPorCep(String cep) {
		return bo.consultarPorCep(cep);
	}
	
	public Endereco consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Endereco> consultarTodos() {
		return bo.consultarTodos();
	}
}