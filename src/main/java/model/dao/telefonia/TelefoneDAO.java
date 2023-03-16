package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {
	
	public static void inserir(Telefone telefone) 
	{
		try 
		{
			String insert = "insert into telefone(DDD,NUMERO,ATIVO,MOVEL) "
					+ "values (?,?,?,?)";
			Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, insert);
			
			query.setString(1, telefone.getDdd());
			query.setString(2, telefone.getNumero());
			query.setBoolean(3, telefone.isAtivo());
			query.setBoolean(4, telefone.isMovel());
			if(telefone.getIdCliente() != null)
			{
				query.setInt(5, telefone.getIdCliente());
			}
			
			int affectedColumns = query.executeUpdate();
			ResultSet keys = query.getGeneratedKeys();
			
			if(affectedColumns > 0)
			{
				if(keys.next())
				{
					telefone.setId(keys.getInt(1));
				}
			}
			
			Banco.closeResultSet(keys);
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
			
		} catch(SQLException e)
		{
			System.out.println("Erro no método inserir da classe TelefoneDAO");
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean atualizar(Telefone telefone)
	{
		boolean retorno = false;
		
//		private Integer id;
//		private Integer idCliente;
//		private String ddd;
//		private String numero;
//		private boolean ativo;
//		private boolean movel;
		
		String update = "update telefone set ddd = ?,"
				+ " numero = ?, ativo = ?, movel = ? "
				+ "where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, update);
		try {
			pstmt.setString(1,telefone.getDdd());
			pstmt.setString(2,telefone.getNumero());
			pstmt.setBoolean(3,telefone.isAtivo());
			pstmt.setBoolean(4,telefone.isMovel());
			pstmt.setInt(5,telefone.getId());
			
			int affectedCollumns = pstmt.executeUpdate();
			
			retorno = affectedCollumns > 0;
		} catch (SQLException e) {
			System.out.println("Erro no método atualizar da classe TelefoneDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	
	public static Telefone consultarPorId(int id)
	{
		Telefone telefoneRetornado = new Telefone();
		String query = "select * from telefone where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		ResultSet resultado = null;
		try 
		{
			pstmt.setInt(1, id);
			resultado = pstmt.executeQuery();
			if(resultado.next())
			{
				telefoneRetornado.setId(resultado.getInt("id"));
				telefoneRetornado.setDdd(resultado.getString("ddd"));
				telefoneRetornado.setNumero(resultado.getString("numero"));
				telefoneRetornado.setAtivo(resultado.getBoolean("ativo"));
				telefoneRetornado.setMovel(resultado.getBoolean("movel"));
				telefoneRetornado.setIdCliente(resultado.getInt("id_cliente"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro no método consultarPorId da classe TelefoneDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return telefoneRetornado;
	}
	
	public static boolean excluirPorId(int id)
	{
		String delete = "delete from telefone where id = ?";
		Connection conn = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatement(conn, delete);
		boolean retorno = false;
		
		try 
		{
			stmt.setInt(1, id);
			retorno = stmt.executeUpdate() > 0;
		}
		catch(SQLException e)
		{
			System.out.println("Erro no método excluirPorId da clase TelefoneDAO");
			System.out.println(e.getMessage());
		}
		finally 
		{
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
}
