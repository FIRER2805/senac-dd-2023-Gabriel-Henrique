package controller.telefonia;

import java.util.List;

import model.bo.ClienteBO;
import model.dao.telefonia.exceptions.CpfAlteradoException;
import model.dao.telefonia.exceptions.CpfJaUtilizadoException;
import model.dao.telefonia.exceptions.EnderecoInvalidoException;
import model.dao.telefonia.vo.Cliente;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, 
			EnderecoInvalidoException {
		
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.inserir(novoCliente);
	}
	
	public boolean atualizar(Cliente clienteAlterado) throws EnderecoInvalidoException, CpfAlteradoException {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.atualizar(clienteAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Cliente consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Cliente> consultarTodos() {
		return bo.consultarTodos();
	}
}
