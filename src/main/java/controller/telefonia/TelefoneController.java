package controller.telefonia;

import java.util.List;

import model.telefonia.bo.TelefoneBO;
import model.telefonia.exceptions.CampoInvalidoException;
import model.telefonia.exceptions.TelefoneJaExiste;
import model.telefonia.vo.Cliente;
import model.telefonia.vo.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	
	public Telefone inserir(Telefone novoTelefone) throws CampoInvalidoException, TelefoneJaExiste {
		this.validarCamposObrigatorios(novoTelefone);
		return bo.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		//TODO validar o preenchimento dos campos obrigatórios
		return bo.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return bo.consultarTodos();
	}
	
	private void validarCamposObrigatorios(Telefone t) throws CampoInvalidoException {
		String mensagemValidacao = "";
		
		if(t.getDdd() == null || t.getDdd().trim().length() != 2 || !t.getDdd().matches("[0-9]+")) {
			mensagemValidacao += "DDD inválido \n";
		}
		
		if(t.getNumero() == null || t.getNumero().trim().length() != 8 || !t.getNumero().matches("[0-9]+"))
		{
			mensagemValidacao += "Numero inválido \n";
		}	
		
		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}
}
