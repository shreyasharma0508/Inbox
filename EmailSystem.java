package labs.lab9;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EmailSystem {
	
	static JFrame frame;
	
	public static String OptionPaneExample(){  
	    frame = new JFrame();   
	    boolean bool = false;
	    String name = "";
	    while (bool == false) {
	    name=JOptionPane.showInputDialog(frame,"Username: ");
	    if (!name.isBlank()) 
	    	bool = true;
		    }
		    
		    return name;
		}  
	
	public static void main(String[] args) {
		
		String username = OptionPaneExample();
		EmailPage emailPage = new EmailPage(username);
		emailPage.setVisible(true);

	
	}

}