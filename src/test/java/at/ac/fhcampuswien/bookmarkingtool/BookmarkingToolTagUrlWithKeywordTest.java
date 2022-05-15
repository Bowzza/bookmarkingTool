package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookmarkingToolTagUrlWithKeywordTest {

    @Test
    public void ensureAddingValidKeywordToUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String expectedResult = "fh campus";
        String result;
        String keyword = "fh campus";
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        bookmarkingTool.getUrlList().get(0).setKeyword(keyword);
        result = bookmarkingTool.getUrlList().get(0).getKeyword();
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureAddingNullKeywordToUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String expectedResult = "Keyword must not be null";
        String result;
        String keyword = null;
        Exception exception;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.getUrlList().get(0).setKeyword(keyword));
        result = exception.getMessage();

        // Assert
        assertEquals(expectedResult, result);
    }
}
