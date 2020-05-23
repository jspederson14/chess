package pieces;

public interface Ipiece {
	void move (int x, int y);
	//moves the piece
	int checkX (Ipiece p);
	//gets x coordinate
	int checkY (Ipiece p);
	//gets y coordinate
	boolean isValid(int x, int y);
	//checks to see if a move is vaild
	void capture();
	//captures a piece and removes it from game
}
