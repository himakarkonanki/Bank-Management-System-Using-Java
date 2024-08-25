
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,Signup;
    JTextField cardtextfield;
    JPasswordField pinfield;
    
    Login(){
        setLayout(null);
        setTitle("Automated Teller Machine");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel Cardno=new JLabel("Card No:");
        Cardno.setFont(new Font("osward", Font.BOLD,28));
        Cardno.setBounds(200,145,200,40);
        add(Cardno);
        
        
        cardtextfield=new JTextField();
        cardtextfield.setBounds(350,150,250,30);
        add(cardtextfield);
        
        
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("osward", Font.BOLD,28));
        pin.setBounds(200,190,400,40);
        add(pin);
        
        pinfield=new JPasswordField();
        pinfield.setBounds(350,200,250,30);
        add(pinfield);
        
        login=new JButton("Login");
        login.setBounds(350,250,120,30);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("Clear");
        clear.setBounds(480,250,120,30);
        clear.addActionListener(this);
        add(clear);
        
        Signup=new JButton("Signup");
        Signup.setBounds(419,300,120,30);
        Signup.addActionListener(this);
        add(Signup);
        
        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardtextfield.setText("");
            pinfield.setText("");
            
        }
    
        else if (ae.getSource()== login){
             Con c =new Con();
             String cardnumber= cardtextfield.getText();
             String pinnumber=pinfield.getText();
             String query="select * from login where cnumber= '"+cardnumber+"' and pin='"+pinnumber+"'";
             try{
                 ResultSet rs= c.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null,"Incorrect Card Number & Pin");
                 }
                 
                 
             }catch(Exception e){
                 System.out.println(e);
             }
        } 
        else if(ae.getSource()== Signup){
            setVisible(false);
            new Signup().setVisible(true);
    
        }
}
    public static void main(String[]args)
    {
        new Login();
    }
}
