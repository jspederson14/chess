package game;

public class ChessGame {
	public static void main(String[] args) {
		GUI g = new GUI();
		boolean whiteTurn = true;
		
		g.setUpGUI();
		g.frameGUI();
		/*while(!g.gameOverGUI()) {
			if(whiteTurn) {
				g.gameAction(whiteTurn);
				whiteTurn=false;
			}
			else {
				g.gameAction(whiteTurn);
				whiteTurn=true;
			}
			g.repaint();
		}
		*/
		g.playGUI(0, 1, 0, 2);
		g.updateGUI();
	}

}
