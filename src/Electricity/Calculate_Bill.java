package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Calculate_Bill extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1;
	Choice c1, c2;
	JButton b1, b2;
	JPanel p1;
	
	Calculate_Bill(){
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(173, 216, 230));
		
		l1 = new JLabel("Calculate Electric Bill");
		l1.setBounds(30, 10, 400, 30);
		
		l2 = new JLabel("Meter Number");
		l2.setBounds(100, 70, 100, 30);
		
		JLabel l6 = new JLabel("Name");
		l6.setBounds(100, 120, 100, 30);
		
		JLabel l7 = new JLabel("Address");
		l7.setBounds(100, 170, 100, 30);

		l3 = new JLabel("Unit Consumed");
		l3.setBounds(100, 220, 100, 30);
		
		l4 = new JLabel("Month");
		l4.setBounds(100, 270, 100, 30);
			
		c1 = new Choice();
		c1.setBounds(250, 70, 100, 20);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
			
			while(rs.next()) {
				c1.add(rs.getString("meter"));
			}
		}catch(Exception e) {}
		
		JLabel l10 = new JLabel();
		l10.setBounds(200, 120, 180, 20);
		p1.add(l10);
		
		JLabel l11 = new JLabel();
		l11.setBounds(200, 170, 180, 20);
		p1.add(l11);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter = '"+c1.getSelectedItem()+"' ");
			while(rs.next()) {
				l10.setText(rs.getString("name"));
				l11.setText(rs.getString("address"));
			}
		}catch(Exception e) {}
		c1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				 try {
					 Conn c = new Conn();
					 ResultSet rs = c.s.executeQuery("SELECT * FROM customer WEHERE meter = '"+c1.getSelectedItem()+"'");
					 while(rs.next()) {
						l10.setText(rs.getString("name"));
						l11.setText(rs.getString("address"));
					 }
				 }catch(Exception e) {}
			}
		});
		t1 = new JTextField();
		t1.setBounds(210, 225, 170, 20);

		c2 = new Choice();
		c2.setBounds(210, 270, 170, 20);
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
        
        b1 = new JButton("Submit");
        b1.setBounds(100, 350, 100, 25);
        b1.addActionListener(this);
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLUE);
        
        b2 = new JButton("Cancel");
        b2.setBounds(230, 350, 100, 25);
        b2.addActionListener(this);

        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLUE);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/calcu.jpg"));
        Image i2 = ic1.getImage().getScaledInstance(215, 230,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(i2);
        l5 = new JLabel(ic3);
        
        l1.setFont(new Font("Senserif",Font.PLAIN,26));
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l6);
        p1.add(l7);
        p1.add(c1);
        p1.add(l4);
        p1.add(c2);
        p1.add(l3);
        p1.add(t1);
        p1.add(b1);
        p1.add(b2);
        
        setLayout(new BorderLayout(30, 30));
        
        add(p1, "Center");
        add(l5, "West");
        
        getContentPane().setBackground(Color.WHITE);
        setSize(650, 500);
        setLocation(350, 220);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			
		String meter_no = c1.getSelectedItem();
		String units = t1.getText();
		String month = c2.getSelectedItem();
		
		int units_consumed = Integer.parseInt(units);
		int per_unit = units_consumed * 6; 
		int total = per_unit+30+12+102+20+50;
		
		String q = "INSERT INTO bill values('"+meter_no+"', '"+units+"', '"+month+"', '"+total+"')";
		
		try {
			Conn c1 = new Conn();
			c1.s.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Bill Updated Successfully");
		    this.setVisible(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}else if(ae.getSource() == b2) {
		this.setVisible(false);
	 }
	}
	public static void main(String[] args) {
		new Calculate_Bill().setVisible(true);
	}
}
