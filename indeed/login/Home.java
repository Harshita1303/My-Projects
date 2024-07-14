package indeed.login;

import indeed.Login.AddJobs;
import indeed.Login.FindJob;
import indeed.system.Login;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Home extends JFrame implements ActionListener{
    
    JButton home, postjob, findjob, logout;
    
    public Home(){
        
        //title
        setTitle("Indeed - A Job Search Engine");

        //home image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/home.png"));
        Image i22 = i11.getImage().getScaledInstance(1070, 500, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,10, 1070, 550);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);
  
        //text on image
        JLabel text1 = new JLabel("A Job Search Engine");
         text1.setBounds(300, 200, 250, 150);
         text1.setForeground(Color.WHITE);//font color
         text1.setFont(new Font("System", Font.BOLD, 20));
         labell.add(text1);
         
    
        //buttons : signup
        home = new JButton("HOME");
        home.setBounds(300, 100, 80, 30);
        home.setBackground(Color.white);
        home.setForeground(Color.black);
        home.addActionListener(this); //to call button
        labell.add(home);
        
          //buttons : clear
        postjob = new JButton("POST");
        postjob.setBounds(400, 100, 80, 30);
        postjob.setBackground(Color.white);
        postjob.setForeground(Color.black);
        postjob.addActionListener(this);
        labell.add(postjob);
        
        //buttons : createaccount
        findjob = new JButton("FIND");
        findjob.setBounds(500, 100, 80, 30);
        findjob.setBackground(Color.white);
        findjob.setForeground(Color.black);
        findjob.addActionListener(this);
        labell.add(findjob);
        
        logout = new JButton("LOGOUT");
        logout.setBounds(600, 100, 90, 30);
        logout.setBackground(Color.white);
        logout.setForeground(Color.black);
        logout.addActionListener(this);
        labell.add(logout);
        
        
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
        
        if(ae.getSource() == home){
            
        setVisible(false);
        new Home().setVisible(true);
          
        }
      if(ae.getSource() == postjob){
      
        setVisible(false);
        new AddJobs().setVisible(true);
               
        }

        if(ae.getSource() == findjob){
            
            setVisible(false); //to remove home
            new FindJob().setVisible(true);
        }
        
         if(ae.getSource() == logout){
            
            setVisible(false); //to remove home
            new Login().setVisible(true);
        }
    }
        
    public static void main(String args[]){
        //Class Object
        new Home(); 
    } 
}
