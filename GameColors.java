public class GameColors {

    public GameColors(int colorSet, float[] accent1, float[] accent2, float[] accent3, float[] accent4) {
        
        // Default Colors
        if (colorSet == 0) {

            //Text
            accent1[0] = 123;
            accent1[1] = 110;
            accent1[2] = 101;

            //Tiles
            accent2[0] = 208;
            accent2[1] = 191;
            accent2[2] = 180;

            //Grid & Scores
            accent3[0] = 191;
            accent3[1] = 172;
            accent3[2] = 160;

            //Button
            accent4[0] = 148;
            accent4[1] = 121;
            accent4[2] = 101;
        }

        // Green Scheme
        if (colorSet == 1) {

            //Text
            accent1[0] = 107;
            accent1[1] = 125;
            accent1[2] = 101;

            //Tiles
            accent2[0] = 192;
            accent2[1] = 210;
            accent2[2] = 180;

            //Grid & Scores
            accent3[0] = 175;
            accent3[1] = 193;
            accent3[2] = 160;

            //Button
            accent4[0] = 132;
            accent4[1] = 150;
            accent4[2] = 101;
        }


    }
}
