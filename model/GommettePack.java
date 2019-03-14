package model;

import java.util.LinkedList;

public class GommettePack extends Pack {
	
public GommettePack() {
		
		setLot(new LinkedList<Piece>());
		
		for(int i = 10 ; i < 18 ; i++ ) {
			for(int j = i ; j < 17; j++) {
				getLot().add(new DominoPiece(i,j));
			}
		}
		shuffle();
	}

}
