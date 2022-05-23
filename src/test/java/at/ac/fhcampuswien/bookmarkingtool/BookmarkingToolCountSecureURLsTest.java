package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolCountSecureURLsTest {

    @ParameterizedTest
    @CsvSource({"http://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, 0",
                "https://www.fh-campuswien.ac.at/, http://moodle.fh-campuswien.ac.at/, 1"})
    public void ensureCountingSecureUrls(String firstParam, String secondParam, int expectedResult) {

        // Arrange
        Url firstUrl = new Url(firstParam);
        Url secondUrl = new Url(secondParam);
        int result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        result = bookmarkingTool.countSecureUrls();

        // Assert
        assertEquals(expectedResult, result);
    }
}
