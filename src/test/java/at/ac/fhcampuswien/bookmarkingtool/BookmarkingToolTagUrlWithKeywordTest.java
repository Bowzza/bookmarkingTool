package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        bookmarkingTool.getUrlList().get(0).addKeyword(keyword);
        result = bookmarkingTool.getUrlList().get(0).getKeyword().get(0);

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
        exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.getUrlList().get(0).addKeyword(keyword));
        result = exception.getMessage();

        // Assert
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"'', Keyword must not be empty", "' ', Keyword must not be empty"})
    public void ensureAddingKeywordWithoutAnyDataToUrl(String input, String expectedResult) {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String result;
        Exception exception;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.getUrlList().get(0).addKeyword(input));
        result = exception.getMessage();

        // Assert
        assertEquals(expectedResult, result);
    }
}
