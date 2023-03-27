package model.dao.vacinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.dao.vacinas.vo.VacinaVO;

public class VacinaDAO {
	
		static public boolean cadastrarVacina(VacinaVO vacina) {
		
		boolean deuBom = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " insert into vacina (paisDeOrigem, estagioDaPesquisa, dataDeInicioDaPesquisa, pesquisador) values (?, ?, ?, ?) ";
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			
			query.setString(1, vacina.getPaisDeOrigem());
			query.setInt(2, vacina.getEstagioDaPesquisa());
			query.setObject(3, vacina.getDataDeInicioDaPesquisa());
			query.setInt(4, vacina.getPesquisadorResponsavel().getId());
			query.execute();
			
			ResultSet resultado = query.getGeneratedKeys();
			
			while(resultado.next()) {
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

	
	
	
	
	
	
	
	
	
	
	
	
}
