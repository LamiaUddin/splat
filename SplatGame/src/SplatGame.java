import javax.imageio.ImageIO;import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class SplatGame extends JFrame implements ActionListener{
  Graphics g, g1 ;
  BufferedImage bImage, img;
  JLabel label, but;
  ImageIcon iIcon;
  SplatLetters[] splat, empty;
  Fruits[] fruits;
  Sweets[] sweets;
  Character character;
  JPanel  game;
  ImageIcon icon ;
  Image image ;
  int letter;
  AudioClip clip;
//menubar 
  static JMenuBar menu; 

  // JMenu 
  static JMenu h; 

  // Menu items 
  static JMenuItem help; 


  // a label 
  static JLabel h2; 

  public SplatGame() {

      // create a menubar 
      menu = new JMenuBar(); 
      // create a menu 
      h = new JMenu("Menu"); 
      // create menuitems 
      help = new JMenuItem("Instructions"); 
      // add ActionListener to menuItems 
      help.addActionListener(this); 
      // add menu items to menu 
      h.add(help); 
      // add menu to menu bar 
      menu.add(h); 
      // add menubar to frame 
      this.setJMenuBar(menu); 
    setTitle("Splat");
    setSize(1000,1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    fruits= new Fruits[5];
    fruits= generateFruits();
    sweets= new Sweets[5];
    sweets= generateSweets();
    splat= new SplatLetters[5];
    splat= generateLetters();
    empty= new SplatLetters[5];
    empty= emptyLetters();
    try{
        icon = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream("/Right.png")));
        image = icon.getImage();

       }
       catch(IOException ioe){
        System.out.println("null");
       }
      character=new Character(500, 670, 3, image, "lamia", 120, 140);
      //URL urlClick = SplatGame.class.getResource("/splatback.wav");
	   //clip = Applet.newAudioClip(urlClick);
	  // clip.play();
        Timer myTimer;
        label = new JLabel();
        bImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        g =  bImage.getGraphics();
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0, getWidth(),getHeight());
        myTimer = new Timer (2, new ActionListener(){
           public void actionPerformed (ActionEvent evt){
        	   if(character.getLives() !=0) {
        		   drawEverything(g);
        	   }
        	   if(character.getLives()<=0) {
        		   JOptionPane.showMessageDialog (null, "<html>You have run out of lives<br> SCORE:"+character.getPoints(), "GAME OVER",
        	                 JOptionPane.INFORMATION_MESSAGE);
        			 System.exit(0);   
        	   }
           }
         });
        this.requestFocus();
        this.addKeyListener (new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                	 try{
                	        ImageIcon icon1 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream("/Left.png")));
                	        Image image1 = icon1.getImage();
                	        character.setImage(image1);
                	       }
                	       catch(IOException ioe){
                	        System.out.println("null");
                	       }
                    character.moveLeft();
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                	try{
            	        ImageIcon icon1 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream("/Right.png")));
            	        Image image1 = icon1.getImage();
            	        character.setImage(image1);
            	       }
            	       catch(IOException ioe){
            	        System.out.println("null");
            	       }
                   character.moveRight();
                }
               drawEverything(g);
             }
          });
         myTimer.start();
        // timer.start();
         this.add(label);//this adds the label with the image onto the frame
         setVisible(true);//makes the frame visible
   }
  public void actionPerformed(ActionEvent e) {
	  JOptionPane.showMessageDialog (this, "<html>1. Use arrow left and right arrow keys to move character.<br> 2. Try to capture the healthy food (i.e. apples) they are each worth one point.<br> 3. Everytime you capture an unhealthy food, you will lose a life.<br>4. You will have 3 lives.<br>5. If you capture a letter from SPLAT you gain two points.<br>6. If you catch all five SPLAT letters, you will earn an extra 15 points.<br>OBJECTIVE: Gain as many points before losing all 3 lives.", "INSTRUCTIONS",
              JOptionPane.INFORMATION_MESSAGE);
	  //instructions panel
      } 
  

  public void drawFallingObjects(Graphics g){
	  	  splat[0].draw(g);
	      splat[0].objectFall(10);
		  splat[1].draw(g);
		  splat[1].objectFall(5);
		  splat[2].draw(g);
		  splat[2].objectFall(2);
		  splat[3].draw(g);
		  splat[3].objectFall(5);
		  splat[4].draw(g);
		  splat[4].objectFall(10);
		 
		  sweets[0].draw(g);
		  sweets[0].objectFall(2);
		  sweets[1].draw(g);
		  sweets[1].objectFall(5);
		  sweets[2].draw(g);
		  sweets[2].objectFall(10);
		  sweets[3].draw(g);
		  sweets[3].objectFall(10);
		  sweets[4].draw(g);
		  sweets[4].objectFall(2);
		  
		  fruits[0].draw(g);
		  fruits[0].objectFall(5);
		  fruits[1].draw(g);
		  fruits[1].objectFall(2);
		  fruits[2].draw(g);
		  fruits[2].objectFall(5);
		  fruits[3].draw(g);
		  fruits[3].objectFall(8);
		  fruits[4].draw(g);
		  fruits[4].objectFall(5);
		  //draws objects falling from sky
		  }

  public void drawEverything(Graphics g) {
	   
   drawBackground(g); 
   drawFallingObjects(g);
   character.drawCharacter(g);
   for(int count=0; count<5; count++){
	   if(sweets[count].intersects(character)) {
		   character.loseLife();
		   sweets[count].setY(-30);
		   sweets[count].setX(randX());
		   sweets[count].draw(g);
		   

	   }
	   if(sweets[count].getY() == 690) {
			  sweets[count].setSweets();
			  sweets[count].draw(g);
		  }
	   if(sweets[count].getY() == 700){
		   sweets[count].setY(-60);
		   sweets[count].setX(randX());
		   sweets[count].setSplat();
		   sweets[count].draw(g);
	   }
	   if(fruits[count].intersects(character)) {
		   character.gainPoint();
		   fruits[count].setY(-80);
		   fruits[count].setX(randX());
		   fruits[count].draw(g);
	   }
	   if(fruits[count].getY() == 690) {
			  fruits[count].setFruits();
			  fruits[count].draw(g);
		  }
	   if(fruits[count].getY() == 700){
		   fruits[count].setY(-100);
		   fruits[count].setX(randX());
		   fruits[count].setSplat();
		   fruits[count].draw(g);
	   }
	   if(splat[count].intersects(character)) {
		   character.gainPoint();
		   character.gainPoint();
		   empty[count].setLetter();
		   splat[count].setY(3000);
		   splat[count].setX(randX());
		   splat[count].draw(g);
		   letter++;
			   if(letter==5){
				 character.gainPoint(); 
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint(); 
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint(); 
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
				 character.gainPoint();
			   }
	   }
	   if(splat[count].getY() ==695) {
			  splat[count].setLetter();
			  splat[count].draw(g);
			 }
	   if(splat[count].getY() == 700){
		   splat[count].setY(-300);
		   splat[count].setX(randX());
		   splat[count].setSplat();
		   splat[count].draw(g);
	   }
   }
   iIcon = new ImageIcon(bImage);// makes an ImageIcon from BufferedImage 
   label.setIcon(iIcon);//this applies the image onto the Jlabel object that covers the frame
   this.add(label);//this adds the label with the image onto the frame
   setVisible(true);//makes the frame visible
  }
 public Fruits[] generateFruits(){
	 Fruits[] fruits= new Fruits[5];
	 int num=1;
	 for(int count=0; count<5; count++){
		 String name= "/H"+num+".png";
		 String name1= "/H"+num+num+".png";
		 num++;
		 try{
 	        ImageIcon i = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name)));
 	        Image img = i.getImage();
 	       ImageIcon i2 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name1)));
	        Image img2 = i2.getImage();
 	       fruits[count]= new Fruits(randX(), 0, img, img2, 80,90);
 	       }
 	       catch(IOException ioe){
 	        System.out.println("null");
 	       }
	 }
	 return fruits;
 }
 public Sweets[] generateSweets(){
	 Sweets[] sweets= new Sweets[5];
	 int num= 1;
	 for(int count=0; count<5; count++){
		 String name= "/J"+num+".png";
		 String name1= "/J"+num+num+".png";
		 try{
 	        ImageIcon i2 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name)));
 	        Image img2 = i2.getImage();
 	       ImageIcon i = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name1)));
	        Image img = i.getImage();
 	       sweets[count]= new Sweets(randX(), 0, img2, img, 80,90);
 	       }
 	       catch(IOException ioe){
 	        System.out.println("null");
 	       }
		 num++;
	 }
	 return sweets;
 }
 public SplatLetters[] generateLetters(){
	 SplatLetters[] splat= new SplatLetters[5];
	 int num= 1;
	 for(int count=0; count<5; count++){
		 String name= "/L"+num+".png";
		 String name1= "/L"+num+num+".png";
		 try{
 	        ImageIcon i2 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name)));
 	        Image img2 = i2.getImage();
 	       ImageIcon i = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name1)));
	        Image img = i.getImage();
 	       splat[count]= new SplatLetters(randX(), 0, img2, img, 100, 90, count);
 	       }
 	       catch(IOException ioe){
 	        System.out.println("null");
 	       }
		 num++;
	 }
	 return splat;
 }
 public SplatLetters[] emptyLetters(){
	 SplatLetters[] empty= new SplatLetters[5];
	 int num= 1;
	 int x=100;
	 for(int count=0; count<5; count++){
		 String name= "/E"+num+".png";
		 String name1= "/L"+num+".png";
		 try{
 	        ImageIcon i2 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name)));
 	        Image img2 = i2.getImage();
 	       ImageIcon i = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream(name1)));
	        Image img = i.getImage();
 	       empty[count]= new SplatLetters(0, x, img2, img, 80, 90, count);
 	       }
 	       catch(IOException ioe){
 	        System.out.println("none");
 	       }
		 num++;
		 x=x+100;
	 }
	 return empty;
 }

 void drawBackground(Graphics g){
     try{
	        ImageIcon i2 = new ImageIcon(ImageIO.read(SplatGame.class.getResourceAsStream("/gameBack.jpg")));
	        Image img2 = i2.getImage();
	        g.drawImage(img2, 0, 0, getWidth(), getHeight(), null);
	        g.setColor(Color.BLACK);
	        Font font= new Font("SansSerif", Font.BOLD, 18);
	        g.setFont(font);
	        g.drawString("Points:"+character.getPoints(), 10, 650);
	        g.drawString("Lives:"+character.getLives(), 10, 700);
     }
	       catch(IOException ioe){
	        System.out.println("null");
	       }
     for(int count=0; count<5; count++){
    	 empty[count].draw(g);
    	 if(splat[count].intersects(character)){
    			empty[count].setLetter(); 
    			

    	 }
     }
      iIcon = new ImageIcon(bImage);// makes an ImageIcon from BufferedImage 
      label.setIcon(iIcon);//this applies the image onto the Jlabel object that covers the frame
      this.add(label);//this adds the label with the image onto the frame
      setVisible(true);//makes the frame visible
 }
 public int randX() {
	 int random = (int)(Math.random() * 1000);
	 return random;
}

 public static void main ( String[] args ){
     javax.swing.SwingUtilities.invokeLater(new Runnable(){
       public void run(){
         SplatGame splat = new SplatGame();//creates the main window
         splat.setVisible(true);
       }
     });
  }
}