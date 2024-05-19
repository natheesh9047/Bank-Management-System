package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    Long random;
    JTextField pantext,addhartext;
    JDateChooser dobtext;
    JRadioButton accyes,accno,syes,sno;
    JButton next;
    JComboBox reg,cate,come,edu,occp;
    String formno;
    
    SignupTwo(String form)
    {
        setLayout(null);
        
        JLabel formno = new JLabel("APPLICATION NO."+form);
        formno.setFont(new Font("Raleway",Font.BOLD,38 ));
        formno.setBounds(200, 20, 600, 40);
        add(formno);
        
        JLabel additional = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additional.setFont(new Font("Raleway",Font.BOLD,22));
        additional.setBounds(270, 80, 400, 30);
        add(additional);
        
        JLabel religion = new JLabel("REGILION : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140, 100, 30);
        add(religion);
        
        String valreg[] ={"HINDU","MUSLIM","CHRISTIAN","OTHER"};
        reg=new JComboBox(valreg);
        reg.setBounds(350, 140, 400, 30);
        reg.setBackground(Color.WHITE);
        add(reg);
        
        
        JLabel category = new JLabel("CATEGORY: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190, 200, 30);
        add(category);
        
        String valcate[] ={"GENERAL","BC","MBC","SC","ST","OTHERS"};
        cate=new JComboBox(valcate);
        cate.setBounds(350, 190, 400, 30);
        cate.setBackground(Color.WHITE);
        add(cate);
        
        JLabel income = new JLabel("INCOME : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240, 120, 30);
        add(income);
        
        String valincome[] ={"< 1,50,000","< 2,50,000","< 5,00,000","UPTO 10,00,000"};
        come=new JComboBox(valincome);
        come.setBounds(350, 240, 400, 30);
        come.setBackground(Color.WHITE);
        add(come);
        
        
        JLabel education = new JLabel("EDUCATION");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290, 200, 30);
        add(education);
        JLabel qualification = new JLabel("QUALIFICATION");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,310, 200, 30);
        add(qualification);
        
        String valedu[] ={"NON-GRADUATION","GRADUATION","POST-GRADUATION","DOCRATE"};
        edu=new JComboBox(valedu);
        edu.setBounds(350, 310, 400, 30);
        edu.setBackground(Color.WHITE);
        add(edu);
        
        JLabel occupation = new JLabel("OCCUPATION");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,360, 200, 30);
        add(occupation);
        
        String valoccp[] ={"NON-EMPOLYEE","EMPOLYEE","SELF-EMPOLYEE","STUDENT"};
        occp=new JComboBox(valoccp);
        occp.setBounds(350, 360, 400, 30);
        occp.setBackground(Color.WHITE);
        add(occp);
        
        JLabel pan = new JLabel("PAN NUMBER : ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,410, 200, 30);
        add(pan);
        
        pantext = new JTextField();
        pantext.setFont(new Font("Raleway",Font.BOLD,14));
        pantext.setBounds(350, 410, 400, 30);
        add(pantext);
        
        JLabel addhar = new JLabel("ADDHAR NUMBER: ");
        addhar.setFont(new Font("Raleway",Font.BOLD,20));
        addhar.setBounds(100,460, 300, 30);
        add(addhar);
        
        addhartext = new JTextField();
        addhartext.setFont(new Font("Raleway",Font.BOLD,14));
        addhartext.setBounds(350, 460, 400, 30);
        add(addhartext);
        
        JLabel senior = new JLabel("SENIOR CITIZEN : ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,510, 200, 30);
        add(senior);
        
        syes=new JRadioButton("YES");
        syes.setBounds(350,510,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("NO");
        sno.setBounds(450,510,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sgroup=new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);
        
        
        JLabel exist = new JLabel("EXISTING ACCOUNT : ");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100,560, 400, 30);
        add(exist);
        
        accyes=new JRadioButton("YES");
        accyes.setBounds(350,560,100,30);
        accyes.setBackground(Color.WHITE);
        add(accyes);
        
        accno=new JRadioButton("NO");
        accno.setBounds(450,560,100,30);
        accno.setBackground(Color.WHITE);
        add(accno);
        
        ButtonGroup accgroup=new ButtonGroup();
        accgroup.add(accyes);
        accgroup.add(accno);
        
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
        String religion=(String)reg.getSelectedItem();
        String category=(String)cate.getSelectedItem();
        String education=(String)edu.getSelectedItem();
        String income=(String)come.getSelectedItem();
        String occupation=(String)occp.getSelectedItem();
        String pan=pantext.getText();
        String addhar=addhartext.getText();
        
        String senior=null;
        if(syes.isSelected())
        {
            senior="YES";
        }else if(sno.isSelected())
        {
            senior="NO";
        }
        
        String exist=null;
        if(accyes.isSelected())
        {
            exist="YES";
        }else if(accno.isSelected())
        {
            exist="NO";
        }
        
        try
        {
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN NUMBER Is Required"); 
            }
            else if(addhar.equals(""))
            {
                JOptionPane.showMessageDialog(null, "ADDHAR NUMBER Is Required"); 
            }
            else
            {
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+addhar+"','"+senior+"','"+exist+"');";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        new SignupTwo(" ");
    }
    
}

