package model;

import java.util.LinkedList;

public class Grid {
	
	
	private LinkedList<Piece> grid;
	
	
	public Grid() {
		this.grid = new LinkedList<Piece>();
	}
	
	public Grid(int taille) {
		this.grid=new LinkedList<Piece>();
		for(int i = 0 ; i < taille ; i ++) {
			this.grid.add(null);
		}
	}
	
	public void add(Piece p) {
		this.grid.add(p);
	}
	
	public void addFirst(Piece p) {
		this.grid.addFirst(p);
	}
	
	public void addLast(Piece p) {
		this.grid.addLast(p);
	}
	
	public void add(Piece p, int position) {
		this.grid.add(position, p);
	}

	@Override
	public String toString() {
		return "Grid [grid=" + grid + "]";
	}

	public LinkedList<Piece> getGrid() {
		return grid;
	}

	public void setGrid(LinkedList<Piece> grid) {
		this.grid = grid;
	}
	
	public int size() {
		if(this.grid != null) {
			return this.grid.size();
		}
		return 0;
	}

}
