package game;

public class ChessGame {
	
	//checks piece at location
	public String checkLocation(int x, int y) {
		return "test";
	}
	
	//checks win conditions
	public boolean win() {
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to chess");
		Board b = new Board();
		b.setUp();
		b.print();
		b.play(7,6,7,4);
		System.out.println(b.givePiece(4, 7));
		b.play(0, 1, 0, 2);
		System.out.println(b.givePiece(2, 0));
		b.play(3, 1, 3, 3);
		b.play(4, 6, 4, 4);
		b.print();
	}

}
