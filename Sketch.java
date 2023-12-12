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
    int frostingColour = readColour();

    stroke(255);
    fill(200, 250, 250);
    rect(10, 10, 40, 40);

    fill(250, 200, 250);
    rect(60, 10, 40, 40);

    fill(250, 250, 200);
    rect(110, 10, 40, 40);

    if(mousePressed){
      noStroke();
      fill(frostingColour);
      ellipse(mouseX, mouseY, 20, 20);
    }
  }

  public void blueFrost(){
    if(mouseX >= 160 || mouseY >= 60){
      if(mousePressed){
        noStroke();
        fill(200, 250, 250);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void redFrost(){
    if(mouseX >= 160 || mouseY >= 60){
      if(mousePressed){
        noStroke();
        fill(250, 200, 250);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void yellowFrost(){
    if(mouseX >= 160 || mouseY >= 60){
      if(mousePressed){
        noStroke();
        fill(250, 250, 200);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void mouseClicked(){
    if(mouseX >= 160 || mouseY >= 60){
      image(imgCream, mouseX - 25, mouseY - 25);
    }
  }

  public int readColour(){
    return get(mouseX, mouseY);
  }
}