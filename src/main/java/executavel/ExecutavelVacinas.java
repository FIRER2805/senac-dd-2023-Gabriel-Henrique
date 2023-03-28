package executavel;

import java.time.LocalDate;

import model.dao.vacinas.PessoaDAO;
import model.dao.vacinas.VacinaDAO;
import model.dao.vacinas.vo.EstagioPesquisaVacina;
import model.dao.vacinas.vo.PessoaVO;
import model.dao.vacinas.vo.TipoPessoa;
import model.dao.vacinas.vo.VacinaVO;

public class ExecutavelVacinas {

	public static void main(String[] args) {
		LocalDate dataNascimento = LocalDate.of(2004, 05, 28);
		PessoaVO pessoa = new PessoaVO("Gabriel Henrique", dataNascimento,
				'M',"00000000000",TipoPessoa.PUBLICO_GERAL);
		VacinaVO vacina = new VacinaVO("Brasil", EstagioPesquisaVacina.INICIAL, LocalDate.now(), pessoa);
		VacinaDAO.cadastrarVacina(vacina);
				
//		private int id;
//		private String paisDeOrigem;
//		private EstagioPesquisaVacina estagioDaPesquisa;
//		private LocalDate dataDeInicioDaPesquisa;
//		private PessoaVO pesquisadorResponsavel;
		
//		for(PessoaVO elemento: PessoaDAO.pesquisarTodasAsPessoas())
//		{
//			System.out.println(elemento.getId());
//			System.out.println(elemento.getNome());
//			System.out.println(elemento.getDataNascimento());
//			System.out.println(elemento.getSexo());
//			System.out.println(elemento.getCpf());
//			System.out.println(elemento.getReacao());
//			System.out.println(elemento.getTipo());
//		}
		
//		
//		System.out.println(PessoaDAO.deletarPessoa(pessoa));
//		VacinaVO vacina = new VacinaVO("Brasil", 1, LocalDate.now(),pessoa);
//		boolean retorno = VacinaDAO.cadastrarVacina(vacina);
//		
		
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
