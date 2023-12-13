import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Images
  PImage imgBackground;
  PImage imgCake;
  PImage imgCream;
  PImage imgStrawberry;
  PImage imgCandle;
  PImage imgSmallCandle;

  // Variables
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  int moleyX = 100;
  int moleyY = 500;

  int topOption = 0;

  String strUser = "";
	
  public void settings() {
    size(750, 750);
  }

  public void setup() {
    // Load and resize images
    imgBackground = loadImage("background.jpg");
    imgBackground.resize(750, 750);

    imgCake = loadImage("cake.png");
    imgCake.resize(400, 400);

    imgCream = loadImage("cream.png");
    imgCream.resize(50, 50);

    imgStrawberry = loadImage("strawberry.png");
    imgStrawberry.resize(50, 50);

    imgCandle = loadImage("candle.png");
    imgCandle.resize(100, 100);

    imgSmallCandle = loadImage("smaller candle.png");
    imgSmallCandle.resize(50, 50);

    // Draws background and cake
    image(imgBackground, 0, 0);
    image(imgCake, 175, 145);
  }

  public void draw() {
    // Calls the 'snake' function
    moley(moleyX, moleyY);

    // Frosting menu
    stroke(255);
    fill(200, 250, 250);
    rect(10, 10, 40, 40);

    fill(250, 200, 200);;
    rect(60, 10, 40, 40);

    fill(250, 250, 200);
    rect(110, 10, 40, 40);

    fill(200, 250, 200);
    rect(160, 10, 40, 40);

    fill(230, 200, 250);
    rect(210, 10, 40, 40);

    textSize(50);
    fill(150);
    text("1", 17, 47);
    text("2", 67, 47);
    text("3", 117, 47);
    text("4", 167, 47);
    text("5", 217, 47);

    // Topping menu
    if(topOption == 0){
      fill(214, 75, 75);
      rect(60, 70, 50, 50);
      rect(115, 70, 30, 50);

      fill(127, 245, 194);
      rect(5, 70, 50, 50);
    }

    else if(topOption == 1){
      fill(214, 75, 75);
      rect(5, 70, 50, 50);
      rect(115, 70, 30, 50);

      fill(127, 245, 194);
      rect(60, 70, 50, 50);
    }

    else if(topOption == 2){
      fill(214, 75, 75);
      rect(5, 70, 50, 50);
      rect(60, 70, 50, 50);

      fill(127, 245, 194);
      rect(115, 70, 30, 50);
    }

    image(imgCream, 5, 70);
    image(imgStrawberry, 60, 70);
    image(imgSmallCandle, 105, 70);

    // Frosting colour selection
    if(keyPressed){
      if (key == '1'){
        blueFrost();
      }

      else if (key == '2'){
        redFrost();
      }

      else if(key == '3'){
        yellowFrost();
      }

      else if(key == '4'){
        greenFrost();
      }

      else if(key == '5'){
        purpleFrost();
      }

      // Clears the screen
      else if(key == BACKSPACE){
        image(imgBackground, 0, 0);
        image(imgCake, 175, 145);
      }
      
      // Changes topping
      else if(keyCode == ALT){
        topOption++;
        try {
          Thread.sleep(100);
        } 
        
        catch (InterruptedException e) {
          e.printStackTrace();
        }

        if(topOption == 3){
          topOption = 0;
        }
      }

      // 'Snake' movement
      if(upPressed){
        moleyY--;
      }

      if(downPressed){
        moleyY++;
      }

      if(leftPressed){
        moleyX--;
      }

      if(rightPressed){
        moleyX++;
      }

      // Text
      fill(255);
      textSize(80);
      text(strUser, 0, 720);
    }
  }

  // Colour of frosting
  public void blueFrost(){
    if(mouseX >= 270 || mouseY >= 70){
      if(mousePressed){
        noStroke();
        fill(200, 250, 250);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void redFrost(){
    if(mouseX >= 270 || mouseY >= 70){
      if(mousePressed){
        noStroke();
        fill(250, 200, 200);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void yellowFrost(){
    if(mouseX >= 270 || mouseY >= 70){
      if(mousePressed){
        noStroke();
        fill(250, 250, 200);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void greenFrost(){
    if(mouseX >= 270 || mouseY >= 70){
      if(mousePressed){
        noStroke();
        fill(200, 250, 200);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  public void purpleFrost(){
    if(mouseX >= 270 || mouseY >= 70){
      if(mousePressed){
        noStroke();
        fill(230, 200, 250);
        ellipse(mouseX, mouseY, 20, 20);
      }
    }
  }

  // When the mouse is clicked, toppings get placed on the cake
  public void mouseClicked(){
    int currentChoice = topOption;

    if(mouseX >= 270 || mouseY >= 70){
      if(currentChoice == 0){
        image(imgCream, mouseX - 25, mouseY - 25);
      }

      else if(currentChoice == 1){
        image(imgStrawberry, mouseX - 25, mouseY - 25);
      }

      else if(currentChoice == 2){
        image(imgCandle, mouseX - 50, mouseY - 95);
      }
    }
  }

  // True or false for 'snake' movement
  public void keyPressed(){
    if(key == 'w'){
      upPressed = true;
    }

    if(key == 's'){
      downPressed = true;
    }

    if(key == 'a'){
      leftPressed = true;
    }

    if(key == 'd'){
      rightPressed = true;
    }
  }

  public void keyReleased(){
    if(key == 'w') {
      upPressed = false;
    }

    if(key == 's'){
      downPressed = false;
    }

    if(key == 'a'){
      leftPressed = false;
    }

    if(key == 'd'){
      rightPressed = false;
    }
  }

  /**
   * @author L. Chen
   * Draws the 'snake'
   * @param moleyXValue the X value of the moley
   * @param moleyYValue the Y value of the moley
   */
  public void moley(int moleyXValue, int moleyYValue){
    stroke(0, 0, 0);
    fill(0, 0, 0);
    rect(32 + moleyXValue, 6 + moleyYValue, 6, 20);

    noStroke();
    fill(49, 34, 160);
    ellipse(35 + moleyXValue, 46 + moleyYValue, 70, 60);

    stroke(255, 230, 66);
    fill(255, 230, 66);
    ellipse(35 + moleyXValue, 51 + moleyYValue, 20, 10);
    ellipse(35 + moleyXValue, 4 + moleyYValue, 8, 8);

    stroke(0, 0, 0);
    fill(0, 0, 0);
    ellipse(15 + moleyXValue, 46 + moleyYValue, 15, 5);
    ellipse(55 + moleyXValue, 46 + moleyYValue, 15, 5); 
  }

  // User message
  public void keyTyped(){
    if(key != BACKSPACE){
      strUser += key;
    }
  }
}