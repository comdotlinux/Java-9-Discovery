# Java-9-Discovery
Java 9 Meetup

To run this program, you need to (of course install Java 9 and setup you PATH properly)
1. Change to the directory where this README.md is.
2. cd jpms
3. javac simple/module-info.java  simple/com/linux/simple/SimpleUiApp.javasimple/com/linux/simple/generators/internal/DefaultContentsGenerator.java
4. cd simple && java com.linux.simple.SimpleUiApp

Possibly more commands to run could be found : (at least better syntax highlighting)

https://github.com/gurukulkarni/Java-9-Discovery/blob/01-jpms/jpms/simple/com/linux/simple/SimpleUiApp.java

For more details see https://github.com/gurukulkarni/Java-9-Discovery/wiki

find . -type f -name "*.class" -exec rm -v {} +   // linux (actually GNU) command to remove all .class files from the project.
This is needed so that when you switch with class files remaining and the directory structure changes, git cannot remove the directories as it is not empty.
And no too mention I am too lazy to figure out how to configure VS Code to sent proper command to force this.