libs = lib/*:.

try: TryCommonMark.class
	java -cp $(libs) TryCommonMark

TryCommonMark.class: TryCommonMark.java
	javac -cp $(libs) $<

test: MarkdownParseTest.class MarkdownParse.class
	java -cp $(libs) org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParseTest.java
	javac -cp $(libs) $<

MarkdownParse.class: MarkdownParse.java
	javac $<
