import java.awt.Rectangle;
import java.awt.Image;
import java.applet.AudioClip;
import javax.swing.JApplet;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
 abstract class FallingObjects extends Rectangle{
  private Image fall, splatter;

  FallingObjects(int x, int y, Image fall, Image splatter, int width, int height){
   super(x, y, width, height);
}

 public Image getFallingImage(){
  return fall;
}

 public Image getSplatterImage(){
  return splatter;
}
 
 public double getX(){
  return x;
}

 public double getY(){
  return y;
}

 public void setX(int x1){
  x=x1;
}

 public void setY(int y1){
  y=y1;
}

 public void objectFall(int x){
  y=y+x;
}

 abstract AudioClip makeSound();
 abstract void draw(Graphics g);
}

