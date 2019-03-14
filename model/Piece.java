package model;

public abstract class Piece  {
	
	protected int LeftSide;
	protected int RightSide;
	
	public abstract boolean tomatchRight(Piece p); 
	
	public abstract boolean tomatchLeft (Piece p);
	
	public void Flip() {
	    int tmp = this.RightSide;
		this.RightSide=this.LeftSide;
		this.LeftSide=tmp;
		//System.out.println("Fliped !!!");
	}
	
    @Override
	public String toString() {
		return "["+ LeftSide + ", " + RightSide + "]";
	}
	
	public int getLeftSide() {
		return LeftSide;
	}
	
	public int getRightSide() {
		return RightSide;
	}

}
