

package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    
    long random;
    JTextField nametextfield,fnametextfield,emailtextfield,addtextfield,citytextfield,pincodetextfield,statetextfield;
    JButton next;
    JRadioButton male,female,single,married,others;
    JDateChooser dobtextfield;
    
    Signup(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("Application Form No: " +random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel Personaldetails =new JLabel("Page 1: Personal Details");
        Personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        Personaldetails.setBounds(290,80,400,30);
        add(Personaldetails);
        
        JLabel name =new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nametextfield=new JTextField();
        nametextfield.setBounds(300,140,350,30);
        add(nametextfield);
        
        JLabel fname =new JLabel("Fathers Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,150,30);
        add(fname);
        
        fnametextfield=new JTextField();
        fnametextfield.setBounds(300,190,350,30);
        add(fnametextfield);
        
        JLabel dob =new JLabel("DOB:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,100,30);
        add(dob);
        
        dobtextfield=new JDateChooser();
        dobtextfield.setBounds(300,240,350,30);
        add(dobtextfield);
        
        JLabel gender =new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,150,30);
        add(gender);
        
        male =new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(360,290,90,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email =new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,150,30);
        add(email);
        
        emailtextfield=new JTextField();
        emailtextfield.setBounds(300,340,350,30);
        add(emailtextfield);
        
        JLabel marital =new JLabel("Maritial Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,150,30);
        add(marital);
        
        single=new JRadioButton("Single");
        single.setBounds(300,390,60,30);
        single.setBackground(Color.WHITE);
        add(single);
        
        married=new JRadioButton("Married");
        married.setBounds(420,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        others=new JRadioButton("Other");
        others.setBounds(540,390,210,30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup status=new ButtonGroup();
        status.add(single);
        status.add(married);
        status.add(others);
        
        JLabel address =new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,150,30);
        add(address);
        
        addtextfield=new JTextField();
        addtextfield.setBounds(300,440,350,30);
        add(addtextfield);
        
        JLabel city =new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,150,30);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setBounds(300,490,350,30);
        add(citytextfield);
        
        JLabel state =new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,150,30);
        add(state);
        
        statetextfield=new JTextField();
        statetextfield.setBounds(300,540,350,30);
        add(statetextfield);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont (new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,150,30);
        add(pincode);
        
        pincodetextfield=new JTextField();
        pincodetextfield.setBounds(300,590,350,30);
        add(pincodetextfield);
        
        next=new JButton();
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,10));
        next.setBounds(570,660,80,29);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
  }
public void actionPerformed(ActionEvent ae){
    String formno=" "+random;
    String name=nametextfield.getText();
    String fname=fnametextfield.getText();
    String dob=((JTextField)dobtextfield.getDateEditor().getUiComponent()).getText();
    String gender=null;
    if(male.isSelected()){
        gender="Male";
    }else if(female.isSelected()){
        gender="Female";
    }
    
    String email=emailtextfield.getText();
    String marital=null;
    if(single.isSelected()){
        marital="Single";
    }else if(married.isSelected()){
        marital="Married";
    }else if(others.isSelected()){
        marital="others";
}
    String address=addtextfield.getText();
    String state=statetextfield.getText();
    String city=citytextfield.getText();
    String pincode=pincodetextfield.getText();
    
    try{
        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is  required");
        }else{
            Con c = new Con();
            String query="insert into signupform values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new Signup2(formno).setVisible(true);
        }
       
        
        
    }catch(Exception e){
        System.out.println(e);
        
    }
    
}
public static void main(String[]args){
      new Signup();
}
}