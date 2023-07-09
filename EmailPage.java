package labs.lab9;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class EmailPage extends JFrame{
	

	private JButton login;
	private JButton cancel;
	String username;
	private ArrayList<Email> emails;
	private JTextArea emailReader;
	private JPanel inboxPanel;
	private JPanel newMessage;
	private JMenuBar menubar;
	private JList list;
	Set<String> users;
	private JPanel usernamePanel;
	
	
	
	private static final int FRAME_WIDTH = 3000;
	private static final int FRAME_HEIGHT = 800;
	
	
	public EmailPage(String username) {
		this.username = username;
		this.emails = new ArrayList<Email>();
		this.users = new HashSet<String>(Arrays.asList("Robert Navarro"));
				

		
		setTitle("Email System - Shreya Sharma - 22077888");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MenuBar();
		createPanels();
		createInbox();
		setInboxtoTrue();
		createName();
		setNMtoTrue();
		addUser(username);

	}
	
	public void addUser(String user) {
		users.add(user);
	}
	
	
	public void createPanels() {
		
		usernamePanel = new JPanel();
		add(usernamePanel, BorderLayout.NORTH);
		
		inboxPanel = new JPanel();
		inboxPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Inbox"));
		
		
		newMessage = new JPanel(new GridLayout(5,1));
		newMessage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "New Message"));
			
	}
	
	
	
	public void createInbox() {
		
		
		usernamePanel.add(new JLabel("Username: "+username));
		ArrayList<Email> sortedEmails = new ArrayList<Email>();
		
		
		for (Email email: emails) {
			if (email.getTo().equals(username)) {
			sortedEmails.add(email);}
			
		}
		Collections.reverse(sortedEmails);
		Collections.sort(sortedEmails);
		
		Object[] lister = sortedEmails.toArray();
		
		String hello[] = {};
		
		int i = 0;
		for (Email email:sortedEmails) {
			lister[i] = "From: "+email.getFrom()+", Subject: "+email.getSubject();
			i++;
			
		}

		list = new JList(lister);
		JScrollPane scrollPaneList = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		list.setVisible(true);
		list.setVisibleRowCount(15);
		list.setFixedCellWidth(250);

		inboxPanel.add(scrollPaneList);
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int index = list.getSelectedIndex();
		        int p = sortedEmails.get(index).getPriority();
		        
		        String hellop= "";
		        if (p==1) {
		        	hellop = "High";
		        }else if(p==2) {
		        	hellop = "Medium";
		        }else {
		        	hellop = "Low";
		        }
		        LocalDateTime hellot = sortedEmails.get(index).getTime();
		        DateTimeFormatter myFormatobj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		        String formattedDate = hellot.format(myFormatobj);
		        
		        emailReader.setText("From: "+sortedEmails.get(index).getFrom()+System.lineSeparator()+"To: "+sortedEmails.get(index).getTo()+System.lineSeparator()+"Priority: "+ hellop+System.lineSeparator()+"Subject: " +sortedEmails.get(index).getSubject()+System.lineSeparator()+formattedDate+System.lineSeparator()+ System.lineSeparator()+  sortedEmails.get(index).getContent());
		    }
		};
		
		
		list.addMouseListener(mouseListener);
		
		//EMAIL READER
		emailReader = new JTextArea(15, 50);
		JScrollPane scrollPaneText = new JScrollPane(emailReader, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		emailReader.setEditable(false);
		inboxPanel.add(scrollPaneText);

		
	}
	
	public void setInboxtoTrue() {
		add(inboxPanel,BorderLayout.CENTER);
	}
	
	public void createName() {
		String[] choices;
		if (users.size()>1) {
			choices = new String[users.size()-1];
		}else {
		choices = new String[users.size()];}
		
		
		int i = 0;
		for (String user :users) {
			if (i>choices.length) {
				break;
			}
			if (!user.equals(username)) {
			choices[i] = user;
			i++;}			
		}

		
		final JComboBox<String> cb = new JComboBox<String>(choices);

	    cb.setMaximumSize(cb.getPreferredSize()); // added code
	    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
	    
	    JPanel namas = new JPanel();
	    
	    namas.add(new JLabel("To: "));
	    namas.add( cb);
	    
	    newMessage.add(namas);
		
		JPanel subject = new JPanel();
		
		JTextField newSubject = new JTextField(20);
		JLabel subjectLogin = new JLabel("Subject: ");
		
		subject.add(subjectLogin);
		subject.add(newSubject);

	    //Priority
	    
	    JRadioButton highP = new JRadioButton("High");
	    JRadioButton medP = new JRadioButton("Medium");
	    JRadioButton lowP = new JRadioButton("Low");
	    
	    ButtonGroup priority = new ButtonGroup();
	    
	    priority.add(lowP);
	    priority.add(medP);
	    priority.add(highP);
	    
	    JPanel prior = new JPanel();
	    prior.add(new JLabel("Priority: "));
	    prior.add(highP);
	    prior.add(medP);
	    prior.add(lowP);
	    
	   highP.setSelected(true);
	    
	    JTextArea email = new JTextArea(5,10);
	    
	    newMessage.add(prior);
	    newMessage.add(subject);
	    
	    JScrollPane scrollPaneemailText = new JScrollPane(email, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
	   newMessage.add(scrollPaneemailText);
	   
	   JButton send = new JButton("Send");
	   JButton clear = new JButton("Clear");
	   
	   JPanel last = new JPanel();
	    
	   last.add(send);
	   last.add(clear);
	   
	   newMessage.add(last);

	   class clearText implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			priority.clearSelection();
			highP.setSelected(true);
			cb.setSelectedIndex(0);
			newSubject.setText("");
			email.setText("");

		}
		   
	   }
	   
	   ActionListener clearEvent = new clearText();
	   
	   clear.addActionListener(clearEvent);
	   
		   
	class sendEmail implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int chosen = cb.getSelectedIndex();
			String to = choices[chosen];
			int prior = 1;
			
			if (lowP.isSelected()) {
				prior = 3;
			}else if(medP.isSelected()) {
				prior = 2;
				
			}else {
				prior = 1;
			}
			
			String subje = newSubject.getText();
			String textA = email.getText();
			
			emails.add(new Email(to,username,subje, textA, prior));
			
			JOptionPane.showMessageDialog(null, "Message Sent");
			
			priority.clearSelection();
			highP.setSelected(true);
			cb.setSelectedIndex(0);
			newSubject.setText("");
			email.setText("");
			
		}
		
	}
	
	ActionListener sendEmailListener = new sendEmail();
	
	send.addActionListener(sendEmailListener);

	}

	public void switchUser(String username) {
		
		this.username = username;
		users.add(username);
		setVisible(false);
		inboxPanel.removeAll();
		usernamePanel.removeAll();
		newMessage.removeAll();
		createName();
		createInbox();
		setVisible(true);
		
	}
	
	public void setNMtoTrue() {
		add(newMessage, BorderLayout.SOUTH);
	}

	public void MenuBar() {
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		JMenu users1 = new JMenu("Users");
		
		
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem switchUser = new JMenuItem("Switch User");
		
		
		class exit implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(ABORT);
				
			}
			
		}
		
		class switchUser implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				 JFrame f=new JFrame();   
				 
				 boolean bol = false;
				 String name = "";
				 while (bol == false) {
				
					 name=JOptionPane.showInputDialog(f,"Username: ");
				    if (!name.isBlank() && !name.isEmpty()) {
				    	bol = true;
				    }
				    
				    }
				 
				 switchUser(name);
				 repaint();
				
			}
			
		}

		ActionListener exitEvent = new exit();
		ActionListener switchUserEvent = new switchUser();
		
		
		exitItem.addActionListener(exitEvent);
		switchUser.addActionListener(switchUserEvent);
		
		
		users1.add(switchUser);
		file.add(exitItem);
		
		
		menubar.add(file);
		menubar.add(users1);
		
		
		
		
	}
	
	
	
	
	
	
}