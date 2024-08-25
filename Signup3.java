
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{

    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    Signup3(String formno){
        
        this.formno=formno;
        setLayout(null);
        
        JLabel l=new JLabel("Page 3: Account Details");
        l.setFont(new Font("Raleway", Font.BOLD ,22));
        l.setBounds(280,40,400,40);
        add(l);
        
        JLabel acctype=new JLabel("Account Type");
        acctype.setFont(new Font("Raleway",Font.BOLD,22));
        acctype.setBounds(100, 140, 200, 30);
        add(acctype);
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,180,20);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,220,20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,180,20);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Reccuring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,180,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card =new JLabel("Card Type");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        
        JLabel number =new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,330,30);
        add(number);
        
        JLabel cdetails =new JLabel("This is your 16 digit card number");
        cdetails.setFont(new Font("Raleway",Font.BOLD,12));
        cdetails.setBounds(100,330,300,20);
        add(cdetails);
        
        
        JLabel pin =new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pdetails =new JLabel("This is your 4 digit pin");
        pdetails.setFont(new Font("Raleway",Font.BOLD,12));
        pdetails.setBounds(100,400,300,20);
        add(pdetails);
        
        JLabel pno =new JLabel("XXXX");
        pno.setFont(new Font("Raleway",Font.BOLD,22));
        pno.setBounds(330,370,200,30);
        add(pno);
        
        JLabel services =new JLabel("Service Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS Card");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above details are correct to my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,10));
        c7.setBounds(100,650,450,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(550,650,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(690,650,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
}

   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String acctype=null;
            if(r1.isSelected()){
                acctype="Savings Account";
            }else if(r2.isSelected()){
                acctype="Fixed Deposit Account";
            }else if(r3.isSelected()){
                acctype="Current Account";
            }else if(r4.isSelected()){
                acctype="Reccuring Deposit Account";
            }
        Random random=new Random();
        String cnumber="" +Math.abs((random.nextLong()%90000000L)+5040936000000000L);
        String pin="" +Math.abs((random.nextLong()% 9000L) +1000L);
        String facility ="";
        if(c1.isSelected())
        {
            facility=facility+"ATM Card";
        }
        else if (c2.isSelected())
        {
            facility=facility+" Internet Banking";
        }
        else if(c3.isSelected())
        {
            facility=facility+"Mobile Banking";
        }
        else if(c4.isSelected())
        {
            facility=facility+"Email & SMS alerts";
        }
        else if(c5.isSelected())
        {
            facility=facility+"Cheque Book";
        }
        else if(c6.isSelected())
        {
            facility=facility+"E Statement";
        }
        
        try
            {
            if(acctype.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }   
            else{
                Con c=new Con();
                String query1 ="insert into Signup3 values('"+formno+"','"+acctype+"','"+cnumber+"','"+pin+"','"+facility+"')";
                String query2 ="insert into login values('"+formno+"','"+cnumber+"','"+pin+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card Number: " +cnumber+ "\n Pin: "+pin);
                setVisible(false);
                new Deposit(pin).setVisible(true);
                
            }
            
            }catch(Exception e){
            System.out.println(e);
            }  
        
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
}
    
      
   public static void main(String args[])
    {
        new Signup3("");
    }
}
