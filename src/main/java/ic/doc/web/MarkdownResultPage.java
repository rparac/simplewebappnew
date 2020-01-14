package ic.doc.web;

import ic.doc.file.FileCreator;
import ic.doc.file.MarkdownFileCreator;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkdownResultPage implements Page {
    private final String query;
    private final String answer;
    private final FileCreator creator;

    public MarkdownResultPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
        this.creator = new MarkdownFileCreator();
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/markdown");

        if (answer != null && query != null) {
            File file = creator.createFile(query, answer);

            InputStream targetStream = new FileInputStream(file);
            targetStream.transferTo(resp.getOutputStream());
        }
    }

}
