import java.awt.Image;
import java.awt.image.ImageObserver;
import java.applet.AudioClip;
import javax.swing.JApplet;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
 class SplatLetters extends FallingObjects{
  private AudioClip ding;
  private Image letter, splatter, fall;
  private int value;

  SplatLetters(int x, int y, Image fall, Image splatter, int width, int height, int value){
   super(x, y, fall, splatter, 50, 70);
   this.letter=fall;
   this.value=value;
   this.splatter=splatter;
   this.fall=fall;
}

  public AudioClip makeSound(){
   return ding;
} 
  
  public String getLetter() {
   if(value==0) {
    return "S";
   }
   if(value==1) {
    return "P";
   }
   if(value==2) {
    return "L";
   }
   if(value==3) {
    return "A";
   }
   if(value==4) {
    return "T";
   }
   return "null";
  }
  
  public void setLetter(){
   letter=splatter;
 }
     public void setSplat(){
      letter=fall;
     }
  public void draw(Graphics g){
   g.drawImage(letter, x, y, 50, 70, null);
  }
}



