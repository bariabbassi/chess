package mvcsaboteur;

import model.*;

public class Board extends Grid{
	
	protected Piece[][] grid;
	private int gridSize;
	
	public Board(int size) {
		this.grid = new Piece[size][size];
		this.gridSize = size;
	}
	
	public boolean add(Piece carte,int x, int y) {
		if( x < gridSize && y < gridSize && x >= 0 && y >= 0) {
			if(this.grid[x][y] != null ) {
				this.grid[x][y]=carte;
				return true;
			}
		}
		return false;
	}

}
