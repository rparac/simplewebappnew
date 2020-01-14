package ic.doc.web;

import ic.doc.file.FileCreator;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileResultPage implements Page {
    private final String query;
    private final String answer;
    private final FileCreator creator;

    public FileResultPage(String query, String answer, FileCreator creator) {
        this.query = query;
        this.answer = answer;
        this.creator = creator;
    }

    @Override
    public void writeTo(HttpServletResponse resp) throws IOException {
        resp.setContentType(creator.getContentType());

        if (answer != null && query != null) {
            File file = creator.createFile(query, answer);

            InputStream targetStream = new FileInputStream(file);
            targetStream.transferTo(resp.getOutputStream());
        }
    }

}
