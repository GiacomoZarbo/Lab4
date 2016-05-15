package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	public boolean isContenutaInDizionario(String parola) {
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}
}
