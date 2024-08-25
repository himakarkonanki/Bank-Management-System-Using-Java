package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel txt=new JLabel("Enter Amount you want to deposit");
        txt.setBounds(155,210,500,35);
        txt.setFont(new Font("SYSTEM",Font.BOLD,12));
        txt.setForeground(Color.WHITE);
        image.add(txt);
        
        
        amount =new JTextField();
        amount.setFont(new Font("SYSTEM",Font.BOLD,12));
        amount.setBounds(175, 270, 150, 25);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("SYSTEM", Font.BOLD,12));
        deposit.setBounds(310, 360, 80, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setFont(new Font("SYSTEM", Font.BOLD,12));
        back.setBounds(120, 360, 80, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource()==deposit){
                 String number=amount.getText();
                 Date date=new Date();
                 if (number.equals(" ")){
                     JOptionPane.showMessageDialog(null,"Please Enter Amount You want to Deposit");
                 }else{
                     try{
                     Con c=new Con();
                     String query=" insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"Rs"+number + "Deposited Successfully");
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                     }catch(Exception e){
                         System.out.println(e);
                     }
                 }
             }else if(ae.getSource()==back){
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
             }
    }
    
    public static void main(String[] args){
        new Deposit("");
    }
}
