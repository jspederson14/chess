package pieces;

//Rook class which is type piece
public class Rook extends Piece{
	public Rook(int x, int y, String color) {
		super(x,y,color);
	}
	public void move(int x, int y) {
		//move
	}
	
	@Override
	public boolean isVaild(int x, int y) {
		return true;
	}
}
