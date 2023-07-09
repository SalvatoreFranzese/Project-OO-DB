package com.smup.DAO;

import com.smup.Entity.Brano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SongDAOimpl implements SongDAO{
	
	private Connection connection;
	
	public SongDAOimpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insertSongDB(String nome, int durata, String genere, String album) {
		try {
			String query_insert_song = "INSERT INTO Brano (songName, songDuration, genereSong, id_Album) VALUES(?, ?, ?, ?)";
			
			PreparedStatement pst = connection.prepareStatement(query_insert_song);
			pst.setString(1, nome);
			pst.setInt(2, durata);
			pst.setString(3, genere);
			pst.setString(4, album);
			pst.execute();

			pst.close();
		}
		catch(SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	
	@Override
	public void deleteSong(String codice) {
		try {
			String query_delete_song = "DELETE FROM Brano WHERE id_Song = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_delete_song);
			pst.setString(1, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void updateSong(String codice, String nome, int durata) {
		try {
			String query_update_song = "UPDATE Brano SET songName = ? , songDuration = ? WHERE id_Song = ?";
			
			PreparedStatement pst = connection.prepareStatement(query_update_song);
			pst.setString(1, nome);
			pst.setInt(2, durata);
			pst.setString(3, codice);
			pst.executeUpdate();
			
			pst.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Brano> getAllSongs() {
		String query_stampa = "SELECT * FROM Album AS A,Pubblica AS P,Brano AS B WHERE A.id_Album = P.id_Album AND A.id_Album = B.id_Album";
		ArrayList<Brano> allSongs = new ArrayList<Brano>();

		try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query_stampa);

            while (rs.next()) {
            	Brano brano = new Brano(rs.getString("id_Song"),
                                        rs.getString("songName"),
                                        rs.getInt("songDuration"),
                                        rs.getString("genereSong"),
                                        rs.getString("id_Album"));
                
            	allSongs.add(brano);
            }   
            
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
		
        return allSongs;
	}
}