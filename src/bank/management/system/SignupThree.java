package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public  class SignupThree extends JFrame implements ActionListener
{
  JRadioButton r1,r2,r3,r4;
  JCheckBox s1,s2,s3,s4,s5,s6;
  JButton submit,cancel;
  String formno;
    
    SignupThree(String formno)
    {
        this.formno=formno;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 =il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        JLabel j1 =new JLabel("PAGE 3:ACCOUNT DETAILS."+formno);
        j1.setFont(new Font("Raleway",Font.BOLD,22));
        j1.setBounds(280,40,400,40);
        add(j1);
        
        JLabel type=new JLabel("ACCOUNT TYPE");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("SAVINGS ACCOUNT");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(150, 180, 250, 20);
        add(r1);
        
        r2=new JRadioButton("CURRENT ACCOUNT");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(500, 180, 350, 20);
        add(r2);
        
        r3=new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(150, 230, 350, 20);
        add(r3);
        
        r4=new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(500, 230, 550, 20);
        add(r4);
        
        ButtonGroup typegroup=new ButtonGroup();
        typegroup.add(r1);
        typegroup.add(r2);
        typegroup.add(r3);
        typegroup.add(r4);
        
        JLabel card=new JLabel("CARD: ");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,280,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4118");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(300,280,350,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 digit account number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,300,350,30);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN NUMBER: ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,330,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(300,330,200,30);
        add(pnumber);
        
        JLabel pindetail=new JLabel("Your 4 digit password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,350,350,30);
        add(pindetail);
        
        
        JLabel service=new JLabel("SERVICES REQUIRED");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100,400,300,30);
        add(service);
        
        s1=new JCheckBox("ATM CARD");
        s1.setFont(new Font("Raleway",Font.BOLD,16));
        s1.setBackground(Color.WHITE);
        s1.setBounds(150, 430, 250, 20);
        add(s1);
        
        s2=new JCheckBox("E-STATEMENT");
        s2.setFont(new Font("Raleway",Font.BOLD,16));
        s2.setBackground(Color.WHITE);
        s2.setBounds(500, 430, 350, 20);
        add(s2);
        
        s3=new JCheckBox("MOBILE BANKING");
        s3.setFont(new Font("Raleway",Font.BOLD,16));
        s3.setBackground(Color.WHITE);
        s3.setBounds(150, 470, 350, 20);
        add(s3);
        
        s4=new JCheckBox("EMAIL & SMS ALERT");
        s4.setFont(new Font("Raleway",Font.BOLD,16));
        s4.setBackground(Color.WHITE);
        s4.setBounds(500, 470, 550, 20);
        add(s4);
        
        s6=new JCheckBox("CHEQUE BOOK");
        s6.setFont(new Font("Raleway",Font.BOLD,16));
        s6.setBackground(Color.WHITE);
        s6.setBounds(150, 510, 550, 20);
        add(s6);
        
        s5=new JCheckBox("I hereby declared that the above entered details are correct to best of my knowledege");
        s5.setFont(new Font("Raleway",Font.BOLD,14));
        s5.setBackground(Color.WHITE);
        s5.setBounds(50, 550, 700, 20);
        add(s5);
        
        submit=new JButton("SUMBIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150, 650, 100, 30);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        submit.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource() == submit)
        {
            String accounttype =null;
            if(r1.isSelected())
            {
                accounttype="SAVINGS ACCOUNT";
            }
            else if(r2.isSelected())
            {
                accounttype="CURRENT ACCOUNT";
            }
            else if(r3.isSelected())
            {
                accounttype="FIXED DEPOSIT ACCOUNT";
            }
            else if(r4.isSelected())
            {
                accounttype="RECURRING DEPOSIT ACCOUNT";
            }
            
            Random random =new Random();
            String cardnumber = "" + Math.abs((random.nextLong()% 90000000L) + 5040936000000000L);
            String pinnumber ="" +Math.abs((random.nextLong()%9000L)+1000L);
            String facility ="";
            if(s1.isSelected())
            {
                facility=facility+" ATM CARD";
            }
            if(s2.isSelected())
            {
                facility=facility+" INTERNET BANKING";
            }
            if(s3.isSelected())
            {
                facility=facility+" MOBILE BANKING";
            }
            if(s4.isSelected())
            {
                facility=facility+" EMAIL & SMS ALERT";
            }
            if(s6.isSelected())
            {
                facility=facility+" CHEQUE BOOK";
            }
            try
            {
                if(accounttype.equals("")){
                JOptionPane.showMessageDialog(null, "Select the Account Type please"); 
            }
                else
                {
                Conn c=new Conn();
                String query="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"');";
                String query1="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"');";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Card Number : "+cardnumber+"\nPin number: "+pinnumber);
                setVisible(false);
                new Deposite(pinnumber).setVisible(true);
                
                }
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
        else if(ac.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new SignupThree(" ");
    }
}
