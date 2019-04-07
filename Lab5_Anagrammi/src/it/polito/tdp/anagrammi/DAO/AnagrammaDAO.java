package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		Connection conn = ConnectDB.getConnection();
		boolean result = false;
		
		try {
			
			String sql = "SELECT nome FROM parola WHERE nome = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				result = true;
			else
				result = false;
			
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
		
	}
	
}
