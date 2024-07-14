package snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//ActionListener: to capture actions : actionPerformed(ActionEvent e)
//Panel:some part of Component(frames), assigned with particular work
public class Board extends JPanel implements ActionListener{
    
    //global declaration: so we can use dots variable in different classes
    private int dots;
    
    private Image apple;  //Image : awt class
    private Image dot;
    private Image head;
    
    private final int allDots = 900;
    private final int dotSize = 10;
    
    private final int x[] = new int[allDots] ;
    private final int y[] = new int[allDots] ;
    
    private final int randomPosition =29;
    
    private int apple_x;
    private int apple_y;
    
    private Timer timer;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    
    private boolean inGame = true;
    
    //creating object in snakegame class
    public Board(){
        
        addKeyListener(new TAdapter());
        //BG color : awt
        //setBackground(new Color(0, 0, 0));
        setBackground(Color.black);
        
        
        setPreferredSize(new Dimension(300, 300));
        //to focus frames
        setFocusable(true);
        
        //load images
        //if images is not present,then no initailization will be occured
        loadImages();
        
        //startig the game
        initializeGame();
    }
    
    //take images from system
    public void loadImages(){
        //takes images from the system
        //path: after source(src) 
        //ImageIcon: awt class
        ImageIcon iCon1 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/apple.png"));
        apple = iCon1.getImage(); //to assign the images in apple variable
        
        ImageIcon iCon2 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/dot.png"));
        dot = iCon2.getImage();
        
        ImageIcon iCon3 = new ImageIcon(ClassLoader.getSystemResource("snakegame/icons/head.png"));
        head = iCon3.getImage();
        
        //now we have to place the images in frames 
    }
    
    //start game
    public void initializeGame(){
        
        //1-head and 2-apple
        // dots - images
        dots = 3; 
        
        for(int i=0; i<dots ; i++){
            y[i] = 50; //cant take both as 50 
            x[i] = 50 - i*dotSize ;

        }
        
        locateApple();
         
        timer = new Timer(140, this);
        timer.start();
    }
    
    //to locate apple
    public void locateApple(){
        
        int r = (int)(Math.random() * randomPosition);   //decimal values  
        apple_x = r*dotSize;
        
        r = (int)(Math.random() * randomPosition);
        apple_y = r*dotSize;
    }
    
    //to show the images in frames, we paint the images in the frame
    //paintComponent: graphics class
    //pass graphic object
    public void paintComponent(Graphics g){
        
        //calls parents paintComponent
        super.paintComponent(g);
        
        //to draw the images
        draw(g);
    }
    
    //to draw the images in frames
    public void draw(Graphics g){
        
        if(inGame){
            g.drawImage(apple, apple_x, apple_y, this);
            //we have to draw the 3 images 
            for(int i=0; i<dots; i++){

                //head
                if(i== 0){
                    g.drawImage(head, x[0], y[i], this);
                }
                else{
                    g.drawImage(dot, x[i], y[i], this);
                }
            }

            //initializing with default toolkit
            Toolkit.getDefaultToolkit().sync();
        }
        else{
            gameOver(g);  
        }  
    }
    
    
     public void gameOver(Graphics g){
             String msg = "Game Over!";
             
             Font font = new Font("SAN_SERIF", Font.BOLD, 14);
             
             FontMetrics metrices = getFontMetrics(font);
             g.setColor(Color.white);
             g.setFont(font);
             g.drawString(msg, (300 - metrices.stringWidth(msg))/2, 300/2);
     
     }
     
     
    public void move(){
        for(int i=dots; i>0; i--){
            
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        if(leftDirection){
            x[0] = x[0] - dotSize;
        }
        if(rightDirection){
            x[0] = x[0] + dotSize;
        }
        if(upDirection){
            y[0] = y[0] - dotSize;
        }
        if(downDirection){
            y[0] = y[0] + dotSize;
        }
        
//        x[0] += dotSize;
//        y[0] += dotSize;
    }
    
    
    public void  checkApple(){
        
        if((x[0] == apple_x) && (y[0]==apple_y)){
            dots++;
            locateApple();
        }
    }
    
    
    public void  checkCollision(){
        for(int i=dots ;i>0; i--){
            //snake collision
            if((i>4)&& (x[0]==x[i]) && (y[0]==y[i])){
                inGame = false;
            }
            
        }
        
        if(y[0] >= 300){
             inGame = false;
        }
        if(x[0] >= 300){
             inGame = false;
        }
        if(x[0] < 0){
             inGame = false;
        }
        if(y[0] < 0){
             inGame = false;
        }
        
        if(!inGame){
            timer.stop();
            
        }
    }
    
    
    public void actionPerformed(ActionEvent ae){
          
        if(inGame){
           checkApple();
        
           checkCollision();
           
           //to make our snake move 
            move();
        }
        
            //refresh method
            repaint();
            
            
        }

    //to handle snake
    public class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            
            int key = e.getKeyCode();
            
            if(key == KeyEvent.VK_LEFT && (!rightDirection))
            {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            
             if(key == KeyEvent.VK_RIGHT && (!leftDirection))
            {   
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
             
              if(key == KeyEvent.VK_UP && (!downDirection))
            {   
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
              
               if(key == KeyEvent.VK_DOWN && (!upDirection))
            {
               downDirection = true;
                leftDirection = false;
                rightDirection = false;
                
            }
        }
    }
} 


