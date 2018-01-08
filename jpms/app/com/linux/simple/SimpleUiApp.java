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
// javac simple/module-info.java simple/com/linux/simple/SimpleUiApp.java simple/com/linux/simple/generators/ContentsGenerator.java simple/com/linux/simple/generators/internal/DefaultContentsGenerator.java
// java --module-path simple --module simple/com.linux.simple.SimpleUiApp

// jdeps --module-path simple --dot-output . --module simple
// jdeps --module-path simple --dot-output . --module simple -s
// http://www.webgraphviz.com/ 

// javac -d target simple/module-info.java simple/com/linux/simple/SimpleUiApp.java simple/com/linux/simple/generators/ContentsGenerator.java simple/com/linux/simple/generators/internal/DefaultContentsGenerator.java
// simple jar (library)
// jar -cvf simple.jar  -C target/ .
// java --module-path simple.jar --module simple/com.linux.simple.SimpleUiApp

// Executable jar 
// jar -cvfe simple.jar com.linux.simple.SimpleUiApp -C target/ .
// java -jar simple.jar