package atm.stimulator.system.login;

import atm.stimulator.system.login.Transaction;
import atm.stimulator.system.Conn;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amt;
    JButton deposit, back;
    String pin;
    
    public Deposit(String pin){
        
        this.pin = pin;
        
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout

       
        //bg image
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("atmstimulatorsystem/icons/atm1.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);         ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(0, 0, 600, 600);
        add(image);
        
         JLabel text = new JLabel("Enter the amount to be deposited");
         text.setBounds(210, 210, 200, 100);
         text.setForeground(Color.WHITE);//font color
         text.setFont(new Font("System", Font.BOLD, 12));
         image.add(text);
            
        JLabel depositamt = new JLabel("Enter Amount: ");
        depositamt.setBounds(180, 240, 200, 100);
        depositamt.setForeground(Color.WHITE);//font color
        depositamt.setFont(new Font("System", Font.BOLD, 12));
        image.add(depositamt);
        
       amt = new JTextField();
       amt.setBounds(240, 310, 150, 20);
       amt.setForeground(Color.black);//font color
       amt.setFont(new Font("System", Font.BOLD, 12));
       image.add(amt);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(320, 350, 100, 20);
        deposit.addActionListener(this);
        image.add(deposit);  
        
        back = new JButton("Back");
        back.setBounds(320, 380, 100, 20);
        back.addActionListener(this);
        image.add(back);  
        
        //Bgcolor
        getContentPane().setBackground(Color.white);
        setSize(600, 600);
        setVisible(true); 
        setLocation(350,0);
       
            
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        
        if(ae.getSource() == deposit){
            
            String number = amt.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be deposit");

            }else{
                
                try{
                    Conn con = new Conn();
                    String query = "insert into Bank values('"+pin+"','"+ date+"','Deposit','"+number+"')";
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Deposited Successfully...");

                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }
        
    }
    
    public static void main(String args[]){
        new Deposit("");
    }
}
