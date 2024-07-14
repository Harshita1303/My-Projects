package indeed.login;

import indeed.signup.Education;
import indeed.system.DBConnection;
import indeed.system.Login;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PostJob extends JFrame implements ActionListener{
    public long random;
    public JTextField jobTitleTextField, companyNameTextField, experienceTextField, salaryTextField, locationTextField, skillsTextField, descriptionName1TextField, categoryTextField, statusTextField;
    public JRadioButton male, female, married, unmarried;
    public JButton next, back , cancel;
    
    public PostJob(){
         //title
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout
 
        //Personal Details
        JLabel personalDetails = new JLabel("Page 1: Job Description");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        personalDetails.setBounds(150, 10, 500, 100);
        add(personalDetails);
        
        
        //name
        JLabel label1 = new JLabel("Job Title: ");
        label1.setFont(new Font("Raleway", Font.BOLD,15));
        label1.setBounds(80, 60, 500, 100);
        add(label1);
        
        jobTitleTextField = new JTextField();
        jobTitleTextField.setFont(new Font("Raleway", Font.BOLD,15));
        jobTitleTextField.setBounds(220, 100, 200, 20);
        add(jobTitleTextField);
                
         //fathers name
        JLabel degree = new JLabel("Company Name: ");
        degree.setFont(new Font("Raleway", Font.BOLD,15));
        degree.setBounds(80, 90, 500, 100);
        add(degree);
        
        companyNameTextField = new JTextField();
        companyNameTextField.setFont(new Font("Raleway", Font.BOLD,15));
        companyNameTextField.setBounds(220, 130, 200, 20);
        add(companyNameTextField);
       
        
         //DOB
        JLabel percentage = new JLabel("Year Experience: ");
        percentage.setFont(new Font("Raleway", Font.BOLD,15));
        percentage.setBounds(80, 120, 500, 100);
        add(percentage);
       
        experienceTextField = new JTextField();
        experienceTextField.setFont(new Font("Raleway", Font.BOLD,15));
        experienceTextField.setBounds(220, 160, 200, 20);
        add(experienceTextField);
                
        
        JLabel ypass1 = new JLabel("Salary: ");
        ypass1.setFont(new Font("Raleway", Font.BOLD,15));
        ypass1.setBounds(80, 150, 500, 100);
        add(ypass1);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Raleway", Font.BOLD,15));
        salaryTextField.setBounds(220, 190, 200, 20);
        add(salaryTextField);
        
    
        JLabel board = new JLabel("Location: ");
        board.setFont(new Font("Raleway", Font.BOLD,15));
        board.setBounds(80, 180, 500, 100);
        add(board);
        
        locationTextField = new JTextField();
        locationTextField.setFont(new Font("Raleway", Font.BOLD,15));
        locationTextField.setBounds(220, 220, 200, 20);
        add(locationTextField);

        JLabel status = new JLabel("Skills Required: ");
        status.setFont(new Font("Raleway", Font.BOLD,15));
        status.setBounds(80, 250, 500, 20);
        add(status);
        
        skillsTextField = new JTextField();
        skillsTextField.setFont(new Font("Raleway", Font.BOLD,15));
        skillsTextField.setBounds(220, 250, 200, 20);
        add(skillsTextField);
        
        JLabel pincode = new JLabel("Status : ");
        pincode.setFont(new Font("Raleway", Font.BOLD,15));
        pincode.setBounds(80, 280, 500, 20);
        add(pincode);
        
        statusTextField = new JTextField();
        statusTextField.setFont(new Font("Raleway", Font.BOLD,15));
        statusTextField.setBounds(220, 280, 200, 20);
        add(statusTextField);
 
          //state
        JLabel state = new JLabel("Category:");
        state.setFont(new Font("Raleway", Font.BOLD,15));
        state.setBounds(80, 310, 500, 20);
        add(state);
        
        categoryTextField = new JTextField();
        categoryTextField.setFont(new Font("Raleway", Font.BOLD,15));
        categoryTextField.setBounds(220, 310, 200, 20);
        add(categoryTextField);
       
        //Address
        JLabel sname = new JLabel("Description: ");
        sname.setFont(new Font("Raleway", Font.BOLD,15));
        sname.setBounds(80, 340, 500, 20);
        add(sname);
        
        descriptionName1TextField = new JTextField();
        descriptionName1TextField.setFont(new Font("Raleway", Font.BOLD,15));
        descriptionName1TextField.setBounds(220, 340, 200, 50);
        add(descriptionName1TextField);
       

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
             String name1 = jobTitleTextField.getText();
        String per1 = companyNameTextField.getText();
        String year1 = experienceTextField.getText();
        String board1 = salaryTextField.getText();
        String name2 = locationTextField.getText();
        String per2 =  skillsTextField.getText();
        String year2 = statusTextField.getText();
        String board2 = categoryTextField.getText();
        

        try{
           
                DBConnection con = new DBConnection();
                String query = "insert into EduDetails1 values('"+name1+"','"+per1+"','"+year1+"','"+board1+"','"+name2+"','"+per2+"','"+year2+"','"+board2+"')";
                con.s.executeUpdate(query);

                  setVisible(false);
                new Education().setVisible(true);
          

        }
        catch(Exception ee){
            ee.printStackTrace();
        } 
                setVisible(false);
                new Home().setVisible(true);
          

        }

        if(e.getSource() == cancel){
            setVisible(false);
        }    
        
       if(e.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        }   
        
    }
    public static void main(String args[]){
        //Class Object
        new PostJob(); 
    } 
    
}
