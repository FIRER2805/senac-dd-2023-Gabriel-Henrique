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
}
