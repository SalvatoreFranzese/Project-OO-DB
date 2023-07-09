package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Entity.Album;
import com.smup.Entity.Artista;
import com.smup.Style.AppColor;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddSongGUI extends JFrame {
	private Controller controller;
	
	private JPanel contentPane;
	private JComboBox<String> comboBoxPubblicazioni;
	private JComboBox<String> comboBoxArtisti;
	private JComboBox<String> comboBoxAlbum;
	int mouseX, mouseY;
	private JTextField textFieldNomePubblicazione;
	private JTextField textFieldDurata;
	private JTextField textFieldEP;
	private JTextField textFieldDataEPSingle;

	public AddSongGUI(Controller controller) {
		setUndecorated(true);

		setResizable(false);
		this.controller = controller;

		setTitle("Add Song");
		setAlwaysOnTop(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 726);
		setBackground(AppColor.darkGrey);

		contentPane = new JPanel();
		contentPane.setBackground(AppColor.darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelAdd = new JPanel();
		panelAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		panelAdd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				setLocation(x - mouseX, y - mouseY);
			}
		});
		panelAdd.setBackground(AppColor.darkGrey);
		contentPane.add(panelAdd, BorderLayout.CENTER);

		JPanel AddArtist = new JPanel();
		AddArtist.setBackground(AppColor.grey);

		JComboBox<String> comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setVisible(false);
		comboBoxGenere.setModel(new DefaultComboBoxModel<String>(new String[] {"Pop", "Rock", "Blues", "Regge", "Jazz", "Bossa nova", "Soul", "Lirica", "Metal", "Alternative", "Funk", "Country", "Hip-Hop"}));
		comboBoxGenere.setOpaque(true);
		comboBoxGenere.setForeground(Color.DARK_GRAY);
		comboBoxGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxGenere.setBorder(null);
		comboBoxGenere.setBackground(new Color(21, 21, 21));
		comboBoxGenere.setBounds(10, 321, 179, 26);
		AddArtist.add(comboBoxGenere);

		JComboBox<String> comboBoxSongNumberEP = new JComboBox<String>();
		comboBoxSongNumberEP.setVisible(false);
		comboBoxSongNumberEP.setModel(new DefaultComboBoxModel<String>(new String[] {"2", "3", "4", "5"}));
		comboBoxSongNumberEP.setOpaque(true);
		comboBoxSongNumberEP.setForeground(Color.DARK_GRAY);
		comboBoxSongNumberEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxSongNumberEP.setBorder(null);
		comboBoxSongNumberEP.setBackground(new Color(21, 21, 21));
		comboBoxSongNumberEP.setBounds(10, 536, 179, 26);
		AddArtist.add(comboBoxSongNumberEP);

		JButton buttonAggiungi = new JButton("Add");
		buttonAggiungi.setEnabled(false);
		buttonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxPubblicazioni.getSelectedItem() == "Singolo" && comboBoxArtisti.getItemCount() != 0) {
					String artista = comboBoxArtisti.getSelectedItem().toString();
					String dataPubblicazione = textFieldDataEPSingle.getText();
					String durata = textFieldDurata.getText();
					String nome = textFieldNomePubblicazione.getText();
					String genere = comboBoxGenere.getSelectedItem().toString();

					controller.insertSingleDB(nome, durata, genere, artista, dataPubblicazione);

					textFieldNomePubblicazione.setText("");
					textFieldDurata.setText("");
					textFieldDataEPSingle.setText("");

				}else if(comboBoxPubblicazioni.getSelectedItem() == "Brano" && comboBoxAlbum.getItemCount() != 0) {
					String album = comboBoxAlbum.getSelectedItem().toString();
					String durata = textFieldDurata.getText();
					String nome = textFieldNomePubblicazione.getText();
					String genere = comboBoxGenere.getSelectedItem().toString();

					controller.insertSongDB(nome, durata, genere, album);

					textFieldNomePubblicazione.setText("");
					textFieldDurata.setText("");

				}else if(comboBoxPubblicazioni.getSelectedItem() == "EP" && comboBoxArtisti.getItemCount() != 0) {
					String artista = comboBoxArtisti.getSelectedItem().toString();
					String nomeEp = textFieldEP.getText();
					String songNumber = comboBoxSongNumberEP.getSelectedItem().toString();
					String dataPubblicazione = textFieldDataEPSingle.getText();
					String genere = comboBoxGenere.getSelectedItem().toString();

					controller.insertEPDB(nomeEp, genere, songNumber, artista, dataPubblicazione);

					textFieldEP.setText("");
					textFieldDataEPSingle.setText("");
					textFieldDurata.setText("");
				}else {
					JOptionPane optionPane = new JOptionPane("Verifica di aver inserito almeno un album/artista", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("Errore");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
			}
		});
		buttonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAggiungi.setBorderPainted(false);
		buttonAggiungi.setForeground(Color.WHITE);
		buttonAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAggiungi.setFocusPainted(false);
		buttonAggiungi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAggiungi.setBackground(AppColor.green);

		JLabel labelAddSong = new JLabel("Add Song");
		labelAddSong.setBounds(10, 11, 401, 36);
		labelAddSong.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddSong.setForeground(Color.WHITE);
		labelAddSong.setFont(new Font("Segoe UI", Font.BOLD, 26));

		JLabel labelHaiQualcheSingolo = new JLabel("Pubblication type");
		labelHaiQualcheSingolo.setBounds(10, 58, 401, 25);
		labelHaiQualcheSingolo.setForeground(Color.WHITE);
		labelHaiQualcheSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldNomePubblicazione = new JTextField();
		textFieldNomePubblicazione.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNomePubblicazione.setBounds(10, 167, 398, 30);
		textFieldNomePubblicazione.setVisible(false);
		textFieldNomePubblicazione.setSelectionColor(new Color(0, 153, 204));
		textFieldNomePubblicazione.setSelectedTextColor(Color.WHITE);
		textFieldNomePubblicazione.setOpaque(false);
		textFieldNomePubblicazione.setForeground(Color.WHITE);
		textFieldNomePubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNomePubblicazione.setColumns(10);
		textFieldNomePubblicazione.setCaretColor(new Color(0, 153, 204));
		textFieldNomePubblicazione.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNomePubblicazione.setBackground(new Color(36, 53, 102));

		JLabel labelNomePubblicazione = new JLabel("Nome Song");
		labelNomePubblicazione.setBounds(10, 131, 361, 25);
		labelNomePubblicazione.setVisible(false);
		labelNomePubblicazione.setForeground(Color.WHITE);
		labelNomePubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel labelDurata = new JLabel("Duration");
		labelDurata.setBounds(10, 208, 361, 25);
		labelDurata.setVisible(false);
		labelDurata.setForeground(Color.WHITE);
		labelDurata.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldDurata = new JTextField();
		textFieldDurata.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldDurata.setBounds(10, 244, 398, 30);
		textFieldDurata.setVisible(false);
		textFieldDurata.setSelectionColor(new Color(0, 153, 204));
		textFieldDurata.setSelectedTextColor(Color.WHITE);
		textFieldDurata.setOpaque(false);
		textFieldDurata.setForeground(Color.WHITE);
		textFieldDurata.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDurata.setColumns(10);
		textFieldDurata.setCaretColor(new Color(0, 153, 204));
		textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldDurata.setBackground(new Color(36, 53, 102));

		JLabel labelGenere = new JLabel("Genre");
		labelGenere.setBounds(10, 285, 361, 25);
		labelGenere.setVisible(false);
		labelGenere.setForeground(Color.WHITE);
		labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldEP = new JTextField();
		textFieldEP.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldEP.setBounds(10, 167, 398, 30);
		textFieldEP.setVisible(false);
		textFieldEP.setSelectionColor(new Color(0, 153, 204));
		textFieldEP.setSelectedTextColor(Color.WHITE);
		textFieldEP.setOpaque(false);
		textFieldEP.setForeground(Color.WHITE);
		textFieldEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldEP.setColumns(10);
		textFieldEP.setCaretColor(new Color(0, 153, 204));
		textFieldEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldEP.setBackground(new Color(36, 53, 102));

		JLabel labelNomeEP = new JLabel("Name EP");
		labelNomeEP.setBounds(10, 131, 361, 25);
		labelNomeEP.setVisible(false);
		labelNomeEP.setForeground(Color.WHITE);
		labelNomeEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel labelAlbum = new JLabel("Album");
		labelAlbum.setForeground(Color.WHITE);
		labelAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelAlbum.setBounds(10, 362, 401, 25);
		labelAlbum.setVisible(false);
		AddArtist.add(labelAlbum);

		comboBoxAlbum = new JComboBox<String>();
		comboBoxAlbum.setOpaque(true);
		comboBoxAlbum.setForeground(Color.DARK_GRAY);
		comboBoxAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxAlbum.setBorder(null);
		comboBoxAlbum.setBackground(new Color(21, 21, 21));
		comboBoxAlbum.setBounds(10, 398, 179, 26);
		comboBoxAlbum.setVisible(false);
		AddArtist.add(comboBoxAlbum);

		JLabel labelNomeArtista = new JLabel("Artist");
		labelNomeArtista.setVisible(false);
		labelNomeArtista.setForeground(Color.WHITE);
		labelNomeArtista.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelNomeArtista.setBounds(10, 362, 401, 25);
		AddArtist.add(labelNomeArtista);

		comboBoxArtisti = new JComboBox<String>();
		comboBoxArtisti.setVisible(false);
		comboBoxArtisti.setOpaque(true);
		comboBoxArtisti.setForeground(Color.DARK_GRAY);
		comboBoxArtisti.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxArtisti.setBorder(null);
		comboBoxArtisti.setBackground(new Color(21, 21, 21));
		comboBoxArtisti.setBounds(10, 398, 179, 26);
		AddArtist.add(comboBoxArtisti);

		JLabel labelSongNumberEP = new JLabel("Song numbers");
		labelSongNumberEP.setVisible(false);
		labelSongNumberEP.setForeground(Color.WHITE);
		labelSongNumberEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelSongNumberEP.setBounds(10, 500, 401, 25);
		AddArtist.add(labelSongNumberEP);

		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		textFieldDataEPSingle = new JFormattedTextField(format);
		textFieldDataEPSingle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDataEPSingle.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldDataEPSingle.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldDataEPSingle.setVisible(false);
		textFieldDataEPSingle.setSelectionColor(new Color(0, 153, 204));
		textFieldDataEPSingle.setSelectedTextColor(Color.WHITE);
		textFieldDataEPSingle.setOpaque(false);
		textFieldDataEPSingle.setForeground(Color.WHITE);
		textFieldDataEPSingle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDataEPSingle.setColumns(10);
		textFieldDataEPSingle.setCaretColor(new Color(0, 153, 204));
		textFieldDataEPSingle.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldDataEPSingle.setBackground(new Color(36, 53, 102));
		textFieldDataEPSingle.setBounds(10, 459, 398, 30);
		AddArtist.add(textFieldDataEPSingle);

		JLabel labelDataEPSingle = new JLabel("Release date");
		labelDataEPSingle.setVisible(false);
		labelDataEPSingle.setForeground(Color.WHITE);
		labelDataEPSingle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		labelDataEPSingle.setBounds(10, 428, 376, 25);
		AddArtist.add(labelDataEPSingle);

		comboBoxPubblicazioni = new JComboBox<String>();
		comboBoxPubblicazioni.setBounds(10, 94, 179, 26);
		comboBoxPubblicazioni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				comboBoxPubblicazioni.setBackground(AppColor.darkGrey);
			}
		});
		comboBoxPubblicazioni.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxPubblicazioni.setBackground(AppColor.darkGrey);
		comboBoxPubblicazioni.setBorder(null);
		comboBoxPubblicazioni.setForeground(Color.DARK_GRAY);
		comboBoxPubblicazioni.setOpaque(true);
		comboBoxPubblicazioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxPubblicazioni.getSelectedItem() == "Single") {
					textFieldNomePubblicazione.setVisible(true);
					labelNomePubblicazione.setVisible(true);
					labelDurata.setVisible(true);
					textFieldDurata.setVisible(true);
					comboBoxGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelNomeEP.setVisible(false);
					textFieldEP.setVisible(false);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
					labelNomeArtista.setVisible(true);
					labelSongNumberEP.setVisible(false);
					comboBoxSongNumberEP.setVisible(false);
					textFieldDataEPSingle.setVisible(true);
					labelDataEPSingle.setVisible(true);
					comboBoxArtisti.setVisible(true);
					buttonAggiungi.setEnabled(true);
					aggiungiArtistiComboBox();
				} else if(comboBoxPubblicazioni.getSelectedItem() == "Song") {
					textFieldNomePubblicazione.setVisible(true);
					labelNomePubblicazione.setVisible(true);
					labelDurata.setVisible(true);
					textFieldDurata.setVisible(true);
					comboBoxGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelAlbum.setVisible(true);
					comboBoxAlbum.setVisible(true);
					labelNomeEP.setVisible(false);
					textFieldEP.setVisible(false);
					labelNomeArtista.setVisible(false);
					comboBoxArtisti.setVisible(false);
					labelSongNumberEP.setVisible(false);
					comboBoxSongNumberEP.setVisible(false);
					textFieldDataEPSingle.setVisible(false);
					labelDataEPSingle.setVisible(false);
					buttonAggiungi.setEnabled(true);
					aggiungiAlbumComboBox();
				} else if(comboBoxPubblicazioni.getSelectedItem() == "EP") {
					textFieldNomePubblicazione.setVisible(false);
					labelNomePubblicazione.setVisible(false);
					labelDurata.setVisible(false);
					textFieldDurata.setVisible(false);
					comboBoxGenere.setVisible(true);
					labelGenere.setVisible(true);
					labelNomeEP.setVisible(true);
					textFieldEP.setVisible(true);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
					labelNomeArtista.setVisible(true);
					labelSongNumberEP.setVisible(true);
					comboBoxSongNumberEP.setVisible(true);
					textFieldDataEPSingle.setVisible(true);
					labelDataEPSingle.setVisible(true);
					comboBoxArtisti.setVisible(true);
					buttonAggiungi.setEnabled(true);
					aggiungiArtistiComboBox();
				} else {
					textFieldNomePubblicazione.setVisible(false);
					labelNomePubblicazione.setVisible(false);
					comboBoxGenere.setVisible(false);
					labelDurata.setVisible(false);
					textFieldDurata.setVisible(false);
					labelGenere.setVisible(false);
					labelNomeEP.setVisible(false);
					textFieldEP.setVisible(false);
					labelAlbum.setVisible(false);
					comboBoxAlbum.setVisible(false);
					labelNomeArtista.setVisible(false);
					comboBoxArtisti.setVisible(false);
					buttonAggiungi.setEnabled(false);
					labelSongNumberEP.setVisible(false);
					comboBoxSongNumberEP.setVisible(false);
					textFieldDataEPSingle.setVisible(false);
					labelDataEPSingle.setVisible(false);
				}
			}
		});
		comboBoxPubblicazioni.setModel(new DefaultComboBoxModel<String>(new String[] {"No", "Single", "EP", "Song"}));

		JLabel labelX = new JLabel("x");
		labelX.setAlignmentY(Component.TOP_ALIGNMENT);
		labelX.setAlignmentX(Component.RIGHT_ALIGNMENT);
		labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		labelX.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		labelX.setForeground(new Color(255, 0, 0));

		JButton buttonAnnulla = new JButton("Cancel");
		buttonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonAnnulla.setForeground(Color.WHITE);
		buttonAnnulla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAnnulla.setFocusPainted(false);
		buttonAnnulla.setBorderPainted(false);
		buttonAnnulla.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAnnulla.setBackground(new Color(204, 0, 0));

		GroupLayout gl_panelAdd = new GroupLayout(panelAdd);
		gl_panelAdd.setHorizontalGroup(
				gl_panelAdd.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAdd.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelAdd.createParallelGroup(Alignment.TRAILING)
								.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(AddArtist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
								.addComponent(buttonAggiungi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
								.addComponent(buttonAnnulla, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
						.addContainerGap())
				);
		gl_panelAdd.setVerticalGroup(
				gl_panelAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAdd.createSequentialGroup()
						.addComponent(labelX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(AddArtist, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAggiungi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonAnnulla, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		AddArtist.setLayout(null);
		AddArtist.add(labelNomeEP);
		AddArtist.add(textFieldEP);
		AddArtist.add(labelGenere);
		AddArtist.add(labelDurata);
		AddArtist.add(textFieldDurata);
		AddArtist.add(labelNomePubblicazione);
		AddArtist.add(textFieldNomePubblicazione);
		AddArtist.add(comboBoxPubblicazioni);
		AddArtist.add(labelHaiQualcheSingolo);
		AddArtist.add(labelAddSong);

		panelAdd.setLayout(gl_panelAdd);
		setLocationRelativeTo(null);
	}

	public void aggiungiArtistiComboBox() {
		ArrayList<Artista> allArtists = controller.stampaArtistDB();
		comboBoxArtisti.removeAllItems();
		
		for (Artista artist : allArtists) {
			Artista a = new Artista(artist.getId(), artist.getFristName(), artist.getLastName(), artist.getCity(), artist.getBirthDate(), artist.getNickname(), artist.getFollowers());
			comboBoxArtisti.addItem(a.toString());
		}
	}

	public void aggiungiAlbumComboBox() {
		ArrayList<Album> allAlbums = controller.stampaAlbumDB();
		comboBoxAlbum.removeAllItems();
		
		if(!allAlbums.isEmpty()) {
			for (Album album : allAlbums) {
				Album a = new Album(String.valueOf(album.getPublications().getAlbum()), album.getName(), album.getGenre(), album.getNumberSongs());
				comboBoxAlbum.addItem(a.toString());
			}
		}
	}
}
