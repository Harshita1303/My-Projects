package indeed.system;

import indeed.login.Home;
import indeed.signup.Option;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

//Frames: Swing 
//JFrame: javax.swing
//ActionListener: java.awt.event :to make buttons work
public class Login extends JFrame implements ActionListener{
    
    JTextField email;
    JPasswordField password;
    JButton signup,login ,clear, logout;
    
    public Login(){
        
        //title
        setTitle("Indeed - A Job Search Engine");
        
        //to write on frames
        JLabel text = new JLabel(" Welcome to Indeed");
        text.setFont(new Font("Osward", Font.BOLD, 40 ));
        text.setBounds(400, 10, 400, 100);//coz layout null
        add(text);

        //home image
        //imageicon: ClassLoader.getSystemResource()
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/home.png"));
        Image i22 = i11.getImage().getScaledInstance(1070, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,50, 1070, 500);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);
  
        //text on image
        JLabel text1 = new JLabel("A Job Search Engine");
         text1.setBounds(300, 100, 250, 150);
         text1.setForeground(Color.WHITE);//font color
         text1.setFont(new Font("System", Font.BOLD, 20));
         labell.add(text1);
         

         //email on image
        JLabel text2 = new JLabel("Email: ");
         text2.setBounds(250, 230, 100, 50);
         text2.setForeground(Color.WHITE);//font color
         text2.setFont(new Font("System", Font.BOLD, 15));
         labell.add(text2);
         
         email = new JTextField();
         email.setBounds(350, 240, 200, 20);
         email.setForeground(Color.black);//font color
         email.setFont(new Font("System", Font.BOLD, 12));
         labell.add(email);
         
         //password on image
         JLabel text3 = new JLabel("Password: ");
         text3.setBounds(250, 270, 100, 50);
         text3.setForeground(Color.WHITE);//font color
         text3.setFont(new Font("System", Font.BOLD, 15));
         labell.add(text3);
         
         password = new JPasswordField();
         password.setBounds(350, 280, 200, 20);
         password.setForeground(Color.black);//font color
         password.setFont(new Font("System", Font.BOLD, 12));
        labell.add(password);
         
        //buttons : signup
        login = new JButton("LOGIN");
        login.setBounds(330, 330, 100, 30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this); //to call button
        labell.add(login);
        
          //buttons : clear
        clear = new JButton("RESET");
        clear.setBounds(440, 330, 100, 30);
        clear.setBackground(Color.white);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        labell.add(clear);
        
        //password on image
        JLabel text4 = new JLabel("Haven't registered yet? ");
         text4.setBounds(250, 370, 200, 50);
         text4.setForeground(Color.WHITE);//font color
         text4.setFont(new Font("System", Font.BOLD, 15));
         labell.add(text4);
         
       
        //buttons : createaccount
        signup = new JButton("SIGNUP");
        signup.setBounds(440, 380, 100, 30);
        signup.setBackground(Color.white);
        signup.setForeground(Color.black);
        signup.addActionListener(this);
        labell.add(signup);
        
    
        //dimension
        setSize(1180, 600);
        
        //backgound color
        getContentPane().setBackground(Color.white);
        
  
        //to make frame visible to us , by default false
        setVisible(true); 
        
        //location
        setLocation(50,50);
    }   
    
        //ActionListener: how buttons to be worked
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            email.setText("");
            password.setText("");
        }
        
        else if(ae.getSource() == login){      
            try{
                DBConnection con = new DBConnection();
                String emailid = email.getText();
                String pass = password.getText(); 
                
//                if(emailid.equals("h@gmail.com") && pin.equals("hh")){
//                    JOptionPane.showMessageDialog(null, "Successfully Logged In...");
//                    setVisible(false);
//                    new Home().setVisible(true);
//                }else{
//                    JOptionPane.showMessageDialog(null, "Invalid Credentials...");
//                    setVisible(false);
//                    new Login().setVisible(true);
//                }

                String query = "select * from Login where email = '"+emailid+"'";
                ResultSet rs = con.s.executeQuery(query);
              
                
                if(rs.next()){
                    ResultSet rs1 = con.s.executeQuery("select * from Login where pin = '"+pass+"'");
                    if(rs1.next())
                    {
                        setVisible(false);
                        new Home().setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Password....");
                        setVisible(false);
                        new Login().setVisible(true);
                    }
     
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Email....");
                    setVisible(false);
                    new Login().setVisible(true);
                }
            }
            catch(Exception e){
                System.out.print(e);
            }
      }    
        
        else if(ae.getSource() == signup){
            setVisible(false); //to remove home
            new Option().setVisible(true);
            }
        }    
    public static void main(String args[]){
        //Class Object
        new Login(); 
    } 
}
