package snakegame;

import javax.swing.*;

public class SnakeGame extends JFrame{

    //default constructor: 0-parameterized constructor: Constructor with no parameter
    //Constructor is called while object creation
    SnakeGame(){
        
        //to call parent class Constructor
        //frame heading 
        //super must be first statement inside the constructor, other error will occur
        super("Snake Game");
        
        //board object
        //add: to add the board functionalites in frame
        //error: add is not a swing component
        add(new Board());
        
        //refresh: 
        //reload/render things after any change in program
        //reflect changes in frame by refreshing it
        //same as setVisible but
        //can be used more than one time 
        pack(); 
        
        //Size Location
        //to align the frame in center we have to setsize before setlocation
        //setSize(300,300);
        
        //frame location
        //setLocation(600, 100);
        setLocationRelativeTo(null);
        
        //jframe class: javax.swing :creates frame
        //one time use
        setVisible(true);
        
        setResizable(false);
    }
    public static void main(String[] args) {
       
       //creating object of class SnakeGame
       //while executing the program, we need frames to be displayed in the screen 
       //to do so we need to add all the code in the Constructor named SnakeGame
       new SnakeGame();
    }
    
}

/*
object 

constructor

 jframe class: javax.swing :creates frame 

setLocation(x, y)

setSize(w, h)

setVisible(true)

*/