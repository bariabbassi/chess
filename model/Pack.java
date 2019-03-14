package model;

import java.util.List;
import java.util.Random;

public class Pack {
	
@SuppressWarnings("rawtypes")
private List<Piece> lot;

	
	public void print() {
		int size = 0;
		for(Piece d : lot) {
			System.out.println(d);
			size++;
		}
		System.out.println("Size : "+size);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Piece> getLot() {
		return lot;
	}
	
	@SuppressWarnings("rawtypes")
	public void setLot(List<Piece> lot) {
		this.lot = lot;
	}

	@SuppressWarnings("rawtypes")
	public void shuffle() {
		
		Random rgen = new Random();  // Random number generator			
		 
		for (int i=0; i < lot.size() ; i++) {
		    int randomPosition = rgen.nextInt(lot.size());
		    Piece temp = lot.get(i);
		    lot.set(i, lot.get(randomPosition));
		    lot.set(randomPosition, temp);
		    
		}
		
	}

	public void dealHand(Player player, int i) {
		for(int j=0;j<i;j++) {
			player.getHand().add(lot.get(j));
			lot.remove(j);
		}
	}

	@Override
	public String toString() {
		return "Pack [lot=" + lot + "]";
	}


}
