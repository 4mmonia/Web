void setup () {
    // Sets the size of the window
    size(200, 200);
}

void draw() {
    background(18, 150, 188);
    // Set CENTER mode
    ellipseMode(CENTER);
    rectMode(CENTER);
    
    // Makes the text
    text("Spurdo Spärde", width/2, width/2);
    
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

void zoog(int xpos, int ypos) {
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
