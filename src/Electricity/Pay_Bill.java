package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pay_Bill extends JFrame implements ActionListener{
	String meter;
	JButton b1;
	Pay_Bill(String meter){
		this.meter = meter;
		JEditorPane ep = new JEditorPane();
		ep.setEditable(false);
		
		b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLUE);
        b1.setBounds(500, 20, 120, 25);
        b1.addActionListener(this);
        ep.add(b1);
		try {
			ep.setPage("https://paytm.com/electricity-bill-payment");
			
		}catch(Exception e) {
			ep.setContentType("text/html");
            ep.setText("<html>Could not load</html>");
		}
		JScrollPane scrollPane = new JScrollPane(ep);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
		new Payment_info(meter).setVisible(true);
	}
	public static void main(String[] args) {
        new Pay_Bill("").setVisible(true);
	}
}
