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
        String expectedResult = "Url must not be null";
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.bookmarkUrl(url));

        // Act
        result = exception.getMessage();

        // Assert
        assertEquals(expectedResult, result);
    }
}
