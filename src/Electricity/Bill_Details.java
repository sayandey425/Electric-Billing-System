package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bill_Details extends JFrame {
	
	JTable t1;
	String x[] = {"Meter Number", "Month ", "Units", "Total Bill", "Status"};
	String y[][] = new String[80][8];
	int i=0;
	int j=0;
	
	Bill_Details(String meter){
		super("Bill Details");
		setSize(700, 650);
		setLocation(200, 150);
		setLayout(null); 
		getContentPane().setBackground(Color.WHITE);
		
		try {
			Conn c = new Conn();
			String q = "SELECT * FROM bill WHERE meter = " +meter;
			ResultSet rs = c.s.executeQuery(q);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane sp  = new JScrollPane(t1);
		sp.setBounds(0, 0, 700, 650);
		add(sp);
	}
	public static void main(String[] args) {
		new Bill_Details("").setVisible(true);
	}
}
