import java.awt.Image;
import java.applet.AudioClip;
import javax.swing.JApplet;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
 class Sweets extends FallingObjects{
  private AudioClip bad;
  private int pointsLost;
  private Image sweets, splatter, fall;

  Sweets(int x, int y, Image fall, Image splatter, int width, int height){
   super(x, y, fall, splatter, 50, 70);
   this.sweets=fall;
   this.splatter=splatter;
   this.fall= fall;
}
  public int losePoints(/* add a points variable in the main game and put it here as a parameter*/ int points){
   if(points>0){
    points--;
   }
   return points;
}
  public AudioClip makeSound(){
   return bad;
}
  public void setSweets(){
   sweets=splatter;
 }
  
  public void setSplat(){
   sweets=fall;
 }
  
  public void draw(Graphics g){
   g.drawImage(sweets, x, y, width, height, null);
  }
}