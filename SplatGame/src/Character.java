import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
 public class Character extends Rectangle{
  private Image character1;
  private int lives;
  private String name;
  static int points=0;
  
 Character(int x,int y, int lives, Image character1, String name, int width, int height){
  super(x, y, width, height);
  this.x=x;
  this.y= y;
  this.lives=lives;
  this.name=name;
  this.character1= character1;
  this.width= width;
  this.height= height;
}
 
 public Image getImage(){
  return character1;
}
 
 public double getX(){
  return x;
}
 
 public void setImage(Image img){
  character1= img;
 }
 
 public void setX(int x1){
  x=x-x1;
}
 
 public void moveRight(){
  x=x+20;
}
 
 public void moveLeft(){
  x=x-20;
}
 
 public int getLives() {
  return lives;
 }
  public void loseLife() {
   lives--;
  }
 public void gainPoint() {
  points++;
 }
 
 public int getPoints() {
  return points;
 }
 
 public void drawCharacter(Graphics g){ 
   g.drawImage(character1, x, y, 100, 120, null);
  }
 }