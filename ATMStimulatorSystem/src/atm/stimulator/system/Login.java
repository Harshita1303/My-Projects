package atm.stimulator.system;

import atm.stimulator.system.login.Transaction;
import atm.stimulator.system.signup.SignUpOne;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton clear , signup, login;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    
    //Constructor
    public Login(){
       
        //title
        setTitle("Automated Teller Machine");
        
        //logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Indeed Colne/src/com/indeedcolne/images"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//image to image icon, to pas 
        JLabel label = new JLabel(i3);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        label.setBounds(70,10, 70, 70);// to maka custom bound aailable we have to set borderlayout as null
        add(label); // to palce the variable on to the frames
        
        
        //dimension
        setSize(800, 500);

        //backgound color
        getContentPane().setBackground(Color.white);
        
        //to write on frames
        JLabel text = new JLabel(" Welcome to ATM ");
        text.setFont(new Font("Osward", Font.BOLD, 40 ));
        text.setBounds(500, 10, 400, 100);//coz layout null
        add(text);
        
        //to write on frames
        JLabel cardNo = new JLabel(" CARD NO: ");
        cardNo.setFont(new Font("Railway", Font.BOLD, 30 ));
        cardNo.setBounds(150, 100, 400, 100);//coz layout null
        add(cardNo);
        
        //to write on frames
        JLabel pin = new JLabel(" PIN: ");
        pin.setFont(new Font("Railway", Font.BOLD, 30 ));
        pin.setBounds(150, 150, 400, 100);//coz layout null
        add(pin);
        
        //to add JTextField - Card no
        cardTextField = new JTextField();
        cardTextField.setBounds(340, 130, 250, 30);//coz layout null
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14 ));
        add(cardTextField);
        
        //to add JTextField - pin
        pinTextField = new JPasswordField();
        pinTextField.setBounds(340, 190, 250, 30);//coz layout null
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14 ));
        add(pinTextField);
        
        //buttons : Sign in
        login = new JButton("SIGN IN");
        login.setBounds(340, 280, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        //buttons : clear
        clear = new JButton("CLEAR");
        clear.setBounds(490, 280, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        //buttons : signup
        signup = new JButton("SIGN UP");
        signup.setBounds(340, 340, 255, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        //to make frame visible to us , by default false
        setVisible(true); 
        
        //location
        setLocation(350,100);
    }
    
    //ActionListener: how buttons to be worked
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
           
            try{
                 Conn con = new Conn();
            String cardNumber = cardTextField.getText();
            String pin = pinTextField.getText();     
                    
            String query = "select * from LoginDetail where cardNumber = '"+cardNumber+"','"+pin+"'";
            
                ResultSet rs = con.s.executeQuery(query);
                
                if(rs.next()){
                    
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect CardNo or PIN....");

                }
            }
            catch(Exception e){
                System.out.print(e);
            }
           
        }
        else if(ae.getSource() == signup){
            setVisible(false); //to remove home
            new SignUpOne().setVisible(true);
            
        }
        
    }
    public static void main(String args[]){
        //Class Object
        new Login();
        
    } 
}
