package ic.doc.file;


import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PdfFileCreatorTest {
  @Test
  public void createsAPdfFile() throws IOException, InterruptedException {
    String name = "Hello";
    String content = "Hello world";

    PdfFileCreator creator = new PdfFileCreator();
    File file = creator.createFile(name, content);

    assertNotNull(file);

    // delete file as a part of a cleanup
    Process deleteProc = new ProcessBuilder()
        .command("rm", name + ".pdf")
        .start();

     int exitCode = deleteProc.waitFor();
     assertThat(exitCode, is(0));
  }
}