package com.linux.java.se.nine.jpms.app.internal;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/**
 * DefaultStage
 */
public class GenerateContents {
	public static void defaultContent(Stage stage) {
		stage.setTitle("Hello Java9 World");
		Button button = new Button();
		button.setText("Hello Java9 World");
		button.setOnAction(e -> System.out.println("Performed " + e.getEventType().toString()));

		StackPane root = new StackPane();
		root.getChildren().add(button);
		stage.setScene(new Scene(root, 400, 300));
	}
}