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
		contentsGenerator.generateContent(primaryStage, "Complex JavaFX Application", ComplexApp.class.getSimpleName());
		primaryStage.show();
	}

}
		
// javac --module-path simple complex/module-info.java complex/com/linux/complex/ComplexApp.java