package com.linux.complex;

import javafx.application.Application;
import javafx.stage.Stage;

import com.linux.simple.generators.ContentsGenerator;

/**
 * ComplexApp
 */
public class ComplexApp extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		ContentsGenerator contentsGenerator = ContentsGenerator.getInstance();
		contentsGenerator.generateContent(primaryStage, "Complicated Hello Java9" , ComplexApp.class.getSimpleName());
		primaryStage.show();
	}
	
}


// javac --module-path app anotherapp/module-info.java anotherapp/com/linux/complex/ComplexApp.java
// java --module-path jpms.app com.linux.java.se.nine.jpms.app.SimpleUiApp