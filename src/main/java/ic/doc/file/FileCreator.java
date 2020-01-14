package ic.doc.file;

import java.io.File;
import java.io.IOException;

public interface FileCreator {
  File createFile(String name, String content) throws IOException;

  String getContentType();
}
