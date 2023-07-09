package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Entity.Artista;
import com.smup.Style.AppColor;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddAlbumGUI extends JFrame {
	private Controller controller;

	int mouseX, mouseY;
	private JPanel contentPane;
	private JTextField textFieldCodice;
	private JTextField textFieldNome;
	private JComboBox<String> comboBoxArtisti;
	private JTextField textFieldData;
	private JTextField textFieldSongNumber;

	public AddAlbumGUI(Controller controller) {
		this.controller = controller;
		
		setUndecorated(true);
		setResizable(false);
		setTitle("Add Album");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 642);
		setBackground(AppColor.darkGrey);

		contentPane = new JPanel();
		contentPane.setBackground(AppColor.darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelAdd = new JPanel();
		panelAdd.setBounds(5, 5, 439, 632);
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
		contentPane.setLayout(null);
		panelAdd.setBackground(AppColor.darkGrey);
		contentPane.add(panelAdd);

		JPanel AddAlbum = new JPanel();
		AddAlbum.setBounds(10, 42, 419, 485);
		AddAlbum.setBackground(AppColor.grey);

		JComboBox<String> comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setModel(new DefaultComboBoxModel<String>(new String[] {"Pop", "Rock", "Blues", "Regge", "Jazz", "Bossa nova", "Soul", "Lirica", "Metal", "Alternative", "Funk", "Country", "Hip-Hop"}));
		comboBoxGenere.setOpaque(true);
		comboBoxGenere.setForeground(Color.DARK_GRAY);
		comboBoxGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxGenere.setBorder(null);
		comboBoxGenere.setBackground(new Color(21, 21, 21));
		comboBoxGenere.setBounds(25, 306, 179, 26);
		AddAlbum.add(comboBoxGenere);

		JButton buttonAggiungi = new JButton("Add");
		buttonAggiungi.setBounds(10, 533, 420, 41);
		buttonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codice = textFieldCodice.getText();
				String nome = textFieldNome.getText();
				String genere = comboBoxGenere.getSelectedItem().toString();
				String data = textFieldData.getText();
				String artista = comboBoxArtisti.getSelectedItem().toString();
				String songNumber = textFieldSongNumber.getText();

				controller.insertAlbumDB(codice, nome, songNumber, genere, data, artista);

				textFieldCodice.setText("");
				textFieldNome.setText("");
				textFieldData.setText("");
				textFieldSongNumber.setText("");
			}
		});
		buttonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAggiungi.setBorderPainted(false);
		buttonAggiungi.setForeground(Color.WHITE);
		buttonAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAggiungi.setFocusPainted(false);
		buttonAggiungi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAggiungi.setBackground(AppColor.green);

		JLabel labelCodice = new JLabel("Id");
		labelCodice.setBounds(25, 67, 376, 25);
		labelCodice.setForeground(Color.WHITE);
		labelCodice.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel labelNome = new JLabel("Name");
		labelNome.setBounds(25, 134, 376, 25);
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(25, 165, 376, 30);
		textFieldNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNome.setOpaque(false);
		textFieldNome.setSelectionColor(new Color(0, 153, 204));
		textFieldNome.setSelectedTextColor(Color.WHITE);
		textFieldNome.setForeground(Color.WHITE);
		textFieldNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNome.setColumns(10);
		textFieldNome.setCaretColor(new Color(0, 153, 204));
		textFieldNome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNome.setBackground(new Color(36, 53, 102));

		JLabel labelGenere = new JLabel("Genre");
		labelGenere.setBounds(25, 276, 376, 25);
		labelGenere.setForeground(Color.WHITE);
		labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel labelAddAlbum = new JLabel("ADD ALBUM");
		labelAddAlbum.setBounds(10, 11, 399, 25);
		labelAddAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddAlbum.setForeground(Color.WHITE);
		labelAddAlbum.setFont(new Font("Segoe UI", Font.BOLD, 26));

		textFieldCodice = new JTextField();
		textFieldCodice.setBounds(25, 98, 376, 30);
		textFieldCodice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCodice.setOpaque(false);
		textFieldCodice.setSelectionColor(new Color(0, 153, 204));
		textFieldCodice.setSelectedTextColor(Color.WHITE);
		textFieldCodice.setForeground(Color.WHITE);
		textFieldCodice.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodice.setColumns(10);
		textFieldCodice.setCaretColor(new Color(0, 153, 204));
		textFieldCodice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCodice.setBackground(new Color(36, 53, 102));

		JLabel labelArtista = new JLabel("Artist");
		labelArtista.setBounds(25, 410, 376, 25);
		labelArtista.setForeground(Color.WHITE);
		labelArtista.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		comboBoxArtisti = new JComboBox<String>();
		comboBoxArtisti.setBounds(25, 441, 179, 26);
		comboBoxArtisti.setOpaque(true);
		comboBoxArtisti.setForeground(Color.DARK_GRAY);
		comboBoxArtisti.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBoxArtisti.setBorder(null);
		comboBoxArtisti.setBackground(new Color(21, 21, 21));

		JLabel labelData = new JLabel("Release date");
		labelData.setBounds(25, 343, 376, 25);
		labelData.setForeground(Color.WHITE);
		labelData.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		textFieldData = new JFormattedTextField(format);
		textFieldData.setBounds(25, 374, 361, 30);
		textFieldData.setSelectionColor(new Color(0, 153, 204));
		textFieldData.setSelectedTextColor(Color.WHITE);
		textFieldData.setOpaque(false);
		textFieldData.setForeground(Color.WHITE);
		textFieldData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldData.setColumns(10);
		textFieldData.setCaretColor(new Color(0, 153, 204));
		textFieldData.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldData.setBackground(new Color(36, 53, 102));

		textFieldSongNumber = new JTextField();
		textFieldSongNumber.setBounds(25, 235, 376, 30);
		textFieldSongNumber.setSelectionColor(new Color(0, 153, 204));
		textFieldSongNumber.setSelectedTextColor(Color.WHITE);
		textFieldSongNumber.setOpaque(false);
		textFieldSongNumber.setForeground(Color.WHITE);
		textFieldSongNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldSongNumber.setColumns(10);
		textFieldSongNumber.setCaretColor(new Color(0, 153, 204));
		textFieldSongNumber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldSongNumber.setBackground(new Color(36, 53, 102));
		textFieldSongNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldSongNumber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldSongNumber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});

		JLabel lblNumeroDiBrani = new JLabel("Number of songs");
		lblNumeroDiBrani.setBounds(25, 201, 376, 25);
		lblNumeroDiBrani.setForeground(Color.WHITE);
		lblNumeroDiBrani.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel labelX = new JLabel("x");
		labelX.setBounds(407, 11, 11, 20);
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
		buttonAnnulla.setBounds(10, 580, 420, 41);
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAnnulla.setForeground(Color.WHITE);
		buttonAnnulla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAnnulla.setFocusPainted(false);
		buttonAnnulla.setBorderPainted(false);
		buttonAnnulla.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAnnulla.setBackground(new Color(204, 0, 0));
		panelAdd.setLayout(null);
		AddAlbum.setLayout(null);
		AddAlbum.add(labelAddAlbum);
		AddAlbum.add(textFieldCodice);
		AddAlbum.add(labelCodice);
		AddAlbum.add(labelNome);
		AddAlbum.add(textFieldNome);
		AddAlbum.add(lblNumeroDiBrani);
		AddAlbum.add(textFieldSongNumber);
		AddAlbum.add(labelGenere);
		AddAlbum.add(labelData);
		AddAlbum.add(textFieldData);
		AddAlbum.add(labelArtista);
		AddAlbum.add(comboBoxArtisti);
		panelAdd.add(AddAlbum);
		panelAdd.add(labelX);
		panelAdd.add(buttonAggiungi);
		panelAdd.add(buttonAnnulla);

		setLocationRelativeTo(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				aggiungiArtistiComboBox();
			}
		});
	}

	public void aggiungiArtistiComboBox() {
		ArrayList<Artista> allArtists = controller.stampaArtistDB();
		comboBoxArtisti.removeAllItems();
		
		for (Artista artist : allArtists) {
			Artista a = new Artista(artist.getId(), artist.getFristName(), artist.getLastName(), artist.getCity(), artist.getBirthDate(), artist.getNickname(), artist.getFollowers());
			comboBoxArtisti.addItem(a.toString());
		}
	}
}
