package bank.management.system;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField pinbox,repinbox;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pintext=new JLabel("Enter New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(180, 330, 500, 35);
        image.add(pintext);
        
        pinbox=new JPasswordField();
        pinbox.setFont(new Font("System",Font.BOLD,16));
        pinbox.setBounds(360, 330, 140,25);
        image.add(pinbox);
        
        JLabel repin=new JLabel("Re-Enter the new Pin : ");
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setBounds(180, 380, 500, 35);
        image.add(repin);
        
        repinbox=new JPasswordField();
        repinbox.setFont(new Font("System",Font.BOLD,16));
        repinbox.setBounds(360, 380, 140,25);
        image.add(repinbox);
        
        change =new JButton("Change");
        change.setBounds(160,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
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
        new PinChange(" ");
    }

    @Override
    public void actionPerformed(ActionEvent ac) 
    {
        if(ac.getSource() == change)
        {
            try
            {
                String npin=pinbox.getText();
                String repin=repinbox.getText();
                
                if(!npin.equals(repin))
                {
                    JOptionPane.showMessageDialog(null, "Entered Pin Does Not match!!!");
                    return;
                }
                
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter The Pin!!!");
                    return;
                }
                
                if(repin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter The Pin!!!");
                    return;
                }
                
                Conn c=new Conn();
                String query1="update bank set pin = '"+repin+"' where pin='"+pinnumber+"';";
                String query2="update login set pin = '"+repin+"' where pin='"+pinnumber+"';";
                String query3="update signupthree set pin = '"+repin+"' where pin='"+pinnumber+"';";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully!!!");
                
                setVisible(false);
                new Transaction(repin).setVisible(true); 
               
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }else
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
              
        
        
    }
    
}
