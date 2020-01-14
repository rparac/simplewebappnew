package ic.doc.file;


import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

public class PdfFileCreatorTest {
  @Test
  public void createsAPdfFile() throws IOException, InterruptedException {
    String name = "Hello";
    String content = "Hello world";

    PdfFileCreator creator = new PdfFileCreator();
    File file = creator.createFile(name, content);

    assertNotNull(file);
  }
}