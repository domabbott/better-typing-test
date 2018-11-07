package ui;

import game.Game;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UI {
	
	TextField typingArea = null;
	Label wordLabel = null;
	Game word = new Game("wordlist.txt");
	
	public void handleInit(Stage stage) {
		int width = 700;
		int height = 300;
		
		stage.setWidth(width);
		stage.setHeight(height);
		
		
		AnchorPane pane = new AnchorPane();
		
		typingArea = new TextField();
		typingArea.setLayoutX(width/3);
		typingArea.setLayoutY(height/2);
		typingArea.setOnKeyReleased(this::handleKeyPress);
		
		wordLabel = new Label();
		wordLabel.setLayoutY(height/4);
		wordLabel.setLayoutX(width/3);
		wordLabel.setText(word.getWord());

		
		pane.getChildren().add(typingArea);
		pane.getChildren().add(wordLabel);
			
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		
		stage.show();
	}
	
	private void handleKeyPress(KeyEvent e) {
		if (e.getCode() == KeyCode.SPACE) {
			wordLabel.setText(word.getNextWord());
			typingArea.setText("");
		}
		
		else {
			setLabelText();
		}
	}
	
	private void setLabelText() {
		
		
		if (typingArea.getText().length() <= word.getWord().length()) {
			String substring = word.getWord().substring(0, typingArea.getText().length());
				
			if (substring.contentEquals(typingArea.getText())) {
				setTextColor("black");
			}
			
			else {
				setTextColor("red");
			}
		}
		
		else {
			setTextColor("red");
		}
		
	}
	
	private void setTextColor(String color) {
		wordLabel.setStyle("-fx-text-fill: " + color);
	}
	

}
