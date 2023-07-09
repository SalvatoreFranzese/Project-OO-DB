package com.smup.DAO;

import com.smup.Entity.Pubblica;
import com.smup.Entity.Singolo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SingleDAOimpl implements SingleDAO{

	private Connection connection;
	
	public SingleDAOimpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insertSingle(String nome, int durata, String genere, String artista, String dataPubblicazione) {
		ResultSet rs = null;
		try {
			String query_insert_single = "INSERT INTO Singolo (id_Single, nameSingle, duration, genere) VALUES( ?, ?, ?, ?)";
			String sequenceSingolo = "SELECT NEXTVAL('codiceSingolo')";
			String query_insert_pubblicazione = "INSERT INTO Pubblica (releaseDate, id_Artist, id_Album, id_Single, id_EP) VALUES (?, ?, NULL, ?, NULL)";
			
			Statement seqSingolo = connection.createStatement();
			rs = seqSingolo.executeQuery(sequenceSingolo);
			
			int idSingolo = 0;
			if(rs.next()) {
				idSingolo = rs.getInt(1);
			}
			
			PreparedStatement pst1 = connection.prepareStatement(query_insert_single);
			pst1.setInt(1, idSingolo);
			pst1.setString(2, nome);
			pst1.setInt(3, durata);
			pst1.setString(4, genere);
			pst1.execute();
			
			PreparedStatement pst2 = connection.prepareStatement(query_insert_pubblicazione);
			pst2.setString(1, dataPubblicazione);
			pst2.setString(2, artista);
			pst2.setInt(3, idSingolo);
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
	public void deleteSingle(String codice) {
		try {
			String query_delete_single = "DELETE FROM Singolo WHERE id_Single = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_delete_single);
			pst.setString(1, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateSingle(String codice, String nome, int durata, String genere, String dataPubblicazione) {
		try {
			String query_update_single = "UPDATE Singolo SET nameSingle = ? , duration = ?, genere = ? WHERE id_Single = ?";
			String query_update_pubblica = "UPDATE Pubblica SET releaseDate = ? WHERE id_Single = ?";
			
			PreparedStatement pst1 = connection.prepareStatement(query_update_single);
			pst1.setString(1, nome);
			pst1.setInt(2, durata);
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
	public ArrayList<Singolo> getAllSingles() {
		String query_stampa = "SELECT * FROM Singolo NATURAL JOIN Pubblica ;";
		ArrayList<Singolo> allSingles = new ArrayList<Singolo>();

		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);

            while (rs.next()) {
            	Pubblica publications = new Pubblica(rs.getString("releaseDate"),
                        							 rs.getString("id_Artist"),
                        							 rs.getString("id_Album"),
                        							 rs.getString("id_Single"),
                        							 rs.getString("id_EP"));
            	
            	Singolo singolo = new Singolo(rs.getString("id_Single"),
                                        	  rs.getString("nameSingle"),
                                              rs.getInt("duration"),
                                              rs.getString("genere"),
                                              publications);
                
            	allSingles.add(singolo);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allSingles;
	}
}
