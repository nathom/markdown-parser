libs = lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:.

test: MarkdownParseTest.class MarkdownParse.class
	java -cp $(libs) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp $(libs) $<

MarkdownParse.class: MarkdownParse.java
	javac $<
