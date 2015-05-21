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

public class ZOOG extends PApplet {

public void setup () {
    // Sets the size of the window
    size(200, 200);
}

public void draw() {
    background(18, 150, 188);
    // Set CENTER mode
    ellipseMode(CENTER);
    rectMode(CENTER);
    
    // Makes the text
    text("Spurdo Sp\u00e4rde", width/2, width/2);
    
    // Draws the grass
    fill(16, 205, 18);
    rect(0, 170, 2000, 60);
    
    // Draw the clouds
    noStroke(); 
    fill(250);
    ellipse(0, 0, 75, 75);
    ellipse(54, 3, 82, 83);
    ellipse(112, -15, 80, 64);
    ellipse(145, -3, 80, 64);
    ellipse(200, -20, 78, 78);
    
    zoog(mouseX, mouseY);
    
}    

public void zoog(int xpos, int ypos) {
      // Draw Zoog's body
    stroke(0);
    fill(225, 255, 255);
    rect(xpos, ypos + 22, 20, 100);
    
    // Draw Zoog's head
    stroke(0);
    fill(255);
    ellipse(xpos, ypos, 60, 60);
    
    // Draw Zoog's eyes
    fill(0);
    ellipse(xpos - 19, ypos, 16, 32);
    ellipse(xpos + 19, ypos, 16, 32);
    
    // Draw Zoog's legs
    stroke(0);
    line(xpos - 9, ypos + 71, xpos - 15, ypos + 90);
    line(xpos + 9, ypos +71, xpos + 15, ypos + 90);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ZOOG" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
