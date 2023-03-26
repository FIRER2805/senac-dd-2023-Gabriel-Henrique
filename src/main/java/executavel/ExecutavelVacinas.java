package executavel;

import java.time.LocalDate;

import model.dao.vacinas.PessoaDAO;
import model.dao.vacinas.vo.PessoaVO;
import model.dao.vacinas.vo.TipoPessoa;

public class ExecutavelVacinas {

	public static void main(String[] args) {
		LocalDate dataNascimento = LocalDate.of(2004, 05, 28);
		PessoaVO pessoa = new PessoaVO("Gabriel", dataNascimento,
				'M',"00000000000",TipoPessoa.PUBLICO_GERAL);
		PessoaVO pessoaRetornada = PessoaDAO.inserir(pessoa);
		if(pessoaRetornada.getId() != 0)
		{
			System.out.println(pessoa.getNome() + " foi cadastrado(a) com sucesso!");
		}
		else 
		{
			System.out.println("Erro ao cadastrar pessoa!");
		}
	}

}
