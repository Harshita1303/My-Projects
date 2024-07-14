package atm.stimulator.system.signup;

import atm.stimulator.system.Conn;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.*;

import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JButton next,back, cancel;
    JTextField card , csvno ;
    JPasswordField pinno, repinno;
    String formNo;
    
    public SignUpTwo(String formNo){
        
            this.formNo = formNo;
            
            //title
            setTitle("Automated Teller Machine");
        
            setLayout(null); //border layout

             //Card Details
            JLabel cardDetails = new JLabel("Page 2: Card Details");
            cardDetails.setFont(new Font("Raleway", Font.BOLD,20));
            cardDetails.setBounds(150, 5, 200, 50);
            add(cardDetails);
            
            //card no
             JLabel cardNo = new JLabel("Enter Card No: ");
            cardNo.setFont(new Font("Raleway", Font.BOLD,15));
            cardNo.setBounds(80, 80, 200, 20);
            add(cardNo);
            
            JLabel cardinfo = new JLabel("Enter Your 12-Digit Card No...");
            cardinfo.setFont(new Font("Raleway", Font.BOLD,10));
            cardinfo.setBounds(80, 85, 200, 50);
            add(cardinfo);
            
            card = new JTextField();
            card.setFont(new Font("Raleway", Font.BOLD,10));
            card.setBounds(200, 80, 200, 20);
            add(card);
   
            
            //enter card no
            JLabel pin = new JLabel("Enter PIN: ");
            pin.setFont(new Font("Raleway", Font.BOLD,15));
            pin.setBounds(80, 150, 100, 20);
            add(pin);
            
            pinno = new JPasswordField();
            pinno.setFont(new Font("Raleway", Font.BOLD,10));
            pinno.setBounds(200, 150, 200, 20);
            add(pinno);
            
            JLabel pinDetails = new JLabel("Enter Your 4-Digit PIN...");
            pinDetails.setFont(new Font("Raleway", Font.BOLD,10));
            pinDetails.setBounds(80, 170, 150, 15);
            add(pinDetails);
            
            
            //re-enter card no
            JLabel repin = new JLabel("Re-Enter PIN: ");
            repin.setFont(new Font("Raleway", Font.BOLD,15));
            repin.setBounds(80, 220, 150, 20);
            add(repin);
            
            repinno = new JPasswordField();
            repinno.setFont(new Font("Raleway", Font.BOLD,10));
            repinno.setBounds(200, 220, 200, 20);
            add(repinno);
            
            JLabel repinDetails = new JLabel("Re-Enter Your 4-Digit PIN...");
            repinDetails.setFont(new Font("Raleway", Font.BOLD,10));
            repinDetails.setBounds(80, 240, 150, 15);
            add(repinDetails);
            
            
            //expired date
            JLabel expireddate = new JLabel("Enter Expired Date: ");
            expireddate.setFont(new Font("Raleway", Font.BOLD,15));
            expireddate.setBounds(80, 290, 150, 20);
            add(expireddate);
            
            JMonthChooser month = new JMonthChooser();
            month.setFont(new Font("Raleway", Font.BOLD,10));
            month.setBounds(230, 290, 80, 20);
            add(month);
            
            JYearChooser year = new JYearChooser();
            year.setFont(new Font("Raleway", Font.BOLD,10));
            year.setBounds(310, 290, 80, 20);
            add(year);
            
            JLabel edetails = new JLabel("Enter Your Card Expired Date...");
            edetails.setFont(new Font("Raleway", Font.BOLD,10));
            edetails.setBounds(80, 310, 150, 15);
            add(edetails);
            

            //CSV No
            JLabel csv = new JLabel("Enter CSV No: ");
            csv.setFont(new Font("Raleway", Font.BOLD,15));
            csv.setBounds(80, 360, 150, 20);
            add(csv);
            
            csvno = new JPasswordField();
            csvno.setFont(new Font("Raleway", Font.BOLD,10));
            csvno.setBounds(200, 360, 200, 20);
            add(csvno);
            
            JLabel csvDetails = new JLabel("Enter Your 3-Digit CSV No...");
            csvDetails.setFont(new Font("Raleway", Font.BOLD,10));
            csvDetails.setBounds(80, 380, 420, 15);
            add(csvDetails);
          
            
             
            back = new JButton("Back");
            back.setFont(new Font("Raleway", Font.BOLD,15));
            back.setBounds(150, 420, 100, 20);
            back.setForeground(Color.white);
            back.setBackground(Color.black);
            back.addActionListener(this);
            add(back);
            
             //cancel button
            next = new JButton("Next");
            next.setFont(new Font("Raleway", Font.BOLD,15));
            next.setBounds(260, 420, 100, 20);
            next.setForeground(Color.white);
            next.setBackground(Color.black);
            next.addActionListener(this);
            add(next);
            
            
            //next button
            cancel = new JButton("Cancel");
            cancel.setFont(new Font("Raleway", Font.BOLD,15));
            cancel.setBounds(370, 420, 100, 20);
            cancel.setForeground(Color.white);
            cancel.setBackground(Color.black);
            cancel.addActionListener(this);
            add(cancel);
            
            
         //Bgcolor
            getContentPane().setBackground(Color.white);

            //create frames
            setSize(500, 500);


           //to make frame visible to us , by default false
            setVisible(true); 

            //location
            setLocation(350,100);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == next){
            try{
                if(card.equals("")){
                }
                else{
                    Conn con = new Conn();
                    String query1 = "insert into LoginDetail values('"+card+"','"+pinno+"')";
                    con.s.executeUpdate(query1);
                    System.out.println("Inserted Successfully...");
                             
                }
                 }catch(Exception ex){
                     System.out.println(ex);
                 }
                 
                 
                   //signup3 Object
                    setVisible(false);
                    new SignUpThree(formNo).setVisible(true);
            
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            
        }
        else if(ae.getSource() == back){
            setVisible(false); //to remove home
            new SignUpOne().setVisible(true);
            
        }
    
    }
    
    
    public static void main(String args[]){
        new SignUpTwo("");
    }
    
}
