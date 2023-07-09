package com.smup.DAO;

import com.smup.Entity.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UtenteDAOimpl implements UtenteDAO {

	private Connection connection;

	public UtenteDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertUser(String username, String password, boolean isAdmin) {
		try {
			String query_insert_user = "INSERT INTO Utente (username, password, isAdmin) VALUES(?, ?, ?)";

			PreparedStatement pst = connection.prepareStatement(query_insert_user);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setBoolean(3, isAdmin);
			pst.execute();

			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Username gi� in uso!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public Utente checkUser(String username, String password) {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();
			String query_check_user = "SELECT * FROM Utente"
					+ " WHERE username = '" + username + "' AND password = '" + password + "'";

			rs = st.executeQuery(query_check_user);

			if (rs != null) {
				while(rs.next()) {
					Utente utente = new Utente(rs.getString("id_User"), rs.getString("username"), rs.getString("password"), rs.getBoolean("isAdmin"));
					return utente;
				}
			}
		}
		catch(SQLException e) {
			System.out.println("Errore accesso: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
