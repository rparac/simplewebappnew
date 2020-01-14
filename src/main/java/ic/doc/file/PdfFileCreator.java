package ic.doc.file;

import java.io.File;
import java.io.IOException;

public class PdfFileCreator implements FileCreator {
  @Override
  public File createFile(String name, String content) throws IOException {
    MarkdownFileCreator markdownFileCreator = new MarkdownFileCreator();
    File tempFile = markdownFileCreator.createFile(name, content);
    String fullName = "/tmp/" + name + ".pdf";

    createPdfPandoc(fullName, tempFile);

    return new File(fullName);
  }

  @Override
  public String getContentType() {
    return "application/pdf";
  }

  private void createPdfPandoc(String name, File tempFile) throws IOException {
    String tempFileLocation = tempFile.toString();

    Process pdfProc = new ProcessBuilder()
        .command("pandoc", tempFileLocation, "-o", name)
        .start();

    int exitCode = 1;
    try {
      exitCode = pdfProc.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (exitCode != 0) {
      throw new RuntimeException("The pdf was not made gracefully" + tempFileLocation + " "
                                 + exitCode + " " + name);
    }
  }
}
