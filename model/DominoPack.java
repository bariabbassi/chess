package model;

import java.util.LinkedList;

public class DominoPack extends Pack {
	
public DominoPack() {
		
		setLot(new LinkedList<Piece>());
		
		for(int i = 0 ; i < 8 ; i++ ) {
			for(int j = i ; j < 7; j++) {
				getLot().add(new DominoPiece(i,j));
			}
		}
		shuffle();
	}

}
