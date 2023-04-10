package executavel;

import java.time.LocalDate;

import model.vacinas.dao.PessoaDAO;
import model.vacinas.dao.VacinaDAO;
import model.vacinas.vo.PessoaVO;
import model.vacinas.vo.TipoPessoa;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
//		private int id;
//		private String nome;
//		private LocalDate dataNascimento;
//		private char sexo;
//		private String cpf;
//		private int reacao;
//		private TipoPessoa tipo;
		
		
		PessoaVO pessoa = new PessoaVO("Gabriel", LocalDate.of(2004, 5, 28), 'M', "06867968961", TipoPessoa.PUBLICO_GERAL);
		
		if(PessoaDAO.inserir(pessoa))
		{
			System.out.println("inseriu com sucesso! aqui esta o id gerado: " + pessoa.getId());
		}
		else 
		{
			System.out.println("não foi possivel inserir :(");
		}
		/*
		 * try { novoCliente = controladorDeClientes.inserir(novoCliente);
		 * 
		 * JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso! Id gerado: "
		 * + novoCliente.getId(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		 * 
		 * //Exemplo de captura de múltiplas exceções, válido apenas a partir do Java
		 * versão 7 } catch (CpfJaUtilizadoException | =EnderecoInvalidoException |
		 * CampoInvalidoException e) { JOptionPane.showMessageDialog(null,
		 * e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); }
		 */
	}
}
