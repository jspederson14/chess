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
		System.out.println(b.play(0, 1, 0, 2));
		b.print();
	}

}
