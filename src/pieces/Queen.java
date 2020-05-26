package pieces;

//Queen which is a type of Piece
public class Queen extends Piece{
	public Queen(int x, int y, String color) {
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
