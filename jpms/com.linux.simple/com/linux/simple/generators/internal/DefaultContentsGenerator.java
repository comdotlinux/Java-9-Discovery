package com.linux.simple.generators.internal;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import com.linux.simple.generators.ContentsGenerator;

/**
 * DefaultContentsGenerator
 */
public class DefaultContentsGenerator implements ContentsGenerator{

	@Override
	public void generateContent(Stage stage, String title, String messagePrefix) {
		System.out.println("Default content generated.");
		stage.setTitle(title);
		Button button = new Button();
		button.setText(title);
		button.setOnAction(e -> System.out.println(messagePrefix + " -- " + e.getEventType().toString()));

		StackPane root = new StackPane();
		root.getChildren().add(button);
		stage.setScene(new Scene(root, 400, 300));
	}
}