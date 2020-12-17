package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class View_Information extends JFrame implements ActionListener{
	
	View_Information(String meter){
		setBounds(300, 250, 850, 650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel title = new JLabel("Customer Information");
		title.setBounds(310, 0, 500, 40);
		title.setFont(new Font("Tehoma", Font.PLAIN, 20));
		add(title);
		
		JLabel l1 =  new JLabel("Name");
		l1.setBounds(70, 80, 100, 20);
		add(l1);
		
		JLabel l2 =  new JLabel();
		l2.setBounds(250, 80, 100, 20);
		add(l2);
		
		JLabel l3 =  new JLabel("Meter Number");
		l3.setBounds(70, 140, 100, 20);
		add(l3);
		
		JLabel l4 =  new JLabel();
		l4.setBounds(250, 140, 100, 20);
		add(l4);
		
		JLabel l5 =  new JLabel("Address");
		l5.setBounds(70, 200, 100, 20);
		add(l5);
		
		JLabel l6 =  new JLabel();
		l6.setBounds(250, 200, 100, 20);
		add(l6);
		
		JLabel l7 =  new JLabel("City");
		l7.setBounds(70, 260, 100, 20);
		add(l7);
		
		JLabel l8 =  new JLabel();
		l8.setBounds(250, 260, 100, 20);
		add(l8);
		
		JLabel l9 =  new JLabel("State");
		l9.setBounds(500, 80, 100, 20);
		add(l9);
		
		JLabel l10 =  new JLabel();
		l10.setBounds(650, 80, 100, 20);
		add(l10);
		
		JLabel l11 =  new JLabel("Email");
		l11.setBounds(500, 140, 100, 20);
		add(l11);
		
		JLabel l12 =  new JLabel();
		l12.setBounds(650, 140, 150, 20);
		add(l12);
		
		JLabel l13 =  new JLabel("Phone");
		l13.setBounds(500, 200, 100, 20);
		add(l13);
		
		JLabel l14 =  new JLabel();
		l14.setBounds(650, 200, 100, 20);
		add(l14);				
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter = '"+meter+"'");
            while(rs.next()){
                l2.setText(rs.getString(1));
                l4.setText(rs.getString(2));
                l6.setText(rs.getString(3));
                l8.setText(rs.getString(4));
                l10.setText(rs.getString(5));
                l12.setText(rs.getString(6));
                l14.setText(rs.getString(7));
            }
        }catch(Exception e){}
		
        JButton b1;	
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLUE);
        b1.setBounds(350, 340, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/info.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(700, 290, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l22  = new JLabel(i3);
        l22.setBounds(120, 350, 600, 300);
        add(l22);
    }   
	public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
	public static void main(String[] args) {
		new View_Information("").setVisible(true);
	}
}
