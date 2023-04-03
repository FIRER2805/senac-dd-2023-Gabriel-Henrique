package executavel;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.dao.telefonia.exceptions.CpfJaUtilizadoException;
import model.dao.telefonia.exceptions.EnderecoInvalidoException;
import model.dao.telefonia.vo.Cliente;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		ClienteBO clienteBO = new ClienteBO();
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Mario Jorge");
		novoCliente.setCpf("10122233311");
		novoCliente.setAtivo(true);

		try {
			clienteBO.inserir(novoCliente);
		} catch (CpfJaUtilizadoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (EnderecoInvalidoException e) {
			JOptionPane.showMessageDialog(null, "Erros acontecem. Causa: " 
						+ e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
