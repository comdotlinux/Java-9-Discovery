package com.linux.java.se.nine.jpms.app;

import javafx.application.Application;
import javafx.stage.Stage;

import com.linux.java.se.nine.jpms.app.internal.GenerateContents;

public class SimpleUiApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		GenerateContents.defaultContent(primaryStage);
		primaryStage.show();
	}
}



// javac com/linux/java/se/nine/jpms/example/module-info.java com/linux/java/se/nine/jpms/example/internal/GenerateContents.java com/linux/java/se/nine/jpms/example/SimpleUiApp.java
// java --module-path jpms.example com.linux.java.se.nine.jpms.example.SimpleUiApp