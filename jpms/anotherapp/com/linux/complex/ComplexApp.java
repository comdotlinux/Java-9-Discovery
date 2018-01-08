package com.linux.complex;

import javafx.application.Application;
import javafx.stage.Stage;

import app.GenerateContents;

/**
 * ComplexApp
 */
public class ComplexApp extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		GenerateContents.defaultContent(primaryStage);
		primaryStage.show();
	}
	
}


// javac com/linux/java/se/nine/jpms/anotherapp/module-info.java com/linux/java/se/nine/jpms/anotherapp/ComplexApp.java
// java --module-path jpms.app com.linux.java.se.nine.jpms.app.SimpleUiApp