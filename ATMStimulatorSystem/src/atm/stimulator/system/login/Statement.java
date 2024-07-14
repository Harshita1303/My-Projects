package atm.stimulator.system.login;

import atm.stimulator.system.Conn;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Statement extends JFrame{
    
    String pin ;
    int bal = 0;
    
    public Statement(String pin){
        this.pin = pin;
        
        setTitle("Mini Statement");
        
        setLayout(null); //border layout

         
         JLabel heading = new JLabel("Mini Statement");
         heading.setBounds(130, 50, 150, 20);
         heading.setFont(new Font("Raleway", Font.BOLD,15));
         add(heading);
         
         JLabel bank = new JLabel("BANK OF INDIA");
         bank.setBounds(110, 10, 200, 30);
         bank.setFont(new Font("Raleway", Font.BOLD,20));
         add(bank);
         
         JLabel card = new JLabel();
         card.setBounds(90, 80, 300, 30);
         card.setFont(new Font("Raleway", Font.BOLD,15));
         add(card);
         
         JLabel mini = new JLabel();
         mini.setBounds(90, 150, 400, 50);
         mini.setFont(new Font("Raleway", Font.BOLD,10));
         add(mini);
         
         JLabel balance = new JLabel();
         balance.setBounds(120, 250, 400, 50);
         balance.setFont(new Font("Raleway", Font.BOLD,10));
         add(balance);
         
         //displaying card number
         try{
             
             Conn con = new Conn();
             
            ResultSet rs1 = con.s.executeQuery("select * from LoginDetail where pin = '"+pin+"'");
             
            while(rs1.next()){
                card.setText("Card Number: "+ "XXXXXXXX" + rs1.getString("CardNo").substring(8));
            }
             
         }catch(Exception e){
             System.out.println(e);
         }
         
           //displaying statement
         try{
             
             Conn con = new Conn();
             
            ResultSet rs2 = con.s.executeQuery("select * from Bank where pin = '"+pin+"'");
             
            while(rs2.next()){
                mini.setText(mini.getText() + "<html>"+ rs2.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs2.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs2.getString("amount")+"<br><br><html>");
            
                if(rs2.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs2.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            
            
            balance.setText("Total Account Balance: Rs" + bal);
            
            
                      
         }catch(Exception e){
             System.out.println(e);
         }
    
        getContentPane().setBackground(Color.white);//awt
        setSize(400, 400);
        setVisible(true); 
        setLocation(350,0);
    }
    
    
    public static void main(String args[]){
        new Statement("");
    }
}
