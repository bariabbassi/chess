package mvcdomino;

import model.*;


public class DominoGame {
	
	protected Player humanPlayer;
	protected Player computerPlayer;
	protected Grid grid;
	protected Pack pack;
	
	public DominoGame(Pack pack,Grid grid) {
		this.grid= grid;
		this.pack = pack;
		this.start();
	}
	
    public void start() {
		
		//System.out.println("Welcome !");
		//set the Players
		this.setHumanPlayer(new Player("You"));
		this.computerPlayer= new Player("Computer");
		// Shuffle the pack 
		pack.shuffle();
		/* Deal the dominos to each player in the game */
		pack.dealHand(this.getHumanPlayer(), 7); // deals 7 dominos into the player's hand.
		//handDealt(this.humanPlayer);            // tells the player their hand was dealt.
		//this.humanPlayer.showHand();//just for test
		pack.dealHand(this.computerPlayer, 7); // deals 7 dominos into the player's hand.
		//handDealt(this.computerPlayer);            // tells the player their hand was dealt.
		//this.computerPlayer.showHand();
		//pack.print();//just for test 
    }

    private void handDealt(Player player) {
	    System.out.println(player.toString()+" : Your hand is ready .");
   }

   

   public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

public Player getHumanPlayer() {
	  return humanPlayer;
  }

  public void setHumanPlayer(Player humanPlayer) {
	  this.humanPlayer = humanPlayer;
  }
}
