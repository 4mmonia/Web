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

  Button asNumber (float tempNumButtonValue, int tempW, int tempH) {
    isNumber = true;
    numButtonValue = tempNumButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  Button asOperator(String tempOpButtonValue, int tempW, int tempH) {
    isOperator = true;
    opButtonValue = tempOpButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  Button asSpecial (String tempSpButtonValue, int tempW, int tempH) {
    isSpecial = true;
    spButtonValue = tempSpButtonValue;
    buttonW = tempW;
    buttonH = tempH;
    return this;
  }

  //member methods
  void display () {
    if (isNumber) {
      fill(140);
      stroke(0);
      strokeWeight(2);
      rect(xpos, ypos, buttonW, buttonH);
      fill(7);
      textSize(24);
      text(int(numButtonValue), xpos+13, ypos+30);
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

  void click () {
    on = mouseX > xpos && mouseX < xpos+buttonSize && mouseY > ypos && mouseY < ypos + buttonSize;
    /*CLICK CLACK GUNS OUT
     if (mx > x && mx < x + w && my > y && my < y + h) {
     on = !on;
     */
  }
}

