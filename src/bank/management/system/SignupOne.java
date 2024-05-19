package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    Long random;
    JTextField nametext,fnametext,emailtext,addresstext,citytext,pincodetext,statetext;
    JDateChooser dobtext;
    JRadioButton male,female,myes,mno;
    JButton next;
    
    SignupOne()
    {
        setLayout(null);
        
        Random ran=new Random();
        random=(Math.abs((ran.nextLong()% 9000L)+1000L));
        JLabel formno = new JLabel("APPLICATION NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38 ));
        formno.setBounds(200, 20, 600, 40);
        add(formno);
        
        JLabel personal = new JLabel("PAGE 1: PERSONAL DETAILS");
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        personal.setBounds(270, 80, 400, 30);
        add(personal);
        
        JLabel name = new JLabel("NAME : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140, 100, 30);
        add(name);
        
        nametext = new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        nametext.setBounds(300, 140, 400, 30);
        add(nametext);
        
        JLabel fname = new JLabel("FATHER NAME : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190, 200, 30);
        add(fname);
        
        fnametext = new JTextField();
        fnametext.setFont(new Font("Raleway",Font.BOLD,14));
        fnametext.setBounds(300, 190, 400, 30);
        add(fnametext);
        
        JLabel dob = new JLabel("DATE OF BIRTH : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240, 200, 30);
        add(dob);
        
        dobtext=new JDateChooser();
        dobtext.setBounds(300,240,200,30);
        dobtext.setForeground(new Color(105,105,105));
        add(dobtext);
        
        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290, 200, 30);
        add(gender);
        
        male=new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("FEMALE");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("EMAIL : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340, 120, 30);
        add(email);
        
        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
        emailtext.setBounds(300, 340, 400, 30);
        add(emailtext);
        
        
        JLabel marital = new JLabel("MARITAL STATUS : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390, 200, 30);
        add(marital);
        
        myes=new JRadioButton("MARRIED");
        myes.setBounds(300,390,100,30);
        myes.setBackground(Color.WHITE);
        add(myes);
        
        mno=new JRadioButton("UNMARRIED");
        mno.setBounds(450,390,100,30);
        mno.setBackground(Color.WHITE);
        add(mno);
        
        ButtonGroup mgroup=new ButtonGroup();
        mgroup.add(myes);
        mgroup.add(mno);
        
        JLabel address = new JLabel("ADDRESS : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440, 200, 30);
        add(address);
        
        addresstext = new JTextField();
        addresstext.setFont(new Font("Raleway",Font.BOLD,14));
        addresstext.setBounds(300, 440, 400, 30);
        add(addresstext);
        
        JLabel city = new JLabel("CITY  : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490, 200, 30);
        add(city);
        
        citytext = new JTextField();
        citytext.setFont(new Font("Raleway",Font.BOLD,14));
        citytext.setBounds(300, 490, 400, 30);
        add(citytext);
        
        JLabel state = new JLabel("STATE : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540, 200, 30);
        add(state);
        
        statetext = new JTextField();
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        statetext.setBounds(300, 540, 400, 30);
        add(statetext);
        
        JLabel pincode = new JLabel("PINCODE : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590, 200, 30);
        add(pincode);
        
        pincodetext = new JTextField();
        pincodetext.setFont(new Font("Raleway",Font.BOLD,14));
        pincodetext.setBounds(300, 590, 400, 30);
        add(pincodetext);
        
        next =new JButton("NEXT");
        next.setBounds(620, 640, 150, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        String formno = "" + random;
        String name=nametext.getText();
        String fname=fnametext.getText();
        String city=citytext.getText();
        String state=statetext.getText();
        String pincode=pincodetext.getText();
        String email=emailtext.getText();
        String address=addresstext.getText();
        String dob=((JTextField) dobtext.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }else if(female.isSelected())
        {
            gender="Female";
        }
        
        String marrital=null;
        if(myes.isSelected())
        {
            marrital="Married";
        }else if(mno.isSelected())
        {
            marrital="Unmarried";
        }
        
        try
        {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name Is Required"); 
            }
            else
            {
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marrital+"','"+address+"','"+city+"','"+pincode+"','"+state+"');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new SignupOne();
    }
    
}
