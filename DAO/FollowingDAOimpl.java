package com.smup.DAO;

import com.smup.Entity.Seguire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FollowingDAOimpl implements FollowingDAO {
	
	private Connection connection;

	public FollowingDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertFollow(String id_User, String id_Artist) {
		try {
			String query_insert_follow = "INSERT INTO Following (id_User, id_Artist) VALUES(?, ?)";

			PreparedStatement pst = connection.prepareStatement(query_insert_follow);
			pst.setString(1, id_User);
			pst.setString(2, id_Artist);
			pst.execute();

			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void removeFollow(String id_User, String id_Following) {
		try {			
			String query_decremente_followers = "UPDATE Artista AS A SET followers = followers - 1 WHERE A.id_artist IN (SELECT id_Artist FROM Following AS F WHERE id_Following = ?)";
			PreparedStatement pst2 = connection.prepareStatement(query_decremente_followers);
			pst2.setString(1, id_Following);
			pst2.executeUpdate();
			
			String query_delete_follow = "DELETE FROM Following WHERE id_Following = ? AND id_User = ?";

			PreparedStatement pst1 = connection.prepareStatement(query_delete_follow);
			pst1.setString(1, id_Following);
			pst1.setString(2, id_User);
			pst1.execute();
			
			pst1.close();
			pst2.close();
		}
		catch(SQLException e) {
			System.out.println("Errore cancellazione: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Seguire> getAllFollowings(String id_User) {
		String query_stampa = "SELECT * FROM (Utente NATURAL JOIN Following) NATURAL JOIN Artista WHERE id_User = '" + id_User + "'";
		ArrayList<Seguire> allFollowings = new ArrayList<Seguire>();
		
		try {
			Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);
            
            while (rs.next()) {
            	Seguire follow = new Seguire(rs.getString("id_Following"),
            								 rs.getString("nomeDArte"));
            	
            	allFollowings.add(follow);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allFollowings;
	}
}
