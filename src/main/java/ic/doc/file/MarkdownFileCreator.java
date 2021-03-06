package ic.doc.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MarkdownFileCreator implements FileCreator {

  @Override
  public File createFile(String name, String content) throws IOException {
    File file = File.createTempFile(name, ".tmp");
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(content);
    fileWriter.close();

    return file;
  }

  @Override
  public String getContentType() {
    return "text/markdown";
  }
}
