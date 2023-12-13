import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  // Images
  PImage imgBackground;
  PImage imgCake;
  PImage imgCream;
  PImage imgStrawberry;
  PImage imgCandle;

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

    image(imgBackground, 0, 0);
    image(imgCake, 175, 145);

    textSize(100);
  }

  public void draw() {
    moley(moleyX, moleyY);

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

      else if(key == BACKSPACE){
        image(imgBackground, 0, 0);
        image(imgCake, 175, 145);
      }

      else if(key == ' '){
        topOption++;
        if(topOption == 3){
          topOption = 0;
        }
      }

      // Text
      fill(255);
      text(strUser, 0, 700);
    }
  }

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
    System.out.println(currentChoice);

    if(mouseX >= 270 || mouseY >= 70){
      if(currentChoice == 0){
        image(imgCream, mouseX - 25, mouseY - 25);
      }

      else if(currentChoice == 1){
        image(imgStrawberry, mouseX - 25, mouseY - 25);
      }

      else if(currentChoice == 2){
        image(imgCandle, mouseX - 50, mouseY - 75);
      }
    }
  }

  // Controls the movement of the 'snake'
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

  // Draws the 'snake'
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

  public void keyTyped(){
    strUser += key;
  }
}