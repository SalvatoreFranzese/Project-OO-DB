package com.smup.Controller;

import com.smup.Connection.*;
import com.smup.Entity.*;
import com.smup.DAO.*;
import com.smup.GUI.*;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controller {

	Connection connection;

	/** Frame declaration */
	
	private LoginGUI frameLogin;
	private SignUpGUI frameSignUp;
	private HomeGUI frameHome;
	private HomeUserGUI frameHomeUser;
	private AddArtistGUI frameAddArtist;
	private AddAlbumGUI frameAddAlbum;
	private AddSongGUI frameAddSong;

	/** Interface DAO declaration */
	
	private UtenteDAO utenteDAO;
	private ArtistaDAO artistDAO;
	private FollowingDAO followingDAO;
	private SongDAO songDAO;
	private AlbumDAO albumDAO;
	private EPDAO epDAO;
	private SingleDAO singleDAO;
	
	/** Logged user saved in a variable */
	public Utente user = null;

	public Controller() {
		
		resetStyle();
		
		// Start Database connection
		connection = ConnessioneDB.DBConnection();

		// Show main frame
		frameLogin = new LoginGUI(this);
		frameLoginGUI(true);

		// Initializing the other frames
		frameSignUp = new SignUpGUI(this);
		frameAddArtist = new AddArtistGUI(this);
		frameAddAlbum = new AddAlbumGUI(this);
		frameAddSong = new AddSongGUI(this);

		// Initializing DAO
		followingDAO = new FollowingDAOimpl(connection);
		utenteDAO = new UtenteDAOimpl(connection);
		artistDAO = new ArtistaDAOimpl(connection);
		songDAO = new SongDAOimpl(connection);
		albumDAO = new AlbumDAOimpl(connection);
		epDAO = new EPDAOimpl(connection);
		singleDAO = new SingleDAOimpl(connection);
	}

	public static void main(String[] args) {
		new Controller();
	}
	
	/** Reset Style, default component appearance */
	public void resetStyle() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Search Artist methods
	 * 
	 */

	public ArrayList<Artista> search(String nomeDaCercare) {
		if((nomeDaCercare.length()>0)) {
			return artistDAO.searchArtist(nomeDaCercare, user.getId());
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci dei dati validi!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	/**
	 * 
	 * User methods
	 * 
	 */

	public void insertUser(String username, String password, boolean isAdmin) {
		if((username.length()>0) && password.length()>0) {
			utenteDAO.insertUser(username.toLowerCase(), password, isAdmin);
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci dei dati validi!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void checkUser(String username, String password) {
		if((username.length()>0) && password.length()>0) {
			user = utenteDAO.checkUser(username.toLowerCase(), password);
			if (user != null && user.isAdmin() == true) {
				frameHome = new HomeGUI(this);
				frameHomeGUI(true);
				frameLoginGUI(false);
			}
			else if(user != null && user.isAdmin() == false) {
				frameHomeUser = new HomeUserGUI(this);
				frameHomeUserGUI(true);
				frameLoginGUI(false);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Password/Email errati!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci un User valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * Following methods
	 * 
	 */

	public void insertFollow(String id_User, String id_Artist) {
		if ((id_User.length()>0 && id_Artist.length()>0))
			followingDAO.insertFollow(id_User, id_Artist);
		else {
			JOptionPane.showMessageDialog(null,
					"Impossibile aggiungere l'artista ai preferiti",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteFollow(String id_User, String id_Following) {
		if ((id_User.length()>0 && id_Following.length()>0)) {
			followingDAO.removeFollow(id_User, id_Following);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Impossibile eliminare l'artista dai preferiti",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<Seguire> stampaFollowing() {
		return followingDAO.getAllFollowings(user.getId());
	}

	/**
	 * 
	 * Artist methods
	 * 
	 */

	public void insertArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0)) {
			if(codice.length() >= 5) {
				String codArtista = codice.substring(0, 5);
				artistDAO.insertArtist(codArtista, nome, cognome, dataNascita, citta, nomeDArte);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Il codice deve essere di 5 caratteri!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		else {
			JOptionPane.showMessageDialog(frameAddArtist,
					"Inserisci un Artista valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteArtistDB(String codice) {
		if(codice.length()>0){
			artistDAO.deleteArtist(codice);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'artista!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateArtistDB(String codice, String nome, String cognome, String dataNascita, String nomeDArte, String citta, String followers) {
		if((codice.length()>0) && (nome.length()>0) && (cognome.length()>0) && (dataNascita.length()>0) && (nomeDArte.length()>0) && (citta.length()>0) && (followers.length()>0)) {
			int Ifollowers = Integer.parseInt(followers);
			if (Ifollowers >= 0) 
				artistDAO.updateArtist(codice, nome, cognome, dataNascita, citta, Ifollowers, nomeDArte);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"Il numero di followers deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento artista!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public float retribuzioneArtista(String followers) {
		float followersArtista = Float.parseFloat(followers);
		float retribuzione = followersArtista / 1000;
		return retribuzione;
	}

	public ArrayList<Artista> stampaArtistDB(String id_User) {
		return artistDAO.getAllArtists(id_User);
	}

	public ArrayList<Artista> stampaArtistDB() {
		return artistDAO.getAllArtists();
	}

	/**
	 * 
	 * Song methods
	 * 
	 */

	public void insertSongDB(String nome, String durata, String genere, String album) {
		if((nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (album.length()>0)) {
			int duration = Integer.parseInt(durata);
			if (duration > 0) {
				String codAlbum = album.substring(0, 5);
				songDAO.insertSongDB(nome, duration, genere, codAlbum);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un brano valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteSongDB(String codice) {
		if(codice.length()>0){
			songDAO.deleteSong(codice);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare il brano!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateSong(String codice, String nome, String songDuration) {
		if((codice.length()>0) && (nome.length()>0) && (songDuration.length()>0)) {
			int sDuration = Integer.parseInt(songDuration);
			if (sDuration > 0)
				songDAO.updateSong(codice, nome, sDuration);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento il brano!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public ArrayList<Brano> stampaSongDB() {
		return songDAO.getAllSongs();
	}

	/**
	 * 
	 * Single methods
	 * 
	 */

	public void insertSingleDB(String nome, String durata, String genere, String artista, String dataPubblicazione) {
		if((artista.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			if (durataInt > 0) {
				String codArtista = artista.substring(0, 5);
				singleDAO.insertSingle(nome, durataInt, genere, codArtista, dataPubblicazione);
			}
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un singolo valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteSingleDB(String codice) {
		if(codice.length()>0){
			singleDAO.deleteSingle(codice);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare il singolo!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateSingle(String codice,String nome, String durata, String genere, String dataPubblicazione) {
		if((codice.length()>0) && (nome.length()>0) && (durata.length()>0) && (genere.length()>0) && (dataPubblicazione.length()>0)) {
			int durataInt = Integer.parseInt(durata);
			if (durataInt > 0)
				singleDAO.updateSingle(codice, nome, durataInt, genere, dataPubblicazione);
			else {
				JOptionPane.showMessageDialog(frameAddArtist,
						"La durata deve essere > 0!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento singolo!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public ArrayList<Singolo> stampaSingleDB() {
		return singleDAO.getAllSingles();
	}

	/**
	 * 
	 * EP methods
	 * 
	 */

	public void insertEPDB(String nome,  String genere, String songNumber, String artista, String dataPubblicazione) {
		if((nome.length()>0) && (genere.length()>0) && (songNumber.length()>0) && (artista.length()>0)  && (dataPubblicazione.length()>0)) {
			int songNumberInt = Integer.parseInt(songNumber);
			String codArtista = artista.substring(0, 5);
			epDAO.insertEP(nome, genere, songNumberInt, codArtista, dataPubblicazione);
		}
		else {
			JOptionPane.showMessageDialog(frameAddSong,
					"Inserisci un EP valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteEPDB(String codice) {
		if(codice.length()>0){
			epDAO.deleteEP(codice);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'EP!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateEP(String codice, String nome, String dataPubblicazione, String genere, String songNumber) {
		if((codice.length()>0) && (nome.length()>0) && (dataPubblicazione.length()>0) && (genere.length()>0) && (songNumber.length()>0)) {
			int songNumberInt = Integer.parseInt(songNumber);
			epDAO.updateEP(codice, nome, dataPubblicazione, genere, songNumberInt);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento EP!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public ArrayList<EP> stampaEPDB() {
		return epDAO.getAllEP();
	}

	/**
	 * 
	 * Album methods
	 * 
	 */

	public void insertAlbumDB(String codice, String nome, String songNumber, String genere, String data, String artista) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0) && (artista.length()>0)){
			int nSong = Integer.parseInt(songNumber);
			String codArtista = artista.substring(0, 5);
			if (nSong > 6) {
				if(codice.length() >= 5) {
					String codiceAlbum = codice.substring(0, 5);
					albumDAO.insertAlbum(codiceAlbum, nome, nSong, genere, data, codArtista);
				}
				else {
					JOptionPane.showMessageDialog(frameAddAlbum,
							"Il codice deve essere di 5 caratteri!!!",
							"Errore",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(frameAddAlbum,
						"Il numero di brani deve essere maggiore di 6!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(frameAddAlbum,
					"Inserisci un album valido!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteAlbumDB(String codice) {
		if(codice.length()>0){
			albumDAO.deleteAlbum(codice);
		}
		else {
			JOptionPane optionPane = new JOptionPane("Impossibile eliminare l'album!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public void updateAlbum(String codice, String nome, String songNumber, String genere, String data) {
		if((codice.length()>0) && (nome.length()>0) && (songNumber.length()>0) && (genere.length()>0) && (data.length()>0)) {
			int nSong = Integer.parseInt(songNumber);
			if (nSong > 6)
				albumDAO.updateAlbum(codice, nome, nSong, genere, data);
			else {
				JOptionPane.showMessageDialog(frameAddAlbum,
						"Il numero di brani deve essere maggiore di 6!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane optionPane = new JOptionPane("Errore aggiornamento album!!!", JOptionPane.ERROR_MESSAGE);    
			JDialog dialog = optionPane.createDialog("Errore");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		}
	}

	public ArrayList<Album> stampaAlbumDB() {
		return albumDAO.getAllAlbums();
	}
	
	/**
	 * 
	 * Frame methods
	 * 
	 */

	public void frameLoginGUI(boolean isVisible) {
		frameLogin.setVisible(isVisible);
	}

	public void frameSignUpGUI(boolean isVisible) {
		frameSignUp.setVisible(isVisible);

	}

	public void frameHomeGUI(boolean isVisible) {
		frameHome.setVisible(isVisible);
	}

	public void frameHomeUserGUI(boolean isVisible) {
		frameHomeUser.setVisible(isVisible);
	}

	public void frameAddArtistGUI(boolean isVisible) {
		frameAddArtist.setVisible(isVisible);
	}

	public void frameAddAlbumGUI(boolean isVisible) {
		frameAddAlbum.setVisible(isVisible);
	}

	public void frameAddSongGUI(boolean isVisible) {
		frameAddSong.setVisible(isVisible);
	}
}
