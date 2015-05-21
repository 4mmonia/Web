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

public class DOGDEATHS extends PApplet {

public void setup() {
  size(950, 300);
}

public void draw() {
  background(0);
  rect(100, 65, mouseX-100, 10);
  textSize(26);
  text ("Everything you love will leave you.", 475, 250);
  textSize(15);
  drawReference(100, 50);
  text ("Human Years = " + PApplet.parseInt((mouseX-100)/10), 50, 100);
  text ("Dog Years = " + changeToDog((mouseX-100)/10), 50, 130);
  text ("Dog Deaths = " + changeToDeath(mouseX-100)/10, 50, 160);
}

public int changeToDog(int value) {
  value = (value*7);
  return value;
}

public float changeToDeath(float value) {
  value = (value/12);
  return value;
  
}
public void drawReference(int xpos, int ypos) {
  stroke(200);
  line(xpos-50, ypos, 900, ypos);
  for (int i = 0; i<800; i+=50) {
    text(i/10, xpos+i-8, ypos);
    line(xpos+i, ypos, xpos+i, ypos+5);
  }
}
public void drawVertRef(int xpos, int ypos) {
  stroke(200);
  line(xpos, ypos, xpos, ypos+200);
  for (int i = 0; i<300; i+=50) {
    text(i, xpos+5, ypos+i);
    line(xpos, ypos+i, xpos-5, ypos+i);
  }
}

public void drawVertRefInv(int xpos, int ypos) {
  stroke(200);
  line(xpos, ypos, xpos, ypos+height);
  for (int i = 300; i>0; i-=50) {
    text(i, xpos+5, height-i);
    line(xpos, height-i, xpos-5, height-i);
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "DOGDEATHS" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
