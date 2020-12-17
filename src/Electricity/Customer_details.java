package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Customer_details extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1;
	
	String x[] = {"Customer Name", "Meter No.", "Address", "City", "State", "Email", "Phone"};
	String y[][] = new String[1000][8];
	int i=0;
	int j=0;
	
	Customer_details(){
		super("Customer Details");
		setSize(1200, 650);
		setLocation(200, 200);
		
		try {
			Conn c1 = new Conn();
			String q = "SELECT * FROM customer";
			ResultSet rs = c1.s.executeQuery(q);
			
			while(rs.next()) {
				y[i][j++] = rs.getString("name");
				y[i][j++] = rs.getString("meter");
				y[i][j++] = rs.getString("address");
				y[i][j++] = rs.getString("city");
				y[i][j++] = rs.getString("state");
				y[i][j++] = rs.getString("email");
				y[i][j++] = rs.getString("phone");
				i++;
				j=0;		
			}
			t1 = new JTable(y,x);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		b1 = new JButton("Print");
		add(b1, "South");
		b1.addActionListener(this);
		
		JScrollPane sp = new JScrollPane(t1);
		add(sp);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			t1.print();
		}catch(Exception e) {}
	}
	public static void main(String[] args) {
		new Customer_details().setVisible(true);
	}
}
