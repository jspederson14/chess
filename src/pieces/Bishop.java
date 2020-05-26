package pieces;

//Bishop class with is a type Piece
public class Bishop extends Piece{
	public Bishop(int x, int y, String color) {
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
