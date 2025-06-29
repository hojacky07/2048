import java.awt.Cursor;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


public class Start extends PApplet {

    Game quickGame;
    
    PFont regularFont;
    PFont boldFont;
    PFont titleFont;

    PImage btnHome;

    static boolean start = true;

    public void settings() {
        size(530, 730);
    }

    public void setup() {
        regularFont = createFont("Arial", 16, false);
        boldFont = createFont("Arial Bold", 16, false);
        titleFont = createFont("Arial Bold", 64, false);
        btnHome = loadImage("home.png");

        quickGame = new Game(this, regularFont, boldFont, titleFont, btnHome);
    }

    public void draw() {
        background(251,248,239,255);
        if (start == true) {
            quickGame.display();
        }
    }
    
    public void mousePressed() {
        quickGame.mousePressed();
    }

    public void keyPressed() {
        quickGame.keyPressed(key, keyCode);
    }

    public void keyReleased() {
        quickGame.keyReleased(key, keyCode);
    }
}  