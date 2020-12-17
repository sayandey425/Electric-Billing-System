package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Deposit_Details extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1, b2;
	JLabel l1, l2; 
	Choice c1, c2;
	
	String x[] = {"Meter Number", "Month ", "Units", "Total Bill", "Status"};
	String y[][] = new String[80][8];
	int i=0;
	int j=0;
	
	Deposit_Details(){
		super("Deposit Details");
		setSize(700, 650);
		setLocation(200, 150);
		setLayout(null); 
		getContentPane().setBackground(Color.WHITE);
		
		l1 = new JLabel("Sort by Meter number"); 
		l1.setBounds(20, 20, 150,  20);
		add(l1);
		
		c1 = new Choice();
		
		l2 = new JLabel("Sort by Month"); 
		l2.setBounds(400, 20, 100,  20);
		add(l2);
		
		c1 = new Choice();
		c2 = new Choice();

		
		try {
			Conn c = new Conn();
			String q = "SELECT * FROM bill";
			ResultSet rs = c.s.executeQuery(q);
			
			while(rs.next()) {
				y[i][j++] = rs.getString("meter_number");
				y[i][j++] = rs.getString("month");
				y[i][j++] = rs.getString("unit");
				y[i][j++] = rs.getString("total_bill");
				y[i][j++] = rs.getString("status");
				i++;
				j=0;		
			}
			t1 = new JTable(y,x);
			
			String str = "SELECT * FROM customer";
			rs = c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("meter"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		c1.setBounds(180, 20, 150, 20);
		add(c1);
		
		c2.setBounds(520, 20, 150, 20);
		c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        add(c2);
        
		b1 = new JButton("Search");
		b1.setBounds(20, 70, 80, 20);
	    b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Print");
		b2.setBounds(120, 70, 80, 20);
	    b2.addActionListener(this);
		add(b2);
		
		JScrollPane sp  = new JScrollPane(t1);
		sp.setBounds(0, 100, 700, 650);
		add(sp);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String str = "SELECT * FROM bill WHERE meter = '"+ c1.getSelectedItem()+"' AND month = '"+c2.getSelectedItem()+"'";
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(str);
			}catch(Exception e) {}
		
	    }else if(ae.getSource() == b2){
		try {
			t1.print();
		}catch(Exception e) {}
	  }
	}
	public static void main(String[] args) {
		new Deposit_Details().setVisible(true);
	}
}

