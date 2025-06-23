import processing.core.PApplet;

class Run {
	  	public static void main(String[] args) {

    	String[] processingArgs = {"Game2048"};
		Start mySketch = new Start();
	    PApplet.runSketch(processingArgs, mySketch);
	}
}
