# Java-9-Discovery
Java 9 Meetup

To run this program, you need to (of course install Java 9 and setup you PATH properly)
1. Change to the directory where this README.md is.
2. cd jpms
3. javac simple/module-info.java simple/com/linux/simple/SimpleUiApp.java simple/com/linux/simple/generators/ContentsGenerator.java simple/com/linux/simple/generators/internal/DefaultContentsGenerator.java
4. java --module-path simple --module simple/com.linux.simple.SimpleUiApp

More commands to run : can be found : (better syntax highlighting)
https://github.com/gurukulkarni/Java-9-Discovery/blob/05-packages/jpms/simple/com/linux/simple/SimpleUiApp.java
https://github.com/gurukulkarni/Java-9-Discovery/blob/05-packages/jpms/complex/com/linux/complex/ComplexApp.java

For more details see https://github.com/gurukulkarni/Java-9-Discovery/wiki