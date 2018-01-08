package com.linux.simple.generators;

import javafx.stage.Stage;

import com.linux.simple.generators.internal.DefaultContentsGenerator;

public interface ContentsGenerator {
	void generateContent(Stage stage, String title, String messagePrefix);

	static ContentsGenerator getInstance() {
		return new DefaultContentsGenerator();
	}
}