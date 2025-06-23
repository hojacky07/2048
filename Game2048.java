import java.awt.Cursor;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Game2048 extends PApplet {
    
    PFont regularFont;
    PFont boldFont;
    PFont titleFont;
    int score = 0;
    int bestScore = 0;

    public void settings() {
        size(530, 640);
    }

    public void setup() {
        
        regularFont = createFont("Arial", 16, false);
        boldFont = createFont("Arial Bold", 16, false);
        titleFont = createFont("Arial Bold", 64, false);
        
        background(251,248,239,255);

        //Title
        fill(123,110,101,255);
        textFont(titleFont);
        text("2048",40, 70);

        // Game Instructions
        fill(123,110,101,255);
        textFont(regularFont);
        text("Join numbers to get to the               !", 40, 110);
        textFont(boldFont);
        text("2048 tile",228, 110);

        // New Game Button
        noStroke();
        fill(148,121,101,255);
        rect(375, 87.5f, 115, 35, 5);

        fill(255);
        textFont(regularFont);
        text("New Game", width - textWidth("New Game") - 60, 110);

        // 2048 Game Grid
        noStroke();
        fill(191,172,160,255);
        rect(40, 150, 450, 450, 5);

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
            noStroke();
            fill(208,191,180,255);
            rect(50 + 110 * i, 160 + 110 * j, 100, 100, 5);
            }
        }
        

    }

    public void draw() {

        if (mouseX >= 375 && mouseX <= 490 && mouseY >= 87.5f && mouseY <= 122.5f) {
            cursor(HAND);
        } else {
            cursor(ARROW);
        }

    }

    public void mousePressed() {
        if (mouseX >= 375 && mouseX <= 490 && mouseY >= 87.5f && mouseY <= 122.5f) {
            score = 0;
        }
    }
    
    public void keyPressed() {

    }

    public void keyReleased() {

    }
}
