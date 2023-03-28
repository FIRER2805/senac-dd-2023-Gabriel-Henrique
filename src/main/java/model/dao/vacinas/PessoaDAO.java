package model.dao.vacinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.dao.vacinas.vo.PessoaVO;
import model.dao.vacinas.vo.TipoPessoa;

public class PessoaDAO {
	
	public static boolean inserir(PessoaVO pessoa)
	{
		String insert = "insert into pessoa(nome, data_nascimento,sexo,cpf,tipo) "
				+ "values(?,?,?,?,?);";
		boolean retorno = false;
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, insert);
		ResultSet chave = null;
		try 
		{
			pstmt.setString(1, pessoa.getNome());
			pstmt.setObject(2, pessoa.getDataNascimento());
			pstmt.setString(3, String.valueOf(pessoa.getSexo()));
			pstmt.setString(4, pessoa.getCpf());
			pstmt.setInt(5, pessoa.getTipo().getValor());
			
			pstmt.executeUpdate();
			chave = pstmt.getGeneratedKeys();
			if(chave.next())
			{
				pessoa.setId(chave.getInt(1));
			}
			retorno = pessoa.getId() > 0;
		}
		catch(SQLException e)
		{
			retorno = false;
			System.out.println("Erro no método inserir da classe PessoaDAO!");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closeResultSet(null);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public static boolean atualizarPessoa(PessoaVO pessoa)
	{
		boolean retorno = false;
		String update = "update pessoa set nome = ?, data_nascimento = ?, sexo = ?, cpf = ?,"
				+ " reacao = ?, tipo = ? where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, update);
		try 
		{
			pstmt.setString(1, pessoa.getNome());
			pstmt.setObject(2, pessoa.getDataNascimento());
			pstmt.setString(3, String.valueOf(pessoa.getSexo()));
			pstmt.setString(4, pessoa.getCpf());
			pstmt.setInt(5, pessoa.getReacao());
			pstmt.setInt(6, pessoa.getTipo().getValor());
			pstmt.setInt(7, pessoa.getId());
			
			retorno = pstmt.executeUpdate() > 0;
		}
		catch(SQLException e)
		{
			retorno = false;
			System.out.println("Erro no método atualizarPessoa da classe PessoaDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public static boolean deletarPessoa(PessoaVO pessoa)
	{
		boolean retorno = false;
		String delete = "delete from pessoa where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, delete);
		try 
		{
			pstmt.setInt(1, pessoa.getId());
			
			retorno = pstmt.executeUpdate() > 0;
		}
		catch(SQLException e)
		{
			retorno = false;
			System.out.println("Erro no método deletarPessoa da classe PessoaDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public static PessoaVO pesquisarPessoaPorId(int id)
	{
		PessoaVO retorno = null;
		String query = "select * from pessoa where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		ResultSet resultadoQuery = null;
		try 
		{
			pstmt.setInt(1,id);
			
			resultadoQuery = pstmt.executeQuery();
			
			PessoaVO pessoaRetornada = new PessoaVO();
			if(resultadoQuery.next())
			{
				pessoaRetornada.setId(resultadoQuery.getInt(1));
				pessoaRetornada.setNome(resultadoQuery.getString(2));
				pessoaRetornada.setDataNascimento(resultadoQuery.getDate(3).toLocalDate());
				pessoaRetornada.setSexo(resultadoQuery.getString(4).charAt(0));
				pessoaRetornada.setCpf(resultadoQuery.getString(5));
				pessoaRetornada.setReacao(resultadoQuery.getInt(6));
				pessoaRetornada.setTipo(TipoPessoa.getTipoPessoaPorValor(resultadoQuery.getInt(7)));
			}
			retorno = pessoaRetornada;
		}
		catch(SQLException e)
		{
			retorno = null;
			System.out.println("Erro no método pesquisarPessoaPorId da classe PessoaDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closeResultSet(resultadoQuery);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	// este método não esta funcionando!
	public static List<PessoaVO> pesquisarTodasAsPessoas()
	{
		ArrayList<PessoaVO> pessoas = new ArrayList<PessoaVO>();
		String query = "select * from pessoa";
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next())
			{
				PessoaVO pessoa = new PessoaVO();
				pessoa.setId(resultado.getInt(1));
				pessoa.setNome(resultado.getString(2));
				pessoa.setDataNascimento(resultado.getDate(3).toLocalDate());
				pessoa.setSexo(resultado.getString(4).charAt(0));
				pessoa.setCpf(resultado.getString(5));
				pessoa.setReacao(resultado.getInt(6));
				pessoa.setTipo(TipoPessoa.getTipoPessoaPorValor(resultado.getInt(7)));
				pessoas.add(pessoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}
}