package ic.doc.file;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MarkdownFileCreatorTest {
  @Test
  public void createdFileContainsContentsPassedIn() throws IOException {
    String content = "Hello world";

    MarkdownFileCreator creator = new MarkdownFileCreator();

    File file = creator.createFile("Hello", content);

    BufferedReader reader = new BufferedReader(new FileReader(file));
    assertThat(reader.readLine(), is(content));
  }

}