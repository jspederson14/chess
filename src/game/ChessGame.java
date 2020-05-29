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
		System.out.println(b.givePiece(7, 6));
		b.play(7,6,7,4);
		System.out.println(b.givePiece(7, 4));
		System.out.println(b.givePiece(0, 1));
		b.play(0, 1, 0, 2);
		System.out.println(b.givePiece(0, 2));
		b.play(3, 1, 3, 3);
		b.play(4, 6, 4, 4);
		b.play(3, 3, 4, 4);
		b.print();
	}

}
