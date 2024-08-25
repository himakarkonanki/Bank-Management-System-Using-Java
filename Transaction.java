
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JButton dep,cashwithdrawl,pchange,mstmt,fastcash,bal,exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        
        JLabel txt=new JLabel("Please select your Transactions");
        txt.setBounds(140,220,500,35);
        txt.setFont(new Font("SYSTEM",Font.BOLD,16));
        txt.setForeground(Color.WHITE);
        image.add(txt);
        
        JLabel txt1=new JLabel("Bank Ante Temple");
        txt1.setBounds(220,270,500,35);
        txt1.setFont(new Font("SYSTEM",Font.BOLD,12));
        txt1.setForeground(Color.WHITE);
        image.add(txt1);
        
        
        dep=new JButton("Deposit");
        dep.setBounds(125,323,120,25);
        dep.setFont(new Font("SYSTEM",Font.BOLD,10));
        dep.setBackground(Color.WHITE);
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        image.add(dep);
        
        cashwithdrawl =new JButton("Withdrawl");
        cashwithdrawl.setBounds(125,350,120,25);
        cashwithdrawl.setFont(new Font("System",Font.BOLD,9));
        cashwithdrawl.setBackground(Color.WHITE);
        cashwithdrawl.setForeground(Color.BLACK);
        cashwithdrawl.addActionListener(this);
        image.add(cashwithdrawl);
        
        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(280,323,120,25);
        fastcash.setFont(new Font("System",Font.BOLD,9));
        fastcash.setBackground(Color.WHITE);
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mstmt =new JButton("Mini Statement");
        mstmt.setBounds(280,350,120,25);
        mstmt.setFont(new Font("System",Font.BOLD,9));
        mstmt.setBackground(Color.WHITE);
        mstmt.setForeground(Color.BLACK);
        mstmt.addActionListener(this);
        image.add(mstmt);
        
        pchange =new JButton("Pin Change");
        pchange.setBounds(280,377,120,25);
        pchange.setFont(new Font("System",Font.BOLD,9));
        pchange.setBackground(Color.WHITE);
        pchange.setForeground(Color.BLACK);
        pchange.addActionListener(this);
        image.add(pchange);
        
        bal =new JButton("Check Balance");
        bal.setBounds(125,377,120,23);
        bal.setFont(new Font("System",Font.BOLD,9));
        bal.setBackground(Color.WHITE);
        bal.setForeground(Color.BLACK);
        bal.addActionListener(this);
        image.add(bal);
        
        exit =new JButton("Exit");
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
            System.exit(0);
            
        }else if(ae.getSource() == dep){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);    
        }else if(ae.getSource()==cashwithdrawl){
                 setVisible(false);
                 new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash){
                setVisible(false);
                new Fastcash(pinnumber).setVisible(true);
        }else if (ae.getSource()==pchange){
                setVisible(false);
                new Pinchange(pinnumber).setVisible(true);
        }else if (ae.getSource()==bal){
                setVisible(false);
                new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==mstmt){
                new MiniStatement (pinnumber).setVisible(true);
        }
    }
    
    
    
    
    public static void main(String[] args){
        new Transaction(" ");
    }
}

