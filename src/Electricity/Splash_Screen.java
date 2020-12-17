package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash_Screen {

	public static void main(String[] args) {
		
		makeFrame f1 = new makeFrame();
		f1.setVisible(true);
		int x=1;
		for(int i=2; i<=600; i+=4, x+=1) {
			f1.setLocation(800 - ((i+x)/2), 500 - (i/2));
			f1.setSize(i+x,i);
			
			try {
				Thread.sleep(10);
			}catch(Exception e) { }
		}
	}
}
class makeFrame extends JFrame implements Runnable{
	Thread t1;
	makeFrame(){
		super("Welcome to WBSEDCL");
		setLayout(new FlowLayout());
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/Wbsedcl-logo.png"));
		Image i1 = ic1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(i1);
		
		JLabel l1 = new JLabel(ic2);
		add(l1);
		
		t1 = new Thread(this);
		t1.start();
		
	}
	public void run() {
		try {
			Thread.sleep(5000);
			this.setVisible(false);
			
			Login l = new Login();
			l.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}