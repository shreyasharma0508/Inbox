package labs.lab9;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class solve extends JFrame
{
	
	//frame
	static JFrame frame;
	
	//lists
	static JList b;


	//main class
	public static void main(String[] args)
	{
		//create a new frame
		frame = new JFrame("frame");
		
		//String array to store weekdays
		String week[]= { "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		//create a object
		solve s=new solve();
	
		//create a panel
		JPanel p =new JPanel();
		
		//create a new label
		JLabel l= new JLabel("select the day of the week");
		
		//create list
		b = new JList(week);
		
		//set a selected index
		b.setSelectedIndex(2);
		
		//add list to panel
		p.add(b);

		frame.add(p);
		
		//set the size of frame
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	
}
