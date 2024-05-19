
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite,withdrawal,balance,ministatement,pinchange,exit;
    String pinnumber;
    Transaction(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(210, 300, 700, 35);
        image.add(text);
        
        deposite =new JButton("Deposite");
        deposite.setBounds(160,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawal =new JButton("Cash Withdrawal");
        withdrawal.setBounds(160,450,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        
        
        ministatement =new JButton("Mini Statement");
        ministatement.setBounds(160,485,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        balance =new JButton("Balance Enquiry");
        balance.setBounds(355,415,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        pinchange =new JButton("Pin Change");
        pinchange.setBounds(355,450,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        exit =new JButton("Exit");
        exit.setBounds(355,485,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==exit)
        {
            System.exit(0);
        }else if(ac.getSource()==deposite)
        {
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }else if(ac.getSource()==withdrawal)
        {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ac.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ac.getSource()==balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ac.getSource()==ministatement)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Transaction(" ");
    }
    
}
