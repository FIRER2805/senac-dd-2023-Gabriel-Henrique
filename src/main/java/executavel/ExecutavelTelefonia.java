package executavel;

import java.util.ArrayList;
import java.util.List;

import model.dao.telefonia.EnderecoDAO;
import model.dao.telefonia.TelefoneDAO;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("88000123", "Nereu Ramos", "10", "Centro", "Florianópolis", "SC");
		
		EnderecoDAO salvadorDeEnderecos = new EnderecoDAO();
		salvadorDeEnderecos.inserir(endereco1);
		
		Telefone telefone = new Telefone("48","96348863",true,true);
		TelefoneDAO.inserir(telefone);
		
		if(endereco1.getId() != null) {
			System.out.println("Novo endereço cadastrado");
		}else {
			System.out.println("Erro ao cadastrar endereço");
		}
		
		if(telefone.getId() != null)
		{
			System.out.println("Telefone cadastrado com sucesso! :)");
		}
		else
		{
			System.out.println("Erro ao cadastrar o telefone :(");
		}
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		telefonesDoSocrates.add(telefone);
		
		System.out.println(telefonesDoSocrates.get(0));
		
//		Cliente pele = new Cliente("Edson Arantes", "11122233344", null, true, endereco1);
//		Cliente socrates = new Cliente("Sócrates Brasileiro", "33322233344", telefonesDoSocrates, true, endereco1);
//		
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		clientes.add(pele);
//		clientes.add(socrates);
//		
//		System.out.println("------------ Clientes da firma ------------");
//		for(Cliente c: clientes) {
//			System.out.println(c.toString());
//		}
//		
//		for(int i=0; i < clientes.size(); i++) {
//			Cliente c = clientes.get(i);
//			System.out.println(c.toString());
//		}
		
	}
}
