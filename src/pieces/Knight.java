package pieces;

//Knight class which is type Piece
public class Knight extends Piece{
	public Knight(int x, int y, String color) {
		super(x,y,color);
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
