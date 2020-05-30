package game;

public class ChessGame {
	public static void main(String[] args) {
		GUI g = new GUI();
		Board b = new Board();
		boolean whiteTurn = true;
		
		b.setUp();
		while(!b.gameOver()) {
			g.frameGUI(b);
			if(whiteTurn) {
				
				whiteTurn=false;
			}
			else {
				
				whiteTurn=true;
			}
			
		}
	}

}
