package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Entity.Album;
import com.smup.Entity.Artista;
import com.smup.Entity.Brano;
import com.smup.Entity.EP;
import com.smup.Entity.Seguire;
import com.smup.Entity.Singolo;
import com.smup.Style.AppColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class HomeUserGUI extends JFrame {
	private Controller controller;
	
	private JPanel contentPane;
	private JPanel panelPrintArtists;
	private JPanel panelPrintAlbums;
	private JPanel panelPrintOthers;
	private JPanel panelPrintFollowed;
	private JPanel panelShowFollowed;
	private JPanel panelPrintSearch;
	private JScrollPane scrollPaneSearch;
	private JScrollPane scrollPaneFollowed;
	private JScrollPane scrollPaneArtists;
	private JScrollPane scrollPaneAlbums;
	private JScrollPane scrollPaneOthers;
	private JTextField searchTextField;

	public HomeUserGUI(Controller controller) {
		this.controller = controller;

		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeUserGUI.class.getResource("/com/smup/Img/LogoB-48.png")));

		setBackground(new Color(36, 53, 102));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1406, 870);
		contentPane = new JPanel();
		contentPane.setBackground(AppColor.darkGrey);
		setContentPane(contentPane);

		JPanel menuRight = new JPanel();
		menuRight.setBackground(AppColor.black);

		JLabel logoTop = new JLabel("");
		logoTop.setHorizontalAlignment(SwingConstants.CENTER);
		logoTop.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Logo-64.png")));

		JPanel Card = new JPanel();
		Card.setBackground(AppColor.grey);

		JPanel panelSearchDB = new JPanel();
		panelSearchDB.setBackground(AppColor.grey);

		JPanel panelShowArtists = new JPanel();
		panelShowArtists.setBackground(AppColor.grey);

		JPanel panelShowAlbums = new JPanel();
		panelShowAlbums.setBackground(AppColor.grey);

		JPanel panelOthers = new JPanel();
		panelOthers.setBackground(AppColor.grey);

		JButton buttonSearch = new JButton("Search...");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearchDB.setVisible(true);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(false);
				panelShowFollowed.setVisible(false);
			}
		});
		buttonSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonSearch.setHorizontalAlignment(SwingConstants.LEFT);
		buttonSearch.setIconTextGap(10);
		buttonSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSearch.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSearch.setBackground(AppColor.black);
			}
		});
		buttonSearch.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonSearch.setForeground(new Color(255, 255, 255));
		buttonSearch.setBackground(AppColor.black);
		buttonSearch.setFocusPainted(false);
		buttonSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSearch.setBorderPainted(false);
		buttonSearch.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Search.png")));

		JButton buttonShowArtists = new JButton("Show all artists");
		buttonShowArtists.setFocusPainted(false);
		buttonShowArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearchDB.setVisible(false);
				panelShowArtists.setVisible(true);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(false);
				panelShowFollowed.setVisible(false);

				stampaArtistGUI();
			}
		});
		buttonShowArtists.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonShowArtists.setHorizontalAlignment(SwingConstants.LEFT);
		buttonShowArtists.setIconTextGap(10);
		buttonShowArtists.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonShowArtists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonShowArtists.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonShowArtists.setBackground(AppColor.black);
			}
		});
		buttonShowArtists.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Artists-48.png")));
		buttonShowArtists.setForeground(Color.WHITE);
		buttonShowArtists.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonShowArtists.setBorderPainted(false);
		buttonShowArtists.setBackground(new Color(15, 15, 15));

		JButton buttonShowAlbums = new JButton("Show all albums");
		buttonShowAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearchDB.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(true);
				panelOthers.setVisible(false);
				panelShowFollowed.setVisible(false);

				stampaAlbumGUI();
			}
		});
		buttonShowAlbums.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonShowAlbums.setHorizontalAlignment(SwingConstants.LEFT);
		buttonShowAlbums.setIconTextGap(10);
		buttonShowAlbums.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonShowAlbums.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonShowAlbums.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonShowAlbums.setBackground(AppColor.black);
			}
		});
		buttonShowAlbums.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Albums-48.png")));
		buttonShowAlbums.setForeground(Color.WHITE);
		buttonShowAlbums.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonShowAlbums.setFocusPainted(false);
		buttonShowAlbums.setBorderPainted(false);
		buttonShowAlbums.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonShowAlbums.setBackground(new Color(15, 15, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(menuRight, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(6)
										.addComponent(logoTop, GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(Card, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(35)
						.addComponent(logoTop, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(Card, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(menuRight, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
				);

		JButton buttonOthers = new JButton("Others...");
		buttonOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearchDB.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(true);
				panelShowFollowed.setVisible(false);

				stampaSongGUI();
			}
		});
		buttonOthers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonOthers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonOthers.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonOthers.setBackground(AppColor.black);
			}
		});
		buttonOthers.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Song-48.png")));
		buttonOthers.setIconTextGap(10);
		buttonOthers.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonOthers.setHorizontalAlignment(SwingConstants.LEFT);
		buttonOthers.setForeground(Color.WHITE);
		buttonOthers.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonOthers.setFocusPainted(false);
		buttonOthers.setBorderPainted(false);
		buttonOthers.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonOthers.setBackground(new Color(15, 15, 15));

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(AppColor.black);
			}
		});
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.user = null;
				controller.frameLoginGUI(true);
				setVisible(false);
			}
		});
		btnLogOut.setIcon(new ImageIcon(HomeGUI.class.getResource("/com/smup/Img/LogOut-48.png")));
		btnLogOut.setIconTextGap(10);
		btnLogOut.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(15, 15, 15));

		JLabel lblNameUsers = new JLabel("NameUsers");
		lblNameUsers.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Account-48.png")));
		lblNameUsers.setText(controller.user.getUsername());
		lblNameUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameUsers.setForeground(Color.WHITE);
		lblNameUsers.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JButton btnFollow = new JButton("Followed");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSearchDB.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(false);
				panelShowFollowed.setVisible(true);

				stampaFollowing();
			}
		});
		btnFollow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFollow.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/FollowSection-48.png")));
		btnFollow.setIconTextGap(10);
		btnFollow.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnFollow.setHorizontalAlignment(SwingConstants.LEFT);
		btnFollow.setForeground(Color.WHITE);
		btnFollow.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnFollow.setFocusPainted(false);
		btnFollow.setBorderPainted(false);
		btnFollow.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		btnFollow.setBackground(new Color(15, 15, 15));
		btnFollow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFollow.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFollow.setBackground(AppColor.black);
			}
		});

		GroupLayout gl_menuRight = new GroupLayout(menuRight);
		gl_menuRight.setHorizontalGroup(
			gl_menuRight.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGroup(gl_menuRight.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
						.addGroup(gl_menuRight.createSequentialGroup()
							.addGroup(gl_menuRight.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_menuRight.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNameUsers, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
								.addComponent(buttonShowArtists, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
								.addComponent(buttonSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
							.addGap(10)))
					.addGap(0))
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGroup(gl_menuRight.createParallelGroup(Alignment.TRAILING)
						.addComponent(buttonShowAlbums, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonOthers, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_menuRight.setVerticalGroup(
			gl_menuRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNameUsers, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(buttonSearch, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowArtists, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowAlbums, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonOthers, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		menuRight.setLayout(gl_menuRight);
		Card.setLayout(new CardLayout(0, 0));

		Card.add(panelSearchDB, "name_228475787480200");

		JLabel labelCreatedBy = new JLabel("Created by Franzese Salvatore & Cammardella Paolo");
		labelCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreatedBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCreatedBy.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		labelCreatedBy.setForeground(new Color(255, 255, 255));
		labelCreatedBy.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel lblDashboard = new JLabel("SEARCH ARTISTS");
		lblDashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		lblDashboard.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 30));

		JLabel SpazioLeft = new JLabel("");

		JLabel SpazioRight = new JLabel("");

		searchTextField = new JTextField();
		searchTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				searchTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				searchTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
			}
		});
		searchTextField.setSelectionColor(new Color(0, 153, 204));
		searchTextField.setSelectedTextColor(Color.WHITE);
		searchTextField.setOpaque(false);
		searchTextField.setForeground(Color.WHITE);
		searchTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		searchTextField.setColumns(10);
		searchTextField.setCaretColor(new Color(0, 153, 204));
		searchTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		searchTextField.setBackground(new Color(36, 53, 102));

		JButton btnSearch = new JButton("Search...");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeDaCercare = searchTextField.getText();

				stampaRicerca(nomeDaCercare);

				searchTextField.setText("");
			}
		});
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(AppColor.darkGreen);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(AppColor.green);
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSearch.setFocusPainted(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnSearch.setBackground(AppColor.green);

		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(AppColor.grey);

		GroupLayout gl_panelSearchDB = new GroupLayout(panelSearchDB);
		gl_panelSearchDB.setHorizontalGroup(
				gl_panelSearchDB.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSearchDB.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelSearchDB.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelSearchDB.createSequentialGroup()
										.addGroup(gl_panelSearchDB.createParallelGroup(Alignment.LEADING)
												.addComponent(labelCreatedBy, GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
												.addGroup(gl_panelSearchDB.createSequentialGroup()
														.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panelSearchDB.createParallelGroup(Alignment.LEADING)
																.addComponent(lblDashboard, GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
																.addComponent(panelSearch, GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)))
										.addContainerGap())
								.addGroup(gl_panelSearchDB.createSequentialGroup()
										.addGap(333)
										.addGroup(gl_panelSearchDB.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(searchTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
										.addGap(340))))
				);
		gl_panelSearchDB.setVerticalGroup(
				gl_panelSearchDB.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearchDB.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblDashboard, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addGap(3)
						.addGroup(gl_panelSearchDB.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSearchDB.createSequentialGroup()
										.addGap(11)
										.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
								.addGroup(gl_panelSearchDB.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
								.addGroup(gl_panelSearchDB.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panelSearch, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
										.addGap(9)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(labelCreatedBy, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		scrollPaneSearch = new JScrollPane();
		scrollPaneSearch.setBorder(null);
		GroupLayout gl_panelSearch = new GroupLayout(panelSearch);
		gl_panelSearch.setHorizontalGroup(
				gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneSearch, GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panelSearch.setVerticalGroup(
				gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneSearch, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
						.addContainerGap())
				);

		panelPrintSearch = new JPanel();
		panelPrintSearch.setPreferredSize(new Dimension(400, 500));
		panelPrintSearch.setBackground(AppColor.grey);
		scrollPaneSearch.setViewportView(panelPrintSearch);

		panelSearch.setLayout(gl_panelSearch);
		panelSearchDB.setLayout(gl_panelSearchDB);

		Card.add(panelShowArtists, "name_228485702864300");

		JLabel labelArtist = new JLabel("ARTISTS");
		labelArtist.setForeground(new Color(255, 255, 255));
		labelArtist.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtist.setFont(new Font("Segoe UI", Font.BOLD, 30));

		scrollPaneArtists = new JScrollPane();
		scrollPaneArtists.setAutoscrolls(true);
		scrollPaneArtists.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneArtists.setBorder(null);

		GroupLayout gl_panelShowArtists = new GroupLayout(panelShowArtists);
		gl_panelShowArtists.setHorizontalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(10)
						.addComponent(labelArtist, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneArtists, GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
						.addGap(13))
				);
		gl_panelShowArtists.setVerticalGroup(
				gl_panelShowArtists.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowArtists.createSequentialGroup()
						.addGap(11)
						.addComponent(labelArtist, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneArtists, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
						.addGap(16))
				);
		scrollPaneArtists.setBackground(AppColor.darkGrey);
		panelShowArtists.setLayout(gl_panelShowArtists);

		panelPrintArtists = new JPanel();
		panelPrintArtists.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelPrintArtists.setPreferredSize(new Dimension(400, 700));
		panelPrintArtists.setBackground(AppColor.grey);
		panelPrintArtists.setForeground(AppColor.grey);
		scrollPaneArtists.setBackground(AppColor.darkGrey);
		scrollPaneArtists.setViewportView(panelPrintArtists);
		panelShowArtists.setLayout(gl_panelShowArtists);

		Card.add(panelShowAlbums, "name_228516752218900");

		JLabel labelAlbum = new JLabel("ALBUMS");
		labelAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		labelAlbum.setForeground(new Color(255, 255, 255));
		labelAlbum.setFont(new Font("Segoe UI", Font.BOLD, 30));

		scrollPaneAlbums = new JScrollPane();
		scrollPaneAlbums.setAutoscrolls(true);
		scrollPaneAlbums.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAlbums.setBorder(null);

		GroupLayout gl_panelShowAlbums = new GroupLayout(panelShowAlbums);
		gl_panelShowAlbums.setHorizontalGroup(
				gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
						.addGap(10)
						.addComponent(labelAlbum, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneAlbums, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panelShowAlbums.setVerticalGroup(
				gl_panelShowAlbums.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowAlbums.createSequentialGroup()
						.addGap(11)
						.addComponent(labelAlbum, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneAlbums, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
						.addContainerGap())
				);

		panelPrintAlbums = new JPanel();
		panelPrintAlbums.setPreferredSize(new Dimension(400, 1000));
		panelPrintAlbums.setBackground(AppColor.grey);
		scrollPaneAlbums.setViewportView(panelPrintAlbums);
		panelPrintAlbums.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelShowAlbums.setLayout(gl_panelShowAlbums);

		Card.add(panelOthers, "name_175542340994200");

		JLabel labelOthers = new JLabel("OTHERS");
		labelOthers.setHorizontalAlignment(SwingConstants.CENTER);
		labelOthers.setForeground(Color.WHITE);
		labelOthers.setFont(new Font("Segoe UI", Font.BOLD, 30));

		scrollPaneOthers = new JScrollPane();
		scrollPaneOthers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneOthers.setBorder(null);
		scrollPaneOthers.setAutoscrolls(true);

		JButton buttonSong = new JButton("Song");
		JButton buttonSIngle = new JButton("Single");
		JButton buttonEP = new JButton("EP");

		buttonSIngle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stampaSingleGUI();
			}
		});

		buttonEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stampaEPGUI();
			}
		});

		buttonSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stampaSongGUI();
			}
		});

		buttonSIngle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSIngle.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSIngle.setBackground(AppColor.black);
			}
		});

		buttonEP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonEP.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonEP.setBackground(AppColor.black);
			}
		});

		buttonSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSong.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSong.setBackground(AppColor.black);
			}
		});

		buttonSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSong.setIconTextGap(10);
		buttonSong.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonSong.setForeground(Color.WHITE);
		buttonSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonSong.setFocusPainted(false);
		buttonSong.setBorderPainted(false);
		buttonSong.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonSong.setBackground(AppColor.black);

		buttonSIngle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSIngle.setIconTextGap(10);
		buttonSIngle.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonSIngle.setForeground(Color.WHITE);
		buttonSIngle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonSIngle.setFocusPainted(false);
		buttonSIngle.setBorderPainted(false);
		buttonSIngle.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonSIngle.setBackground(new Color(15, 15, 15));

		buttonEP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonEP.setIconTextGap(10);
		buttonEP.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonEP.setForeground(Color.WHITE);
		buttonEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonEP.setFocusPainted(false);
		buttonEP.setBorderPainted(false);
		buttonEP.setBorder(new LineBorder(new Color(0, 51, 255), 10));
		buttonEP.setBackground(new Color(15, 15, 15));
		GroupLayout gl_panelOthers = new GroupLayout(panelOthers);
		gl_panelOthers.setHorizontalGroup(
				gl_panelOthers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOthers.createSequentialGroup()
						.addGap(10)
						.addComponent(labelOthers, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(Alignment.TRAILING, gl_panelOthers.createSequentialGroup()
						.addGap(158)
						.addComponent(buttonSong, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonSIngle, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonEP, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addGap(156))
				.addGroup(gl_panelOthers.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneOthers, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panelOthers.setVerticalGroup(
				gl_panelOthers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOthers.createSequentialGroup()
						.addGap(11)
						.addComponent(labelOthers, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelOthers.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOthers.createParallelGroup(Alignment.BASELINE)
										.addComponent(buttonSong, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonSIngle, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addComponent(buttonEP, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneOthers, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
						.addContainerGap())
				);

		panelPrintOthers = new JPanel();
		panelPrintOthers.setPreferredSize(new Dimension(400, 740));
		panelPrintOthers.setBackground(AppColor.grey);
		scrollPaneOthers.setViewportView(panelPrintOthers);

		panelOthers.setLayout(gl_panelOthers);

		panelShowFollowed = new JPanel();
		panelShowFollowed.setBackground(new Color(26, 26, 26));
		Card.add(panelShowFollowed, "name_346680048940800");

		JLabel lblFollowed = new JLabel("Followed");
		lblFollowed.setHorizontalAlignment(SwingConstants.CENTER);
		lblFollowed.setForeground(Color.WHITE);
		lblFollowed.setFont(new Font("Segoe UI", Font.BOLD, 30));

		scrollPaneFollowed = new JScrollPane();
		scrollPaneFollowed.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFollowed.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneFollowed.setBorder(null);
		scrollPaneFollowed.setBackground(AppColor.grey);
		scrollPaneFollowed.setAutoscrolls(true);
		GroupLayout gl_panelShowFollowed = new GroupLayout(panelShowFollowed);
		gl_panelShowFollowed.setHorizontalGroup(
				gl_panelShowFollowed.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1149, Short.MAX_VALUE)
				.addGroup(gl_panelShowFollowed.createSequentialGroup()
						.addGap(10)
						.addComponent(lblFollowed, GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelShowFollowed.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPaneFollowed, GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
						.addGap(13))
				);
		gl_panelShowFollowed.setVerticalGroup(
				gl_panelShowFollowed.createParallelGroup(Alignment.LEADING)
				.addGap(0, 711, Short.MAX_VALUE)
				.addGroup(gl_panelShowFollowed.createSequentialGroup()
						.addGap(11)
						.addComponent(lblFollowed, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPaneFollowed, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addGap(16))
				);

		panelPrintFollowed = new JPanel();
		panelPrintFollowed.setPreferredSize(new Dimension(400, 500));
		panelPrintFollowed.setBackground(AppColor.grey);
		scrollPaneFollowed.setViewportView(panelPrintFollowed);

		panelShowFollowed.setLayout(gl_panelShowFollowed);

		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
	}

	public void stampaArtistGUI() {
		panelPrintArtists.removeAll();
		panelPrintArtists.revalidate();
		panelPrintArtists.repaint();
		
		ArrayList<Artista> allArtists = controller.stampaArtistDB(controller.user.getId());
		
		if(!allArtists.isEmpty()) {
			for (Artista artist : allArtists) {
					JPanel panelBackGroundArtist = new JPanel();
					panelBackGroundArtist.setBackground(AppColor.darkGrey);

					JTextField textFieldNomeArtista = new JTextField();
					textFieldNomeArtista.setForeground(new Color(255, 255, 255));
					textFieldNomeArtista.setEditable(false);
					textFieldNomeArtista.setDisabledTextColor(new Color(255, 255, 255));
					textFieldNomeArtista.setBackground(AppColor.darkGrey);
					textFieldNomeArtista.setBorder(null);
					textFieldNomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFieldNomeArtista.setColumns(10);

					JTextField textFieldNomeDArte = new JTextField();
					textFieldNomeDArte.setForeground(new Color(255, 255, 255));
					textFieldNomeDArte.setEditable(false);
					textFieldNomeDArte.setDisabledTextColor(new Color(255, 255, 255));
					textFieldNomeDArte.setBackground(AppColor.darkGrey);
					textFieldNomeDArte.setBorder(null);
					textFieldNomeDArte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					textFieldNomeDArte.setColumns(10);

					DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					JTextField textFieldDataNascita = new JFormattedTextField(format);
					textFieldDataNascita.setForeground(new Color(255, 255, 255));
					textFieldDataNascita.setEditable(false);
					textFieldDataNascita.setDisabledTextColor(new Color(255, 255, 255));
					textFieldDataNascita.setBackground(AppColor.darkGrey);
					textFieldDataNascita.setBorder(null);
					textFieldDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDataNascita.setColumns(10);

					JTextField textFieldFollowers = new JTextField();
					textFieldFollowers.setForeground(new Color(255, 255, 255));
					textFieldFollowers.setEditable(false);
					textFieldFollowers.setDisabledTextColor(new Color(255, 255, 255));
					textFieldFollowers.setBackground(AppColor.darkGrey);
					textFieldFollowers.setBorder(null);
					textFieldFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldFollowers.setColumns(10);

					JTextField textFieldCity = new JTextField();
					textFieldCity.setForeground(new Color(255, 255, 255));
					textFieldCity.setEditable(false);
					textFieldCity.setDisabledTextColor(new Color(255, 255, 255));
					textFieldCity.setBackground(AppColor.darkGrey);
					textFieldCity.setBorder(null);
					textFieldCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCity.setColumns(10);

					JTextField textFieldCodiceArtista = new JTextField();
					textFieldCodiceArtista.setForeground(new Color(255, 255, 255));
					textFieldCodiceArtista.setEditable(false);
					textFieldCodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodiceArtista.setDisabledTextColor(new Color(255, 255, 255));
					textFieldCodiceArtista.setBackground(AppColor.darkGrey);
					textFieldCodiceArtista.setBorder(null);
					textFieldCodiceArtista.setColumns(10);

					JTextField textFieldCognomeArtista = new JTextField();
					textFieldCognomeArtista.setForeground(Color.WHITE);
					textFieldCognomeArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFieldCognomeArtista.setEditable(false);
					textFieldCognomeArtista.setDisabledTextColor(Color.WHITE);
					textFieldCognomeArtista.setColumns(10);
					textFieldCognomeArtista.setBorder(null);
					textFieldCognomeArtista.setBackground(new Color(21, 21, 21));

					JLabel lblFollowers = new JLabel("Followers:");
					lblFollowers.setForeground(new Color(255, 255, 255));
					lblFollowers.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JLabel lblCod = new JLabel("Cod:");
					lblCod.setForeground(Color.WHITE);
					lblCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JLabel lblDataNascita = new JLabel("Data nascita:");
					lblDataNascita.setForeground(Color.WHITE);
					lblDataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					panelPrintArtists.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

					JButton buttonFollowArtist = new JButton("");
					buttonFollowArtist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonFollowArtist.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String id_Artist = textFieldCodiceArtista.getText();
							String id_User = controller.user.getId();

							controller.insertFollow(id_User, id_Artist);

							stampaArtistGUI();
						}
					});
					buttonFollowArtist.setIcon(new ImageIcon(HomeGUI.class.getResource("/com/smup/Img/Follow-48.png")));
					buttonFollowArtist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonFollowArtist.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonFollowArtist.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonFollowArtist.setBackground(AppColor.black);
						}
					});
					buttonFollowArtist.setIconTextGap(10);
					buttonFollowArtist.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonFollowArtist.setForeground(Color.WHITE);
					buttonFollowArtist.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonFollowArtist.setFocusPainted(false);
					buttonFollowArtist.setBorderPainted(false);
					buttonFollowArtist.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonFollowArtist.setBackground(new Color(15, 15, 15));

					GroupLayout gl_panelBackGroundArtist = new GroupLayout(panelBackGroundArtist);
					gl_panelBackGroundArtist.setHorizontalGroup(
						gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
										.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
										.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
										.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addComponent(buttonFollowArtist, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					gl_panelBackGroundArtist.setVerticalGroup(
						gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
										.addContainerGap()
										.addComponent(buttonFollowArtist, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
											.addGap(21)
											.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
												.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE, false)
												.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
											.addContainerGap(46, Short.MAX_VALUE)
											.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
													.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblFollowers))
												.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
													.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
													.addGap(28)))
											.addGap(5))))
								.addContainerGap())
					);
					panelBackGroundArtist.setLayout(gl_panelBackGroundArtist);
					panelPrintArtists.add(panelBackGroundArtist);
					panelPrintArtists.setPreferredSize(new Dimension(400, 700));
					panelPrintArtists.setBackground(AppColor.grey);
					panelPrintArtists.setForeground(AppColor.grey);
					scrollPaneArtists.setBackground(AppColor.darkGrey);
					scrollPaneArtists.setViewportView(panelPrintArtists);
					
					textFieldCodiceArtista.setText(artist.getId());
					textFieldNomeArtista.setText(artist.getFristName());
					textFieldCognomeArtista.setText(artist.getLastName());
					textFieldDataNascita.setText(artist.getBirthDate());
					textFieldCity.setText(artist.getCity());
					textFieldFollowers.setText(String.valueOf(artist.getFollowers()));
					textFieldNomeDArte.setText(artist.getNickname());
				}
			} else
					JOptionPane.showMessageDialog(this,
							"DataBase vuoto!!!",
							"Errore",
							JOptionPane.ERROR_MESSAGE);
	}

	public void stampaAlbumGUI() {
		panelPrintAlbums.removeAll();
		panelPrintAlbums.revalidate();
		panelPrintAlbums.repaint();
		ArrayList<Album> allAlbums = controller.stampaAlbumDB();
		
		if(!allAlbums.isEmpty()) {
			for (Album album : allAlbums) {
				JPanel panelBackGroundAlbum = new JPanel();
				panelBackGroundAlbum.setBackground(new Color(21, 21, 21));
				panelPrintAlbums.add(panelBackGroundAlbum);

				JTextField textFieldArtista = new JTextField();
				textFieldArtista.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldArtista.setForeground(Color.WHITE);
				textFieldArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldArtista.setEditable(false);
				textFieldArtista.setDisabledTextColor(Color.WHITE);
				textFieldArtista.setColumns(10);
				textFieldArtista.setBorder(null);
				textFieldArtista.setBackground(new Color(21, 21, 21));

				JTextField textFieldNomeAlbum = new JTextField();
				textFieldNomeAlbum.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldNomeAlbum.setForeground(Color.WHITE);
				textFieldNomeAlbum.setFont(new Font("Segoe UI", Font.BOLD, 25));
				textFieldNomeAlbum.setEditable(false);
				textFieldNomeAlbum.setDisabledTextColor(Color.WHITE);
				textFieldNomeAlbum.setColumns(10);
				textFieldNomeAlbum.setBorder(null);
				textFieldNomeAlbum.setBackground(new Color(21, 21, 21));

				JLabel lblDataPubblicazione = new JLabel("Data pubblicazione:");
				lblDataPubblicazione.setForeground(Color.WHITE);
				lblDataPubblicazione.setFont(new Font("Segoe UI", Font.PLAIN, 14));

				DateFormat format = new SimpleDateFormat("dd/mm/yyyy"); 
				JTextField textFieldData = new JFormattedTextField(format);
				textFieldData.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldData.setForeground(Color.WHITE);
				textFieldData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldData.setEditable(false);
				textFieldData.setDisabledTextColor(Color.WHITE);
				textFieldData.setColumns(10);
				textFieldData.setBorder(null);
				textFieldData.setBackground(new Color(21, 21, 21));

				JLabel labelGenere = new JLabel("Genere:");
				labelGenere.setForeground(Color.WHITE);
				labelGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));

				JTextField textFieldGenere = new JTextField();
				textFieldGenere.setForeground(Color.WHITE);
				textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldGenere.setEditable(false);
				textFieldGenere.setDisabledTextColor(Color.WHITE);
				textFieldGenere.setColumns(10);
				textFieldGenere.setBorder(null);
				textFieldGenere.setBackground(new Color(21, 21, 21));

				JTextField textFieldNumeroBrani = new JTextField();
				textFieldNumeroBrani.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldNumeroBrani.setForeground(Color.WHITE);
				textFieldNumeroBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldNumeroBrani.setEditable(false);
				textFieldNumeroBrani.setDisabledTextColor(Color.WHITE);
				textFieldNumeroBrani.setColumns(10);
				textFieldNumeroBrani.setBorder(null);
				textFieldNumeroBrani.setBackground(new Color(21, 21, 21));

				JTextField textFieldCodiceAlbum = new JTextField();
				textFieldCodiceAlbum.setHorizontalAlignment(SwingConstants.LEFT);
				textFieldCodiceAlbum.setForeground(Color.WHITE);
				textFieldCodiceAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldCodiceAlbum.setEditable(false);
				textFieldCodiceAlbum.setDisabledTextColor(Color.WHITE);
				textFieldCodiceAlbum.setColumns(10);
				textFieldCodiceAlbum.setBorder(null);
				textFieldCodiceAlbum.setBackground(new Color(21, 21, 21));

				JLabel lblCod_1 = new JLabel("Cod:");
				lblCod_1.setForeground(Color.WHITE);
				lblCod_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

				JLabel lblNBrani = new JLabel("N. brani:");
				lblNBrani.setForeground(Color.WHITE);
				lblNBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));


				GroupLayout gl_panelBackGroundAlbum = new GroupLayout(panelBackGroundAlbum);
				gl_panelBackGroundAlbum.setHorizontalGroup(
					gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
									.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldNumeroBrani, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
								.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(80)
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelGenere, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldGenere, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(textFieldData, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_panelBackGroundAlbum.setVerticalGroup(
					gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
									.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
									.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE, false)
										.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelGenere)
										.addComponent(textFieldNumeroBrani, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(12, Short.MAX_VALUE))
				);
				panelBackGroundAlbum.setLayout(gl_panelBackGroundAlbum);

				panelPrintAlbums.add(panelBackGroundAlbum);

				textFieldCodiceAlbum.setText(album.getId());
				textFieldNomeAlbum.setText(album.getName());
				textFieldArtista.setText(String.valueOf(album.getPublications().getArtist()));
				textFieldNumeroBrani.setText(String.valueOf(album.getNumberSongs()));
				textFieldGenere.setText(album.getGenre());
				textFieldData.setText(album.getPublications().getReleaseDate().toString());
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"DataBase vuoto!!!",
					"Errore",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void stampaSongGUI() {
		panelPrintOthers.removeAll();
		panelPrintOthers.revalidate();
		panelPrintOthers.repaint();
		
		ArrayList<Brano> allSongs = controller.stampaSongDB();
		
		if(!allSongs.isEmpty()) {
			for (Brano brano : allSongs) {
					JPanel panelBackGroundSong = new JPanel();
					panelBackGroundSong.setBackground(new Color(21, 21, 21));
					panelPrintOthers.add(panelBackGroundSong);

					JTextField textFieldNomeSong = new JTextField();
					textFieldNomeSong.setForeground(Color.WHITE);
					textFieldNomeSong.setFont(new Font("Segoe UI", Font.BOLD, 25));
					textFieldNomeSong.setEditable(false);
					textFieldNomeSong.setDisabledTextColor(Color.WHITE);
					textFieldNomeSong.setColumns(10);
					textFieldNomeSong.setBorder(null);
					textFieldNomeSong.setBackground(new Color(21, 21, 21));

					JLabel labelCodSong = new JLabel("Cod:");
					labelCodSong.setForeground(Color.WHITE);
					labelCodSong.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldCodSong = new JTextField();
					textFieldCodSong.setForeground(Color.WHITE);
					textFieldCodSong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodSong.setEditable(false);
					textFieldCodSong.setDisabledTextColor(Color.WHITE);
					textFieldCodSong.setColumns(10);
					textFieldCodSong.setBorder(null);
					textFieldCodSong.setBackground(new Color(21, 21, 21));

					JLabel lblAlbum = new JLabel("Album:");
					lblAlbum.setForeground(Color.WHITE);
					lblAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldAlbumSong = new JTextField();
					textFieldAlbumSong.setForeground(Color.WHITE);
					textFieldAlbumSong.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldAlbumSong.setEditable(false);
					textFieldAlbumSong.setDisabledTextColor(Color.WHITE);
					textFieldAlbumSong.setColumns(10);
					textFieldAlbumSong.setBorder(null);
					textFieldAlbumSong.setBackground(new Color(21, 21, 21));

					JLabel labelDurata = new JLabel("Durata:");
					labelDurata.setForeground(Color.WHITE);
					labelDurata.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldDurata = new JTextField();
					textFieldDurata.setForeground(Color.WHITE);
					textFieldDurata.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDurata.setEditable(false);
					textFieldDurata.setDisabledTextColor(Color.WHITE);
					textFieldDurata.setColumns(10);
					textFieldDurata.setBorder(null);
					textFieldDurata.setBackground(new Color(21, 21, 21));

					JLabel label_4 = new JLabel("Genere:");
					label_4.setForeground(Color.WHITE);
					label_4.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldGenereSong = new JTextField();
					textFieldGenereSong.setForeground(Color.WHITE);
					textFieldGenereSong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldGenereSong.setEditable(false);
					textFieldGenereSong.setDisabledTextColor(Color.WHITE);
					textFieldGenereSong.setColumns(10);
					textFieldGenereSong.setBorder(null);
					textFieldGenereSong.setBackground(new Color(21, 21, 21));

					GroupLayout gl_panelBackGroundSong = new GroupLayout(panelBackGroundSong);
					gl_panelBackGroundSong.setHorizontalGroup(
						gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSong.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSong.createSequentialGroup()
										.addComponent(labelCodSong, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAlbum, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldAlbumSong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldNomeSong, GroupLayout.PREFERRED_SIZE, 712, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addComponent(labelDurata, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldDurata, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldGenereSong, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
					);
					gl_panelBackGroundSong.setVerticalGroup(
						gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSong.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelDurata, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldDurata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldNomeSong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_4)
									.addComponent(textFieldGenereSong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelCodSong, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldCodSong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAlbum, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldAlbumSong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(12, Short.MAX_VALUE))
					);
					panelBackGroundSong.setLayout(gl_panelBackGroundSong);

					textFieldCodSong.setText(brano.getId());
					textFieldNomeSong.setText(brano.getName());
					textFieldDurata.setText(String.valueOf(brano.getDuration()));
					textFieldGenereSong.setText(brano.getGenre());
					textFieldAlbumSong.setText(brano.getAlbum());
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
	}

	public void stampaSingleGUI() {
		panelPrintOthers.removeAll();
		panelPrintOthers.revalidate();
		panelPrintOthers.repaint();
		
		ArrayList<Singolo> allSingles = controller.stampaSingleDB();
		
		if(!allSingles.isEmpty()) {
			for (Singolo single : allSingles) {
					JPanel panelBackGroundSingle = new JPanel();
					panelBackGroundSingle.setBackground(new Color(21, 21, 21));
					panelPrintOthers.add(panelBackGroundSingle);

					JTextField textFieldNomeSingolo = new JTextField();
					textFieldNomeSingolo.setForeground(Color.WHITE);
					textFieldNomeSingolo.setFont(new Font("Segoe UI", Font.BOLD, 25));
					textFieldNomeSingolo.setEditable(false);
					textFieldNomeSingolo.setDisabledTextColor(Color.WHITE);
					textFieldNomeSingolo.setColumns(10);
					textFieldNomeSingolo.setBorder(null);
					textFieldNomeSingolo.setBackground(new Color(21, 21, 21));

					JLabel label_1 = new JLabel("Cod:");
					label_1.setForeground(Color.WHITE);
					label_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldCodSingolo = new JTextField();
					textFieldCodSingolo.setForeground(Color.WHITE);
					textFieldCodSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodSingolo.setEditable(false);
					textFieldCodSingolo.setDisabledTextColor(Color.WHITE);
					textFieldCodSingolo.setColumns(10);
					textFieldCodSingolo.setBorder(null);
					textFieldCodSingolo.setBackground(new Color(21, 21, 21));

					JLabel lblArtista = new JLabel("Artista:");
					lblArtista.setForeground(Color.WHITE);
					lblArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldArtistaSingolo = new JTextField();
					textFieldArtistaSingolo.setForeground(Color.WHITE);
					textFieldArtistaSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldArtistaSingolo.setEditable(false);
					textFieldArtistaSingolo.setDisabledTextColor(Color.WHITE);
					textFieldArtistaSingolo.setColumns(10);
					textFieldArtistaSingolo.setBorder(null);
					textFieldArtistaSingolo.setBackground(new Color(21, 21, 21));

					JLabel label_3 = new JLabel("Durata:");
					label_3.setForeground(Color.WHITE);
					label_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JLabel label_5 = new JLabel("Genere:");
					label_5.setForeground(Color.WHITE);
					label_5.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldDurataSingolo = new JTextField();
					textFieldDurataSingolo.setForeground(Color.WHITE);
					textFieldDurataSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDurataSingolo.setEditable(false);
					textFieldDurataSingolo.setDisabledTextColor(Color.WHITE);
					textFieldDurataSingolo.setColumns(10);
					textFieldDurataSingolo.setBorder(null);
					textFieldDurataSingolo.setBackground(new Color(21, 21, 21));

					JTextField textFieldGenereSingolo = new JTextField();
					textFieldGenereSingolo.setForeground(Color.WHITE);
					textFieldGenereSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldGenereSingolo.setEditable(false);
					textFieldGenereSingolo.setDisabledTextColor(Color.WHITE);
					textFieldGenereSingolo.setColumns(10);
					textFieldGenereSingolo.setBorder(null);
					textFieldGenereSingolo.setBackground(new Color(21, 21, 21));

					DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					JTextField textFieldDataPubblicazioneSingolo = new JFormattedTextField(format);
					textFieldDataPubblicazioneSingolo.setForeground(Color.WHITE);
					textFieldDataPubblicazioneSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDataPubblicazioneSingolo.setEditable(false);
					textFieldDataPubblicazioneSingolo.setDisabledTextColor(Color.WHITE);
					textFieldDataPubblicazioneSingolo.setColumns(10);
					textFieldDataPubblicazioneSingolo.setBorder(null);
					textFieldDataPubblicazioneSingolo.setBackground(new Color(21, 21, 21));

					JLabel lblDataPubblicazione_1 = new JLabel("Data:");
					lblDataPubblicazione_1.setForeground(Color.WHITE);
					lblDataPubblicazione_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					GroupLayout gl_panelBackGroundSingle = new GroupLayout(panelBackGroundSingle);
					gl_panelBackGroundSingle.setHorizontalGroup(
						gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodSingolo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldArtistaSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblDataPubblicazione_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldDataPubblicazioneSingolo, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldNomeSingolo, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldDurataSingolo, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldGenereSingolo, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addContainerGap())
					);
					gl_panelBackGroundSingle.setVerticalGroup(
						gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
										.addGap(32)
										.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldDurataSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_5)
													.addComponent(textFieldGenereSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldArtistaSingolo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblDataPubblicazione_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldDataPubblicazioneSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldCodSingolo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))))
									.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
										.addContainerGap()
										.addComponent(textFieldNomeSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(12, Short.MAX_VALUE))
					);
					panelBackGroundSingle.setLayout(gl_panelBackGroundSingle);
					
					textFieldCodSingolo.setText(single.getId());
					textFieldNomeSingolo.setText(single.getName());
					textFieldDurataSingolo.setText(String.valueOf(single.getDuration()));
					textFieldGenereSingolo.setText(single.getGenre());
					textFieldArtistaSingolo.setText(single.getPublications().getArtist());
					textFieldDataPubblicazioneSingolo.setText(String.valueOf(single.getPublications().getReleaseDate()));
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
	}

	public void stampaEPGUI() {
		panelPrintOthers.removeAll();
		panelPrintOthers.revalidate();
		panelPrintOthers.repaint();
		
		ArrayList<EP> allEPs = controller.stampaEPDB();
		
		if(!allEPs.isEmpty()) {
			for (EP ep : allEPs) {
					JPanel panelBackGroundEP = new JPanel();
					panelBackGroundEP.setBackground(new Color(21, 21, 21));
					panelPrintOthers.add(panelBackGroundEP);

					JTextField textFieldNomeEP = new JTextField();
					textFieldNomeEP.setForeground(Color.WHITE);
					textFieldNomeEP.setFont(new Font("Segoe UI", Font.BOLD, 25));
					textFieldNomeEP.setEditable(false);
					textFieldNomeEP.setDisabledTextColor(Color.WHITE);
					textFieldNomeEP.setColumns(10);
					textFieldNomeEP.setBorder(null);
					textFieldNomeEP.setBackground(new Color(21, 21, 21));

					JLabel label_2 = new JLabel("Cod:");
					label_2.setForeground(Color.WHITE);
					label_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldCodEP = new JTextField();
					textFieldCodEP.setForeground(Color.WHITE);
					textFieldCodEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodEP.setEditable(false);
					textFieldCodEP.setDisabledTextColor(Color.WHITE);
					textFieldCodEP.setColumns(10);
					textFieldCodEP.setBorder(null);
					textFieldCodEP.setBackground(new Color(21, 21, 21));

					JLabel label_6 = new JLabel("Artista:");
					label_6.setForeground(Color.WHITE);
					label_6.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldArtistaEP = new JTextField();
					textFieldArtistaEP.setForeground(Color.WHITE);
					textFieldArtistaEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldArtistaEP.setEditable(false);
					textFieldArtistaEP.setDisabledTextColor(Color.WHITE);
					textFieldArtistaEP.setColumns(10);
					textFieldArtistaEP.setBorder(null);
					textFieldArtistaEP.setBackground(new Color(21, 21, 21));

					JLabel label_7 = new JLabel("Data:");
					label_7.setForeground(Color.WHITE);
					label_7.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					JTextField textFieldDataEP = new JFormattedTextField(format);
					textFieldDataEP.setForeground(Color.WHITE);
					textFieldDataEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDataEP.setEditable(false);
					textFieldDataEP.setDisabledTextColor(Color.WHITE);
					textFieldDataEP.setColumns(10);
					textFieldDataEP.setBorder(null);
					textFieldDataEP.setBackground(new Color(21, 21, 21));

					JLabel label_9 = new JLabel("Genere:");
					label_9.setForeground(Color.WHITE);
					label_9.setFont(new Font("Segoe UI", Font.PLAIN, 14));

					JTextField textFieldGenereEP = new JTextField();
					textFieldGenereEP.setForeground(Color.WHITE);
					textFieldGenereEP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldGenereEP.setEditable(false);
					textFieldGenereEP.setDisabledTextColor(Color.WHITE);
					textFieldGenereEP.setColumns(10);
					textFieldGenereEP.setBorder(null);
					textFieldGenereEP.setBackground(new Color(21, 21, 21));

					JTextField textFieldNumeroBraniEP = new JTextField();
					textFieldNumeroBraniEP.setForeground(Color.WHITE);
					textFieldNumeroBraniEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldNumeroBraniEP.setEditable(false);
					textFieldNumeroBraniEP.setDisabledTextColor(Color.WHITE);
					textFieldNumeroBraniEP.setColumns(10);
					textFieldNumeroBraniEP.setBorder(null);
					textFieldNumeroBraniEP.setBackground(new Color(21, 21, 21));

					JLabel lblNBrani_1 = new JLabel("N. brani");
					lblNBrani_1.setForeground(Color.WHITE);
					lblNBrani_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					GroupLayout gl_panelBackGroundEP = new GroupLayout(panelBackGroundEP);
					gl_panelBackGroundEP.setHorizontalGroup(
						gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundEP.createSequentialGroup()
								.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundEP.createSequentialGroup()
										.addContainerGap()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodEP, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldArtistaEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldDataEP, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundEP.createSequentialGroup()
										.addGap(12)
										.addComponent(textFieldNomeEP, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundEP.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblNBrani_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldNumeroBraniEP)
									.addComponent(textFieldGenereEP, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
								.addContainerGap())
					);
					gl_panelBackGroundEP.setVerticalGroup(
						gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundEP.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundEP.createSequentialGroup()
										.addComponent(textFieldNomeEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(5)
										.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.BASELINE)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldCodEP, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldArtistaEP, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldDataEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panelBackGroundEP.createSequentialGroup()
										.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblNBrani_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldNumeroBraniEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.BASELINE)
											.addComponent(label_9)
											.addComponent(textFieldGenereEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(12, Short.MAX_VALUE))
					);
					panelBackGroundEP.setLayout(gl_panelBackGroundEP);

					textFieldArtistaEP.setText(ep.getPublications().getArtist());
					textFieldCodEP.setText(ep.getId());
					textFieldNomeEP.setText(ep.getName());
					textFieldGenereEP.setText(ep.getGenre());
					textFieldDataEP.setText(String.valueOf(ep.getPublications().getReleaseDate()));
					textFieldNumeroBraniEP.setText(String.valueOf(ep.getSongNumer()));
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
	}

	public void stampaFollowing() {
		panelPrintFollowed.removeAll();
		panelPrintFollowed.revalidate();
		panelPrintFollowed.repaint();
		
		ArrayList<Seguire> allFollowers = controller.stampaFollowing();
		
		if(!allFollowers.isEmpty()) {
			for (Seguire follow : allFollowers) {
					JPanel panelBackGroundFollowArtist = new JPanel();
					panelBackGroundFollowArtist.setBackground(new Color(21, 21, 21));
					panelPrintFollowed.add(panelBackGroundFollowArtist);

					JTextField CodiceArtista = new JTextField();
					CodiceArtista.setText("CODICE ARTISTA");
					CodiceArtista.setForeground(Color.WHITE);
					CodiceArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					CodiceArtista.setEditable(false);
					CodiceArtista.setDisabledTextColor(Color.WHITE);
					CodiceArtista.setColumns(10);
					CodiceArtista.setBorder(null);
					CodiceArtista.setBackground(new Color(21, 21, 21));

					JTextField textFildNomeDarteArtista = new JTextField();
					textFildNomeDarteArtista.setText("NOME D'ARTE");
					textFildNomeDarteArtista.setForeground(Color.WHITE);
					textFildNomeDarteArtista.setFont(new Font("Segoe UI", Font.BOLD, 24));
					textFildNomeDarteArtista.setEditable(false);
					textFildNomeDarteArtista.setDisabledTextColor(Color.WHITE);
					textFildNomeDarteArtista.setColumns(10);
					textFildNomeDarteArtista.setBorder(null);
					textFildNomeDarteArtista.setBackground(new Color(21, 21, 21));

					JButton DeleteFollow = new JButton("");
					DeleteFollow.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String id_Following = CodiceArtista.getText();
							String id_User = controller.user.getId();
							String nome = textFildNomeDarteArtista.getText();

							Object[] options = {"Si", "No", "Annulla"};
							int scelta = JOptionPane.showOptionDialog(null,
									"Sei sicuro di voler cancellare "
											+ nome,
											"Cancella artista dai preferiti",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[2]);

							if(scelta == JOptionPane.YES_OPTION){
								controller.deleteFollow(id_User, id_Following);
								stampaFollowing();
							}
						}
					});
					DeleteFollow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					DeleteFollow.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							DeleteFollow.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							DeleteFollow.setBackground(AppColor.black);
						}
					});
					DeleteFollow.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/DeleteArtist-48.png")));
					DeleteFollow.setIconTextGap(10);
					DeleteFollow.setHorizontalTextPosition(SwingConstants.RIGHT);
					DeleteFollow.setForeground(Color.WHITE);
					DeleteFollow.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					DeleteFollow.setFocusPainted(false);
					DeleteFollow.setEnabled(true);
					DeleteFollow.setBorderPainted(false);
					DeleteFollow.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					DeleteFollow.setBackground(new Color(15, 15, 15));

					GroupLayout gl_panelBackGroundFollowArtist = new GroupLayout(panelBackGroundFollowArtist);
					gl_panelBackGroundFollowArtist.setHorizontalGroup(
							gl_panelBackGroundFollowArtist.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundFollowArtist.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panelBackGroundFollowArtist.createParallelGroup(Alignment.LEADING)
											.addComponent(CodiceArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFildNomeDarteArtista, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
									.addComponent(DeleteFollow, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
							);
					gl_panelBackGroundFollowArtist.setVerticalGroup(
							gl_panelBackGroundFollowArtist.createParallelGroup(Alignment.TRAILING)
							.addGap(0, 104, Short.MAX_VALUE)
							.addGroup(gl_panelBackGroundFollowArtist.createSequentialGroup()
									.addGroup(gl_panelBackGroundFollowArtist.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panelBackGroundFollowArtist.createSequentialGroup()
													.addContainerGap()
													.addComponent(DeleteFollow, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelBackGroundFollowArtist.createSequentialGroup()
													.addGap(21)
													.addComponent(textFildNomeDarteArtista, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(CodiceArtista, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
									.addContainerGap())
							);
					panelBackGroundFollowArtist.setLayout(gl_panelBackGroundFollowArtist);

					CodiceArtista.setText(follow.getId());
					textFildNomeDarteArtista.setText(follow.getNickname());
			}
		} else
				JOptionPane.showMessageDialog(this,
						"DataBase vuoto!!!",
						"Errore",
						JOptionPane.ERROR_MESSAGE);
	}

	public void stampaRicerca(String nomeDaCercare) {
		panelPrintSearch.removeAll();
		panelPrintSearch.revalidate();
		panelPrintSearch.repaint();
		ArrayList<Artista> filteredArtists = controller.search(nomeDaCercare);
		
		if(!filteredArtists.isEmpty()) {
			for (Artista artist : filteredArtists) {
				JPanel panelBackGroundSearchArtist = new JPanel();
				panelBackGroundSearchArtist.setBackground(new Color(21, 21, 21));
				panelPrintSearch.add(panelBackGroundSearchArtist);

				JTextField textFieldCodiceArtistaSearch = new JTextField();
				textFieldCodiceArtistaSearch.setText("CODICE ARTISTA");
				textFieldCodiceArtistaSearch.setForeground(Color.WHITE);
				textFieldCodiceArtistaSearch.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				textFieldCodiceArtistaSearch.setEditable(false);
				textFieldCodiceArtistaSearch.setDisabledTextColor(Color.WHITE);
				textFieldCodiceArtistaSearch.setColumns(10);
				textFieldCodiceArtistaSearch.setBorder(null);
				textFieldCodiceArtistaSearch.setBackground(new Color(21, 21, 21));

				JTextField textFieldNomeDarteSearch = new JTextField();
				textFieldNomeDarteSearch.setText("NOME D'ARTE");
				textFieldNomeDarteSearch.setForeground(Color.WHITE);
				textFieldNomeDarteSearch.setFont(new Font("Segoe UI", Font.BOLD, 24));
				textFieldNomeDarteSearch.setEditable(false);
				textFieldNomeDarteSearch.setDisabledTextColor(Color.WHITE);
				textFieldNomeDarteSearch.setColumns(10);
				textFieldNomeDarteSearch.setBorder(null);
				textFieldNomeDarteSearch.setBackground(new Color(21, 21, 21));

				JButton btnFollow = new JButton("");
				btnFollow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id_Artist = textFieldCodiceArtistaSearch.getText();
						String id_User = controller.user.getId();

						controller.insertFollow(id_User, id_Artist);

						JOptionPane.showMessageDialog(null,
								"Artista aggiunto con successo",
								"Artista aggiunto",
								JOptionPane.PLAIN_MESSAGE);

						stampaRicerca("  ");
					}
				});
				btnFollow.setIcon(new ImageIcon(HomeUserGUI.class.getResource("/com/smup/Img/Follow-48.png")));
				btnFollow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnFollow.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnFollow.setBackground(AppColor.blueViolet);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnFollow.setBackground(AppColor.black);
					}
				});
				btnFollow.setIconTextGap(10);
				btnFollow.setHorizontalTextPosition(SwingConstants.RIGHT);
				btnFollow.setForeground(Color.WHITE);
				btnFollow.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				btnFollow.setFocusPainted(false);
				btnFollow.setEnabled(true);
				btnFollow.setBorderPainted(false);
				btnFollow.setBorder(new LineBorder(new Color(0, 51, 255), 10));
				btnFollow.setBackground(new Color(15, 15, 15));

				GroupLayout gl_panelBackGroundSearcArtists = new GroupLayout(panelBackGroundSearchArtist);
				gl_panelBackGroundSearcArtists.setHorizontalGroup(
						gl_panelBackGroundSearcArtists.createParallelGroup(Alignment.LEADING)
						.addGap(0, 1046, Short.MAX_VALUE)
						.addGroup(gl_panelBackGroundSearcArtists.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_panelBackGroundSearcArtists.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldCodiceArtistaSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldNomeDarteSearch, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
								.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addGap(18))
						);
				gl_panelBackGroundSearcArtists.setVerticalGroup(
						gl_panelBackGroundSearcArtists.createParallelGroup(Alignment.TRAILING)
						.addGap(0, 104, Short.MAX_VALUE)
						.addGroup(gl_panelBackGroundSearcArtists.createSequentialGroup()
								.addGroup(gl_panelBackGroundSearcArtists.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelBackGroundSearcArtists.createSequentialGroup()
												.addContainerGap()
												.addComponent(btnFollow, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelBackGroundSearcArtists.createSequentialGroup()
												.addGap(21)
												.addComponent(textFieldNomeDarteSearch, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldCodiceArtistaSearch, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
								.addContainerGap())
						);
				panelBackGroundSearchArtist.setLayout(gl_panelBackGroundSearcArtists);

				textFieldNomeDarteSearch.setText(artist.getNickname());
				textFieldCodiceArtistaSearch.setText(artist.getId());
			}
		} else 
			JOptionPane.showMessageDialog(this,
				"DataBase vuoto!!!",
				"Errore",
				JOptionPane.ERROR_MESSAGE);
	}
}