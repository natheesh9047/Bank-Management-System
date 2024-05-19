package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cbox;
    JPasswordField pbox;
    
    Login()
                {
                    setTitle("AUTOMATED TELLER MACHINE");
                    setLayout(null);
                    ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
                    Image i2 =il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    ImageIcon i3=new ImageIcon(i2);
                    JLabel label=new JLabel(i3);
                    label.setBounds(70, 10, 100, 100);
                    add(label); 
                    JLabel text= new JLabel ("WELCOME TO ATM");
                    add(text);
                    text.setFont(new Font("Osward",Font.BOLD,38));
                    text.setBounds(200,40,400,40);
                    
                    JLabel card= new JLabel ("Card No : ");
                    add(card);
                    card.setFont(new Font("Raleway",Font.BOLD,28));
                    card.setBounds(120,150,400,40);
                    
                    cbox=new JTextField();
                    cbox.setBounds(300,150,250,30);
                    cbox.setFont(new Font("Ariel" ,Font.BOLD,14));
                    add(cbox);
                    
                    JLabel pin= new JLabel ("Pin : ");
                    add(pin);
                    pin.setFont(new Font("Raleway",Font.BOLD,28));
                    pin.setBounds(120,220,400,40);
                    
                    pbox=new JPasswordField();
                    pbox.setBounds(300,220,250,30);
                    pbox.setFont(new Font("Ariel" ,Font.BOLD,14));
                    add(pbox);
                    
                    login =new JButton("SIGN IN");
                    login.setBounds(250, 300, 150, 30);
                    login.setBackground(Color.BLACK);
                    login.setForeground(Color.WHITE);
                    login.addActionListener(this);
                    add(login);
                    
                    clear =new JButton("CLEAR");
                    clear.setBounds(450, 300, 150, 30);
                    clear.setBackground(Color.BLACK);
                    clear.setForeground(Color.WHITE);
                    clear.addActionListener(this);
                    add(clear);
                    
                    signup =new JButton("SIGN UP");
                    signup.setBounds(250, 350, 350, 30);
                    signup.setBackground(Color.BLACK);
                    signup.setForeground(Color.WHITE);
                    signup.addActionListener(this);
                    add(signup);
                    
                    
                    getContentPane().setBackground(Color.white);
                    setSize(800,480);
                    setVisible(true);
                    setLocation(350,200);
                }
    
    /**
     *
     * @param ac
     */
    @Override
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()  == clear)
        {
            cbox.setText("");
            pbox.setText("");
        }
        else if(ac.getSource()== login)
        {
            Conn c=new Conn();
            String cardnumber =cbox.getText();
            String pinnumber=pbox.getText();
            String query="select * from login where cardnumber='"+cardnumber+"' and pin ='"+pinnumber+"';";
            try
            {
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Entered cardnumber or pinnumber is invalid!!!");
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        else if(ac.getSource()== signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main (String args[])
    {
        new Login();
    }
    
}
