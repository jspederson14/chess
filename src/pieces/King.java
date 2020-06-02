package pieces;

//King which is a type of Piece
public class King extends Piece{
	public King(int y, int x, String color) {
		super(y,x,color);
	}
	public String giveType() {
		if(color.equals("White"))
			return "K";
		else if(color.equals("Black"))
			return "k";
		return "error";
	}
	@Override
	public boolean isVaild(int endX, int endY) {
		if((this.x-1==endX && this.y-1==endY)||(this.x+1==endX && this.y-1==endY)||
				(this.x+1==endX&& this.y+1==endY)||(this.x-1==endX&& this.y+1==endY)||
				(this.x==endX && this.y-1==endY)||(this.x==endX && this.y+1==endY))
			return true;
		return false;
	}

}
