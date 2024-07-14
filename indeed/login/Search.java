package indeed.Login;

import indeed.login.PostJob;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Search extends JFrame implements ActionListener{
        
    JButton addjob;
    JTextField role, locatoin;
    
    public Search(){
        
        //title
        setTitle("Indeed - A Job Search Engine");
       
        //home image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/search.jpg"));
        Image i22 = i11.getImage().getScaledInstance(1070, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,20, 1070, 500);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);

        //buttons : signup
        addjob = new JButton("SEARCH");
        addjob.setBounds(765, 285, 200, 50);
        addjob.setBackground(Color.black);
        addjob.setForeground(Color.white);
        addjob.addActionListener(this);
        labell.add(addjob);
        
        role = new JTextField();
        role.setBounds(100, 288, 340, 40);
        role.setForeground(Color.black);//font color
        role.setFont(new Font("System", Font.BOLD, 12));
        labell.add(role);
        
        locatoin = new JTextField();
        locatoin.setBounds(440, 288, 320, 40);
        locatoin.setForeground(Color.black);//font color
        locatoin.setFont(new Font("System", Font.BOLD, 12));
        labell.add(locatoin);
         
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
            new ViewJobs().setVisible(true);
        }

    }
        
    public static void main(String args[]){
        //Class Object
        new Search(); 
    } 
}
