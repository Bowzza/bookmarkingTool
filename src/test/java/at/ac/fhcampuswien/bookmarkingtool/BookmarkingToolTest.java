package at.ac.fhcampuswien.bookmarkingtool;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkingToolTest {

    @Test
    public void ensureBookmarkingValidUrl() {

        // Arrange
        String url = "https://www.fh-campuswien.ac.at/";
        boolean result;

        // Act
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.getUrlList().contains(url);

        // Assert
        assertTrue(result);
    }
}
