import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Game extends PApplet{

    // Game Font
    PFont regularFont;
    PFont boldFont;
    PFont titleFont;

    PApplet p;

    PImage btnHome;

    int[][] board = new int[4][4];
    int score = 0;
    int bestScore = 0;

    boolean merged;
    boolean moved;

    // Game Colors
    float[][] colors = new float[4][3];

    public Game (PApplet p, PFont regularFont, PFont boldFont, PFont titleFont, PImage btnHome, float[][] colors) {
        this.p = p;
        this.regularFont = regularFont;
        this.boldFont = boldFont;
        this.titleFont = titleFont;
        this.btnHome = btnHome;
        this.colors = colors;
    }

    public void display() {

        if (score > bestScore) {
            bestScore = score;
        }

        // Title
        p.textAlign(LEFT);
        p.fill(colors[0][0], colors[0][1], colors[0][2]);
        p.textFont(titleFont);
        p.text("2048", 40, 90);

        // Score
        p.fill(colors[2][0], colors[2][1], colors[2][2]);
        p.rect(400, 37.5f, 90, 61.25f, 5);
        p.rect(300, 37.5f, 90, 61.25f, 5);

        p.fill(colors[1][0], colors[1][1], colors[1][2]);
        p.textFont(boldFont);
        p.text("SCORE", 316.25f, 57.5f);
        p.text("BEST", 422.5f, 57.5f);
        p.fill(255);
        p.textAlign(CENTER);
        p.textFont(boldFont);
        p.text(score, 342.5f, 82.5f);
        p.text(bestScore, 442.5f, 82.5f);

        // Game Instructions
        p.textAlign(LEFT);
        p.fill(colors[0][0], colors[0][1], colors[0][2]);
        p.textFont(regularFont);
        p.textSize(14);
        p.text("Join numbers to get to the               !", 40, 145);
        p.textFont(boldFont);
        p.textSize(14);
        p.text("2048 tile", 205, 145);
        
        // New Game Button
        p.noStroke();
        p.fill(colors[3][0], colors[3][1], colors[3][2]);
        p.rect(330, 122.5f, 115, 35, 5);

        p.fill(255);
        p.textFont(boldFont);
        p.text("New Game", 330 + (115 - p.textWidth("New Game"))/2, 145);


        // Home Button
        p.noStroke();
        p.fill(colors[3][0], colors[3][1], colors[3][2]);
        p.rect(455, 122.5f, 35, 35, 5);

        p.image(btnHome, 462.5f, 130, 20, 20);

        // Game Grid
        p.noStroke();
        p.fill(colors[2][0], colors[2][1], colors[2][2]);
        p.rect(40, 180, 450, 450, 5);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                p.noStroke();
                p.fill(colors[1][0], colors[1][1], colors[1][2]);
                p.rect(50 + 110 * i, 190 + 110 * j, 100, 100, 5);
            }
        }

        // Game Tiles
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int value = board[i][j];
                if (value != 0) {
                    p.noStroke();
                    applyTileColor(value);
                    p.rect(50 + 110 * j, 190 + 110 * i, 100, 100, 5);

                    applyTileText(value);
                    p.textAlign(CENTER, CENTER);
                    p.textFont(boldFont);
                    p.textSize(32);
                    p.text(value, 50 + 110 * j + 50, 190 + 110 * i + 45);
                }
            }
        }

        //Game Over Screen
        if (isGameOver()) {
            p.fill(255,100);
            p.rect(40, 180, 450, 450, 5);

            p.fill(colors[0][0], colors[0][1], colors[0][2]);
            p.textFont(boldFont);
            p.textSize(56);
            p.text("Game over!", 265, 380);

            p.fill(colors[3][0], colors[3][1], colors[3][2]);
            p.rect(210, 465, 110, 40, 5);

            p.fill(255);
            p.textFont(boldFont);
            p.text("Try Again", 265, 482.5f);

        }

        //Change Cursor
        if ((p.mouseX >= 330 && p.mouseX <= 445 && p.mouseY >= 122.5f && p.mouseY <= 157.5f) || (p.mouseX >= 455 && p.mouseX <= 490 && p.mouseY >= 122.5f && p.mouseY <= 157.5f) || ((p.mouseX >= 207.5f && p.mouseX <= 322.5f && p.mouseY >= 465f && p.mouseY <= 500f) && isGameOver())) {
            p.cursor(HAND);
        } else {
            p.cursor(ARROW);
        }
    }

    public void startGame() {
        score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }

        spawnTile();
        spawnTile();
    }

    public boolean isGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
                if (j < 3 && board[i][j] == board[i][j + 1]) {
                    return false;
                }
                if (i < 3 && board[i][j] == board[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void spawnTile() {
        ArrayList<int[]> empty = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }

        if (!empty.isEmpty()) {
            int[] spot = empty.get((int) random(empty.size())); 

            float i = random(1);

            if (i < 0.9) {
                board[spot[0]][spot[1]] = 2;
            } else {
                board[spot[0]][spot[1]] = 4;
            }
        }
    }

    public void applyTileColor(int value) {
        if (value == 2) {
            p.fill(238, 228, 218);
        } else if (value == 4) {
            p.fill(237, 224, 200);
        } else if (value == 8) {
            p.fill(242, 177, 121);
        } else if (value == 16) {
            p.fill(245, 149, 99);
        } else if (value == 32) {
            p.fill(246, 124, 95);
        } else if (value == 64) {
            p.fill(246, 94, 59);
        } else if (value == 128) {
            p.fill(237, 207, 114);
        } else if (value == 256) {
            p.fill(237, 204, 97);
        } else if (value == 512) {
            p.fill(237, 200, 80);
        } else if (value == 1024) {
            p.fill(237, 197, 63);
        } else if (value == 2048) {
            p.fill(237, 194, 46);
        } else if (value > 2048) {
            p.fill(60, 58, 50);
        } else {
            p.fill(colors[1][0], colors[2][1], colors[1][2]);
        }
    }

    public void applyTileText(int value) {
        if (value < 8) {
            p.fill(colors[0][0], colors[0][1], colors[0][2]);
        } else if (value > 4) {
            p.fill(255);
        }
    }

    public void mousePressed() {
        if (p.mouseX >= 330 && p.mouseX <= 445 && p.mouseY >= 122.5f && p.mouseY <= 157.5f) {
            startGame();
        }
        if (p.mouseX >= 455 && p.mouseX <= 490 && p.mouseY >= 122.5f && p.mouseY <= 157.5f) {
            Start.page = "home";
        }
        if (isGameOver()) {
            if (p.mouseX >= 207.5f && p.mouseX <= 322.5f && p.mouseY >= 465f && p.mouseY <= 500f) {
                startGame();
            }
        }
    }

    public void moveLeft() {
        moved = false;
        merged = true;
        while (merged) {
            merged = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (board[i][j-1] == 0 && board[i][j] != 0) {
                        board[i][j-1] = board[i][j];
                        board[i][j] = 0;
                        merged = true;
                        moved = true;
                    }
                    else if (board[i][j-1] == board[i][j] && board[i][j] != 0) {
                        board[i][j-1] *= 2;
                        score += board[i][j-1];
                        board[i][j] = 0;
                        merged = true;
                        moved = true;
                    }
                }
            }
        }
    }

    public void moveRight() {
        moved = false;
        merged = true;
        while (merged) {
            merged = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if (board[i][j] == 0 && board[i][j-1] != 0) {
                        board[i][j] = board[i][j-1];
                        board[i][j-1] = 0;
                        merged = true;
                        moved = true;
                    }
                    else if (board[i][j] == board[i][j-1] && board[i][j-1] != 0) {
                        board[i][j] *= 2;
                        score += board[i][j];
                        board[i][j-1] = 0;
                        merged = true;
                        moved = true;
                    }
                }
            }
        }
    }

    public void moveUp() {
        moved = false;
        merged = true;
        while (merged) {
            merged = false;
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i-1][j] == 0 && board[i][j] != 0) {
                        board[i-1][j] = board[i][j];
                        board[i][j] = 0;
                        merged = true;
                        moved = true;
                    }
                    else if (board[i-1][j] == board[i][j] && board[i][j] != 0) {
                        board[i-1][j] *= 2;
                        score += board[i-1][j];
                        board[i][j] = 0;
                        merged = true;
                        moved = true;
                    }
                }
            }
        }
    }

    public void moveDown() {
        moved = false;
        merged = true;
        while (merged) {
            merged = false;
            for (int i = 3; i > 0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == 0 && board[i-1][j] != 0) {
                        board[i][j] = board[i-1][j];
                        board[i-1][j] = 0;
                        merged = true;
                        moved = true;
                    }
                    else if (board[i][j] == board[i-1][j] && board[i-1][j] != 0) {
                        board[i][j] *= 2;
                        score += board[i][j];
                        board[i-1][j] = 0;
                        merged = true;
                        moved = true;
                    }
                }
            }
        }
    }

    public void keyPressed(char key, int keyCode) {

        if (key == 'w' || key == 'W') {
            moveUp();
            if (moved == true) {
                spawnTile();
            }
        }

        if (key == 's' || key == 'S') {
            moveDown();
            if (moved == true) {
                spawnTile();
            }
        }

        if (key == 'a' || key == 'A') {
            moveLeft();
            if (moved == true) {
                spawnTile();
            }
        }

        if (key == 'd' || key == 'D') {
            moveRight();
            if (moved == true) {
                spawnTile();
            }
        }
        
    }
    
}
