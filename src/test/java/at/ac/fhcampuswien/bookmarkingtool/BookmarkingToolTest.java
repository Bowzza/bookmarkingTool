package at.ac.fhcampuswien.bookmarkingtool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkingToolTest {

    @Test
    public void ensureBookmarkingValidUrl() {

        // Arrange
        String url = "https://www.fh-campuswien.ac.at/";
        String expectedResult = "https://www.fh-campuswien.ac.at/";
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.findUrl(url);

        // Assert
        assertEquals(expectedResult, result);
    }
}
