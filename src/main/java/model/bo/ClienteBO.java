package model.bo;

import java.util.List;

import model.dao.telefonia.ClienteDAO;
import model.dao.telefonia.exceptions.ClienteComTelefoneException;
import model.dao.telefonia.exceptions.CpfAlteradoException;
import model.dao.telefonia.exceptions.CpfJaUtilizadoException;
import model.dao.telefonia.exceptions.EnderecoInvalidoException;
import model.dao.telefonia.vo.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();
	
	/**
	 * Insere um novo cliente, mas faz validações que podem gerar exceções
	 * @param novoCliente
	 * @return o novoCliente inserido, com a PK gerada
	 * @throws ClienteComTelefoneException 
	 * @throws CpfJaUtilizadoException
	 * @throws EnderecoInvalidoException
	 */
	
	public boolean excluir(int id) throws ClienteComTelefoneException{
		if(dao.consultarPorId(id).getTelefones().size() > 0){
			throw new ClienteComTelefoneException("Cliente possui telefone");
		}
		return dao.excluir(id);
	}
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, 
			EnderecoInvalidoException {
		if(dao.cpfJaUtilizado(novoCliente.getCpf())) {
			throw new CpfJaUtilizadoException("CPF informado já foi utilizado");
		}
		
		validarEndereco(novoCliente);

		//Caso CPF não utilizado -> salvar e devolver o cliente
		return dao.inserir(novoCliente);
	}
	
	/**
	 * Atualiza um novo cliente, mas faz validações que podem gerar exceções
	 * @param cliente
	 * @return o cliente atualizado
	 * @throws CpfAlteradoException 
	 * @throws EnderecoInvalidoException
	 */
	public boolean atualizar(Cliente clienteAlterado) throws EnderecoInvalidoException, CpfAlteradoException {
		Cliente clienteOriginal = dao.consultarPorId(clienteAlterado.getId());
		
		if(clienteAlterado.getCpf() != clienteOriginal.getCpf()) {
			throw new CpfAlteradoException("CPF não pode ser alterado");
		}
		
		validarEndereco(clienteAlterado);

		return dao.atualizar(clienteAlterado);
	}
	
	public Cliente consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Cliente> consultarTodos() {
		return dao.consultarTodos();
	}
	
	private void validarEndereco(Cliente cliente) throws EnderecoInvalidoException {
		if(cliente.getEndereco() == null || cliente.getEndereco().getId() == null) {
			throw new EnderecoInvalidoException("Endereço não informado");
		}
	}
}
