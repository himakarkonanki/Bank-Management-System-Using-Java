
package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener {
    
    MiniStatement(String pinnumber){
    
        JLabel mini=new JLabel();
        add(mini);
        
        JLabel bank =new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        try{
            Con c =new Con();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cnumber").substring(0,4)+"XXXXXXXX"  + rs.getString("cnumber").substring(12,16));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Con c =new Con();
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br><html>");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        mini.setBounds(20,140,400,200);
    setLayout(null);    
    setSize(400,600);
    setLocation(20,20);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);

        
    }
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        
    }
    
    public static void main(String[] args){
        new MiniStatement("");
}
}