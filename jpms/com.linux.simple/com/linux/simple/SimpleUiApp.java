package com.linux.simple;

import javafx.application.Application;
import javafx.stage.Stage;

import com.linux.simple.generators.ContentsGenerator;

public class SimpleUiApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		ContentsGenerator contentGenerator = ContentsGenerator.getInstance();
		contentGenerator.generateContent(primaryStage, "Hello Java9", SimpleUiApp.class.getSimpleName());
		primaryStage.show();
	}
}


// cd jpms
// javac app/module-info.java app/com/linux/simple/SimpleUiApp.java app/com/linux/simple/generators/ContentsGenerator.java app/com/linux/simple/generators/internal/DefaultContentsGenerator.java
// cd app && java com.linux.simple.SimpleUiApp; cd ..