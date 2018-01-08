package com.linux.simple;

import javafx.application.Application;
import javafx.stage.Stage;

import com.linux.simple.internal.GenerateContents;

public class SimpleUiApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		GenerateContents.defaultContent(primaryStage);
		primaryStage.show();
	}
}


// cd jpms
// javac `find app -type f -name "*.java"`
// jar -cvf jpms.app.jar -e com.linux.java.se.nine.jpms.app.SimpleUiApp  -C com/linux/java/se/nine/jpms/app .
// java --module-path jpms.app com.linux.java.se.nine.jpms.app.SimpleUiApp