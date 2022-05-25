package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookmarkingToolRemoveBookmarkTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void ensureRemovingBookmark(String firstParameter, String secondParameter, String removeParameter, List<String> expectedResult) {

        //Arrange
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        Url firstUrl = new Url(firstParameter);
        Url secondUrl = new Url(secondParameter);
        Url removeUrl = new Url(removeParameter);
        List<String> result;

        //Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.removeBookmarkUrl(removeUrl.getUrl());
        result = bookmarkingTool.getUrlListString();

        //Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("https://www.fh-campuswien.ac.at/", "https://moodle.fh-campuswien.ac.at/",
                        "https://moodle.fh-campuswien.ac.at/",
                        new ArrayList<String>() {{
                            add("https://www.fh-campuswien.ac.at/");
                        }}
                ),

                Arguments.of("https://www.fh-campuswien.ac.at/", "https://moodle.fh-campuswien.ac.at/",
                        "https://portal.fh-campuswien.ac.at/",
                        new ArrayList<String>() {{
                            add("https://www.fh-campuswien.ac.at/");
                            add("https://moodle.fh-campuswien.ac.at/");
                        }}
                )
        );
    }

    @Test
    public void ensureRemovingNullBookmark() {

        //Arrange
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String removeUrl = null;
        String expectedResult = "Url must not be null";
        Exception exception;
        String result;

        //Act
        bookmarkingTool.bookmarkUrl(url);
        exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.removeBookmarkUrl(removeUrl));
        result = exception.getMessage();

        //Assert
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"'', Url must not be empty", "' ', Url must not be empty", "'\n', Url must not be empty", "\n, Url must not be null"})
    public void ensureRemovingEmptyUrl(String removeUrl, String expectedResult) {

        //Arrange
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        Exception exception;
        String result;

        //Act
        bookmarkingTool.bookmarkUrl(url);
        exception = assertThrows(IllegalArgumentException.class, () -> bookmarkingTool.removeBookmarkUrl(removeUrl));
        result = exception.getMessage();

        //Assert
        assertEquals(expectedResult, result);
    }
}
