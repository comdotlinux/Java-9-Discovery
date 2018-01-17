package com.linux.simple;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleUiApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello Java9 World");
		Button button = new Button();
		button.setText("Hello Java9 World");
		button.setOnAction(e -> System.out.println("Performed " + e.getEventType().toString()));

		StackPane root = new StackPane();
		root.getChildren().add(button);
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
	}
}


// This still works.
// cd jpms
// javac simple/module-info.java  simple/com/linux/simple/SimpleUiApp.java
// cd simple && java com.linux.simple.SimpleUiApp

// this won't
// java --module-path simple --module simple/com.linux.simple.SimpleUiApp
// jlink --module-path simple:/usr/lib/jvm/java-9-oracle/jmods --add-modules simple --limit-modules simple --launcher simpleJfxApp=simple/com.linux.simple.SimpleUiApp --output tmp
// ./tmp/bin/java --list-modules