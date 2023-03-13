package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {
	
	public static void inserir(Telefone telefone) 
	{
		try 
		{
			String insert = "insert into telefone('DDD','NUMERO','ATIVO','MOVEL','ID_CLIENTE')+"
					+ "values ('?','?','?','?','?')";
			Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, insert);
			
			query.setString(1, telefone.getDdd());
		} catch(SQLException e)
		{
			
		}
	}
}
