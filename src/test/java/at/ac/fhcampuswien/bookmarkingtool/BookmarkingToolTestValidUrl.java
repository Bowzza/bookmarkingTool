package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookmarkingToolTestValidUrl {

    @ParameterizedTest
    @CsvSource({"https://www.fh-campuswien.ac.at/, https://www.fh-campuswien.ac.at/", "http://www.fh-campuswien.ac.at/, http://www.fh-campuswien.ac.at/"})
    public void ensureBookmarkingValidUrl(String input, String expectedResult) {

        // Arrange
        Url url = new Url(input);
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

    @ParameterizedTest
    @CsvSource({"://www.fh-campuswien.ac.at/, no protocol: ://www.fh-campuswien.ac.at/", "htt://www.fh-campuswien.ac.at/, unknown protocol: htt", "httpswww.fh-campuswien.ac.at/, no protocol: httpswww.fh-campuswien.ac.at/,", "https/:/www.fh-campuswien.ac.at/, no protocol: https/:/www.fh-campuswien.ac.at/", "https://www.fh-campuswi^n.ac.at/, Illegal character in authority at index 8: https://www.fh-campuswi^n.ac.at/", "' ', 'no protocol:  '", "https://www.fh-cam puswien.ac.at/, Illegal character in authority at index 8: https://www.fh-cam puswien.ac.at/", "'', 'no protocol: '"})
    public void ensureBookmarkingUrlWithIllegalCharactersNoProtocolUnknownProtocol(String input, String expectedResult) {

        // Arrange
        Url url = new Url(input);
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.bookmarkUrl(url));

        // Act
        result = exception.getMessage();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureAddingValidKeywordToUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String expectedResult = "fh campus";
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        bookmarkingTool.getUrlList().get(0).setKeyword("fh campus");
        result = bookmarkingTool.getUrlList().get(0).getKeyword();
        // Assert
        assertEquals(expectedResult, result);
    }
}
