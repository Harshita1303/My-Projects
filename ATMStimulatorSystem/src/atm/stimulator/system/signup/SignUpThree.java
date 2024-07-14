package atm.stimulator.system.signup;

import atm.stimulator.system.Conn;
import atm.stimulator.system.Conn;
import atm.stimulator.system.Login;
import atm.stimulator.system.signup.SignUpTwo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    public JRadioButton r1, r2, r3, r4;
    public JCheckBox c1, c2, c3, c4, c5, c6, c7;
    public JButton submit, cancel, back;
    public String formNo;
            
    public SignUpThree(String formNo){
        
        this.formNo = formNo;
        
            //title
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout

            //Account Details
            JLabel accountDetails = new JLabel("Page 3: Account Details");
            accountDetails.setFont(new Font("Raleway", Font.BOLD,20));
            accountDetails.setBounds(150, 5, 500, 50);
            add(accountDetails);
            
            //Account Type
            JLabel accountType = new JLabel("Account Type: ");
            accountType.setFont(new Font("Raleway", Font.BOLD,12));
            accountType.setBounds(50, 50, 500, 50);
            add(accountType);
  
            r1 = new JRadioButton("Saving Account ");
            r1.setFont(new Font("Raleway", Font.BOLD,10));
            r1.setBounds(100, 90, 120, 20);
            r1.setBackground(Color.white);
            add(r1);

            r2 = new JRadioButton("Current Account ");
            r2.setFont(new Font("Raleway", Font.BOLD,10));
            r2.setBounds(250, 90, 150, 20);
            r2.setBackground(Color.white);
            add(r2);
            
            r3 = new JRadioButton("Fixed Deposit Account ");
            r3.setFont(new Font("Raleway", Font.BOLD,10));
            r3.setBounds(100, 120, 150, 20);
            r3.setBackground(Color.white);
            add(r3);
            
            r4 = new JRadioButton("Recurring Account ");
            r4.setFont(new Font("Raleway", Font.BOLD,10));
            r4.setBounds(250, 120, 150, 20);
            r4.setBackground(Color.white);
            add(r4);

            ButtonGroup other = new ButtonGroup();
            other.add(r1);
            other.add(r2 );
            other.add(r3);
            other.add(r4);

            
            //card no
             JLabel cardNo = new JLabel("Card No: ");
            cardNo.setFont(new Font("Raleway", Font.BOLD,12));
            cardNo.setBounds(50, 150, 500, 50);
            add(cardNo);
            
            JLabel cardDetails = new JLabel("Your 12-Digit Card No");
            cardDetails.setFont(new Font("Raleway", Font.BOLD,8));
            cardDetails.setBounds(50, 165, 500, 50);
            add(cardDetails);
            
            JLabel card = new JLabel("XXXX-XXXX-XXXX-5647");
            card.setFont(new Font("Raleway", Font.BOLD,10));
            card.setBounds(120, 150, 500, 50);
            add(card);
            
            
            
             //card no
             JLabel pin = new JLabel("PIN: ");
            pin.setFont(new Font("Raleway", Font.BOLD,12));
            pin.setBounds(50, 200, 500, 50);
            add(pin);
            
            JLabel pinno = new JLabel("XXXX");
            pinno.setFont(new Font("Raleway", Font.BOLD,10));
            pinno.setBounds(120, 200, 500, 50);
            add(pinno);
            
            JLabel pinDetails = new JLabel("Your 4-Digit PIN");
            pinDetails.setFont(new Font("Raleway", Font.BOLD,8));
            pinDetails.setBounds(50, 215, 500, 50);
            add(pinDetails);
            
            
            //Services
            JLabel services = new JLabel("Services: ");
            services.setFont(new Font("Raleway", Font.BOLD,12));
            services.setBounds(50, 250, 500, 50);
            add(services);
            
            
            //checkbox
            c1 = new JCheckBox("ATM Card");
            c1.setBackground(Color.white);
            c1.setFont(new Font("Raleway", Font.BOLD,10));
            c1.setBounds(100, 270, 100, 50);
            add(c1);
            
            //checkbox
            c2 = new JCheckBox("Internet Banking");
            c2.setBackground(Color.white);
            c2.setFont(new Font("Raleway", Font.BOLD,10));
            c2.setBounds(250, 270, 150, 50);
            add(c2);
            
            //checkbox
            c3 = new JCheckBox("Mobile Banking");
            c3.setBackground(Color.white);
            c3.setFont(new Font("Raleway", Font.BOLD,10));
            c3.setBounds(100, 300, 100, 50);
            add(c3);
            
            //checkbox
            c4 = new JCheckBox("Email/SMS Alerts");
            c4.setBackground(Color.white);
            c4.setFont(new Font("Raleway", Font.BOLD,10));
            c4.setBounds(250, 300, 150, 50);
            add(c4);
            
            c5 = new JCheckBox("Cheque Book");
            c5.setBackground(Color.white);
            c5.setFont(new Font("Raleway", Font.BOLD,10));
            c5.setBounds(100, 330, 100, 50);
            add(c5);
            
            
            //checkbox
            c6 = new JCheckBox("E-Statement");
            c6.setBackground(Color.white);
            c6.setFont(new Font("Raleway", Font.BOLD,10));
            c6.setBounds(250, 330, 100, 50);
            add(c6);
            
            //checkbox
            c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
            c7.setBackground(Color.white);
            c7.setFont(new Font("Raleway", Font.BOLD,10));
            c7.setBounds(30, 370, 500, 50);
            add(c7);
            
            
            back = new JButton("Back");
            back.setFont(new Font("Raleway", Font.BOLD,15));
            back.setBounds(150, 420, 100, 20);
            back.setForeground(Color.white);
            back.setBackground(Color.black);
            back.addActionListener(this);
            add(back);
            
             //cancel button
            submit = new JButton("Submit");
            submit.setFont(new Font("Raleway", Font.BOLD,15));
            submit.setBounds(260, 420, 100, 20);
            submit.setForeground(Color.white);
            submit.setBackground(Color.black);
            submit.addActionListener(this);
            add(submit);
            
            
            //next button
            cancel = new JButton("Cancel");
            cancel.setFont(new Font("Raleway", Font.BOLD,15));
            cancel.setBounds(370, 420, 100, 20);
            cancel.setForeground(Color.white);
            cancel.setBackground(Color.black);
            cancel.addActionListener(this); // to perform some action
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
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == submit)
            {
              
                //accountType 
                String accountType = null;
                if(r1.isSelected())
                {
                    accountType = "Saving Account";
                }
                else if(r2.isSelected())
                {
                    accountType = "Fixed Deposit Account";
                }
                 else if(r3.isSelected())
                {
                    accountType = "Current Account";
                }
                 else if(r4.isSelected())
                {
                    accountType = "Reccuring Deposit Account";
                }
                
               
                SignUpTwo cardDetails = new SignUpTwo("");
                //card no
                JTextField card = cardDetails.card;
                
                //pin
                JPasswordField pin = cardDetails.pinno;

                
                //services
                String facility = "";
                 if(c1.isSelected())
                {
                    facility = facility + " ATM Card";
                }
                else if(c2.isSelected())
                {
                    facility = facility + " Internet Banking";
                }
                 else if(c3.isSelected())
                {
                    facility = facility + " Mobile Banking";
                }
                 else if(c4.isSelected())
                {
                    facility = facility + " Email/SMS Alerts";
                }
                else if(c5.isSelected())
                {
                    facility = facility + " Cheque Book";
                }
                else if(c6.isSelected())
                {
                    facility = facility + " E-Statement";
                }
                
                
                 try{
                     if(accountType.equals("")){
                         JOptionPane.showMessageDialog(null, "AccountType is required...");
                     }
                     else{
                        Conn con = new Conn();
                        String query1 = "insert into AccountDetail values('"+accountType+"','"+card+"','"+pin+"','"+facility+"')";
                        con.s.executeUpdate(query1);
                        
                        System.out.println("Registered Successfully...");
    
                     }
                 }catch(Exception ex){
                     System.out.println(ex);
                 }
                 
                  JOptionPane.showMessageDialog(null, "Account Successfully Registered...");
              
                
                setVisible(false); //to remove home
                new Login().setVisible(true);
              
                
            }
            
            else if(e.getSource() == cancel)
            {
                setVisible(false);
            }
            
            else if(e.getSource() == back)
            { 
                setVisible(false); //to remove home
                
                new SignUpTwo(formNo).setVisible(true);
              
                
            }
      
    }

    public static void main(String arg[]){
        new SignUpThree("");
    }
}

