package mvcpuzzle;

import java.util.Random;

public class Game {
	
	protected int[][] board;
	protected int[][] expectedBorad;
	
	protected int sizeBoard;
	
	public Game(int size) {
		this.board = new int[size][size];
		this.expectedBorad = new int[size][size];
		
		this.sizeBoard = board.length;
		start();
	}
	
	private void start() {
        int k = 1;
        for (int i = 0; i < sizeBoard ; i++) {
            for (int j = 0; j < sizeBoard ; j++) {
            	expectedBorad[i][j] = k;
                board[i][j] = k;
                k++;
            }
        }
        // the field with element 0 is an empty field
        expectedBorad[sizeBoard-1][sizeBoard-1] = 0;
        board[sizeBoard-1][sizeBoard-1] = 0;
        shuffleBoard();
    }

    private void shuffleBoard() {
		
		Random rgen = new Random();			
		 
		for (int i=0; i < sizeBoard; i++) {
			for (int j=0; j < sizeBoard; j++) {
				int randomPositionX = rgen.nextInt(sizeBoard);
				int randomPositionY = rgen.nextInt(sizeBoard);
			    int temp = this.board[i][j];
			    this.board[i][j]=this.board[randomPositionX][randomPositionY];
			    this.board[randomPositionX][randomPositionY]=temp;
			}
		}
		
	}
     
    public void printBoards() {
        System.out.println("The board :");
        for (int x = 0; x < sizeBoard; x++) {
            for (int y = 0; y < sizeBoard; y++) {
            	 System.out.print(" " + this.board[x][y] + " ");
            }
            System.out.println();
        }
 
        System.out.println("Expected board :");
 
        for (int x = 0; x < sizeBoard; x++) {
            for (int y = 0; y < sizeBoard; y++) {
            	System.out.print(" " + this.expectedBorad[x][y]+ " ");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		Game game = new Game(5);
		game.printBoards();
	}
    
}
