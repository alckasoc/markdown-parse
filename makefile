test: MarkdownParse.class MarkdownParseTest.class

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp ".;./lib/junit-4.13.2.jar;./lib/hamcrest-core-1.3.jar" MarkdownParseTest.java
	java -cp ".;./lib/junit-4.13.2.jar;./lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest

# MarkdownParse.java is optional?

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

clean:
	rm -f MarkdownParse.class
	rm -f MarkdownParseTest.class

