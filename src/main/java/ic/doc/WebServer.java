package ic.doc;

import ic.doc.file.MarkdownFileCreator;
import ic.doc.file.PdfFileCreator;
import ic.doc.web.HTMLResultPage;
import ic.doc.web.IndexPage;
import ic.doc.web.FileResultPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {

    public WebServer() throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new Website()), "/*");
        server.setHandler(handler);

        server.start();
    }

    static class Website extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String query = req.getParameter("q");
            String button = req.getParameter("button");

            if (query == null) {
                new IndexPage().writeTo(resp);
            }  else {
                String result = new QueryProcessor().process(query);
                switch (button) {
                    case "markdown":
                        new FileResultPage(query, result,
                            new MarkdownFileCreator()).writeTo(resp);
                        break;
                    case "pdf":
                        new FileResultPage(query, result,
                            new PdfFileCreator()).writeTo(resp);
                        break;
                    default:
                        new HTMLResultPage(query, result).writeTo(resp);
                        break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new WebServer();
    }
}

