package indeed.signup;

import indeed.system.DBConnection;
import indeed.system.Login;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Experience extends JFrame implements ActionListener{
    public long random;
    public JTextField titleTextField, companyNameTextField, companyAddressTextField,fromTextField, toTextField, dutyTextField, reasonTextField;
    public JRadioButton male, female, married, unmarried;
    public JButton Skip,next, back , cancel;
    
    public Experience(){
         //title
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout
    
        
        //Personal Details
        JLabel personalDetails = new JLabel("Page 4: Experience Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,20));
        personalDetails.setBounds(150, 10, 500, 100);
        add(personalDetails);
        
        
        //name
        JLabel title = new JLabel("Job Title: ");
        title.setFont(new Font("Raleway", Font.BOLD,15));
        title.setBounds(80, 60, 500, 100);
        add(title);
        
        titleTextField = new JTextField();
        titleTextField.setFont(new Font("Raleway", Font.BOLD,15));
        titleTextField.setBounds(220, 100, 200, 20);
        add(titleTextField);
       
                
         //fathers name
        JLabel Cname = new JLabel("Company Name : ");
        Cname.setFont(new Font("Raleway", Font.BOLD,15));
        Cname.setBounds(80, 90, 500, 100);
        add(Cname);
        
        companyNameTextField = new JTextField();
        companyNameTextField.setFont(new Font("Raleway", Font.BOLD,15));
        companyNameTextField.setBounds(220, 130, 200, 20);
        add(companyNameTextField);
       
        
         //DOB
        JLabel cadd = new JLabel("Company Address: ");
        cadd.setFont(new Font("Raleway", Font.BOLD,15));
        cadd.setBounds(80, 120, 500, 100);
        add(cadd);
       
        companyAddressTextField = new JTextField();
        companyAddressTextField.setFont(new Font("Raleway", Font.BOLD,15));
        companyAddressTextField.setBounds(220, 160, 200, 50);
        add(companyAddressTextField);
       
        
         //Email
        JLabel Email = new JLabel("From : ");
        Email.setFont(new Font("Raleway", Font.BOLD,15));
        Email.setBounds(80, 180, 500, 100);
        add(Email);
        
        fromTextField = new JTextField();
        fromTextField.setFont(new Font("Raleway", Font.BOLD,15));
        fromTextField.setBounds(220, 220, 200, 20);
        add(fromTextField);
       
        
        //Marital Status
        JLabel to = new JLabel("To: ");
        to.setFont(new Font("Raleway", Font.BOLD,15));
        to.setBounds(80, 210, 500, 100);
        add(to);
        
        toTextField = new JTextField();
        toTextField.setFont(new Font("Raleway", Font.BOLD,15));
        toTextField.setBounds(220, 250, 200, 20);
        add(toTextField);
        
        
        //Address
        JLabel duty = new JLabel("Duties : ");
        duty.setFont(new Font("Raleway", Font.BOLD,15));
        duty.setBounds(80, 240, 500, 100);
        add(duty);
        
        dutyTextField = new JTextField();
        dutyTextField.setFont(new Font("Raleway", Font.BOLD,15));
        dutyTextField.setBounds(220, 280, 200, 20);
        add(dutyTextField);
       
        //City
        JLabel reason = new JLabel("Reason Leaving : ");
        reason.setFont(new Font("Raleway", Font.BOLD,15));
        reason.setBounds(80, 270, 500, 100);
        add(reason);
        
        reasonTextField = new JTextField();
        reasonTextField.setFont(new Font("Raleway", Font.BOLD,15));
        reasonTextField.setBounds(220, 310, 200, 90);
        add(reasonTextField);
       
        
        Skip = new JButton("Skip");
            Skip.setFont(new Font("Raleway", Font.BOLD,15));
            Skip.setBounds(40, 420, 100, 20);
            Skip.setForeground(Color.white);
            Skip.setBackground(Color.black);
            Skip.addActionListener(this);
            add(Skip);
      
 
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
        
         if(e.getSource() == Skip){
            setVisible(false);
            new Login().setVisible(true);
        }
        if(e.getSource() == next){
                  setVisible(false);
           new Experience().setVisible(true);
        
        String title = titleTextField.getText();
        String Cname = companyNameTextField.getText();
        String cadd = companyAddressTextField.getText(); 
        
        String from = fromTextField.getText();
        
        String to = toTextField.getText();
        
        String duty = dutyTextField.getText();
        String reason = reasonTextField.getText();
        

        try{
           
                DBConnection con = new DBConnection();
                String query = "insert into ExpDetails values('"+title+"','"+Cname+"','"+cadd+"','"+from+"','"+to+"','"+reason+"')";
                con.s.executeUpdate(query);
        
            setVisible(false);
            new Login().setVisible(true);
          

        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        
        
           
        if(e.getSource() == cancel){
            setVisible(false);
        }    
        
       if(e.getSource() == back){
            setVisible(false);
            new Education().setVisible(true);
        }   
        }
    }
    public static void main(String args[]){
        //Class Object
        new Experience(); 
    } 
    
}
