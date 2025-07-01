public class GameColors {

    public GameColors(int colorSet, float[][] colors) {
        
        // Default Colors
        if (colorSet == 0) {

            //Text
            colors[0][0] = 123;
            colors[0][1] = 110;
            colors[0][2] = 101;

            //Tiles
            colors[1][0] = 208;
            colors[1][1] = 191;
            colors[1][2] = 180;

            //Grid & Scores
            colors[2][0] = 191;
            colors[2][1] = 172;
            colors[2][2] = 160;

            //Button
            colors[3][0] = 148;
            colors[3][1] = 121;
            colors[3][2] = 101;
        }

        // Green Scheme
        if (colorSet == 1) {

            //Text
            colors[0][0] = 107;
            colors[0][1] = 125;
            colors[0][2] = 101;

            //Tiles
            colors[1][0] = 192;
            colors[1][1] = 210;
            colors[1][2] = 180;

            //Grid & Scores
            colors[2][0] = 175;
            colors[2][1] = 193;
            colors[2][2] = 160;

            //Button
            colors[3][0] = 132;
            colors[3][1] = 150;
            colors[3][2] = 101;
        }

        // Purple Theme
        if (colorSet == 2) {

            //Text
            colors[0][0] = 110;
            colors[0][1] = 101;
            colors[0][2] = 123;

            //Tiles
            colors[1][0] = 191;
            colors[1][1] = 180;
            colors[1][2] = 208;

            //Grid & Scores
            colors[2][0] = 172;
            colors[2][1] = 160;
            colors[2][2] = 191;

            //Button
            colors[3][0] = 121;
            colors[3][1] = 101;
            colors[3][2] = 148;
        }

    }
}
