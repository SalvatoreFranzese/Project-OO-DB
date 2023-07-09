package com.smup.DAO;

import com.smup.Entity.EP;
import com.smup.Entity.Pubblica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EPDAOimpl implements EPDAO{

	private Connection connection;

	public EPDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertEP(String nome,  String genere, int songNumber, String artista, String dataPubblicazione) {
		ResultSet rs = null;
		try {
			String query_insert_ep = "INSERT INTO EP (id_EP, nameEP, songNumber, genere) VALUES( ?, ?, ?, ?)";
			String sequence = "SELECT NEXTVAL('codiceEP')";
			String query_insert_pubblicazione = "INSERT INTO Pubblica (releaseDate, id_Artist, id_Album, id_Single, id_EP) VALUES (?, ?, NULL, NULL, ?)";

			Statement seq = connection.createStatement();
			rs = seq.executeQuery(sequence);

			int idEP = 0;
			if(rs.next()) {
				idEP = rs.getInt(1);
			}
			else
				System.out.print("Errore sequenza");

			PreparedStatement pst1 = connection.prepareStatement(query_insert_ep);
			pst1.setInt(1, idEP);
			pst1.setString(2, nome);
			pst1.setInt(3, songNumber);
			pst1.setString(4, genere);
			pst1.execute();

			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);
			pst2.setString(1, dataPubblicazione);
			pst2.setString(2, artista);
			pst2.setInt(3, idEP);
			pst2.execute();

			pst1.close();
			pst2.close();
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	@Override
	public void deleteEP(String codice) {
		try {
			String query_delete_ep = "DELETE FROM EP WHERE id_EP = ?";

			PreparedStatement pst = connection.prepareStatement(query_delete_ep);
			pst.setString(1, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, int songNumber) {
		try {
			String query_update_single = "UPDATE EP SET nameEP = ? , songNumber = ?, genere = ? WHERE id_EP = ?";
			String query_update_pubblica = "UPDATE Pubblica SET releaseDate = ? WHERE id_EP = ?";

			PreparedStatement pst1 = connection.prepareStatement(query_update_single);
			pst1.setString(1, nome);
			pst1.setInt(2, songNumber);
			pst1.setString(3, genere);
			pst1.setString(4, codice);
			pst1.executeUpdate();

			PreparedStatement pst2 = connection.prepareStatement(query_update_pubblica);
			pst2.setString(1, dataPubblicazione);
			pst2.setString(2, codice);
			pst2.executeUpdate();
			
			pst1.close();
			pst2.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<EP> getAllEP() {
		String query_stampa = "SELECT * FROM EP NATURAL JOIN Pubblica ;";
		ArrayList<EP> allEPs = new ArrayList<EP>();
		
		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);

            while (rs.next()) {
            	Pubblica publications = new Pubblica(rs.getString("releaseDate"),
                        							 rs.getString("id_Artist"),
                        							 rs.getString("id_Album"),
                        							 rs.getString("id_Single"),
                        							 rs.getString("id_EP"));
            	
            	EP ep = new EP(rs.getString("id_EP"),
                               rs.getString("nameEP"),
                               rs.getInt("songNumber"),
                               rs.getString("genere"),
                               publications);
                
            	allEPs.add(ep);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allEPs;
	}
	
	@Override
	public ResultSet stampaEP() {
		ResultSet rs = null;
		try {
			Statement st = connection.createStatement();

			String query_stampa = "SELECT * FROM EP NATURAL JOIN Pubblica ;";
			rs = st.executeQuery(query_stampa);

			return rs;
		}
		catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}

}
