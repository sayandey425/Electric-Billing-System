package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JLabel l1, l2, l3, l4, l5;
	JTextField t1;
	JPasswordField pf2;
	JButton b1, b2, b3;
	JPanel p1, p2, p3, p4;
	Choice c1;
	
	Login(){
		super("Login");
		setLayout(null);  
		getContentPane().setBackground(Color.white);
		
		l1 = new JLabel("Username :");
		l1.setBounds(300, 20, 100, 20);
		add(l1);
		l2 = new JLabel("Password :");
		l2.setBounds(300, 60, 100, 20);
		add(l2);
		l4 = new JLabel("Logging In As :");
		t1 = new JTextField(15);
		t1.setBounds(380, 20, 180, 20);
		add(t1);
		pf2 = new JPasswordField(15);
		pf2.setBounds(380, 60, 180, 20);
		add(pf2);
		
		l4 = new JLabel("Logging In As: ");
		l4.setBounds(300, 100, 100, 20);
		add(l4);
		c1 = new Choice();
		c1.add("Customer");
		c1.add("Admin");
		c1.setBounds(399, 100, 163, 20);
		add(c1);
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b1 = new JButton("Login", new ImageIcon(i1));
		b1.setBounds(350, 160, 100, 20);
		add(b1);
		
		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
		Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);	
		b2 = new JButton("Cancel", new ImageIcon(i2));
		b2.setBounds(480, 160, 100, 20);
		add(b2);
		
		l5 = new JLabel("New User ?");
		l5.setBounds(330, 210, 100, 20);
		add(l5);
		ImageIcon ic5 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i4 = ic5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		b3 = new JButton("Sign Up", new ImageIcon(i4));
		b3.setBounds(420, 210, 100, 20);
		add(b3);
	
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		
		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icons/log.png"));
		Image i3 = ic3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon ic4 = new ImageIcon(i3);
		l3 = new JLabel(ic4);
		l3.setBounds(0, 0, 250, 250);
		add(l3);
		setLayout(new BorderLayout());
		
		setSize(640,300);
        setLocation(600,300);
        setVisible(true);

	}	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
		try {
			Conn c = new Conn();
			String a = t1.getText();
			String b = pf2.getText();
			String user = c1.getSelectedItem();
			String q  = "SELECT * FROM login WHERE username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
			
			ResultSet rs = c.s.executeQuery(q);
			
			if(rs.next()) {
				String meter = rs.getString("meter_number");
				new Homepage(meter, user).setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Login");
				t1.setText("");
				pf2.setText("");
			}
		}catch(Exception e) {
			 e.printStackTrace();
	            System.out.println("error: "+e);
		}
	  }else if(ae.getSource() == b2){
		  this.setVisible(false);
		  
	  }else if(ae.getSource() == b3) {
		  this.setVisible(false);
		  new Signup().setVisible(true);
	  }
	}
	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
