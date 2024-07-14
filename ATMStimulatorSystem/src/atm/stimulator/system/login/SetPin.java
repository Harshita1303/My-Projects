package atm.stimulator.system.login;

import atm.stimulator.system.Conn;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;

public class SetPin extends JFrame implements ActionListener{
    
    String pin;
    JPasswordField pinno, repinno;
    JButton back, reset;
    
    public SetPin(String pin){
        
        this.pin = pin;
        
        setTitle("Reset PIN");
        
        setLayout(null); //border layout

         
        //bg image
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("atmstimulatorsystem/icons/atm1.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);         ImageIcon icon3 = new ImageIcon(icon2);
        ImageIcon icon = new ImageIcon(icon2);
        JLabel image = new JLabel(icon);
        image.setBounds(0, 0, 600, 600);
        add(image);
            
        JLabel label = new JLabel(" Reset Your PIN: ");
        label.setBounds(240, 210, 200, 100);
        label.setForeground(Color.WHITE);//font color
        label.setFont(new Font("System", Font.BOLD, 12));
        image.add(label);
        
        JLabel pinnn = new JLabel("Enter PIN: ");
        pinnn.setBounds(200, 250, 200, 100);
        pinnn.setForeground(Color.WHITE);//font color
        pinnn.setFont(new Font("System", Font.BOLD, 10));
        image.add(pinnn);
        
        JLabel repin = new JLabel("Re-Enter PIN: ");
        repin.setBounds(200, 270, 200, 100);
        repin.setForeground(Color.WHITE);//font color
        repin.setFont(new Font("System", Font.BOLD, 10));
        image.add(repin);
        
        
        pinno = new JPasswordField();
        pinno.setBounds(280, 290, 100, 15);
        pinno.setForeground(Color.black);//font color
        pinno.setFont(new Font("System", Font.BOLD, 12));
        image.add(pinno);

        repinno = new JPasswordField();
        repinno.setBounds(280, 310, 100, 15);
        repinno.setForeground(Color.black);//font color
        repinno.setFont(new Font("System", Font.BOLD, 12));
        image.add(repinno);

        reset = new JButton("Reset");
        reset.setBounds(320, 350, 100, 20);
        reset.addActionListener(this);
        image.add(reset);  
        
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
        
        if(ae.getSource() == reset){
            try{

                String npin = pinno.getText();
                String rpin = repinno.getText();

                if(npin.equals("") || rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "PIN and REPIN is must...");
                    return;

                }

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "PIN and REPIN is not equal....");
                    return;                                   
                }

                Conn con = new Conn();

                String q1 = "update Bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                //String q2 = "update LoginDetail set pin = '"+rpin+"' where pin = '"+pin+"'";
                //String q3 = "update AccountDetail set pin = '"+rpin+"' where pin = '"+pin+"'";

                con.s.executeUpdate(q1);
                //con.s.executeUpdate(q2);
                //con.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully...");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
    }
    
    public static void main(String args[]){
        new SetPin("").setVisible(true);
    }
}
