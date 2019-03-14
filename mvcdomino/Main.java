package mvcdomino;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DominoPack;
import model.Grid;

public class Main extends Application {
	
	Controller controller = new Controller(new DominoGame(new DominoPack(),new Grid()));
	// window
	Stage window;
	// root
	BorderPane root;
	// Elements for the view
	HBox handBox     = new HBox(10);
	HBox computerBox = new HBox(10);
	VBox packBox     = new VBox(10);
	Pane gridPane    = new Pane();
	// Positions where to draw a max of 28 dominos .
	int[][] positions  = {{0, 120},{60, 120},
			{120,120},
			{180,120},
			{240,120},
			{285,135},//
			{285,195},
			{285,255},
			{285,310},
			{285,370},
			{300,415},//
			{360,415},
			{420,415},
			{480,415},
			{540,415},
			{600,415},
			{660,415},//17
			{660,415},
			{720,415},
			{780,415},
			{840,415},
			{900,415},
			{960,415},
			{1020,415},
			{1080,415},
			{1140,415},
			{1200,415},
			{1260,415},
			};
	

	@Override
	public void start(Stage stage) throws Exception {
		this.window = stage;
		Button reset = new Button("RESET");
		reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				controller = new Controller(new DominoGame(new DominoPack(),new Grid()));
				render();
			}
		});
		root = new BorderPane();
		handBox.setAlignment(Pos.CENTER);
		computerBox.setAlignment(Pos.CENTER);
		packBox.setAlignment(Pos.CENTER);
		root.setBottom(handBox);
		root.setTop(computerBox);
		root.setRight(packBox);
		root.setLeft(reset);
		root.setCenter(gridPane);
		Scene scene = new Scene(root,800,800);
		window.setScene(scene);
		window.show();
		//
		render();
	}
	public void render() {
		
		handBox.getChildren().clear();
		computerBox.getChildren().clear();
		packBox.getChildren().clear();
		gridPane.getChildren().clear();
		//
		Image background = new Image("file:src/Images/background.jpg");
		ImageView image = new ImageView(background);
		image.fitWidthProperty().bind(gridPane.widthProperty());
		image.fitHeightProperty().bind(gridPane.heightProperty()); 
		gridPane.getChildren().add(image);
		//Hand of Player
		int index = 0;
		for(Image img : controller.handImages) {
			//handBox.getChildren().add(new ImageView(img));	
			handBox.getChildren().add(new ButtonPressed(img,index));
			index++;
		}
		//Hand of computer
		for(Image img : controller.computerImages) {
			computerBox.getChildren().add(new ImageView(img));		
		}
		//Pack Images
		int i = 0 ;
		
		for(Image img : controller.packImages) {
			if( i < 8 ) {
				packBox.getChildren().add(new ImageView(img));		
			}
			i++;
		}
		//grid Images
		int j = 0;
		for(Image img : controller.gridImages) {
			ImageView imv = new ImageView(img);
			imv.setLayoutX(positions[j][0]);
			imv.setLayoutY(positions[j][1]);
			if( j == 5 || j == 6 || j == 7 || j == 8 || j == 9 ) {
				imv.setRotate(90);
			}
			gridPane.getChildren().add(imv);
			j++;
		}
		
		if(!controller.stillPlaying()) {
			ButtonType replay = new ButtonType("Replay");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("");
			alert.setHeaderText(null);
			alert.getButtonTypes().setAll(replay);
			if(controller.playerWin()) {
				alert.setContentText("Congratulations , you won !");
			}else {
				alert.setContentText("Too bad, you lost.... ");
			}
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == replay){
				controller = new Controller(new DominoGame(new DominoPack(),new Grid()));
				render();
			}
		}
		
	}
	
	private class ButtonPressed extends Button {
		private int index;
		private ButtonPressed(Image img,int index) {
			ImageView imv = new ImageView(img);
			this.setGraphic(imv);
			this.index = index;
			this.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	if(controller.stillPlaying()) {
			    		controller.selected = getIndex();
			    		controller.playerTurn();
						controller.computerTurn();
						render();
			    	}
			    }
			});
		}
		private int getIndex() {
			return this.index;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
