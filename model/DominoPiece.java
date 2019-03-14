package model;

public class DominoPiece extends Piece{
	
	 public DominoPiece() {
			
			this.RightSide= 0;
			this.LeftSide=  0;

		}
	 
	public DominoPiece(Integer l, Integer r) {
		    	
		    this.LeftSide= l;
		    this.RightSide=r;
		    	
	}

	@Override
	public boolean tomatchRight(Piece p){
		//
		if (this.RightSide == p.getLeftSide() ) {
			return true;
		}
	    if( this.RightSide == p.getRightSide()) {
			p.Flip();
			return true;
		}
	    //
	    return false;
	}

	@Override
	public boolean tomatchLeft(Piece p) {
		//
		if (this.LeftSide == p.getLeftSide() ) {
			p.Flip();
			return true;
		}
	    if( this.LeftSide == p.getRightSide()) {
			return true;
		}
	    //
	    return false;
	}

}
