package labs.lab9;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPage extends JFrame{
	
	private JButton login;
	private JButton cancel;
	JTextField username;
	public String usernameInput;
	
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	
	public LoginPage() {
		createComponents();
		setTitle("Input");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		
	}
	
	public String returnUsername() {
		return usernameInput;
	}
	public void createComponents() {
		
		login = new JButton("Login");
		cancel = new JButton("Cancel");
		username = new JTextField(20);
		JLabel usernameLogin = new JLabel("Username: ");
		
		
		class CancelEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
				
			}
			
		}
		class Login implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				usernameInput = username.getText();
				if (!usernameInput.isBlank()) {
//				EmailSystem.ProcessData(usernameInput.strip());
				setVisible(false);
				}

				
			}
			
		}
		
		
		
		ActionListener loginEvent = new Login();
		ActionListener cancelEvent = new CancelEvent();
		
		cancel.addActionListener(cancelEvent);
		login.addActionListener(loginEvent);
		
		JPanel panel2 = new JPanel();
		panel2.add(usernameLogin);
		panel2.add(username);
		
		
		JPanel panel = new JPanel();
		panel.add(login);
		panel.add(cancel);
		
		JPanel panel3 = new JPanel();
		
		add(panel3,BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		
		
		
	}
	
	
	
}