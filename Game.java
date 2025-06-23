import processing.core.PApplet;
import processing.core.PFont;

public class Game extends PApplet{

    // Game Font
    PFont regularFont;
    PFont boldFont;
    PFont titleFont;

    PApplet p;

    int score = 0;
    int bestScore = 0;

    // Game Colors
    float[] accent1 = new float[3];
    float[] accent2 = new float[3];
    float[] accent3 = new float[3];
    float[] accent4 = new float[3];

    public Game (PApplet p, PFont regularFont, PFont boldFont, PFont titleFont) {
        this.p = p;
        this.regularFont = regularFont;
        this.boldFont = boldFont;
        this.titleFont = titleFont;
    }

    public void display() {

        new GameColors(1, accent1, accent2, accent3, accent4);

        //Title
        p.fill(accent1[0], accent1[1], accent1[2]);
        p.textFont(titleFont);
        p.text("2048", 40, 80);

        //Score 
        p.textAlign(LEFT);
        p.fill(accent3[0],accent3[1],accent3[2]);
        p.rect(400, 27.5f, 90, 61.25f, 5);
        p.rect(300, 27.5f, 90, 61.25f, 5);

        p.fill(accent2[0], accent2[1], accent2[2]);
        p.textFont(boldFont);
        p.text("SCORE", 316.25f, 47.5f);
        p.text("BEST", 422.5f, 47.5f);
        p.fill(255);
        p.textAlign(CENTER);
        p.textFont(boldFont);
        p.text(score, 342.5f, 70);
        p.text(bestScore, 442.5f, 70);


        // Game Instructions
        p.textAlign(LEFT);
        p.fill(accent1[0], accent1[1], accent1[2]);
        p.textFont(regularFont);
        p.text("Join numbers to get to the               !", 40, 135);
        p.textFont(boldFont);
        p.text("2048 tile",228, 135);

        // New Game Button
        p.noStroke();
        p.fill(accent4[0], accent4[1], accent4[2]);
        p.rect(375, 112.5f, 115, 35, 5);

        p.fill(255);
        p.textFont(boldFont);
        p.text("New Game", 530 - p.textWidth("New Game") - 57.5f, 135);

        // 2048 Game Grid
        p.noStroke();
        p.fill(accent3[0], accent3[1], accent3[2]);
        p.rect(40, 170, 450, 450, 5);

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                p.noStroke();
                p.fill(accent2[0], accent2[1], accent2[2]);
                p.rect(50 + 110 * i, 180 + 110 * j, 100, 100, 5);
            }
        }

        if (p.mouseX >= 375 && p.mouseX <= 490 && p.mouseY >= 112.5f && p.mouseY <= 147.5f) {
            p.cursor(HAND);
        } else {
            p.cursor(ARROW);
        }
    }

    public void mousePressed() {
        if (p.mouseX >= 375 && p.mouseX <= 490 && p.mouseY >= 112.5 && p.mouseY <= 147.5f) {
            if (score > bestScore) {
                bestScore = score;
                score = 0;
            } else {
                score = 0;
            }
        } else {
            score += 10;
        }
    }

    public void keyPressed(char key, int keyCode) {
        
    }
    
    public void keyReleased(char key, int keyCode) {

    }
}
