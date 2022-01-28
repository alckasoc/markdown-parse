import static org.junit.Assert.*;
import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of("https://something.com", "some-page.html");
        assertEquals("Check expected links for test-file.md", expectedLinks, links);
    }

    @Test
    public void testImageLink() throws IOException{
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of();
        assertEquals("Check expected links for image_link.md", expectedLinks, links);
    }

    @Test
    public void testNoLinks() throws IOException{
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expectedLinks = List.of();
        assertEquals("Check expected links for no_links.md", expectedLinks, links);
    }
}