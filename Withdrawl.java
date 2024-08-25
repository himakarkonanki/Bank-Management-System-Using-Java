
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel txt=new JLabel("Enter Amount you want to Withdraw");
        txt.setBounds(155,210,500,35);
        txt.setFont(new Font("SYSTEM",Font.BOLD,12));
        txt.setForeground(Color.WHITE);
        image.add(txt);
        
        
        amount =new JTextField();
        amount.setFont(new Font("SYSTEM",Font.BOLD,12));
        amount.setBounds(175, 270, 150, 25);
        image.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setFont(new Font("SYSTEM", Font.BOLD,12));
        withdraw.setBounds(290, 360, 100, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
             if(ae.getSource()==withdraw){
                 String number=amount.getText();
                 Date date=new Date();
                 if (number.equals(" ")){
                     JOptionPane.showMessageDialog(null,"Please Enter Amount You want to withdraw");
                 }else{
                     try{
                     Con c=new Con();
                     String query=" insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                     c.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(null,"Rs" +number+ "Withdrawn Successfully");
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
        new Withdrawl("");
    }
}
