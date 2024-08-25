
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    
    JButton dep,cashwithdrawl,pchange,mstmt,fastcash,bal,exit;
    String pinnumber;
    
    Fastcash(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        
        JLabel txt=new JLabel("SELECT WITHDRAWL AMOUNT");
        txt.setBounds(148,220,500,35);
        txt.setFont(new Font("SYSTEM",Font.BOLD,15));
        txt.setForeground(Color.WHITE);
        image.add(txt);
        
        
        dep=new JButton("Rs 100");
        dep.setBounds(125,323,120,25);
        dep.setFont(new Font("SYSTEM",Font.BOLD,10));
        dep.setBackground(Color.WHITE);
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        image.add(dep);
        
        cashwithdrawl =new JButton("Rs 500");
        cashwithdrawl.setBounds(125,350,120,25);
        cashwithdrawl.setFont(new Font("System",Font.BOLD,9));
        cashwithdrawl.setBackground(Color.WHITE);
        cashwithdrawl.setForeground(Color.BLACK);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);
        
        fastcash =new JButton("Rs 1000");
        fastcash.setBounds(280,323,120,25);
        fastcash.setFont(new Font("System",Font.BOLD,9));
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mstmt =new JButton("Rs 2000");
        mstmt.setBounds(280,350,120,25);
        mstmt.setFont(new Font("System",Font.BOLD,9));
        mstmt.setBackground(Color.WHITE);
        mstmt.setForeground(Color.BLACK);
        mstmt.addActionListener(this);
        image.add(mstmt);
        
        pchange =new JButton("Rs 5000");
        pchange.setBounds(280,377,120,25);
        pchange.setFont(new Font("System",Font.BOLD,9));
        pchange.setBackground(Color.WHITE);
        pchange.setForeground(Color.BLACK);
        pchange.addActionListener(this);
        image.add(pchange);
        
        bal =new JButton("Rs 10000");
        bal.setBounds(125,377,120,23);
        bal.setFont(new Font("System",Font.BOLD,9));
        bal.setBackground(Color.WHITE);
        bal.setForeground(Color.BLACK);
        bal.addActionListener(this);
        image.add(bal);
        
        exit =new JButton("Back");
        exit.setBounds(280,404,120,23);
        exit.setFont(new Font("System",Font.BOLD,9));
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);    
        } 
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Con c =new Con();
            try{
                ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                         balance-=Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(ae.getSource()!= exit && balance < Integer.parseInt(amount))
                {
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+ amount + " Debited Successfully ");
                 
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
                 
            }catch(Exception e){
                System.out.println(ae);
            }
        }
        
    }
    
    
    
    
    
    public static void main(String[] args){
        new Fastcash("");
    }
}

