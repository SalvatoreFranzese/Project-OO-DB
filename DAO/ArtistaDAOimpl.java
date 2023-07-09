package com.smup.DAO;

import com.smup.Entity.Artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArtistaDAOimpl implements ArtistaDAO{

	private Connection connection;

	public ArtistaDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertArtist(String codice, String nome, String cognome, String dataNascita, String citta, String nomeDArte) {
		try {
			String query_insert = "INSERT INTO Artista (id_artist, firstName, secondName, birthDate, city, followers, nomeDArte) VALUES (?,?,?,?,?,0,?)";

			PreparedStatement pst = connection.prepareStatement(query_insert);
			pst.setString(1, codice);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, dataNascita);
			pst.setString(5, citta);
			pst.setString(6, nomeDArte);
			pst.executeUpdate();

			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
		}
	}

	@Override
	public void deleteArtist(String codice) {
		try {
			String query_delete = "DELETE FROM Artista WHERE id_Artist = ?";

			PreparedStatement pst = connection.prepareStatement(query_delete);
			pst.setString(1, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateArtist(String codice, String nome, String cognome, String dataNascita, String citta, int followers, String nomeDArte) {
		try {
			String query_update = "UPDATE Artista SET firstName = ? , secondName = ?, birthDate = ?, city = ?, followers = ?, nomeDArte = ? WHERE id_Artist = ? ";

			PreparedStatement pst = connection.prepareStatement(query_update);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, dataNascita);
			pst.setString(4, citta);
			pst.setInt(5, followers);
			pst.setString(6, nomeDArte);
			pst.setString(7, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Artista> getAllArtists() {
		String query_stampa = "SELECT * FROM Artista";
		ArrayList<Artista> allArtists = new ArrayList<Artista>();
		
		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);

            while (rs.next()) {
            	Artista artista = new Artista(rs.getString("id_Artist"),
                                        	  rs.getString("firstName"),
                                              rs.getString("secondName"),
                                              rs.getString("city"),
                                              rs.getString("birthDate"),
                                              rs.getString("nomeDArte"),
                                              rs.getInt("followers"));
                
            	allArtists.add(artista);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allArtists;
	}
	
	// STAMPA PER USER NON ADMIN
	@Override
	public ArrayList<Artista> getAllArtists(String id_User) {
		String query_stampa = "SELECT * FROM Artista WHERE id_Artist NOT IN (SELECT id_Artist FROM Following WHERE id_User = '" + id_User + "')";
		ArrayList<Artista> allArtists = new ArrayList<Artista>();
		
		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);

            while (rs.next()) {
            	Artista artista = new Artista(rs.getString("id_Artist"),
                                        	  rs.getString("firstName"),
                                              rs.getString("secondName"),
                                              rs.getString("city"),
                                              rs.getString("birthDate"),
                                              rs.getString("nomeDArte"),
                                              rs.getInt("followers"));
                
            	allArtists.add(artista);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allArtists;
	}
	
	@Override
	public ArrayList<Artista> searchArtist(String nomeDaCercare, String id_User) {
		String query_cerca = "SELECT nomeDArte, id_Artist FROM Artista AS A WHERE nomeDArte LIKE '%" + nomeDaCercare + "%' AND id_Artist NOT IN (SELECT id_Artist FROM Following WHERE id_User = '" + id_User + "')";
		ArrayList<Artista> filteredArtists = new ArrayList<Artista>();
		
		try {
			Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_cerca);
            
            while (rs.next()) {
            	Artista artista = new Artista(rs.getString("id_Artist"),
                                        	  rs.getString("firstName"),
                                              rs.getString("secondName"),
                                              rs.getString("city"),
                                              rs.getString("birthDate"),
                                              rs.getString("nomeDArte"),
                                              rs.getInt("followers"));
                
            	filteredArtists.add(artista);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return filteredArtists;
	}
}
