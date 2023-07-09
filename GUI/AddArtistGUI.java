package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Style.AppColor;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JFormattedTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddArtistGUI extends JFrame {

	private JPanel contentPane;

	private Controller controller;
	private JTextField textFieldCodiceArtista;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JFormattedTextField textFieldDataNascita;
	private JTextField textFieldNomeDarte;
	private JTextField textFieldCitta;
	private JButton buttonAggiungi;

	int mouseX, mouseY;

	public AddArtistGUI(Controller controller) {
		this.controller = controller;
		
		setUndecorated(true);
		setResizable(false);

		setTitle("Add Artist");
		setAlwaysOnTop(true);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 763);
		setBackground(AppColor.darkGrey);

		contentPane = new JPanel();
		contentPane.setBackground(AppColor.darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelAdd = new JPanel();
		panelAdd.setBounds(5, 11, 427, 741);
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

		JPanel AddArtist = new JPanel();
		AddArtist.setBounds(10, 38, 407, 593);
		AddArtist.setBackground(AppColor.grey);

		buttonAggiungi = new JButton("Add");
		buttonAggiungi.setBounds(10, 642, 406, 41);
		buttonAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codice = textFieldCodiceArtista.getText();
				String nome = textFieldNome.getText();
				String cognome = textFieldCognome.getText();
				String dataNascita = textFieldDataNascita.getText();
				String nomeDArte = textFieldNomeDarte.getText();
				String citta = textFieldCitta.getText();

				controller.insertArtistDB(codice, nome, cognome, dataNascita, nomeDArte, citta);

				textFieldCodiceArtista.setText("");
				textFieldNome.setText("");
				textFieldCognome.setText("");
				textFieldDataNascita.setText("");
				textFieldNomeDarte.setText("");
				textFieldCitta.setText("");
			}
		});
		buttonAggiungi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAggiungi.setBorderPainted(false);
		buttonAggiungi.setForeground(Color.WHITE);
		buttonAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAggiungi.setFocusPainted(false);
		buttonAggiungi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAggiungi.setBackground(AppColor.green);

		JLabel labelAddArtist = new JLabel("ADD ARTIST");
		labelAddArtist.setHorizontalAlignment(SwingConstants.CENTER);
		labelAddArtist.setForeground(Color.WHITE);
		labelAddArtist.setFont(new Font("Segoe UI", Font.BOLD, 26));

		JLabel labelCodiceArtista = new JLabel("Id");
		labelCodiceArtista.setForeground(new Color(255, 255, 255));
		labelCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldCodiceArtista = new JTextField();
		textFieldCodiceArtista.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCodiceArtista.setOpaque(false);
		textFieldCodiceArtista.setSelectedTextColor(new Color(255, 255, 255));
		textFieldCodiceArtista.setSelectionColor(new Color(0, 153, 204));
		textFieldCodiceArtista.setCaretColor(new Color(0, 153, 204));
		textFieldCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCodiceArtista.setForeground(new Color(255, 255, 255));
		textFieldCodiceArtista.setBackground(new Color(36, 53, 102));
		textFieldCodiceArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCodiceArtista.setColumns(10);

		JLabel labelNome = new JLabel("Name");
		labelNome.setForeground(Color.WHITE);
		labelNome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldNome = new JTextField();
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

		JLabel labelCognome = new JLabel("Surname");
		labelCognome.setForeground(Color.WHITE);
		labelCognome.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldCognome = new JTextField();
		textFieldCognome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCognome.setOpaque(false);
		textFieldCognome.setSelectionColor(new Color(0, 153, 204));
		textFieldCognome.setSelectedTextColor(Color.WHITE);
		textFieldCognome.setForeground(Color.WHITE);
		textFieldCognome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCognome.setColumns(10);
		textFieldCognome.setCaretColor(new Color(0, 153, 204));
		textFieldCognome.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCognome.setBackground(new Color(36, 53, 102));

		JLabel labelData = new JLabel("Date of birth");
		labelData.setForeground(Color.WHITE);
		labelData.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		textFieldDataNascita = new JFormattedTextField(format);
		textFieldDataNascita.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldDataNascita.setOpaque(false);
		textFieldDataNascita.setSelectionColor(new Color(0, 153, 204));
		textFieldDataNascita.setSelectedTextColor(Color.WHITE);
		textFieldDataNascita.setForeground(Color.WHITE);
		textFieldDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldDataNascita.setColumns(10);
		textFieldDataNascita.setCaretColor(new Color(0, 153, 204));
		textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldDataNascita.setBackground(new Color(36, 53, 102));

		JLabel labelNomeDarte = new JLabel("Art name");
		labelNomeDarte.setForeground(Color.WHITE);
		labelNomeDarte.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldNomeDarte = new JTextField();
		textFieldNomeDarte.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldNomeDarte.setOpaque(false);
		textFieldNomeDarte.setSelectionColor(new Color(0, 153, 204));
		textFieldNomeDarte.setSelectedTextColor(Color.WHITE);
		textFieldNomeDarte.setForeground(Color.WHITE);
		textFieldNomeDarte.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldNomeDarte.setColumns(10);
		textFieldNomeDarte.setCaretColor(new Color(0, 153, 204));
		textFieldNomeDarte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldNomeDarte.setBackground(new Color(36, 53, 102));

		JLabel labelCitta = new JLabel("City");
		labelCitta.setForeground(Color.WHITE);
		labelCitta.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		textFieldCitta = new JTextField();
		textFieldCitta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		textFieldCitta.setOpaque(false);
		textFieldCitta.setSelectionColor(new Color(0, 153, 204));
		textFieldCitta.setSelectedTextColor(Color.WHITE);
		textFieldCitta.setForeground(Color.WHITE);
		textFieldCitta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldCitta.setColumns(10);
		textFieldCitta.setCaretColor(new Color(0, 153, 204));
		textFieldCitta.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textFieldCitta.setBackground(new Color(36, 53, 102));

		JLabel labelErroreInput = new JLabel("");
		labelErroreInput.setForeground(Color.RED);
		labelErroreInput.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		GroupLayout gl_AddArtist = new GroupLayout(AddArtist);
		gl_AddArtist.setHorizontalGroup(
				gl_AddArtist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddArtist.createSequentialGroup()
						.addGroup(gl_AddArtist.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_AddArtist.createSequentialGroup()
										.addContainerGap()
										.addComponent(labelAddArtist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_AddArtist.createSequentialGroup()
										.addGap(20)
										.addGroup(gl_AddArtist.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(labelCodiceArtista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldCodiceArtista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
												.addComponent(textFieldNome, Alignment.LEADING)
												.addComponent(labelCognome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(labelNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldCognome, Alignment.LEADING)
												.addComponent(labelData, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldDataNascita, Alignment.LEADING)
												.addComponent(labelNomeDarte, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldNomeDarte, Alignment.LEADING)
												.addComponent(labelCitta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textFieldCitta, Alignment.LEADING)
												.addComponent(labelErroreInput, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap())
				);
		gl_AddArtist.setVerticalGroup(
				gl_AddArtist.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddArtist.createSequentialGroup()
						.addContainerGap()
						.addComponent(labelAddArtist, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addComponent(labelCodiceArtista)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(labelNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelCognome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldCognome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelData)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelNomeDarte)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldNomeDarte, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelCitta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldCitta, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(73)
						.addComponent(labelErroreInput, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				);
		AddArtist.setLayout(gl_AddArtist);

		JLabel labelX = new JLabel("x");
		labelX.setBounds(406, 0, 11, 32);
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
		buttonAnnulla.setBounds(10, 689, 406, 41);
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
		panelAdd.setLayout(null);
		panelAdd.add(AddArtist);
		panelAdd.add(labelX);
		panelAdd.add(buttonAnnulla);
		panelAdd.add(buttonAggiungi);

		setLocationRelativeTo(null);
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
