
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    
    Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        
        JLabel pintext=new JLabel("CHANGE YOUR PIN");
        pintext.setBounds(187,220,500,35);
        pintext.setFont(new Font("SYSTEM",Font.BOLD,15));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        JLabel npin=new JLabel("NEW PIN");
        npin.setBounds(135,280,100,20);
        npin.setFont(new Font("SYSTEM",Font.BOLD,12));
        npin.setForeground(Color.WHITE);
        image.add(npin);
        
        pin=new JPasswordField();
        pin.setFont(new Font("RALEWAY",Font.BOLD,9));
        pin.setBounds(280,280,100,20);
        image.add(pin);
        
        JLabel repintxt=new JLabel("RE-ENTER YOUR PIN");
        repintxt.setBounds(135,310,400,20);
        repintxt.setFont(new Font("SYSTEM",Font.BOLD,12));
        repintxt.setForeground(Color.WHITE);
        image.add(repintxt);
        
        repin=new JPasswordField();
        repin.setFont(new Font("RALEWAY",Font.BOLD,9));
        repin.setBounds(280,310,100,20);
        image.add(repin);
        
        
        change =new JButton("Change");
        change.setBounds(180,390,78,25);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(290,390,78,25);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Pin");
                return;
            }
             if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter Pin");
                return;
            }
             
             Con c =new Con();
             String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
             String query2="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
             String query3="update Signup3 set pin='"+rpin+"' where pin='"+pinnumber+"'";
             
             c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
             c.s.executeUpdate(query3);
             
             JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
             setVisible(false);
             new Transaction(rpin).setVisible(true);
             
        }catch(Exception e){
            System.out.println(e);
        }
        
        }else{
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
                }
        
    }
    
    
    
    public static void main(String[] args){
        
        new Pinchange("").setVisible(true);
        
    }
}
