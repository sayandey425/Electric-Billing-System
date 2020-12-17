package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_Bill extends JFrame implements ActionListener {
	
	JLabel l1, l2;
	JTextArea t1;
	JPanel p1;
	Choice c2;
	JButton b1;
	String meter;
	Generate_Bill(String meter){
		this.meter = meter;
		setSize(500, 900);
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		l1 = new JLabel("Generate Bill");
		l2 = new JLabel(meter);
		
		c2 = new Choice();
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
        
        t1 = new JTextArea(50, 15);
        t1.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        JScrollPane sp = new JScrollPane();
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        
        b1 = new JButton("Generate Bill");
        b1.addActionListener(this);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(c2);
        
        add(p1,"North");
        add(sp,"Center");
        add(b1,"South");
         
        setLocation(350, 40);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			Conn c = new Conn();
			String month = c2.getSelectedItem();
			t1.setText("\tWest Bengal State Electricity Distribution Company Limited\nELECTRICITY BILL FOR THE MONTH OF" +month+ ",2021\n\n\n");
			
			ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_number=" +meter);
			
			if(rs.next()) {
				t1.append("\n    Customer Name: "+rs.getString("name"));
				t1.append("\n    Meter Number:  "+rs.getString("meter_number"));
				t1.append("\n    Address:       "+rs.getString("address"));
				t1.append("\n    State:         "+rs.getString("state"));
				t1.append("\n    City:          "+rs.getString("city"));
				t1.append("\n    Email:         "+rs.getString("email"));
				t1.append("\n    Phone Number:  "+rs.getString("phone"));
				t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
			}
			 rs = c.s.executeQuery("SELECT * FROM meter_info WHERE meter_number = "+meter);
	            
	            if(rs.next()){
	                t1.append("\n    Meter Location: "+rs.getString("meter_location"));
	                t1.append("\n    Meter Type:     "+rs.getString("meter_type"));
	                t1.append("\n    Phase Code:     "+rs.getString("phase_code"));
	                t1.append("\n    Bill Type:      "+rs.getString("bill_type"));
	                t1.append("\n    Days:           "+rs.getString("days"));
	                t1.append("\n");
	                t1.append("---------------------------------------------------------------");
	                t1.append("\n\n");
	                t1.append("\n    Meter Rent:    Rs. "+rs.getString("meter_rent"));
	                t1.append("\n    MCB Rent:      Rs. "+rs.getString("mcb_rent"));
	                t1.append("\n    Service Tax:   Rs. "+rs.getString("service_rent"));
	                t1.append("\n    GST@9%:        Rs. "+rs.getString("gst"));
	                t1.append("\n");
	                
	            }
	            
	            rs = c.s.executeQuery("SELECT * FROM bill WHERE meter_number= "+meter+" AND month = '"+c2.getSelectedItem()+"'");
	            
	            if(rs.next()){
	                t1.append("\n    Current Month :\t"+rs.getString("month"));
	                t1.append("\n    Units Consumed:\t"+rs.getString("units"));
	                t1.append("\n    Total Charges :\t"+rs.getString("amount"));
	                t1.append("\n---------------------------------------------------------------");
	                t1.append("\n    TOTAL PAYABLE :\t"+rs.getString("amount"));
	            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Generate_Bill("").setVisible(true);
	}
}
