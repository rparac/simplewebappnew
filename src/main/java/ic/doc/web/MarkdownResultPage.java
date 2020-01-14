package ic.doc.web;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MarkdownResultPage implements Page {
    private final String query;
    private final String answer;

    public MarkdownResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/markdown");

        if (answer != null) {
            File file = File.createTempFile(query, ".tmp");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(answer);
            fileWriter.close();

            InputStream targetStream = new FileInputStream(file);

            targetStream.transferTo(resp.getOutputStream());
        }
    }
}
