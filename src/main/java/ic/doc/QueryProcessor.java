package ic.doc;

public class QueryProcessor {

    public String process(String query) {
        StringBuilder results = new StringBuilder();
        if (query.toLowerCase().contains("shakespeare")) {
            results.append("William Shakespeare (26 April 1564 - 23 April 1616) was an\n" +
                           "English poet, playwright, and actor, widely regarded as the greatest\n" +
                           "writer in the English language and the world's pre-eminent dramatist. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("asimov")) {
            results.append("Isaac Asimov (2 January 1920 - 6 April 1992) was an\n" +
                           "American writer and professor of Biochemistry, famous for\n" +
                           "his works of hard science fiction and popular science. \n");
            results.append(System.lineSeparator());
        }

        if (query.toLowerCase().contains("twain")) {
            results.append("Samuel Langhorne Clemens (November 30, 1835 to April 21, 1910)\n" +
                           ",[1] known by his pen name Mark Twain, was an American writer, \n" +
                           "humorist, entrepreneur, publisher, and lecturer. He was lauded as \n" +
                           "the \"greatest humorist this country has produced\"");
        }

        if (query.toLowerCase().contains("milo")) {
            results.append("Milo Djukanovic (born 15 February 1962) is a Montenegrin politician who\n" +
                           "has been the President of Montenegro since 20 May 2018. He served as Prime\n" +
                           "Minister of Montenegro in three governments from 1991 to 1998, as the\n" +
                           "President of Montenegro from 1998 to 2002, and as Prime Minister again\n" +
                           "from 2003 to 2006, from 2008 to 2010, and from 2012 to 2016\n");
        }

        return results.toString();
    }
}
