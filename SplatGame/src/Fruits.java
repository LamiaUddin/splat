
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

import javax.print.DocFlavor.URL;
 class Fruits extends FallingObjects{
  private AudioClip good;
  private Image fruits, splatter, fall;

  Fruits(int x, int y, Image fall, Image splatter, int width, int height){
   super(x, y, fall, splatter, width, height);
   this.fruits=fall;
   this.splatter=splatter;
   this.fall=fall;
}

  public void addPoints(/* add a points variable in the main game and put it here as a parameter*/ int points){
   points++;
}

  public AudioClip makeSound(){
	  
   return good;
}

  public void setFruits(){
   fruits=splatter;
 }
  public void setSplat(){
   fruits=fall;
  }
  public void draw(Graphics g){
   g.drawImage(fruits, x, y, width, height, null);
  }
}

