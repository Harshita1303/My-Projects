package indeed.signup;


import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

import indeed.system.DBConnection;
import indeed.system.Login;
import java.awt.event.*;
public class Recruiter extends JFrame implements ActionListener{
    
    public long random;
    public JTextField roleTextField,nameTextField, companyNameTextField, emailTextField, phoneTextField,addressTextField, stateTextField, cityTextField, pincodeTextField;
    public JRadioButton male, female, married, unmarried;
    public JButton next, back , cancel;
            
    public Recruiter() {
        
        //title
        setTitle("Automated Teller Machine");
        
        setLayout(null); //border layout
    
        Random ran  = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);

        //Personal Details
        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,17));
        personalDetails.setBounds(150, 2, 500, 100);
        add(personalDetails);
        
        //
        JLabel role = new JLabel("Role: ");
        role.setFont(new Font("Raleway", Font.BOLD,15));
        role.setBounds(80, 30, 500, 100);
        add(role);
        
        roleTextField = new JTextField();
        roleTextField.setFont(new Font("Raleway", Font.BOLD,15));
        roleTextField.setBounds(220, 70, 200, 20);
        add(roleTextField);
       
        //name
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD,15));
        name.setBounds(80, 60, 500, 100);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,15));
        nameTextField.setBounds(220, 100, 200, 20);
        add(nameTextField);
       
                
         //fathers name
        JLabel fname = new JLabel("Company Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD,15));
        fname.setBounds(80, 90, 500, 100);
        add(fname);
        
        companyNameTextField = new JTextField();
        companyNameTextField.setFont(new Font("Raleway", Font.BOLD,15));
        companyNameTextField.setBounds(220, 130, 200, 20);
        add(companyNameTextField);
       
        
         //DOB
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,15));
        dob.setBounds(80, 120, 500, 100);
        add(dob);
       
        JDateChooser date = new JDateChooser();
        date.setBounds(220, 160, 200, 20);
        date.setForeground(new Color(105, 105, 105));
        add(date);
                
        
         //Gender
        JLabel gen = new JLabel("Gender : ");
        gen.setFont(new Font("Raleway", Font.BOLD,15));
        gen.setBounds(80, 150, 500, 100);
        add(gen);
        
        male = new JRadioButton("Male ");
        male.setFont(new Font("Raleway", Font.BOLD,12));
        male.setBounds(220, 190, 100, 20);
        add(male);
        
        female = new JRadioButton("Female ");
        female.setFont(new Font("Raleway", Font.BOLD,12));
        female.setBounds(320, 190, 100, 20);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female );
        
        
         //Email
        JLabel Email = new JLabel("Email Address : ");
        Email.setFont(new Font("Raleway", Font.BOLD,15));
        Email.setBounds(80, 180, 500, 100);
        add(Email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,15));
        emailTextField.setBounds(220, 220, 200, 20);
        add(emailTextField);
       
        
        //Marital Status
        JLabel phone = new JLabel("Phone : ");
        phone.setFont(new Font("Raleway", Font.BOLD,15));
        phone.setBounds(80, 210, 500, 100);
        add(phone);
        
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway", Font.BOLD,15));
        phoneTextField.setBounds(220, 250, 200, 20);
        add(phoneTextField);
        
        
       
        //Address
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,15));
        address.setBounds(80, 240, 500, 100);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,15));
        addressTextField.setBounds(220, 280, 200, 20);
        add(addressTextField);
       
        //City
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD,15));
        city.setBounds(80, 270, 500, 100);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,15));
        cityTextField.setBounds(220, 310, 200, 20);
        add(cityTextField);
       
          //state
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD,15));
        state.setBounds(80, 300, 500, 100);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,15));
        stateTextField.setBounds(220, 340, 200, 20);
        add(stateTextField);
       
          //pincode
        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD,15));
        pincode.setBounds(80, 330, 500, 100);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD,15));
        pincodeTextField.setBounds(220, 370, 200, 20);
        add(pincodeTextField);
 
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
        
        String role = roleTextField.getText();
        String name = nameTextField.getText();
        String Cname = companyNameTextField.getText();
        String gen = null; 
        if(male.isSelected()){
            gen = "Male";
        }
        else{
           gen = "Female"; 
        }
        
        String email = emailTextField.getText();
        
        String phone = phoneTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        

        try{
           
                DBConnection con = new DBConnection();
                
                String query1 = "insert into EmpDetails values('"+role+"','"+name+"','"+Cname+"','"+gen+"','"+email+"','"+phone+"','"+address+"','"+city+"','"+state+"')";
                con.s.executeUpdate(query1);
                
                String query2 = "insert into Login values('"+email+"','"+phone+"')";
                con.s.executeUpdate(query2);
                
                
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully...");

                
            setVisible(false);
            new Login().setVisible(true);
          

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
            new Option().setVisible(true);
        }   
        
    }
        
        
    
    public static void main(String args[]){
        new Recruiter();
    }
    
    
}
