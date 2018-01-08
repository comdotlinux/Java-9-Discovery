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
// export PATH=/usr/lib/jvm/java-9-oracle/bin:/usr/lib/jvm/java-9-oracle/db/bin:/usr/lib/jvm/java-9-oracle/jre/bin:$PATH
// find Java-9-Discovery -type f -name "*.class" -exec rm -v {} + -o -name "*.jar" -exec rm -v {} +