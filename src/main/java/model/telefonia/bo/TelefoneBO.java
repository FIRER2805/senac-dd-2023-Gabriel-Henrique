package model.telefonia.bo;

import java.util.List;

import model.telefonia.dao.TelefoneDAO;
import model.telefonia.exceptions.TelefoneJaExiste;
import model.telefonia.vo.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();
	
	public Telefone inserir(Telefone novoTelefone) throws TelefoneJaExiste {
		novoTelefone.setAtivo(novoTelefone.getIdCliente() != null);
		if(dao.verificarExistenciaTelefone(novoTelefone.getId()))
		{
			throw new TelefoneJaExiste("telefone já existe!");
		}
		return dao.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		telefoneAlterado.setAtivo(telefoneAlterado.getIdCliente() != null);

		return dao.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return dao.consultarTodos();
	}
}
