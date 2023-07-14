package com.smup.GUI;

import com.smup.Controller.Controller;
import com.smup.Style.AppColor;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class SignUpGUI extends JFrame {
	private Controller controller;

	int mouseX, mouseY;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JPanel contentPane;

	public SignUpGUI(Controller controller) {
		this.controller = controller;

		setUndecorated(true);
		setBackground(Color.DARK_GRAY);

		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeGUI.class.getResource("/com/smup/Img/LogoB-48.png")));

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 574);
		contentPane = new JPanel();
		contentPane.setBackground(AppColor.darkGrey);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				setLocation(x - mouseX, y - mouseY);
			}
		});

		setLocationRelativeTo(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(10, 52, 805, 511);
		panelLogin.setBackground(AppColor.grey);

		JLabel labelX = new JLabel("x");
		labelX.setHorizontalAlignment(SwingConstants.CENTER);
		labelX.setBounds(795, 11, 20, 30);
		labelX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelX.setForeground(Color.RED);
		labelX.setFont(new Font("Segoe UI", Font.PLAIN, 26));

		JLabel lblSingUp = new JLabel("SIGN UP");
		lblSingUp.setBounds(10, 115, 785, 60);
		lblSingUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingUp.setForeground(AppColor.white);
		lblSingUp.setFont(new Font("Segoe UI", Font.BOLD, 26));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(215, 190, 376, 25);
		lblUsername.setForeground(AppColor.white);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		usernameTextField = new JTextField();
		usernameTextField.setBounds(215, 224, 380, 30);
		usernameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.white));
			}
		});
		usernameTextField.setSelectionColor(new Color(0, 153, 204));
		usernameTextField.setSelectedTextColor(Color.WHITE);
		usernameTextField.setOpaque(false);
		usernameTextField.setForeground(Color.WHITE);
		usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		usernameTextField.setColumns(10);
		usernameTextField.setCaretColor(new Color(0, 153, 204));
		usernameTextField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.white));
		usernameTextField.setBackground(new Color(36, 53, 102));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(215, 265, 376, 25);
		lblPassword.setForeground(AppColor.white);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JButton buttonAnnulla = new JButton("Cancel");
		buttonAnnulla.setBounds(215, 444, 380, 41);
		buttonAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.frameLoginGUI(true);
				setVisible(false);
			}
		});
		buttonAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonAnnulla.setBackground(new Color(139, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonAnnulla.setBackground(new Color(204, 0, 0));
			}
		});
		buttonAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAnnulla.setForeground(Color.WHITE);
		buttonAnnulla.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		buttonAnnulla.setFocusPainted(false);
		buttonAnnulla.setBorderPainted(false);
		buttonAnnulla.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		buttonAnnulla.setBackground(new Color(204, 0, 0));

		JCheckBox chckbxIsAdmin = new JCheckBox("Is Admin");
		chckbxIsAdmin.setBounds(215, 352, 380, 34);
		chckbxIsAdmin.setIcon(new ImageIcon(SignUpGUI.class.getResource("/com/smup/Img/boxCheck-32.png")));
		chckbxIsAdmin.setSelectedIcon(new ImageIcon(SignUpGUI.class.getResource("/com/smup/Img/Check-32.png")));
		chckbxIsAdmin.setPressedIcon(new ImageIcon(SignUpGUI.class.getResource("/com/smup/Img/Check-32.png")));
		chckbxIsAdmin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) AppColor.white));
		chckbxIsAdmin.setFocusPainted(false);
		chckbxIsAdmin.setForeground(AppColor.white);
		chckbxIsAdmin.setBackground(AppColor.grey);
		chckbxIsAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		JButton btnAccedi = new JButton("Sing up");
		btnAccedi.setBounds(215, 397, 380, 41);
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextField.getText();
				String password = String.valueOf(passwordField.getPassword());

				if (chckbxIsAdmin.isSelected())
					controller.insertUser(username, password, true);
				else
					controller.insertUser(username, password, false);

				usernameTextField.setText("");
				passwordField.setText("");
				
				controller.frameLoginGUI(true);
				setVisible(false);
			}
		});
		btnAccedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAccedi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccedi.setBackground(AppColor.darkGreen);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccedi.setBackground(AppColor.green);
			}
		});
		panelLogin.setLayout(null);
		btnAccedi.setForeground(Color.WHITE);
		btnAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnAccedi.setFocusPainted(false);
		btnAccedi.setBorderPainted(false);
		btnAccedi.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		btnAccedi.setBackground(AppColor.green);
		panelLogin.add(btnAccedi);
		panelLogin.add(buttonAnnulla);
		panelLogin.add(lblUsername);
		panelLogin.add(lblPassword);
		panelLogin.add(usernameTextField);
		panelLogin.add(chckbxIsAdmin);
		panelLogin.add(lblSingUp);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('●');
		passwordField.setBounds(215, 302, 330, 30);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.blueViolet));
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.white));
			}
		});
		passwordField.setSelectionColor(new Color(0, 153, 204));
		passwordField.setSelectedTextColor(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField.setColumns(10);
		passwordField.setCaretColor(new Color(0, 153, 204));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) AppColor.white));
		passwordField.setBackground(new Color(36, 53, 102));
		panelLogin.add(passwordField);

		JCheckBox chckbxShowPassword = new JCheckBox("");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else
					passwordField.setEchoChar('●');
			}
		});
		contentPane.setLayout(null);
		chckbxShowPassword.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxShowPassword.setBounds(555, 298, 40, 34);
		chckbxShowPassword.setIcon(new ImageIcon(LoginGUI.class.getResource("/com/smup/Img/NOShowPassword-32.png")));
		chckbxShowPassword.setSelectedIcon(new ImageIcon(LoginGUI.class.getResource("/com/smup/Img/ShowPassword-32.png")));
		chckbxShowPassword.setPressedIcon(new ImageIcon(LoginGUI.class.getResource("/com/smup/Img/ShowPassword-32.png")));
		chckbxShowPassword.setForeground(Color.WHITE);
		chckbxShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxShowPassword.setFocusPainted(false);
		chckbxShowPassword.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		chckbxShowPassword.setBackground(new Color(26, 26, 26));
		panelLogin.add(chckbxShowPassword);
		
		contentPane.add(panelLogin);
		contentPane.add(labelX);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(LoginGUI.class.getResource("/com/smup/Img/Logo-64.png")));
		logo.setBounds(10, 23, 785, 94);
		panelLogin.add(logo);
		contentPane.add(labelX);
	}
}
