package mvcpuzzle;

public class GameController {
	//selected 
	protected int sX;
	protected int sY;
	//voisions
	private int[] vX = { 0, -1, 1, 0 };
	private int[] vY = { 1, 0, 0, -1 };
	
	protected Game game;
	
	public GameController(Game game) {
		this.game = game;
	}
	
	public boolean play(int x, int y) {
		for(int i : vX) {
			for(int j : vY) {
				if(this.game.board[x][y] != 0) {
					if(x+i >= 0 && x+i < this.game.sizeBoard && y+j >= 0 && y+j < this.game.sizeBoard ) {
						if(this.game.board[x+i][y+j] == 0) {
							this.game.board[x+i][y+j] = this.game.board[x][y];
							 this.game.board[x][y] = 0;
							 return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkSolution() {
		for(int i = 0; i < this.game.sizeBoard ;i++) {
			for(int j = 0 ; j < this.game.sizeBoard ;j++) {
				if(this.game.board[i][j] != this.game.expectedBorad[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		GameController ctrl = new GameController(new Game(5));
		System.out.println("apres j'ai changé ");
		ctrl.game.board[0][4] = 0;
        ctrl.game.printBoards();
		System.out.println("apres j'ai jouée");
		ctrl.play(1, 4);
		ctrl.game.printBoards();
	}
	

}
