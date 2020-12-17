package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Payment_info extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l10, l11, l12, l13, l14, l15;
	JTextField t1;
	Choice c1, c2;
	JButton b1, b2;
	String meter;
	Payment_info(String meter){
		this.meter = meter;
		setBounds(550, 220, 900, 600);
        setLayout(null);
		JLabel title = new JLabel("Electricity Bill");
		title.setFont(new Font("Tehoma", Font.PLAIN, 26));
		title.setBounds(120, 10, 400, 30);
		add(title); 
		
		l1 = new JLabel("Meter Number :");
		l1.setBounds(35, 80, 200, 20);
		add(l1);
		
		JLabel l10 = new JLabel();
		l10.setBounds(300, 80, 200, 20);
		add(l10);
		
		JLabel l2 = new JLabel("Name :");
		l2.setBounds(35, 140, 200, 20);
		add(l2);

		JLabel l11 = new JLabel();
		l11.setBounds(300, 140, 200, 20);
		add(l11);
		
		JLabel l3 = new JLabel("Month :");
		l3.setBounds(35, 200, 200, 20);
		add(l3);

		c1 = new Choice();
		c1.setBounds(300, 200, 200, 20);
		c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);

		l4 = new JLabel("Unit Consumed :");
		l4.setBounds(35, 260, 200, 20);
		add(l4);

		JLabel l12 = new JLabel();
		l12.setBounds(300, 260, 200, 20);
		add(l11);
		
		l5 = new JLabel("Total Bill :");
		l5.setBounds(35, 320, 200, 20);
		add(l5);

		JLabel l13 = new JLabel();
		l13.setBounds(300, 320, 200, 20);
		add(l13);
		
		l6 = new JLabel("Status :");
		l6.setBounds(35, 380, 200, 20);
		add(l6);

		JLabel l14 = new JLabel();
		l14.setBounds(300, 380, 200, 20);
		l14.setForeground(Color.RED);
		add(l14);
		
		
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter = '"+meter+"' ");
			while(rs.next()) {
				l10.setText(rs.getString("meter number"));
				l11.setText(rs.getString("name"));
			}
			rs = c.s.executeQuery("SELECT * FROM bill WHERE meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
			while(rs.next()){
				l12.setText(rs.getString("units"));
				l13.setText(rs.getString("total_bill"));
				l14.setText(rs.getString("status"));
			}
	}catch(Exception e) {}
		c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				 try {
					 Conn c = new Conn();
					 ResultSet rs = c.s.executeQuery("SELECT * FROM bill WEHERE meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
					 while(rs.next()) {
						l12.setText(rs.getString("units"));
						l13.setText(rs.getString("total_bill"));
						l14.setText(rs.getString("status"));
					 }
				 }catch(Exception e) {}
			}
		});
		t1 = new JTextField();
		t1.setBounds(210, 225, 170, 20);

        b1 = new JButton("Pay");
        b1.setBounds(100, 460, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(230, 460, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLUE);

        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLUE);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.png"));
        Image i2 = ic1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(ic3);
        l21.setBounds(350, 120, 600, 300);
        add(l21);
        
        getContentPane().setBackground(Color.WHITE);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
		try {
			Conn c = new Conn();
			c.s.executeUpdate("UPDATE bill status = 'Paid' WHERE meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");	
		}catch(Exception e) {
			this.setVisible(false);
			new Pay_Bill(meter).setVisible(true);
		}
	}else if(ae.getSource() == b2) {
		this.setVisible(false);
	 }
	}
	public static void main(String[] args) {
		new Payment_info("").setVisible(true);
	}
}
