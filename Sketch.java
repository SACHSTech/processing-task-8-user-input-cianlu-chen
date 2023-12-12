import processing.core.PApplet;
import processing.core.PImage;
import java.awt.event.MouseEvent;

public class Sketch extends PApplet {
  // Images
  PImage imgBackground;
  PImage imgCake;
  PImage imgCream;
	
  public void settings() {
    size(750, 750);
  }

  public void setup() {
    imgBackground = loadImage("background.jpg");
    imgBackground.resize(750, 750);

    imgCake = loadImage("cake.png");
    imgCake.resize(400, 400);

    imgCream = loadImage("cream.png");
    imgCream.resize(50, 50);

    image(imgBackground, 0, 0);
    image(imgCake, 175, 145);
  }

  public void draw() {
    if(mousePressed){
      noStroke();
      fill(200, 250, 250);
      ellipse(mouseX, mouseY, 20, 20);
    }
  }

  public void mouseClicked(){
    if(true){
      image(imgCream, mouseX - 25, mouseY - 25);
    }
  }
}