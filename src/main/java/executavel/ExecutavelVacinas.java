package executavel;

import java.time.LocalDate;

import model.dao.vacinas.VacinaDAO;
import model.dao.vacinas.vo.PessoaVO;
import model.dao.vacinas.vo.TipoPessoa;
import model.dao.vacinas.vo.VacinaVO;

public class ExecutavelVacinas {

	public static void main(String[] args) {
		LocalDate dataNascimento = LocalDate.of(2004, 05, 28);
		PessoaVO pessoa = new PessoaVO("Gabriel", dataNascimento,
				'M',"00000000000",TipoPessoa.PUBLICO_GERAL);
		VacinaVO vacina = new VacinaVO("Brasil", 1, LocalDate.now(),"Gabriel Henrique Muller de Medeiros");
		boolean retorno = VacinaDAO.cadastrarVacina(vacina);
		
//		private int id;
//		private String paisDeOrigem;
//		private int estagioDaPesquisa;
//		private LocalDate dataDeInicioDaPesquisa;
//		private String pesquisadorResponsavel;
//		PessoaVO pessoaRetornada = PessoaDAO.inserir(pessoa);
//		if(pessoaRetornada.getId() != 0)
//		{
//			System.out.println(pessoa.getNome() + " foi cadastrado(a) com sucesso!");
//		}
//		else 
//		{
//			System.out.println("Erro ao cadastrar pessoa!");
//		}
	}
}
