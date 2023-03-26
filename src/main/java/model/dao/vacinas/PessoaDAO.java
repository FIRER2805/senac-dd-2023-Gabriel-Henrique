package model.dao.vacinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.dao.vacinas.vo.PessoaVO;

public class PessoaDAO {
	
	public static PessoaVO inserir(PessoaVO pessoa)
	{
		String insert = "insert into pessoa(nome, data_nascimento,sexo,cpf,tipo) "
				+ "values(?,?,?,?,?);";
		PessoaVO retorno = null;
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
			retorno = pessoa;
		}
		catch(SQLException e)
		{
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
}