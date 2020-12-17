package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Homepage extends JFrame implements ActionListener {
	String meter;
	Homepage(String meter, String customer){
		super("Electricity Billing System");
		this.meter = meter;
		setSize(1920, 1030);
		
		// Background Image //
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/Homepage copy.jpg"));
		Image i = ic.getImage().getScaledInstance(1458, 758, Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(i);
		JLabel l1 = new JLabel(ic1);
		add(l1);
		
		// MenuBars column //
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem m1 = new JMenuItem("New Customer");
		JMenuItem m2 = new JMenuItem("Customer Details");
		JMenuItem m3 = new JMenuItem("Deposit Details");
		menu.setForeground(Color.BLUE);
		
		// New Customer //
		m1.setFont(new Font("monospaced", Font.PLAIN, 12));
		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icons/icon1.png"));
		Image i1 = ic2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		m1.setIcon(new ImageIcon(i1));
		// ShortCut Key set //
		m1.setMnemonic('N');
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.META_MASK));
		m1.setBackground(Color.white);
		
		
		// customer details //
		 m2.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
	     Image i2 = ic3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     m2.setIcon(new ImageIcon(i2));
	     m2.setMnemonic('A');
	     m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.META_MASK));
	     m2.setBackground(Color.WHITE);
	     
	     
	     // Deposit details //
	     m3.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
	     Image i3 = ic4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     m3.setIcon(new ImageIcon(i3));
	     m3.setMnemonic('D');
	     m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.META_MASK));
	     m3.setBackground(Color.WHITE);
	     
	     
	     m1.addActionListener(this);
	     m2.addActionListener(this);
	     m3.addActionListener(this);
	     
	     
	  // Information column //
	     JMenu info = new JMenu("Information");
	     JMenuItem info1 = new JMenuItem("Update Information");
	     JMenuItem info2 = new JMenuItem("View Information");
	     info.setForeground(Color.RED);
	     
	     // Pay bills //
	     info1.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic11 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
	     Image i11 = ic11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     info1.setIcon(new ImageIcon(i11));
	     info1.setMnemonic('P');
	     info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.META_MASK));
	     info1.setBackground(Color.WHITE);
	     
	     // Bill details //
	     info2.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic12 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
	     Image i12 = ic12.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     info2.setIcon(new ImageIcon(i12));
	     info2.setMnemonic('B');
	     info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.META_MASK));
	     info2.setBackground(Color.WHITE);
	     
	     info1.addActionListener(this);
	     info2.addActionListener(this);
		
		
	     // Users column //
	     JMenu user = new JMenu("User");
	     JMenuItem u1 = new JMenuItem("Pay Bill");
	     JMenuItem u2 = new JMenuItem("Calculate Bill");
	     JMenuItem u3 = new JMenuItem("Bill Details");
	     user.setForeground(Color.RED);
	     
	     // Pay bills //
	     u1.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic5 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.png"));
	     Image i4 = ic5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     u1.setIcon(new ImageIcon(i4));
	     u1.setMnemonic('P');
	     u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.META_MASK));
	     u1.setBackground(Color.WHITE);
	     
	     // Bill details //
	     u2.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic6 = new ImageIcon(ClassLoader.getSystemResource("icons/icon5.png"));
	     Image i5 = ic6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     u2.setIcon(new ImageIcon(i5));
	     u2.setMnemonic('B');
	     u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.META_MASK));
	     u2.setBackground(Color.WHITE);
	     
	     // Last bill detail //
	     u3.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic7 = new ImageIcon(ClassLoader.getSystemResource("icons/icon6.png"));
	     Image i6 = ic7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     u3.setIcon(new ImageIcon(i6));
	     u3.setMnemonic('L');
	     u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.META_MASK));
	     u3.setBackground(Color.WHITE);
	     
	     
	     u1.addActionListener(this);
	     u2.addActionListener(this);
	     u3.addActionListener(this);
	     
	     
	     // report column //
	     JMenu report = new JMenu("Bill");
	     JMenuItem r1 = new JMenuItem("Genarate Bill");
	     report.setForeground(Color.BLUE);
	     
	     // report //
	     r1.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic8 = new ImageIcon(ClassLoader.getSystemResource("icons/icon7.png"));
	     Image i7 = ic8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     r1.setIcon(new ImageIcon(i7));
	     r1.setMnemonic('R');
	     r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.META_MASK));
	     r1.setBackground(Color.WHITE);
	     r1.addActionListener(this);
	     
	     
	     // utility column //
	     JMenu utility = new JMenu("Utility");
	     JMenuItem ut1 = new JMenuItem("Notepad");
	     JMenuItem ut2 = new JMenuItem("Calculator");
	     JMenuItem ut3 = new JMenuItem("Web Browser");
	     utility.setForeground(Color.RED); 
	     
	     // calendar //
	     ut1.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic9 = new ImageIcon(ClassLoader.getSystemResource("icons/icon12.png"));
	     Image i8 = ic9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     ut1.setIcon(new ImageIcon(i8));
	     ut1.setMnemonic('C');
	     ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.META_MASK));
	     ut1.setBackground(Color.WHITE);
	     
	     // calculator //
	     ut2.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic10 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
	     Image i9 = ic10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     ut2.setIcon(new ImageIcon(i9));
	     ut2.setMnemonic('X');
	     ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.META_MASK));
	     ut2.setBackground(Color.WHITE);
	     
	     // Chrome browser //
	     ut3.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic21 = new ImageIcon(ClassLoader.getSystemResource("icons/icon10.png"));
	     Image i21 = ic21.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     ut3.setIcon(new ImageIcon(i21));
	     ut3.setMnemonic('W');
	     ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.META_MASK));
	     ut3.setBackground(Color.WHITE);
	     
	     ut1.addActionListener(this);
	     ut2.addActionListener(this);
	     ut3.addActionListener(this);
	     
	     // exit column //
	     JMenu exit = new JMenu("Esc");
	     JMenuItem ext = new JMenuItem("Log Out");
	     exit.setForeground(Color.RED);
	     
	     ext.setFont(new Font("monospaced",Font.PLAIN,12));
	     ImageIcon ic22 = new ImageIcon(ClassLoader.getSystemResource("icons/icon11.png"));
	     Image i22 = ic22.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	     ext.setIcon(new ImageIcon(i22));
	     ext.setMnemonic('Z');
	     ext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.META_MASK));
	     ext.setBackground(Color.WHITE);
	     ext.addActionListener(this);
	     	     
	     menu.add(m1);
	     menu.add(m2);
	     menu.add(m3);
	     
	     info.add(info1);
	     info.add(info2);
	     
	     user.add(u1);
	     user.add(u2);
	     user.add(u3);
	     
	     report.add(r1);
	     
	     utility.add(ut1);
	     utility.add(ut2);
	     utility.add(ut3);
	     
	     exit.add(ext);
	     
	     if(customer.equals("Admin")){
	        mb.add(menu);
	     }else {   
	     mb.add(info);
	     mb.add(user);
	     mb.add(report);
	     }
	     mb.add(utility);
	     mb.add(exit);

	     setJMenuBar(mb);
	     
	     setFont(new Font("Senserif",Font.BOLD,16));
	     setLayout(new FlowLayout());
	     setVisible(false);	  
	}
	public void actionPerformed(ActionEvent ae) {
		String mssg = ae.getActionCommand();
		if(mssg.equals("Customer Details")) {
		 new Customer_details().setVisible(true);
		 
	}else if(mssg.equals("Deposit Details")) {
		new Deposit_Details().setVisible(true);
		
	}else if(mssg.equals("View Information")) {
		new View_Information(meter).setVisible(true);	
	
	}else if(mssg.equals("Update Information")) {
		new Update_Information(meter).setVisible(true);
	 
	}else if(mssg.equals("New Customer")) {
		new NewCustomer().setVisible(true);
		
	}else if(mssg.equals("Calculate Bill")) {
		new Calculate_Bill().setVisible(true);
		
	}else if(mssg.equals("Pay Bill")) {
		new Payment_info(meter).setVisible(true);
		
	}else if(mssg.equals("Bill Details")) {
		new Bill_Details(meter).setVisible(true);	
		
	}else if(mssg.equals("Notepad")) {
		try {
			Runtime.getRuntime().exec("Notes.exec");
			
		}catch(Exception e) { }
		
	}else if(mssg.equals("Calculator")) {
		try {
			Runtime.getRuntime().exec("Calculator");
			
		}catch(Exception e) {}
		
	}else if(mssg.equals("Web Browser")) {
	    try {
	    	Runtime.getRuntime().exec("Applications/Google Chrome");
	    	
	    }catch(Exception e) {}
	}else if(mssg.equals("Genarate Bill")) {
		new Generate_Bill(meter).setVisible(true);
		
	}else if(mssg.equals("Log Out")) {
		this.setVisible(false);
		new Login().setVisible(true);
	}
}
	public static void main(String[] args) {
		new Homepage("", "").setVisible(true);
	}
}
