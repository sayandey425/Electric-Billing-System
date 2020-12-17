package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener{
	
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l11;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2;
	
	NewCustomer(){
		setLocation(350, 200);
		setSize(650, 600);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		p.setBackground(new Color(173,  216, 230));
		
		JLabel title = new JLabel("New Customer");
		title.setBounds(100, 10, 200, 20);
		title.setFont(new Font("Tehoma", Font.PLAIN, 24));
		p.add(title);
		
		l1 = new JLabel("Name");
		l1.setBounds(100, 80, 100, 20);
		t1 = new JTextField();
		t1.setBounds(240, 80, 200, 20);
		p.add(l1);
		p.add(t1);
		
		l2 = new JLabel("Meter Number");
		l2.setBounds(100, 120, 100, 20);
		l11 = new JLabel();
		l11.setBounds(240, 120, 200, 20);
		p.add(l2);
		p.add(l11);
		
		l3 = new JLabel("Address");
		l3.setBounds(100, 160, 100, 20);
		t3 = new JTextField();
		t3.setBounds(240, 160, 200, 20);
		p.add(l3);
		p.add(t3);
		
		l5 = new JLabel("City");
		l5.setBounds(100, 200, 100, 20);
		t5 = new JTextField();
		t5.setBounds(240, 200, 200, 20);
		p.add(l5);
		p.add(t5);
		
		l4 = new JLabel("State");
		l4.setBounds(100, 240, 100, 20);
		t4 = new JTextField();
		t4.setBounds(240, 240, 200, 20);
		p.add(l4);
		p.add(t4);
		
		l6 = new JLabel("Email Id:");
		l6.setBounds(100, 280, 100, 20);
		t6 = new JTextField();
		t6.setBounds(240, 280, 200, 20);
		p.add(l6);
		p.add(t6);
		
		l7 = new JLabel("Phone Number");
		l7.setBounds(100, 320, 100, 20);
		t7 = new JTextField();
		t7.setBounds(240, 320, 200, 20);
		p.add(l7);
		p.add(t7);
		
		b1 = new JButton("Next");
		b1.setBounds(120, 390, 100, 20);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		b2.setBounds(250, 390, 100, 20);
		b2.addActionListener(this);
		
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.BLUE);
		
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.BLUE);
		
		p.add(b1);
		p.add(b2);
		
		setLayout(new BorderLayout());
		add(p, "Center");
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcus.jpg"));
		Image i1 = ic1.getImage().getScaledInstance(190, 500, Image.SCALE_DEFAULT);
		ImageIcon ic2 = new ImageIcon(i1);
		l8 = new JLabel(ic2);
		add(l8, "West");
		
		getContentPane().setBackground(Color.WHITE);
		
		Random ran = new Random();
		long first = (ran.nextLong() % 1000000L);
		l11.setText(""+(Math.abs(first)));
	}
	public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

		String name = t1.getText();
		String meter = t2.getText();
		String address = t3.getText();
		String city = t4.getText();
		String state = t5.getText();
		String email= t6.getText();
		String phone = t7.getText();
		String q = "INSERT INTO customer values('"+name+"', '"+meter+"', '"+address+"', '"+city+"', '"+state+"', '"+email+"', '"+phone+"')";
		String q2 = "INSERT INTO Login values('"+meter+"','', '', '', '')";
		try {
			Conn c1 = new Conn();
			c1.s.executeUpdate(q);
			c1.s.executeUpdate(q2);
			JOptionPane.showMessageDialog(null, "Thank you for joining WBSEDCL family");
			this.setVisible(false);
			new MeterInfo(meter).setVisible(true);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
       }else if(ae.getSource() == b2) {
            this.setVisible(false);
        }
	}
	public static void main(String[] args) {
		new NewCustomer().setVisible(true);
	}
}
