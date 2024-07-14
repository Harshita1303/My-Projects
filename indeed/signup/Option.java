package indeed.signup;

import indeed.system.Login;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Option extends JFrame implements ActionListener{
    
     JButton jobSeeker, employer,home;
             
    public Option(){
     //title
        setTitle("Indeed - A Job Search Engine");
   
        //home image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/woman.png"));
        Image i22 = i11.getImage().getScaledInstance(1070, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,50, 1070, 500);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);
  
        //buttons : signup
        jobSeeker = new JButton("JOB SEEKER");
        jobSeeker.setBounds(380, 300, 200, 50);
        jobSeeker.setBackground(Color.black);
        jobSeeker.setForeground(Color.white);
        jobSeeker.addActionListener(this);
        labell.add(jobSeeker);
        
          //buttons : clear
        employer = new JButton("RECRUITER");
        employer.setBounds(380, 370, 200, 50);
        employer.setBackground(Color.black);
        employer.setForeground(Color.white);
        employer.addActionListener(this);
        labell.add(employer);
 
        //buttons : signup
        home = new JButton("LOGIN");
        home.setBounds(1000, 500, 100, 30);
        home.setBackground(Color.black);
        home.setForeground(Color.white);
        home.addActionListener(this);
        add(home);
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
    
        if(ae.getSource() == jobSeeker){
             setVisible(false); //to remove home
            new Jobseeker().setVisible(true);

        }
               
        else if(ae.getSource() == employer){
            setVisible(false); //to remove home
            new Recruiter().setVisible(true);
            }
        else if(ae.getSource() == home){
            setVisible(false); //to remove home
            new Login().setVisible(true);
            }
    }
    
    public static void main(String args[]){
        //Class Object
        new Option(); 
    }
}
