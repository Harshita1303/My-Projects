package indeed.signup;

import indeed.system.DBConnection;
import indeed.system.Login;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Education extends JFrame implements ActionListener{
    public long random;
    public JTextField schoolNameTextField, schoolName1TextField, graduationName1TextField,percentageTextField, percentage1TextField, ypass1TextField, ypass2TextField, board1TextField, board2TextField;
    public JRadioButton male, female, married, unmarried;
    public JButton next, back , cancel;
    
    public Education(){
         //title
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout
    
        Random ran  = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);
        
        
       
        
        //Personal Details
        JLabel personalDetails = new JLabel("Page 3: Education Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        personalDetails.setBounds(150, 10, 500, 100);
        add(personalDetails);
        
        
        //name
        JLabel label1 = new JLabel("Highest Degree Details: ");
        label1.setFont(new Font("Raleway", Font.BOLD,20));
        label1.setBounds(80, 60, 500, 100);
        add(label1);
                
         //fathers name
        JLabel degree = new JLabel("Degree: ");
        degree.setFont(new Font("Raleway", Font.BOLD,15));
        degree.setBounds(80, 90, 500, 100);
        add(degree);
        
        schoolNameTextField = new JTextField();
        schoolNameTextField.setFont(new Font("Raleway", Font.BOLD,15));
        schoolNameTextField.setBounds(220, 130, 200, 20);
        add(schoolNameTextField);
       
        
         //DOB
        JLabel percentage = new JLabel("Course: ");
        percentage.setFont(new Font("Raleway", Font.BOLD,15));
        percentage.setBounds(80, 120, 500, 100);
        add(percentage);
       
        percentageTextField = new JTextField();
        percentageTextField.setFont(new Font("Raleway", Font.BOLD,15));
        percentageTextField.setBounds(220, 160, 200, 20);
        add(percentageTextField);
                
        
        JLabel ypass1 = new JLabel("Stream: ");
        ypass1.setFont(new Font("Raleway", Font.BOLD,15));
        ypass1.setBounds(80, 150, 500, 100);
        add(ypass1);
        
        ypass1TextField = new JTextField();
        ypass1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        ypass1TextField.setBounds(220, 190, 200, 20);
        add(ypass1TextField);
        
    
        JLabel board = new JLabel("Course Status: ");
        board.setFont(new Font("Raleway", Font.BOLD,15));
        board.setBounds(80, 180, 500, 100);
        add(board);
        
        board1TextField = new JTextField();
        board1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        board1TextField.setBounds(220, 220, 200, 20);
        add(board1TextField);
       
   
        
        //Marital Status
        JLabel status = new JLabel("Graduation Date: ");
        status.setFont(new Font("Raleway", Font.BOLD,15));
        status.setBounds(80, 210, 500, 100);
        add(status);
        
        graduationName1TextField = new JTextField();
        graduationName1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        graduationName1TextField.setBounds(220, 250, 200, 20);
        add(graduationName1TextField);
        
        //Address
        JLabel sname = new JLabel("Result Date: ");
        sname.setFont(new Font("Raleway", Font.BOLD,15));
        sname.setBounds(80, 240, 500, 100);
        add(sname);
        
        schoolName1TextField = new JTextField();
        schoolName1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        schoolName1TextField.setBounds(220, 280, 200, 20);
        add(schoolName1TextField);
       
        //City
        JLabel per1 = new JLabel("Backlog(if any): ");
        per1.setFont(new Font("Raleway", Font.BOLD,15));
        per1.setBounds(80, 270, 500, 100);
        add(per1);
        
        percentage1TextField = new JTextField();
        percentage1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        percentage1TextField.setBounds(220, 310, 200, 20);
        add(percentage1TextField);
       
          //state
        JLabel state = new JLabel("Percentage");
        state.setFont(new Font("Raleway", Font.BOLD,15));
        state.setBounds(80, 300, 500, 100);
        add(state);
        
        ypass2TextField = new JTextField();
        ypass2TextField.setFont(new Font("Raleway", Font.BOLD,15));
        ypass2TextField.setBounds(220, 340, 200, 20);
        add(ypass2TextField);
       
//          //pincode
//        JLabel pincode = new JLabel("Board : ");
//        pincode.setFont(new Font("Raleway", Font.BOLD,15));
//        pincode.setBounds(80, 330, 500, 100);
//        add(pincode);
//        
//        board2TextField = new JTextField();
//        board2TextField.setFont(new Font("Raleway", Font.BOLD,15));
//        board2TextField.setBounds(220, 370, 200, 20);
//        add(board2TextField);
 
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
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == next){ 
            
        String name1 = schoolNameTextField.getText();
        String per1 = percentageTextField.getText();
        String year1 = ypass1TextField.getText();
        String board1 = board1TextField.getText();
        String name2 = schoolName1TextField.getText();
        String per2 = percentage1TextField.getText();
        String year2 = ypass2TextField.getText();
       
        

        try{
           
                DBConnection con = new DBConnection();
                String query = "insert into EduDetails2 values('"+name1+"','"+per1+"','"+year1+"','"+board1+"','"+name2+"','"+per2+"','"+year2+"')";
                con.s.executeUpdate(query);
                
                setVisible(false);
                new Experience().setVisible(true);
          

        }
        catch(Exception ee){
            ee.printStackTrace();
        } 
    
        }

        if(e.getSource() == cancel){
            setVisible(false);
        }    
        
       if(e.getSource() == back){
            setVisible(false);
            new Education1().setVisible(true);
        }   
        
    }
    public static void main(String args[]){
        //Class Object
        new Education(); 
    } 
    
}
