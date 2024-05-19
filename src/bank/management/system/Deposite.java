package bank.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class Deposite extends JFrame implements ActionListener
{
    JButton deposite,back;
    JTextField amount;
    String pinnumber;
    Deposite(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposite");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);
        
        deposite =new JButton("Deposite");
        deposite.setBounds(160,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        back =new JButton("Back");
        back.setBounds(355,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Deposite(" ");
    }

    @Override
    public void actionPerformed(ActionEvent ac) 
    {
        if(ac.getSource()==deposite)
        {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount to deposite!!!");
            }else
            {
                try
                {
                Conn c=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+number+"');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" is Deposite Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            
        }else if(ac.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
            
    }
}
