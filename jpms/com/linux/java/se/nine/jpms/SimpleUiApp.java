package com.linux.java.se.nine.jpms;

import javafx.application.Application;
import javafx.stage.Stage;

import com.linux.java.se.nine.jpms.GenerateContents;

public class SimpleUiApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		GenerateContents.defaultContent(primaryStage);
		primaryStage.show();
	}
}



// javac com/module-info.java  com/linux/java/se/nine/jpms/SimpleUiApp.java com/linux/java/se/nine/jpms/internal/GenerateContents.java
// java --module-path com.linux.java.se.nine.jpms com.linux.java.se.nine.jpms.SimpleUiApp