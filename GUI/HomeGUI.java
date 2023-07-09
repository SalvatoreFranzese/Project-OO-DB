package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Entity.Album;
import com.smup.Entity.Artista;
import com.smup.Entity.Brano;
import com.smup.Entity.EP;
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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class HomeGUI extends JFrame {
	private Controller controller;
	
	private JPanel contentPane;
	private JPanel panelPrintArtists;
	private JPanel panelPrintAlbums;
	private JPanel panelPrintOthers;
	private JScrollPane scrollPaneArtists;
	private JScrollPane scrollPaneAlbums;
	private JScrollPane scrollPaneOthers;

	public HomeGUI(Controller controller) {
		this.controller = controller;

		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeGUI.class.getResource("/Img/LogoB-48.png")));

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
		logoTop.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Logo-64.png")));

		JPanel Card = new JPanel();
		Card.setBackground(AppColor.grey);

		JPanel panelDashboard = new JPanel();
		panelDashboard.setBackground(AppColor.grey);

		JPanel panelShowArtists = new JPanel();
		panelShowArtists.setBackground(AppColor.grey);


		JPanel panelShowAlbums = new JPanel();
		panelShowAlbums.setBackground(AppColor.grey);

		JPanel panelOthers = new JPanel();
		panelOthers.setBackground(AppColor.grey);

		JButton buttonDashboard = new JButton("Dashboard");
		buttonDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(true);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(false);
			}
		});
		buttonDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		buttonDashboard.setIconTextGap(10);
		buttonDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonDashboard.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonDashboard.setBackground(AppColor.black);
			}
		});
		buttonDashboard.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonDashboard.setForeground(new Color(255, 255, 255));
		buttonDashboard.setBackground(AppColor.black);
		buttonDashboard.setFocusPainted(false);
		buttonDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDashboard.setBorderPainted(false);
		buttonDashboard.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Dashboard-48.png")));

		JButton buttonShowArtists = new JButton("Show artist");
		buttonShowArtists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelShowArtists.setVisible(true);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(false);

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
		buttonShowArtists.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Artists-48.png")));
		buttonShowArtists.setForeground(Color.WHITE);
		buttonShowArtists.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonShowArtists.setFocusPainted(false);
		buttonShowArtists.setBorderPainted(false);
		buttonShowArtists.setBackground(new Color(15, 15, 15));

		JButton buttonShowAlbums = new JButton("Show albums");
		buttonShowAlbums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDashboard.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(true);
				panelOthers.setVisible(false);

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
		buttonShowAlbums.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Albums-48.png")));
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
				panelDashboard.setVisible(false);
				panelShowArtists.setVisible(false);
				panelShowAlbums.setVisible(false);
				panelOthers.setVisible(true);

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
		buttonOthers.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Song-48.png")));
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
				System.exit(0);
			}
		});
		btnLogOut.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/LogOut-48.png")));
		btnLogOut.setIconTextGap(10);
		btnLogOut.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(15, 15, 15));

		JLabel lblNameUsers = new JLabel("NameUsers");
		lblNameUsers.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Account-48.png")));
		lblNameUsers.setText(controller.user.getUsername());
		lblNameUsers.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameUsers.setForeground(Color.WHITE);
		lblNameUsers.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		GroupLayout gl_menuRight = new GroupLayout(menuRight);
		gl_menuRight.setHorizontalGroup(
			gl_menuRight.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGroup(gl_menuRight.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_menuRight.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNameUsers, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
						.addComponent(buttonOthers, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonShowAlbums, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonShowArtists, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(buttonDashboard, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(btnLogOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_menuRight.setVerticalGroup(
			gl_menuRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuRight.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNameUsers, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(buttonDashboard, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowArtists, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(buttonShowAlbums, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonOthers, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		menuRight.setLayout(gl_menuRight);
		Card.setLayout(new CardLayout(0, 0));

		Card.add(panelDashboard, "name_228475787480200");

		JLabel labelCreatedBy = new JLabel("Created by Franzese Salvatore & Cammardella Paolo");
		labelCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		labelCreatedBy.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCreatedBy.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		labelCreatedBy.setForeground(new Color(255, 255, 255));
		labelCreatedBy.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JLabel lblDashboard = new JLabel("DASHBOARD");
		lblDashboard.setAlignmentY(Component.TOP_ALIGNMENT);
		lblDashboard.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblDashboard.setForeground(new Color(255, 255, 255));
		lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 30));

		JButton buttonAddArtist = new JButton("Add Artist");
		buttonAddArtist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddArtistGUI(true);
			}
		});
		buttonAddArtist.setBorder(null);
		buttonAddArtist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAddArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAddArtist.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAddArtist.setBackground(AppColor.black);
			}
		});
		buttonAddArtist.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonAddArtist.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAddArtist.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Artist-64.png")));
		buttonAddArtist.setIconTextGap(10);
		buttonAddArtist.setForeground(Color.WHITE);
		buttonAddArtist.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonAddArtist.setFocusPainted(false);
		buttonAddArtist.setBorderPainted(false);
		buttonAddArtist.setBackground(new Color(15, 15, 15));

		JButton buttonAddAlbum = new JButton("Add Album");
		buttonAddAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddAlbumGUI(true);
			}
		});
		buttonAddAlbum.setBorder(null);
		buttonAddAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAddAlbum.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAddAlbum.setBackground(AppColor.black);
			}
		});
		buttonAddAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAddAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Album-64.png")));
		buttonAddAlbum.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonAddAlbum.setIconTextGap(10);
		buttonAddAlbum.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAddAlbum.setForeground(Color.WHITE);
		buttonAddAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonAddAlbum.setFocusPainted(false);
		buttonAddAlbum.setBorderPainted(false);
		buttonAddAlbum.setBackground(new Color(15, 15, 15));

		JLabel SpazioButtom = new JLabel("");
		SpazioButtom.setHorizontalAlignment(SwingConstants.CENTER);
		SpazioButtom.setForeground(Color.WHITE);
		SpazioButtom.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		SpazioButtom.setAlignmentY(1.0f);
		SpazioButtom.setAlignmentX(0.5f);

		JLabel SpazioLeft = new JLabel("");

		JLabel SpazioRight = new JLabel("");

		JButton buttonAddSong = new JButton("Add Song");
		buttonAddSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAddSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAddSong.setBackground(AppColor.blueViolet);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAddSong.setBackground(AppColor.black);
			}
		});
		buttonAddSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.frameAddSongGUI(true);
			}
		});
		buttonAddSong.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Song-48.png")));
		buttonAddSong.setVerticalTextPosition(SwingConstants.BOTTOM);
		buttonAddSong.setIconTextGap(10);
		buttonAddSong.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonAddSong.setForeground(Color.WHITE);
		buttonAddSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		buttonAddSong.setFocusPainted(false);
		buttonAddSong.setBorderPainted(false);
		buttonAddSong.setBorder(null);
		buttonAddSong.setBackground(new Color(15, 15, 15));

		GroupLayout gl_panelDashboard = new GroupLayout(panelDashboard);
		gl_panelDashboard.setHorizontalGroup(
				gl_panelDashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(10)
						.addComponent(lblDashboard, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGap(10))
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addContainerGap()
						.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAddArtist, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAddAlbum, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(buttonAddSong, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
						.addGap(1)
						.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addContainerGap()
						.addComponent(labelCreatedBy, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(20)
						.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE))
				);
		gl_panelDashboard.setVerticalGroup(
				gl_panelDashboard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDashboard.createSequentialGroup()
						.addGap(11)
						.addComponent(lblDashboard, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDashboard.createSequentialGroup()
										.addGap(11)
										.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
												.addComponent(SpazioLeft, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
												.addGroup(gl_panelDashboard.createSequentialGroup()
														.addGap(2)
														.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING, false)
																.addComponent(buttonAddArtist, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(buttonAddAlbum, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)))))
								.addGroup(gl_panelDashboard.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelDashboard.createParallelGroup(Alignment.LEADING)
												.addComponent(buttonAddSong, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
												.addComponent(SpazioRight, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(SpazioButtom, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addGap(4)
						.addComponent(labelCreatedBy, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		panelDashboard.setLayout(gl_panelDashboard);

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

				JButton buttonDelete = new JButton("");
				buttonDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String codice = textFieldCodiceArtista.getText();
						String nome = textFieldNomeArtista.getText();
						String cognome = textFieldCognomeArtista.getText();

						Object[] options = {"Si", "No", "Annulla"};
						int scelta = JOptionPane.showOptionDialog(null,
								"Sei sicuro di voler cancellare "
										+ nome + " " + cognome,
										"Cancella artista",
										JOptionPane.YES_NO_CANCEL_OPTION,
										JOptionPane.QUESTION_MESSAGE,
										null,
										options,
										options[2]);

						if(scelta == JOptionPane.YES_OPTION){  
							controller.deleteArtistDB(codice);
							stampaArtistGUI();
						}
					}
				});
				buttonDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonDelete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						buttonDelete.setBackground(AppColor.blueViolet);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						buttonDelete.setBackground(AppColor.black);
					}
				});
				panelPrintArtists.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				buttonDelete.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
				buttonDelete.setIconTextGap(10);
				buttonDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
				buttonDelete.setForeground(Color.WHITE);
				buttonDelete.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				buttonDelete.setFocusPainted(false);
				buttonDelete.setBorderPainted(false);
				buttonDelete.setBorder(new LineBorder(new Color(0, 51, 255), 10));
				buttonDelete.setBackground(new Color(15, 15, 15));

				JButton buttonModify = new JButton("");
				JButton buttonSave = new JButton("");
				buttonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonSave.setEnabled(false);
				buttonSave.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
				buttonSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textFieldNomeArtista.setEditable(false);
						textFieldCognomeArtista.setEditable(false);
						textFieldDataNascita.setEditable(false);
						textFieldCity.setEditable(false);
						textFieldFollowers.setEditable(false);
						textFieldNomeDArte.setEditable(false);

						textFieldNomeArtista.setBorder(null);
						textFieldCognomeArtista.setBorder(null);
						textFieldDataNascita.setBorder(null);
						textFieldCity.setBorder(null);
						textFieldFollowers.setBorder(null);
						textFieldNomeDArte.setBorder(null);

						String codice = textFieldCodiceArtista.getText();
						String nome = textFieldNomeArtista.getText();
						String cognome = textFieldCognomeArtista.getText();
						String dataNascita = textFieldDataNascita.getText();
						String nomeDArte = textFieldNomeDArte.getText();
						String citta = textFieldCity.getText();
						String followers = textFieldFollowers.getText();

						controller.updateArtistDB(codice, nome, cognome, dataNascita, nomeDArte, citta, followers);

						buttonSave.setEnabled(false);
						buttonSave.setBackground(AppColor.darkGrey);
						buttonModify.setEnabled(true);

						stampaArtistGUI();
					}
				});
				buttonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonSave.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						if (buttonSave.isEnabled() == true)
							buttonSave.setBackground(AppColor.blueViolet);
						else
							buttonSave.setBackground(AppColor.black);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						buttonSave.setBackground(AppColor.black);
					}
				});
				buttonSave.setIconTextGap(10);
				buttonSave.setHorizontalTextPosition(SwingConstants.RIGHT);
				buttonSave.setForeground(Color.WHITE);
				buttonSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				buttonSave.setFocusPainted(false);
				buttonSave.setBorderPainted(false);
				buttonSave.setBorder(new LineBorder(new Color(0, 51, 255), 10));
				buttonSave.setBackground(new Color(15, 15, 15));

				buttonModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textFieldNomeArtista.setEditable(true);
						textFieldCognomeArtista.setEditable(true);
						textFieldDataNascita.setEditable(true);
						textFieldCity.setEditable(true);
						textFieldFollowers.setEditable(true);
						textFieldNomeDArte.setEditable(true);
						buttonSave.setEnabled(true);
						buttonModify.setBackground(AppColor.darkGrey);
						buttonModify.setEnabled(false);

						textFieldNomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						textFieldCognomeArtista.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						textFieldDataNascita.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						textFieldCity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						textFieldFollowers.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						textFieldNomeDArte.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
					}
				});
				buttonModify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonModify.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						buttonModify.setBackground(AppColor.blueViolet);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						buttonModify.setBackground(AppColor.black);
					}
				});
				buttonModify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				buttonModify.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
				buttonModify.setIconTextGap(10);
				buttonModify.setHorizontalTextPosition(SwingConstants.RIGHT);
				buttonModify.setForeground(Color.WHITE);
				buttonModify.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				buttonModify.setFocusPainted(false);
				buttonModify.setBorderPainted(false);
				buttonModify.setBorder(new LineBorder(new Color(0, 51, 255), 10));
				buttonModify.setBackground(new Color(15, 15, 15));
				buttonModify.setEnabled(true);

				JTextField textFieldRetribuzione = new JTextField();
				textFieldRetribuzione.setForeground(new Color(0, 204, 0));
				textFieldRetribuzione.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				textFieldRetribuzione.setEditable(false);
				textFieldRetribuzione.setDisabledTextColor(Color.WHITE);
				textFieldRetribuzione.setColumns(10);
				textFieldRetribuzione.setBorder(null);
				textFieldRetribuzione.setBackground(new Color(21, 21, 21));

				GroupLayout gl_panelBackGroundArtist = new GroupLayout(panelBackGroundArtist);
				gl_panelBackGroundArtist.setHorizontalGroup(
						gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldCodiceArtista, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addComponent(textFieldNomeArtista, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldRetribuzione, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
								.addGap(84)
								.addComponent(buttonDelete)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						);
				gl_panelBackGroundArtist.setVerticalGroup(
						gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
								.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addContainerGap()
												.addComponent(buttonDelete))
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addGap(21)
												.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
														.addComponent(textFieldNomeArtista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldCognomeArtista, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldNomeDArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldCodiceArtista, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
														.addComponent(textFieldFollowers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblFollowers)
														.addComponent(textFieldRetribuzione, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
												.addContainerGap(25, Short.MAX_VALUE)
												.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.TRAILING)
														.addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
														.addComponent(buttonModify, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panelBackGroundArtist.createSequentialGroup()
																.addGroup(gl_panelBackGroundArtist.createParallelGroup(Alignment.BASELINE)
																		.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(textFieldDataNascita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblDataNascita, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
																.addGap(33)))))
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

				String followers = textFieldFollowers.getText();
				float retribuzione = controller.retribuzioneArtista(followers);
				textFieldRetribuzione.setText(retribuzione + "�");
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
					textFieldArtista.setForeground(Color.WHITE);
					textFieldArtista.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldArtista.setEditable(false);
					textFieldArtista.setDisabledTextColor(Color.WHITE);
					textFieldArtista.setColumns(10);
					textFieldArtista.setBorder(null);
					textFieldArtista.setBackground(new Color(21, 21, 21));

					JTextField textFieldNomeAlbum = new JTextField();
					textFieldNomeAlbum.setForeground(Color.WHITE);
					textFieldNomeAlbum.setFont(new Font("Segoe UI", Font.BOLD, 24));
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
					textFieldGenere.setFont(new Font("Segoe UI", Font.PLAIN, 16));
					textFieldGenere.setEditable(false);
					textFieldGenere.setDisabledTextColor(Color.WHITE);
					textFieldGenere.setColumns(10);
					textFieldGenere.setBorder(null);
					textFieldGenere.setBackground(new Color(21, 21, 21));

					JTextField textFieldNumeroBrani = new JTextField();
					textFieldNumeroBrani.setForeground(Color.WHITE);
					textFieldNumeroBrani.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldNumeroBrani.setEditable(false);
					textFieldNumeroBrani.setDisabledTextColor(Color.WHITE);
					textFieldNumeroBrani.setColumns(10);
					textFieldNumeroBrani.setBorder(null);
					textFieldNumeroBrani.setBackground(new Color(21, 21, 21));

					JTextField textFieldCodiceAlbum = new JTextField();
					textFieldCodiceAlbum.setForeground(Color.WHITE);
					textFieldCodiceAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldCodiceAlbum.setEditable(false);
					textFieldCodiceAlbum.setDisabledTextColor(Color.WHITE);
					textFieldCodiceAlbum.setColumns(10);
					textFieldCodiceAlbum.setBorder(null);
					textFieldCodiceAlbum.setBackground(new Color(21, 21, 21));

					JButton buttonSalvaAlbum = new JButton("");
					JButton buttonModificaAlbum = new JButton("");
					buttonModificaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModificaAlbum.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeAlbum.setEditable(true);
							textFieldNumeroBrani.setEditable(true);
							textFieldGenere.setEditable(true);
							textFieldData.setEditable(true);
							buttonSalvaAlbum.setEnabled(true);
							buttonModificaAlbum.setBackground(AppColor.darkGrey);
							buttonModificaAlbum.setEnabled(false);

							textFieldNomeAlbum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldNumeroBrani.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldGenere.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldData.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						}
					});
					buttonModificaAlbum.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonModificaAlbum.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonModificaAlbum.setBackground(AppColor.black);
						}
					});
					buttonModificaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModificaAlbum.setIconTextGap(10);
					buttonModificaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModificaAlbum.setForeground(Color.WHITE);
					buttonModificaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModificaAlbum.setFocusPainted(false);
					buttonModificaAlbum.setEnabled(true);
					buttonModificaAlbum.setBorderPainted(false);
					buttonModificaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModificaAlbum.setBackground(new Color(15, 15, 15));

					buttonSalvaAlbum.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeAlbum.setEditable(false);
							textFieldNumeroBrani.setEditable(false);
							textFieldGenere.setEditable(false);
							textFieldData.setEditable(false);
							buttonSalvaAlbum.setEnabled(false);
							buttonModificaAlbum.setBackground(new Color(15, 15, 15));
							buttonModificaAlbum.setEnabled(true);

							String codice = textFieldCodiceAlbum.getText();
							String nome = textFieldNomeAlbum.getText();
							String songNumber = textFieldNumeroBrani.getText();
							String genere = textFieldGenere.getText();
							String data = textFieldData.getText();

							controller.updateAlbum(codice, nome, songNumber, genere, data);

							textFieldNomeAlbum.setBorder(null);
							textFieldNumeroBrani.setBorder(null);
							textFieldGenere.setBorder(null);
							textFieldData.setBorder(null);
						}
					});
					buttonSalvaAlbum.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if (buttonSalvaAlbum.isEnabled() == true)
								buttonSalvaAlbum.setBackground(AppColor.blueViolet);
							else
								buttonSalvaAlbum.setBackground(AppColor.black);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonSalvaAlbum.setBackground(AppColor.black);
						}
					});
					buttonSalvaAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSalvaAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSalvaAlbum.setIconTextGap(10);
					buttonSalvaAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSalvaAlbum.setForeground(Color.WHITE);
					buttonSalvaAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSalvaAlbum.setFocusPainted(false);
					buttonSalvaAlbum.setEnabled(false);
					buttonSalvaAlbum.setBorderPainted(false);
					buttonSalvaAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSalvaAlbum.setBackground(new Color(15, 15, 15));

					JButton buttonDeleteAlbum = new JButton("");
					buttonDeleteAlbum.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodiceAlbum.getText();
							String nome = textFieldNomeAlbum.getText();

							Object[] options = {"Si", "No", "Annulla"};
							int scelta = JOptionPane.showOptionDialog(null,
									"Sei sicuro di voler cancellare "
											+ nome,
											"Cancella album",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[2]);

							if(scelta == JOptionPane.YES_OPTION){  
								controller.deleteAlbumDB(codice);
								stampaAlbumGUI();
							}
						}
					});
					buttonDeleteAlbum.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if (buttonDeleteAlbum.isEnabled() == true)
								buttonDeleteAlbum.setBackground(AppColor.blueViolet);
							else
								buttonDeleteAlbum.setBackground(AppColor.black);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonDeleteAlbum.setBackground(AppColor.black);
						}
					});
					buttonDeleteAlbum.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDeleteAlbum.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
					buttonDeleteAlbum.setIconTextGap(10);
					buttonDeleteAlbum.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDeleteAlbum.setForeground(Color.WHITE);
					buttonDeleteAlbum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDeleteAlbum.setFocusPainted(false);
					buttonDeleteAlbum.setEnabled(true);
					buttonDeleteAlbum.setBorderPainted(false);
					buttonDeleteAlbum.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDeleteAlbum.setBackground(new Color(15, 15, 15));

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
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldNumeroBrani, 0, 0, Short.MAX_VALUE)))
								.addGap(63)
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addComponent(labelGenere, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addGap(67)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					gl_panelBackGroundAlbum.setVerticalGroup(
						gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
									.addComponent(buttonDeleteAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonSalvaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addComponent(buttonModificaAlbum, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(textFieldNomeAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldArtista, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
										.addGap(21)
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblCod_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldCodiceAlbum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNBrani, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldNumeroBrani, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(12, Short.MAX_VALUE))
							.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
								.addContainerGap(27, Short.MAX_VALUE)
								.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelBackGroundAlbum.createSequentialGroup()
										.addGroup(gl_panelBackGroundAlbum.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblDataPubblicazione, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(labelGenere))
									.addComponent(textFieldGenere, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(20))
					);
					panelBackGroundAlbum.setLayout(gl_panelBackGroundAlbum);

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
					textFieldNomeSong.setFont(new Font("Segoe UI", Font.BOLD, 24));
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

					JButton buttonDeleteSong = new JButton("");
					buttonDeleteSong.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodSong.getText();

							String nome = textFieldNomeSong.getText();

							Object[] options = {"Si", "No", "Annulla"};
							int scelta = JOptionPane.showOptionDialog(null,
									"Sei sicuro di voler cancellare "
											+ nome,
											"Cancella brano",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[2]);

							if(scelta == JOptionPane.YES_OPTION){  
								controller.deleteSongDB(codice);
								stampaSongGUI();
							}

						}
					});
					buttonDeleteSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDeleteSong.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonDeleteSong.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonDeleteSong.setBackground(AppColor.black);
						}
					});
					buttonDeleteSong.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
					buttonDeleteSong.setIconTextGap(10);
					buttonDeleteSong.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDeleteSong.setForeground(Color.WHITE);
					buttonDeleteSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDeleteSong.setFocusPainted(false);
					buttonDeleteSong.setEnabled(true);
					buttonDeleteSong.setBorderPainted(false);
					buttonDeleteSong.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDeleteSong.setBackground(new Color(15, 15, 15));

					JButton buttonModificaSong = new JButton("");
					JButton buttonSaveSong = new JButton("");

					buttonModificaSong.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeSong.setEditable(true);
							textFieldDurata.setEditable(true);
							buttonSaveSong.setEnabled(true);
							buttonModificaSong.setBackground(AppColor.darkGrey);
							buttonModificaSong.setEnabled(false);

							textFieldNomeSong.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldDurata.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						}
					});
					buttonModificaSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModificaSong.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonModificaSong.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonModificaSong.setBackground(AppColor.black);
						}
					});
					buttonModificaSong.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModificaSong.setIconTextGap(10);
					buttonModificaSong.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModificaSong.setForeground(Color.WHITE);
					buttonModificaSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModificaSong.setFocusPainted(false);
					buttonModificaSong.setEnabled(true);
					buttonModificaSong.setBorderPainted(false);
					buttonModificaSong.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModificaSong.setBackground(new Color(15, 15, 15));

					buttonSaveSong.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeSong.setEditable(false);
							textFieldDurata.setEditable(false);
							buttonSaveSong.setEnabled(false);
							buttonModificaSong.setBackground(AppColor.black);
							buttonModificaSong.setEnabled(true);

							String codice = textFieldCodSong.getText();
							String nome = textFieldNomeSong.getText();
							String durata = textFieldDurata.getText();

							controller.updateSong(codice, nome, durata);

							textFieldNomeSong.setBorder(null);
							textFieldDurata.setBorder(null);
						}
					});
					buttonSaveSong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSaveSong.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if (buttonSaveSong.isEnabled() == true)
								buttonSaveSong.setBackground(AppColor.blueViolet);
							else
								buttonSaveSong.setBackground(AppColor.black);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonSaveSong.setBackground(AppColor.black);
						}
					});
					buttonSaveSong.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSaveSong.setIconTextGap(10);
					buttonSaveSong.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSaveSong.setForeground(Color.WHITE);
					buttonSaveSong.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSaveSong.setFocusPainted(false);
					buttonSaveSong.setEnabled(false);
					buttonSaveSong.setBorderPainted(false);
					buttonSaveSong.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSaveSong.setBackground(new Color(15, 15, 15));

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
									.addComponent(textFieldNomeSong, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
								.addGap(54)
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addComponent(labelDurata, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldDurata, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldGenereSong, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addComponent(buttonDeleteSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonModificaSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonSaveSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					gl_panelBackGroundSong.setVerticalGroup(
						gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSong.createSequentialGroup()
								.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSong.createSequentialGroup()
										.addGap(22)
										.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.TRAILING)
											.addComponent(buttonDeleteSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonSaveSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonModificaSong, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panelBackGroundSong.createSequentialGroup()
												.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.BASELINE)
													.addComponent(labelDurata, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldDurata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_4)
													.addComponent(textFieldGenereSong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_panelBackGroundSong.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelCodSong, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCodSong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblAlbum, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldAlbumSong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_panelBackGroundSong.createSequentialGroup()
										.addContainerGap()
										.addComponent(textFieldNomeSong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
					textFieldNomeSingolo.setFont(new Font("Segoe UI", Font.BOLD, 24));
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

					JButton buttonDeleteSingle = new JButton("");
					buttonDeleteSingle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodSingolo.getText();
							String nome = textFieldNomeSingolo.getText();

							Object[] options = {"Si", "No", "Annulla"};
							int scelta = JOptionPane.showOptionDialog(null,
									"Sei sicuro di voler cancellare "
											+ nome,
											"Cancella singolo",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[2]);

							if(scelta == JOptionPane.YES_OPTION){  
								controller.deleteSingleDB(codice);
								stampaSingleGUI();
							}
						}
					});
					buttonDeleteSingle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDeleteSingle.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonDeleteSingle.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonDeleteSingle.setBackground(AppColor.black);
						}
					});
					buttonDeleteSingle.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
					buttonDeleteSingle.setIconTextGap(10);
					buttonDeleteSingle.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDeleteSingle.setForeground(Color.WHITE);
					buttonDeleteSingle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDeleteSingle.setFocusPainted(false);
					buttonDeleteSingle.setEnabled(true);
					buttonDeleteSingle.setBorderPainted(false);
					buttonDeleteSingle.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDeleteSingle.setBackground(new Color(15, 15, 15));

					DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					JTextField textFieldDataPubblicazioneSingolo = new JFormattedTextField(format);
					textFieldDataPubblicazioneSingolo.setForeground(Color.WHITE);
					textFieldDataPubblicazioneSingolo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldDataPubblicazioneSingolo.setEditable(false);
					textFieldDataPubblicazioneSingolo.setDisabledTextColor(Color.WHITE);
					textFieldDataPubblicazioneSingolo.setColumns(10);
					textFieldDataPubblicazioneSingolo.setBorder(null);
					textFieldDataPubblicazioneSingolo.setBackground(new Color(21, 21, 21));

					JButton buttonModifySingolo = new JButton("");
					JButton buttonSaveModifySingolo = new JButton("");

					buttonModifySingolo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeSingolo.setEditable(true);
							textFieldDurataSingolo.setEditable(true);
							textFieldDataPubblicazioneSingolo.setEditable(true);
							textFieldGenereSingolo.setEditable(true);

							buttonSaveModifySingolo.setEnabled(true);
							buttonModifySingolo.setBackground(AppColor.darkGrey);
							buttonModifySingolo.setEnabled(false);

							textFieldNomeSingolo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldDurataSingolo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldDataPubblicazioneSingolo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldGenereSingolo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						}
					});
					buttonModifySingolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModifySingolo.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonModifySingolo.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonModifySingolo.setBackground(AppColor.black);
						}
					});
					buttonModifySingolo.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModifySingolo.setIconTextGap(10);
					buttonModifySingolo.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModifySingolo.setForeground(Color.WHITE);
					buttonModifySingolo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModifySingolo.setFocusPainted(false);
					buttonModifySingolo.setEnabled(true);
					buttonModifySingolo.setBorderPainted(false);
					buttonModifySingolo.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModifySingolo.setBackground(new Color(15, 15, 15));

					buttonSaveModifySingolo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodSingolo.getText();
							String nome = textFieldNomeSingolo.getText();
							String durata = textFieldDurataSingolo.getText();
							String dataPubblicazione = textFieldDataPubblicazioneSingolo.getText();
							String genere = textFieldGenereSingolo.getText();

							controller.updateSingle(codice, nome, durata, genere, dataPubblicazione);

							textFieldNomeSingolo.setBorder(null);
							textFieldDurataSingolo.setBorder(null);
							textFieldDataPubblicazioneSingolo.setBorder(null);
							textFieldGenereSingolo.setBorder(null);

							buttonSaveModifySingolo.setEnabled(false);
							buttonModifySingolo.setBackground(AppColor.black);
							buttonModifySingolo.setEnabled(true);
						}
					});
					buttonSaveModifySingolo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSaveModifySingolo.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if (buttonSaveModifySingolo.isEnabled() == true)
								buttonSaveModifySingolo.setBackground(AppColor.blueViolet);
							else
								buttonSaveModifySingolo.setBackground(AppColor.black);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonSaveModifySingolo.setBackground(AppColor.black);
						}
					});
					buttonSaveModifySingolo.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSaveModifySingolo.setIconTextGap(10);
					buttonSaveModifySingolo.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSaveModifySingolo.setForeground(Color.WHITE);
					buttonSaveModifySingolo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSaveModifySingolo.setFocusPainted(false);
					buttonSaveModifySingolo.setEnabled(false);
					buttonSaveModifySingolo.setBorderPainted(false);
					buttonSaveModifySingolo.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSaveModifySingolo.setBackground(new Color(15, 15, 15));

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
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldArtistaSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblDataPubblicazione_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textFieldDataPubblicazioneSingolo, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldNomeSingolo, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldDurataSingolo, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldGenereSingolo, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addComponent(buttonDeleteSingle, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonModifySingolo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonSaveModifySingolo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
					);
					gl_panelBackGroundSingle.setVerticalGroup(
						gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
								.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
										.addGap(22)
										.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.TRAILING)
											.addComponent(buttonDeleteSingle, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonSaveModifySingolo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonModifySingolo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCodSingolo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblArtista, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldArtistaSingolo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDataPubblicazione_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldDataPubblicazioneSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelBackGroundSingle.createSequentialGroup()
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldDurataSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panelBackGroundSingle.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_5)
													.addComponent(textFieldGenereSingolo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
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
					textFieldNomeEP.setFont(new Font("Segoe UI", Font.BOLD, 24));
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

					JButton buttonDeleteEP = new JButton("");
					buttonDeleteEP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodEP.getText();
							String nome = textFieldNomeEP.getText();

							Object[] options = {"Si", "No", "Annulla"};
							int scelta = JOptionPane.showOptionDialog(null,
									"Sei sicuro di voler cancellare "
											+ nome,
											"Cancella EP",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[2]);

							if(scelta == JOptionPane.YES_OPTION){  
								controller.deleteEPDB(codice);
								stampaEPGUI();
							}
						}
					});
					buttonDeleteEP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonDeleteEP.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonDeleteEP.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonDeleteEP.setBackground(AppColor.black);
						}
					});
					buttonDeleteEP.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/DeleteArtist-48.png")));
					buttonDeleteEP.setIconTextGap(10);
					buttonDeleteEP.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonDeleteEP.setForeground(Color.WHITE);
					buttonDeleteEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonDeleteEP.setFocusPainted(false);
					buttonDeleteEP.setEnabled(true);
					buttonDeleteEP.setBorderPainted(false);
					buttonDeleteEP.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonDeleteEP.setBackground(new Color(15, 15, 15));

					JTextField textFieldNumeroBraniEP = new JTextField();
					textFieldNumeroBraniEP.setForeground(Color.WHITE);
					textFieldNumeroBraniEP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					textFieldNumeroBraniEP.setEditable(false);
					textFieldNumeroBraniEP.setDisabledTextColor(Color.WHITE);
					textFieldNumeroBraniEP.setColumns(10);
					textFieldNumeroBraniEP.setBorder(null);
					textFieldNumeroBraniEP.setBackground(new Color(21, 21, 21));

					JButton buttonModifyEP = new JButton("");
					JButton buttonSaveEP = new JButton("");
					buttonSaveEP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String codice = textFieldCodEP.getText();
							String nome = textFieldNomeEP.getText();
							String dataPubblicazione = textFieldDataEP.getText();
							String genere = textFieldGenereEP.getText();
							String numberSong = textFieldNumeroBraniEP.getText();

							if( Integer.parseInt(numberSong) > 5)
								JOptionPane.showMessageDialog(null,
										"Numero brani EP errore!!!",
										"Errore",
										JOptionPane.ERROR_MESSAGE);
							else {
								controller.updateEP(codice, nome, dataPubblicazione, genere, numberSong);

								textFieldNomeEP.setBorder(null);
								textFieldDataEP.setBorder(null);
								textFieldGenereEP.setBorder(null);
								textFieldNumeroBraniEP.setBorder(null);

								buttonSaveEP.setEnabled(false);
								buttonModifyEP.setBackground(AppColor.black);
								buttonModifyEP.setEnabled(true);
							}
						}
					});
					buttonSaveEP.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Save-48.png")));
					buttonSaveEP.setIconTextGap(10);
					buttonSaveEP.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonSaveEP.setForeground(Color.WHITE);
					buttonSaveEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonSaveEP.setFocusPainted(false);
					buttonSaveEP.setEnabled(false);
					buttonSaveEP.setBorderPainted(false);
					buttonSaveEP.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonSaveEP.setBackground(new Color(15, 15, 15));
					buttonSaveEP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonSaveEP.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							if (buttonSaveEP.isEnabled() == true)
								buttonSaveEP.setBackground(AppColor.blueViolet);
							else
								buttonSaveEP.setBackground(AppColor.black);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonSaveEP.setBackground(AppColor.black);
						}
					});
					buttonModifyEP.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textFieldNomeEP.setEditable(true);
							textFieldDataEP.setEditable(true);
							textFieldGenereEP.setEditable(true);
							textFieldNumeroBraniEP.setEditable(true);

							buttonSaveEP.setEnabled(true);
							buttonModifyEP.setBackground(AppColor.darkGrey);
							buttonModifyEP.setEnabled(false);

							textFieldNomeEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldDataEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldGenereEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
							textFieldNumeroBraniEP.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
						}
					});
					buttonModifyEP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					buttonModifyEP.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							buttonModifyEP.setBackground(AppColor.blueViolet);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							buttonModifyEP.setBackground(AppColor.black);
						}
					});
					buttonModifyEP.setIcon(new ImageIcon(HomeGUI.class.getResource("/Img/Modify-48.png")));
					buttonModifyEP.setIconTextGap(10);
					buttonModifyEP.setHorizontalTextPosition(SwingConstants.RIGHT);
					buttonModifyEP.setForeground(Color.WHITE);
					buttonModifyEP.setFont(new Font("Segoe UI", Font.PLAIN, 18));
					buttonModifyEP.setFocusPainted(false);
					buttonModifyEP.setEnabled(true);
					buttonModifyEP.setBorderPainted(false);
					buttonModifyEP.setBorder(new LineBorder(new Color(0, 51, 255), 10));
					buttonModifyEP.setBackground(new Color(15, 15, 15));

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
													.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldCodEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldArtistaEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(14)
													.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
													.addGap(12)
													.addComponent(textFieldDataEP, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelBackGroundEP.createSequentialGroup()
													.addGap(12)
													.addComponent(textFieldNomeEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panelBackGroundEP.createSequentialGroup()
													.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldGenereEP, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelBackGroundEP.createSequentialGroup()
													.addComponent(lblNBrani_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(textFieldNumeroBraniEP, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
									.addComponent(buttonDeleteEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buttonModifyEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(buttonSaveEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
							);
					gl_panelBackGroundEP.setVerticalGroup(
							gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelBackGroundEP.createSequentialGroup()
									.addGap(22)
									.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.TRAILING)
											.addComponent(buttonSaveEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonModifyEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.BASELINE)
													.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldCodEP, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
													.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldArtistaEP, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panelBackGroundEP.createSequentialGroup()
															.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
																	.addComponent(lblNBrani_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textFieldNumeroBraniEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
															.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.LEADING)
																	.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
																	.addGroup(gl_panelBackGroundEP.createParallelGroup(Alignment.BASELINE)
																			.addComponent(textFieldDataEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(label_9)
																			.addComponent(textFieldGenereEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
													.addComponent(buttonDeleteEP, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(12, Short.MAX_VALUE))
							.addGroup(gl_panelBackGroundEP.createSequentialGroup()
									.addContainerGap()
									.addComponent(textFieldNomeEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(59, Short.MAX_VALUE))
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
}