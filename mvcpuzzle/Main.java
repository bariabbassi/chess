package mvcpuzzle;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	protected GameController controller = new GameController(new Game(5));
	//
	private Stage window;
	//
	private BorderPane root    =new BorderPane();
	private GridPane board     =new GridPane();
	private Button Reset       =new Button("RESET");
	//
	private ImageView puzzleSolution = new ImageView(new Image("file:src/Images/puzzle/puzzle.jpg"));
	
	public void render() {
		board.getChildren().clear();
		for(int i = 0 ; i < controller.game.sizeBoard ; i++) {
			for(int j = 0 ; j < controller.game.sizeBoard ; j++) {
				board.add(new PuzzleButton(new ImageView(new Image("file:src/Images/puzzle/"+this.controller.game.board[i][j]+".jpg")),i,j), i,j);
			}
		}
		endGame();
	}
	
	public void endGame() {
		if(controller.checkSolution()) {
			ButtonType replay = new ButtonType("replay");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("");
			alert.setHeaderText(null);
			alert.getButtonTypes().setAll(replay);
			alert.setContentText("Congratulations , you won !");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == replay){
				controller = new GameController(new Game(5));
				render();
			}
		}
	}
	
	private class PuzzleButton extends Button {
		private int x;
		private int y;
		
		public PuzzleButton(ImageView imv,int x,int y) {
			this.x =x ;
			this.y =y ;
			this.setGraphic(imv);
			this.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					controller.play(getX(),getY());
					render();
				}
				
			});
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		//
		Image background = new Image("file:src/Images/puzzle/background.jpg");
		ImageView image = new ImageView(background);
		image.fitWidthProperty().bind(root.widthProperty());
		image.fitHeightProperty().bind(root.heightProperty()); 
		root.getChildren().add(image);
		//
		this.window = stage;
		root.setLeft(board);
		root.setRight(puzzleSolution);
		Reset.setMaxSize(150,300);
		Reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent args0) {
				controller = new GameController(new Game(5));
				render();
			}
		});
		root.setBottom(Reset);
		Scene scene = new Scene(root,1500,800);
		window.setScene(scene);
		window.show();
		//
		render();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
