package indeed.Login;

import indeed.login.PostJob;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class NewJob extends JFrame implements ActionListener{
        
    JButton addjob;
    
    public NewJob(){
        
        //title
        setTitle("Indeed - A Job Search Engine");
       
        //home image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/page1.png"));
        Image i22 = i11.getImage().getScaledInstance(1070, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,20, 1070, 500);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);

        //buttons : signup
        addjob = new JButton("ADD A JOB");
        addjob.setBounds(215, 290, 150, 50);
        addjob.setBackground(Color.black);
        addjob.setForeground(Color.white);
        addjob.addActionListener(this);
        labell.add(addjob);
        
       
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
        
        if(ae.getSource() == addjob){
            
             setVisible(false); //to remove home
            new PostJob().setVisible(true);
        }

    }
        
    public static void main(String args[]){
        //Class Object
        new NewJob(); 
    } 
}
