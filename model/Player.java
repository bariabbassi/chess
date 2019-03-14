package model;

import java.util.LinkedList;
import java.util.List;


public class Player {
	
    private String name;
    private int dominoSelected;
	
	private List<Piece> hand;
	
	public Player(String name) {
		this.setName(name);
		this.hand = new LinkedList<Piece>();
		this.setDominoSelected(0);//Default 
	}
	
	public Piece Selected(int i) {
		try {
			return this.hand.get(i);
		}catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public String toString() {
		return"Player [" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void showHand() {
		
		String str="Hand of Player :"+this.name+"\n";
		for(Piece d  : hand) {
			str=str+d.toString()+" ";
		}
		System.out.println(str);
	}

	public List<Piece> getHand() {
		return hand;
	}

	public int getDominoSelected() {
		return dominoSelected;
	}

	public void setDominoSelected(int dominoSelected) {
		this.dominoSelected = dominoSelected;
	}



}
