package ic.doc.web;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MarkdownResultPageTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  HttpServletResponse response = context.mock(HttpServletResponse.class);

  @Test
  public void doesNotWriteResponseWhenQueryResultIsNull() throws IOException {
    checkNoOccurrenceOfResponse();

    MarkdownResultPage page = new MarkdownResultPage("mark", null);
    page.writeTo(response);
  }

  @Test
  public void doesNotWriteResponseWhenQueryIsNull() throws IOException {
    checkNoOccurrenceOfResponse();

    MarkdownResultPage page = new MarkdownResultPage(null, "afs");
    page.writeTo(response);
  }

  @Test
  public void setsResponseTypeToMarkdown() throws IOException {
   context.checking(new Expectations() {{
     exactly(1).of(response).setContentType("text/markdown");
     ignoring(response);
   }});

   MarkdownResultPage page = new MarkdownResultPage(null, null);
   page.writeTo(response);
  }

  private void checkNoOccurrenceOfResponse() {
    context.checking(new Expectations() {{
      ignoring(response).setContentType("text/markdown");
      never(response);
    }});
  }
}