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

    float[][] colors = new float[4][3];

    int colorSet = 0;

    static String page = "home";

    public void settings() {
        size(530, 730);
    }

    public void setup() {
        regularFont = createFont("Arial", 16, false);
        boldFont = createFont("Arial Bold", 16, false);
        titleFont = createFont("Arial Bold", 64, false);
        btnHome = loadImage("home.png");
        new GameColors(colorSet, colors);

        quickGame = new Game(this, regularFont, boldFont, titleFont, btnHome, colors);
    }

    public void draw() {
        background(251,248,239,255);
        new GameColors(colorSet, colors);
        if (page == "home") {
            displayStartScreen();
        }
        if (page == "quick game") {
            quickGame.display();
        }
    }
    
    public void displayStartScreen() {
        background(251, 248, 239);
        textAlign(CENTER, CENTER);

        fill(colors[0][0], colors[0][1], colors[0][2]);
        textFont(titleFont);
        textSize(96);
        text("2048", width / 2, 190);

        noStroke();
        fill(colors[3][0], colors[3][1], colors[3][2]);
        rect(width / 2 - 100, 290, 200, 50, 10);
        fill(255);
        textFont(boldFont);
        textSize(20);
        text("Classic Game", width / 2, 312.5f);

        fill(colors[3][0], colors[3][1], colors[3][2]);
        rect(width / 2 - 100, 360, 200, 50, 10); 
        fill(255);
        text("Unlimited", width / 2, 382.5f);

        colorSelection();

        noStroke();

        if ((mouseX >= width / 2 - 100 && mouseX <= width / 2 + 100 && ((mouseY >= 290 && mouseY <= 340) || (mouseY >= 360 && mouseY <= 410))) || dist(mouseX, mouseY, width / 2 - 70, 460) < 15 || dist(mouseX, mouseY, width / 2, 460) < 15 || dist(mouseX, mouseY, width / 2 + 70, 460) < 15) {
            cursor(HAND);
        } else {
            cursor(ARROW);
        }
    }

    public void colorSelection() {
        strokeWeight(3);

        if (colorSet == 0) {
            stroke(0);
        } else {
            stroke(200);
        }

        fill(148, 121, 101);
        ellipse(width / 2 - 70, 460, 30, 30);

        if (colorSet == 1) {
            stroke(0);
        } else {
            stroke(200);
        }

        fill(132, 150, 101);
        ellipse(width / 2, 460, 30, 30);
        
        if (colorSet == 2) {
            stroke(0);
        } else {
            stroke(200);
        }

        fill(125, 105, 225);
        ellipse(width / 2 + 70, 460, 30, 30);
    }

    public void mousePressed() {
        if (page.equals("home")) {
            if (mouseX >= width / 2 - 100 && mouseX <= width / 2 + 100) {
                if (mouseY >= 290 && mouseY <= 340) {
                    page = "quick game";
                    quickGame.startGame();
                }
                if (mouseY >= 360 && mouseY <= 410) {
                    page = "quick game"; 
                    quickGame.startGame();
                }
            }

            if (dist(mouseX, mouseY, width / 2 - 70, 460) < 15) {
                colorSet = 0;
            } else if (dist(mouseX, mouseY, width / 2, 460) < 15) {
                colorSet = 1;
            } else if (dist(mouseX, mouseY, width / 2 + 70, 460) < 15) {
                colorSet = 2;
            }
        } else {
            quickGame.mousePressed();
        }
    }

    public void keyPressed() {
        quickGame.keyPressed(key, keyCode);
    }
}  