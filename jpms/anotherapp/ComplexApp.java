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
// java --module-path simple:complex --module complex/com.linux.complex.ComplexApp

// using jars
// javac -d target --module-path simple.jar complex/module-info.java complex/com/linux/complex/ComplexApp.java
// jar -cvf complex.jar -C target/ .
// java --module-path simple.jar:complex.jar --module complex/com.linux.complex.ComplexApp

// using executable jars  :: seperating the options is important!!
// jar --create --verbose --file complex.jar --main-class com.linux.complex.ComplexApp -C target/ .
// java --module-path simple.jar:complex.jar -m complex
