package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_Information extends JFrame implements ActionListener{
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JLabel l11, l12;
	JButton b1, b2;
	String meter;
	Update_Information(String meter){
        this.meter = meter;
		setBounds(400, 220, 1050, 450);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel title = new JLabel("Update Customer Information");
		title.setBounds(400, 0, 400, 30);
		title.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(title);
		
		JLabel l1 = new JLabel("Name :");
		l1.setBounds(30, 70, 200, 40);
		l1.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l1);
		
		 l11 = new JLabel();
		l11.setBounds(230, 70, 200, 40);
		l11.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l11);
		
		JLabel l2 = new JLabel("Meter number :");
		l2.setBounds(30, 110, 200, 40);
		l2.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l2);
		
		 l12 = new JLabel();
		l12.setBounds(230, 110, 200, 40);
		l12.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l12);
		
		JLabel l3 = new JLabel("Address :");
		l3.setBounds(30, 150, 200, 40);
		l3.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(230, 160, 200, 20);
		add(t1);
		
		JLabel l4 = new JLabel("City :");
		l4.setBounds(30, 190, 200, 40);
		l4.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(230, 199, 200, 20);
		add(t2);
		
		JLabel l5 = new JLabel("State :");
		l5.setBounds(30, 230, 200, 40);
		l5.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(230, 240, 200, 20);
		add(t3);
		
		JLabel l6 = new JLabel("Email :");
		l6.setBounds(30, 270, 200, 40);
		l6.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(230, 280, 200, 20);
		add(t4);
		
		JLabel l7 = new JLabel("Phone :");
		l7.setBounds(30, 310, 200, 40);
		l7.setFont(new Font("Tehoma", Font.PLAIN, 18));
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(230, 320, 200, 20);
		add(t5);
		
		b1 = new JButton("Update");
		b1.addActionListener(this);
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLUE);
		b1.setBounds(90, 370, 120, 25);
		add(b1); 
		
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.BLUE);
		b2.setBounds(250, 369, 120, 25);
		add(b2); 
		
		try {
		   Conn c = new Conn();
		   ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter = '"+meter+"'");
		   while(rs.next()) {
			   l11.setText(rs.getString(1));
			   l12.setText(rs.getString(2));
			   t1.setText(rs.getString(3));
			   t2.setText(rs.getString(4));
			   t3.setText(rs.getString(5));
			   t4.setText(rs.getString(6));
			   t5 .setText(rs.getString(7));
		   }
		}catch(Exception e) {
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateinfo.png"));
	        Image i2  = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel l8  = new JLabel(i3);
	        l8.setBounds(550, 50, 400, 300);
	        add(l8);
		}
	} 
	    public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == b1){
	            String s1 = l11.getText();
	            String s2 = l12.getText();
	            String s3 = t1.getText();
	            String s4 = t2.getText();
	            String s5 = t3.getText();
	            String s6 = t4.getText();
	            String s7 = t5.getText();
	            
	            try{
	                Conn c = new Conn();
	                c.s.executeUpdate("UPDATE customer SET address = '"+s3+"', city = '"+s4+"', state = '"+s5+"', email = '"+s6+"', phone = '"+s7+"' WHERE meter = '"+meter+"'");
	                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
	                this.setVisible(false);
	                
	            }catch(Exception e){}
	            
	        }else if(ae.getSource() == b2){
	            this.setVisible(false);
	        }
	    }
	public static void main(String[] args) {
		new Update_Information("").setVisible(true);

	}

}
