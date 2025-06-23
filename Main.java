import processing.core.PApplet;

class Main {
	  	public static void main(String[] args) {

    	String[] processingArgs = {"Game2048"};
		Game2048 mySketch = new Game2048();
	    PApplet.runSketch(processingArgs, mySketch);
	}
}
