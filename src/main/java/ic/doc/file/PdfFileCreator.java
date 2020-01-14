package ic.doc.file;

import java.io.File;
import java.io.IOException;

public class PdfFileCreator implements FileCreator {
  @Override
  public File createFile(String name, String content) throws IOException {
    MarkdownFileCreator markdownFileCreator = new MarkdownFileCreator();
    markdownFileCreator.createFile(name, content);

    createPdfPandoc(name);

    return new File(name + ".pdf");
  }

  private void createPdfPandoc(String name) throws IOException {
    Process pdfProc = new ProcessBuilder()
        .command("pandoc", name + ".tmp", "-o", name + ".pdf")
        .start();

    int exitCode = 1;
    try {
      exitCode = pdfProc.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (exitCode != 0) {
      throw new RuntimeException("The pdf was not made gracefully");
    }
  }
}
