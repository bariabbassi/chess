package model;

public class GommettePiece extends Piece {
	
	/*
	 * Exemple : GommettePiece(12,15) 
	 *           12 : number 2 represent the color , number 1 represent the form 
	 *           35 : number 2 represent the color , number 3 represent the form 
	 * a GommettePiece matchs another one if it has the same form or the same color .
	 */
	
	public GommettePiece() {
		
		this.RightSide=0;
		this.LeftSide=0;

	}
	
	public GommettePiece(Integer l, Integer r) {
    	
	    this.LeftSide= l;
	    this.RightSide=r;
	    	
}

	@Override
	public boolean tomatchRight(Piece p) {
		
		if (this.RightSide/10 == p.getLeftSide()/10    || this.RightSide%10 == p.getLeftSide()%10 ) {
			return true;
		}
	    if (this.RightSide/10 == p.getRightSide()/10   || this.RightSide%10 == p.getRightSide()%10 ) {
			p.Flip();
			return true;
		}
	    //
	    return false;
	}

	@Override
	public boolean tomatchLeft(Piece p) {
		if (this.LeftSide/10 == p.getLeftSide()/10     ||  this.LeftSide%10 == p.getLeftSide()%10 ) {
			p.Flip();
			return true;
		}
	    if (this.LeftSide/10 == p.getRightSide()/10    || this.LeftSide%10 == p.getRightSide()%10) {
			return true;
		}
	    //
	    return false;
	}
	
	

}
