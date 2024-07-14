package indeed.Login;

import indeed.login.Home;
import indeed.system.DBConnection;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ViewJobs extends JFrame implements ActionListener{
        
    JButton submit;
    
    public ViewJobs(){
        
        //title
        setTitle("Indeed - A Job Search Engine");
       
        JLabel role = new JLabel("Java Developer - Bengaluru, Karnataka");
         role.setBounds(110, 30, 400, 30);
         role.setFont(new Font("Raleway", Font.BOLD,20));
         add(role);
      
          //home image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/1.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);//image to image icon, to pas 
        JLabel label = new JLabel(i3);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        label.setBounds(50,100, 1070, 200);// to maka custom bound aailable we have to set borderlayout as null
        add(label);
         
         //home image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("indeed/images/3.png"));
        Image i22 = i11.getImage().getScaledInstance(800, 200, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);//image to image icon, to pas 
        JLabel labell = new JLabel(i33);//(ImageIcon) firstly have to add images into jlabel 
        setLayout(null);
        labell.setBounds(50,300, 1070, 200);// to maka custom bound aailable we have to set borderlayout as null
        add(labell);
        
     
         //buttons : signup
        submit = new JButton("Home");
        submit.setBounds(1000, 500, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        
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
        
        if(ae.getSource() == submit){
            
             
           setVisible(false); //to remove home
            new Home().setVisible(true);
        }

    }
        
    public static void main(String args[]){
        //Class Object
        new ViewJobs(); 
    } 
}
