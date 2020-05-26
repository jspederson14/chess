package pieces;

//Pawn class which is a type of Piece
public class Pawn extends Piece{
	public Pawn(int x, int y, String color) {
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
