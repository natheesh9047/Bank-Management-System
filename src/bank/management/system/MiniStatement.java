package bank.management.system;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class MiniStatement extends JFrame implements ActionListener
{
    String pinnumber;
    JButton exit;
    MiniStatement(String pinnumber)
    {
        this.pinnumber=pinnumber;
    setTitle("Mini Statement");
    setLayout(null);
    
    JLabel mini=new JLabel();
    add(mini);
    
    JLabel bank=new JLabel("Indian Bank");
    bank.setBounds(150,20,100,25);
    bank.setFont(new Font("System",Font.BOLD,16));
    add(bank);
    
    JLabel card=new JLabel();
    card.setBounds(20,80,300,20);
    add(card);
    
    JLabel bal=new JLabel();
    bal.setBounds(20,80,300,20);
    add(bal);
    
    exit =new JButton("Back");
    exit.setBounds(200,400,100,30);
    exit.setForeground(Color.BLACK);
    exit.addActionListener(this);
    add(exit);
    
    try
    {
        Conn c=new Conn();
        String query="select * from login where pin ='"+pinnumber+"';";
        ResultSet rs =c.s.executeQuery(query);
        while(rs.next())
        {
            card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
        }
        
    }catch(Exception e)
    {
        System.out.println(e);
    }
    
    try
    {
        Conn c=new Conn();
        String query="select * from bank where pin ='"+pinnumber+"';";
        ResultSet rs =c.s.executeQuery(query);
        int balance=0;
        while(rs.next())
        {
            mini.setText(mini.getText()+ "<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br>");
            if(rs.getString("type").equals("Deposite"))
                    {
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
        
        }
        bal.setBounds(20,350,300,20);
        bal.setText("Your Current Balance is Rs : "+balance);
        
        
    }catch(Exception e)
    {
        System.out.println(e);
    }
    mini.setBounds(20,140,400,200);
    
    setSize(400,600);
    setLocation(20,20);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    }
    

    public static void main(String args[])
    {
        new MiniStatement(" ");
    }
    
    
    
    public void actionPerformed(ActionEvent ac) {
        if(ac.getSource()==exit)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
}
