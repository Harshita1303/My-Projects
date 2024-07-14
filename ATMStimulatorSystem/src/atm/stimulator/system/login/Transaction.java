package atm.stimulator.system.login;


import  atm.stimulator.system.login.Deposit;
import  atm.stimulator.system.login.Withdrawl;
import  atm.stimulator.system.login.SetPin;
import  atm.stimulator.system.login.Statement;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;



public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit , withdrawl, statement , pinchange, fastCash, enquiry, exit; 
    String pin ;
    
    public Transaction(String pin){
        
            this.pin = pin;
            
            setTitle("Automated Teller Machine");
        
            setLayout(null); //border layout

         
            //bg image
            ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("atmstimulatorsystem/icons/atm1.jpg"));
            Image icon2 = icon1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
            ImageIcon icon3 = new ImageIcon(icon2);
            JLabel image = new JLabel(icon3);
            image.setBounds(0, 0, 600, 600);
            add(image);
            
            //
            JLabel text = new JLabel("Please Select Your Transaction");
            text.setBounds(210, 220, 200, 100);
            text.setForeground(Color.WHITE);//font color
            text.setFont(new Font("System", Font.BOLD, 12));
            image.add(text);
            
            deposit = new JButton("Deposit");
            deposit.setBounds(180, 295, 100, 20);
            deposit.addActionListener(this);
            image.add(deposit);
            
            withdrawl = new JButton("Withdrawl");
            withdrawl.setBounds(320, 295, 100, 20);
            withdrawl.addActionListener(this);
            image.add(withdrawl);
            
            fastCash = new JButton("Fast Cash");
            fastCash.setBounds(180, 325, 100, 20);
            fastCash.addActionListener(this);
            image.add(fastCash);
            
            statement = new JButton("Statement");
            statement.setBounds(180, 355, 100, 20);
            statement.addActionListener(this);
            image.add(statement);
            
            pinchange = new JButton("Reset PIN");
            pinchange.setBounds(320, 325, 100, 20);
            pinchange.addActionListener(this);
            image.add(pinchange);
            
            enquiry = new JButton("Enquiry");
            enquiry.setBounds(320, 355, 100, 20);
            enquiry.addActionListener(this);
            image.add(enquiry);
            
            exit = new JButton("Exit");
            exit.setBounds(320, 385, 100, 20);
            exit.addActionListener(this);
            image.add(exit);
            
            //Bgcolor
            getContentPane().setBackground(Color.white);
            setSize(600, 600);
            setVisible(true); 
            setLocation(350,0);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
       if(ae.getSource() == exit){
           setVisible(false);
           //System.exit(0);
       }
       
       if(ae.getSource() == deposit){
           setVisible(false);
           new Deposit(pin).setVisible(true);
 
       }
       else if(ae.getSource() == withdrawl){
           setVisible(false);
           new Withdrawl(pin).setVisible(true);
       }
       
       else if(ae.getSource() == statement){
           new Statement(pin).setVisible(true);
       }
      
       else if(ae.getSource() == pinchange){
           setVisible(false);
           new SetPin(pin).setVisible(true);
       }
       
    }
    
    public static void main(String args[]){
        
        new Transaction("");
    } 
}
