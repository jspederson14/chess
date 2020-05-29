package pieces;

//Knight class which is type Piece
public class Knight extends Piece{
	public Knight(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "N";
		else if(color.equals("Black"))
			return "n";
		return "error";
	}
	@Override
	public boolean isVaild(int x, int y) {
		return true;
	}

}
