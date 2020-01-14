package ic.doc.web;

import ic.doc.file.FileCreator;
import ic.doc.file.MarkdownFileCreator;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FileResultPageTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  HttpServletResponse response = context.mock(HttpServletResponse.class);
  FileCreator fileCreator = new MarkdownFileCreator();

  @Test
  public void doesNotWriteResponseWhenQueryResultIsNull() throws IOException {
    checkNoOccurrenceOfResponse();

    FileResultPage page = new FileResultPage("mark", null,
                                             fileCreator);
    page.writeTo(response);
  }

  @Test
  public void doesNotWriteResponseWhenQueryIsNull() throws IOException {
    checkNoOccurrenceOfResponse();

    FileResultPage page = new FileResultPage(null, "afs",
                                             fileCreator);
    page.writeTo(response);
  }

  @Test
  public void setsResponseTypeToMarkdown() throws IOException {
   context.checking(new Expectations() {{
     exactly(1).of(response).setContentType("text/markdown");
     ignoring(response);
   }});

   FileResultPage page = new FileResultPage(null, null,
                                            fileCreator);
   page.writeTo(response);
  }

  private void checkNoOccurrenceOfResponse() {
    context.checking(new Expectations() {{
      ignoring(response).setContentType("text/markdown");
      never(response);
    }});
  }
}