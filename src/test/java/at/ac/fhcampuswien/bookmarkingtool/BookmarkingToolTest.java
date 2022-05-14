package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkingToolTest {

    @Test
    public void ensureBookmarkingValidUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String expectedResult = new Url("https://www.fh-campuswien.ac.at/").getUrl();
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.getUrlList().get(0).getUrl();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureBookmarkingWithNull() {

        // Arrange
        Url url = null;
        int expectedResult = 0;
        int result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.getUrlList().size();

        // Assert
        assertEquals(expectedResult, result);
    }
}
