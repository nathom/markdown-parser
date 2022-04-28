import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.junit.*;

public class MarkdownParseTest {
  @Test
  public void addition() {
    assertEquals(2, 1 + 1);
  }

  @Test
  public void test1() {
    String s = readFile("test-file.md");
    List<String> l = MarkdownParse.getLinks(s);
    assertEquals(l, List.of("https://something.com", "some-thing.html"));
  }

  @Test
  public void test2() {
    String s = readFile("test-file2.md");
    List<String> l = MarkdownParse.getLinks(s);
    assertEquals(l, List.of("https://other-link.com"));
  }

  @Test
  public void test3() {
    String s = readFile("test-file3.md");
    List<String> l = MarkdownParse.getLinks(s);
    assertEquals(l, List.of("this should show"));
  }

  @Test
  public void test4() {
    String s = readFile("test-file4.md");
    List<String> l = MarkdownParse.getLinks(s);
    assertEquals(l.size(), 0);
  }

  @Test
  public void test5() {
    String s = readFile("test-file8.md");
    List<String> l = MarkdownParse.getLinks(s);
    assertEquals(List.of("google.com"), l);
  }

  private String readFile(String path) {
    try {
      return Files.readString(Paths.get(path));
    } catch (IOException i) {
      return null;
    }
  }
}
