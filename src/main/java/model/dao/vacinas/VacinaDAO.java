package model.dao.vacinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.dao.vacinas.vo.EstagioPesquisaVacina;
import model.dao.vacinas.vo.PessoaVO;
import model.dao.vacinas.vo.TipoPessoa;
import model.dao.vacinas.vo.VacinaVO;

public class VacinaDAO {

	static public boolean cadastrarVacina(VacinaVO vacina) {

		boolean deuBom = false;

		Connection conexao = Banco.getConnection();
		String sql = " insert into vacina (paisDeOrigem, estagioDaPesquisa, dataDeInicioDaPesquisa, pesquisador) values (?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

			query.setString(1, vacina.getPaisDeOrigem());
			query.setInt(2, vacina.getEstagioDaPesquisa().getValor());
			query.setObject(3, vacina.getDataDeInicioDaPesquisa());
			query.setInt(4, vacina.getPesquisadorResponsavel().getId());
			query.execute();

			ResultSet resultado = query.getGeneratedKeys();

			while (resultado.next()) {
				vacina.setId(resultado.getInt(1));
			}

			deuBom = vacina.getId() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar vacina!" + "\nCausa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return deuBom;

	}

//		private int id;
//		private String paisDeOrigem;
//		private EstagioPesquisaVacina estagioDaPesquisa;
//		private LocalDate dataDeInicioDaPesquisa;
//		private PessoaVO pesquisadorResponsavel;

	public static boolean Atualizar(VacinaVO vacina) {
		boolean retorno = false;
		String update = "update vacina set paisDeOrigem = ?, EstagioDaPesquisa = ?, dataDeInicioDaPesquisa = ?, pesquisar = ?,"
				+ " where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, update);
		try {
			pstmt.setString(1, vacina.getPaisDeOrigem());
			pstmt.setInt(2, vacina.getEstagioDaPesquisa().getValor());
			pstmt.setObject(3, vacina.getDataDeInicioDaPesquisa());
			pstmt.setInt(4, vacina.getPesquisadorResponsavel().getId());
			retorno = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			retorno = false;
			System.out.println("Erro no método atualizar da classe VacinaDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public static boolean Deletar(VacinaVO vacina) {
		boolean retorno = false;
		String update = "delete from vacina where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, update);
		try {
			pstmt.setInt(1, vacina.getId());

			retorno = pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			retorno = false;
			System.out.println("Erro no método deletar da classe VacinaDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public static VacinaVO pesquisarVacinaPorId(int id) {
		VacinaVO retorno = new VacinaVO();
		String query = "select * from pessoa where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		ResultSet resultadoQuery = null;
		try {
			pstmt.setInt(1, id);

			resultadoQuery = pstmt.executeQuery();

			if (resultadoQuery.next()) {
				retorno.setId(resultadoQuery.getInt(1));
				retorno.setPaisDeOrigem(resultadoQuery.getString(2));
				retorno.setEstagioDaPesquisa(
						EstagioPesquisaVacina.pegarEstagioPesquisaPorValor(resultadoQuery.getInt(3)));
				retorno.setDataDeInicioDaPesquisa(resultadoQuery.getDate(4).toLocalDate());
				retorno.setPesquisadorResponsavel(PessoaDAO.pesquisarPessoaPorId(id));
			}
		} catch (SQLException e) {
			retorno = null;
			System.out.println("Erro no método pesquisarVacinaPorId da classe VacinaDAO");
			System.out.println(e.getMessage());
		} finally {
			Banco.closeResultSet(resultadoQuery);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public static List<VacinaVO> pesquisarTodasAsVacinas() {
		ArrayList<VacinaVO> vacinas = new ArrayList<VacinaVO>();
		String query = "select * from pessoa";
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				VacinaVO vacina = new VacinaVO();
				vacina.setId(resultado.getInt(1));
				vacina.setPaisDeOrigem(resultado.getString(2));
				vacina.setEstagioDaPesquisa(
						EstagioPesquisaVacina.pegarEstagioPesquisaPorValor(resultado.getInt(3)));
				vacina.setDataDeInicioDaPesquisa(resultado.getDate(4).toLocalDate());
				vacina.setPesquisadorResponsavel(PessoaDAO.pesquisarPessoaPorId(resultado.getInt(5)));
				vacinas.add(vacina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacinas;
	}
}
