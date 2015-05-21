import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Calul8r extends PApplet {

// Otis Sperry | 2014

// Instantiate each of the classification of buttons
Button[] numButtons = new Button[10];
Button[] opButtons = new Button[11];
Button[] spButtons = new Button[1];

String displayValue = "0";
String valueToCompute = "";
String valueToCompute2 = "";
float valueToComputeI = 0;
float valueToComputeI2 = 0;
float result = 0;
char opValue;
boolean firstNum;

public void setup () {
  size(420, 400);
  background(255);
  //noFill();
  strokeWeight(3);
  stroke(200);

  // Populate operators
  opButtons[0] = new Button(220, 140).asOperator("+", 40, 40);
  opButtons[1] = new Button(220, 200).asOperator("-", 40, 40);
  opButtons[2] = new Button(220, 260).asOperator("*", 40, 40);
  opButtons[3] = new Button(220, 320).asOperator("/", 40, 40);
  opButtons[4] = new Button(280, 320).asOperator("=", 40, 40);
  opButtons[5] = new Button(280, 140).asOperator("C", 40, 40);
  opButtons[6] = new Button(280, 200).asOperator("+/-", 40, 40);
  opButtons[7] = new Button(340, 140).asOperator("Sqrt", 40, 40);
  opButtons[8] = new Button(340, 200).asOperator("Sin", 40, 40);
  opButtons[9] = new Button(340, 260).asOperator("Cos", 40, 40);
  opButtons[10] = new Button(340, 320).asOperator("Sq", 40, 40);

  // Populate number buttons
  numButtons[0] = new Button(40, 320).asNumber(0, 160, 40);
  numButtons[1] = new Button(40, 260).asNumber(1, 40, 40);
  numButtons[2] = new Button(100, 260).asNumber(2, 40, 40);
  numButtons[3] = new Button(160, 260).asNumber(3, 40, 40);
  numButtons[4] = new Button(40, 200).asNumber(4, 40, 40);
  numButtons[5] = new Button(100, 200).asNumber(5, 40, 40);
  numButtons[6] = new Button(160, 200).asNumber(6, 40, 40);
  numButtons[7] = new Button(40, 140).asNumber(7, 40, 40);
  numButtons[8] = new Button(100, 140).asNumber(8, 40, 40);
  numButtons[9] = new Button(160, 140).asNumber(9, 40, 40);

  // Populate special buttons
  spButtons[0] = new Button(280, 260).asSpecial(".", 40, 40);
  //spButton[0] = new Button(10, 275).asSpecial(".", 40, 40);

  // Initial value is true
  firstNum = true;
}
public void draw() {
  for (int i=0; i<numButtons.length; i++) {
    Button inumButton = numButtons[i];
    inumButton.display();
  }

  for (int i=0; i<opButtons.length; i++) {
    Button iopButton = opButtons[i];
    iopButton.display();
  }

  for (int i=0; i<spButtons.length; i++) {
    Button ispButton = spButtons[i];
    ispButton.display();

   
  }
  updateDisplay();
}
public void mousePressed() {
  for (int i=0; i<numButtons.length; i++) {
    Button inumButton = numButtons[i];
    inumButton.click();
    if (inumButton.on) {
      if (firstNum) {
        valueToCompute += PApplet.parseInt(inumButton.numButtonValue);
        displayValue = valueToCompute;
      } else {
        valueToCompute2 += PApplet.parseInt(inumButton.numButtonValue);
        displayValue = valueToCompute2;
      }
    }
  }
  for (int i=0; i<spButtons.length; i++) {
    Button iSpButton = spButtons[i];
    iSpButton.click();
    if (iSpButton.on) {
      if (iSpButton.spButtonValue == ".") {
        if (iSpButton.on && firstNum == true) {
          valueToCompute += iSpButton.spButtonValue;
          displayValue = valueToCompute;
        } else if (iSpButton.on && firstNum == false) {
          valueToCompute2 += iSpButton.spButtonValue;
          displayValue = valueToCompute2;
        }
      }
    }
  } 
  for (int i=0; i<opButtons.length; i++) {
    Button iOpButton = opButtons[i];
    iOpButton.click();
    if (iOpButton.on) {
      if (iOpButton.opButtonValue == "C") {
        println(i + " " + iOpButton.opButtonValue);
        displayValue = "0";
        opValue = 'C';
        valueToCompute = "";
        valueToCompute2 = "";
        valueToComputeI = 0;
        valueToComputeI = 0;
        result = 0;
        firstNum = true;
      } else if (iOpButton.opButtonValue == "=") {
        // Perform calculation
        firstNum = true;
        performCalculation();
      } else if (iOpButton.opButtonValue == "+") {
        if (result != 0) {
          opValue = '+';
          valueToCompute2 = "";
          firstNum = false;
          displayValue = "+";
        } else {
          opValue = '+';
          firstNum = false;
          displayValue = "+";
        }
      } else if (iOpButton.opButtonValue == "-") {
        if (result != 0) {
          opValue = '-';
          valueToCompute2 = "";
          firstNum = false;
          displayValue = "-";
        } else {
          opValue = '-';
          firstNum = false;
          displayValue = "-";
        }
      } else if (iOpButton.opButtonValue == "*") {
        if (result != 0) {
          opValue = '*';
          valueToCompute2 = "";
          firstNum = false;
          displayValue = "*";
        } else {
          opValue = '*';
          firstNum = false;
          displayValue = "*";
        }
      } else if (iOpButton.opButtonValue == "/") {
        if (result != 0) {
          opValue = '/';
          valueToCompute2 = "";
          firstNum = false;
          displayValue = "/";
        } else {
          opValue = '/';
          firstNum = false;
          displayValue = "/";
        }
      } else if (iOpButton.opButtonValue == "+/-") {
        opValue = 'n';
        performCalculation();
      } else if (iOpButton.opButtonValue == "%") {
        opValue = '%';
        performCalculation();
      } else if (iOpButton.opButtonValue == "Sqrt") {
        opValue = 's';
        performCalculation();
      } else if (iOpButton.opButtonValue == "Sin") {
        opValue = 'i';
        performCalculation();
      } else if (iOpButton.opButtonValue == "Cos") {
        opValue = 'c';
        performCalculation();
      } else if (iOpButton.opButtonValue == "Sq") {
        opValue = 'q';
        performCalculation();
      }
    }
  }
}
public void performCalculation() {
  // set string values to integers
  valueToComputeI = PApplet.parseFloat(valueToCompute);
  valueToComputeI2 = PApplet.parseFloat(valueToCompute2);

  // perform calculation based on the appropriate operator
  if (opValue == '+') {
    result = valueToComputeI + valueToComputeI2;
    displayValue = str(result);
  } else if (opValue == '-') {

    result = valueToComputeI - valueToComputeI2;
    displayValue = str(result);
  } else if (opValue == '*') {
    result = valueToComputeI * valueToComputeI2;
    displayValue = str(result);
  } else if (opValue == '/') {
    result = valueToComputeI / valueToComputeI2;
    displayValue = str(result);
  } else if (opValue == 'n') {
    if (firstNum) {
      valueToComputeI = valueToComputeI*-1;
      displayValue = str(valueToComputeI);
    } else {
      valueToComputeI2 = valueToComputeI2*-1;
      displayValue = str(valueToComputeI);
    }
  } else if (opValue == 's') {
    result = sqrt(valueToComputeI);
    displayValue = str(result);
  } else if (opValue == 'i') {

    result = sin(valueToComputeI);
    displayValue = str(result);
  } else if (opValue == 'c') {
    result = cos(valueToComputeI);
    displayValue = str(result);
  } else if (opValue == 'q') {
    result = sq(valueToComputeI);
    displayValue = str(result);
  }
  // let = work multiple times
  if (firstNum) {
    valueToCompute = displayValue;
  } else {
    valueToCompute = displayValue;
    valueToCompute2 = "";
  }
}
public void updateDisplay() {
  fill(220);
  rect(40, 40, 340, 80, 7);
  fill(0);
  textSize(25);
  text(displayValue, 45, 110);
  /*
  fill(50, 55, 55);
   noStroke();
   rect(230, 250, 100, 75);
   fill(255);
   textSize(10);
   text("Val 1: " + valueToCompute, 240, 260);
   text("Val 1: " + valueToCompute, 240, 270);
   text("Result: " + result, 240, 275);
   text("Operator: " + opValue, 240, 305);
   */
}

/*void keyPressed() {
 if (key == '1') {
 handleKeyPressNum("1");
 } else if (key == '2') {
 handleKeyPressNum("2");
 
 }
 }
 */
class Button {
  //member variables
  boolean isNumber;
  boolean isSpecial;
  boolean isOperator;
  float numButtonValue;
  String opButtonValue;
  String spButtonValue;
  float xpos;
  float ypos;
  int buttonSize = 40;
  int buttonW = 40;
  int buttonH = 40;
  boolean on = false;

  //constructor
  Button(float tempXpos, float tempYpos) {
    xpos = tempXpos; 
    ypos = tempYpos;
  } 

  public Button asNumber (float tempNumButtonValue, int tempW, int tempH) {
    isNumber = true;
    numButtonValue = tempNumButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  public Button asOperator(String tempOpButtonValue, int tempW, int tempH) {
    isOperator = true;
    opButtonValue = tempOpButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  public Button asSpecial (String tempSpButtonValue, int tempW, int tempH) {
    isSpecial = true;
    spButtonValue = tempSpButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  //member methods
  public void display () {
    if (isNumber) {
      fill(140);
      stroke(0);
      strokeWeight(2);
      rect(xpos, ypos, buttonW, buttonH);
      fill(7);
      textSize(24);
      text(PApplet.parseInt(numButtonValue), xpos+13, ypos+30);
    } else if (isOperator) {
      fill(140);
      stroke(0);
      strokeWeight(2);
      rect(xpos, ypos, buttonW, buttonH);
      fill(220);
      textSize(20);
      if (opButtonValue == "+/-") {
        text(opButtonValue, xpos + 1, ypos + 28);
      } else {
        text(opButtonValue, xpos+15, ypos+30);
      }
    } else if (isSpecial) {
      fill(124);
      stroke(0);
      strokeWeight(2);
      rect(xpos, ypos, buttonW, buttonH);
      fill(220);
      textSize(24);
      text(spButtonValue, xpos + 17, ypos + 30);
    }

    rectMode(CORNER);
    stroke(0);
    // The color changes based on the state of the button
    if (on) {
      fill(175);
      stroke(0);
    } else {
      fill (0);
    }
    //rect(x, y, w, h);
  }

  public void click () {
    on = mouseX > xpos && mouseX < xpos+buttonSize && mouseY > ypos && mouseY < ypos + buttonSize;
    /*CLICK CLACK GUNS OUT
     if (mx > x && mx < x + w && my > y && my < y + h) {
     on = !on;
     */
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Calul8r" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
