package mvcdomino;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javafx.scene.image.Image;
import model.Piece;
import model.Player;

public class Controller {
	
	protected DominoGame game;
	
	protected LinkedList<Image> handImages;
	protected LinkedList<Image> computerImages;
	protected LinkedList<Image> packImages;
	protected LinkedList<Image> gridImages;
	
	protected int selected=0;
	
	public Controller(DominoGame game) {
		
		this.game=game;
		handImages = new LinkedList<Image>();
		computerImages = new LinkedList<Image>();
		packImages = new LinkedList<Image>();
		gridImages = new LinkedList<Image>();
		createImages();
	}
	
	public boolean add(Piece p) {
		int size = this.game.grid.size();
		if( size == 0 ) {
			this.game.grid.add(p);
			//System.out.println("la list :"+this.game.grid);
			return true;
		}
		size = this.game.grid.size();
		Piece top = this.game.grid.getGrid().get(size -1);
		if ( top != null) {
			//System.out.println("Top Domino :"+top);
			if(top.tomatchRight(p)) {
				this.game.grid.add(p);
				//System.out.println("la list :"+this.game.grid);
				return true;
			}else {
				if(this.game.grid.getGrid().get(0).tomatchLeft(p)) {
					this.game.grid.addFirst(p);
					//System.out.println("la list :"+this.game.grid);
					return true;
				}
			}
		}
		//System.out.println("la list :"+this.game.grid);
		return false;
	}
	
	public void playerTurn() {
			//System.out.println("Player turn !");
			if(!playAdomino(game.getHumanPlayer())) {
				piocher(game.getHumanPlayer());
			}
			clear();
			createImages();
	}
	
	public boolean playAdomino(Player player) {
		int dominoSelected = selected;
		//System.out.println("Selected : "+dominoSelected);
		Piece domino = player.getHand().get(dominoSelected);
		//System.out.println("Domino selected :"+domino);
	    if(add(domino)) {
	    	player.getHand().remove(domino);
	    	return true;
	    }
		return false;
	}
	public void piocher(Player player) {
		if ( !this.game.pack.getLot().isEmpty()) {
			 int size = this.game.pack.getLot().size();
			 Random rgen = new Random();
			 int random = rgen.nextInt(size);
			 Piece domino = this.game.pack.getLot().get(random);
		     this.game.pack.getLot().remove(domino);
		     player.getHand().add(domino);
		}
	}
	
	public boolean stillPlaying() {
		if ( !playerWin() && !computerWin() ) {
			return true;
		}
		return false;
	}
	
	public boolean playerWin() {
		return game.getHumanPlayer().getHand().isEmpty();
	}
	
	public boolean computerWin() {
		return game.computerPlayer.getHand().isEmpty();
	}
	
	public void computerTurn() {
		boolean flag = false;
		List<Piece> computerHand = game.computerPlayer.getHand();
		for(Piece p : computerHand) {
			if(add(p)) {
				computerHand.remove(p);
				//game.computerPlayer.showHand();
				flag = true;
				break;
			}
		}
		if(flag == false) {
			piocher(game.computerPlayer);
		}
		clear();
		createImages();
	}
	
	public void createImages(){
		//player hand
		for(Piece p : game.getHumanPlayer().getHand()) {
			handImages.add(new Image("file:src/Images/"+p.getLeftSide()+p.getRightSide()+".jpg"));
		}
		//Computer images , we load only the back 
		int handsize = game.computerPlayer.getHand().size();
		for(int i = 0; i < handsize ; i++) {
			computerImages.add(new Image("file:src/Images/back.png"));
		}
		//pack
		int packsize = game.pack.getLot().size();
		for(int i = 0; i < packsize ; i++) {
			packImages.add(new Image("file:src/Images/back.png"));
		}
		//grid
		int n = this.game.grid.size();
		for(int i = 0 ; i < n ; i++) {
			Piece p = this.game.grid.getGrid().get(i);
			if(p!= null) {
				gridImages.add(new Image("file:src/Images/"+p.getLeftSide()+p.getRightSide()+".jpg"));
			}  
		}
		
	}
	public void clear() {
		
	    this.packImages.clear();
		this.handImages.clear();
		this.computerImages.clear();
		this.gridImages.clear();
			
	}
	/*
	public static void main(String[] args) {
		Controller ctrl = new Controller(new Game());
		ctrl.add(new DominoPiece(1,1));
		
	}
	*/

}
