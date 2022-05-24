package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolFilterByOneKeywordTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void ensureFilteringByOneKeyword(String firstParam, String firstKeyword, String secondParam,
                                         String secondKeyword, String thirdParam, String thirdKeyword,
                                         String filterKeyword, List<String> expectedResult) {

        // Arrange
        Url firstUrl = new Url(firstParam);
        Url secondUrl = new Url(secondParam);
        Url thirdUrl = new Url(thirdParam);
        List<String> result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        firstUrl.addKeyword(firstKeyword);
        secondUrl.addKeyword(secondKeyword);
        thirdUrl.addKeyword(thirdKeyword);
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        result = bookmarkingTool.filterByKeyword(filterKeyword);

        // Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("http://www.fh-campuswien.ac.at/", "fh campus", "http://moodle.fh-campuswien.ac.at/",
                        "fh campus", "http://portal.fh-campuswien.ac.at/", "fh campus", "fhcampus", new ArrayList<String>()
                ),
                Arguments.of("http://www.fh-campuswien.ac.at/", "fh campus", "http://moodle.fh-campuswien.ac.at/",
                        "moodle fh campus", "http://portal.fh-campuswien.ac.at/", "portal fh campus", "moodle fh campus",
                        new ArrayList<String>() {{
                            add("http://moodle.fh-campuswien.ac.at/");
                        }}
                ),
                Arguments.of("http://www.fh-campuswien.ac.at/", "fh campus", "http://moodle.fh-campuswien.ac.at/",
                        "fh campus", "http://portal.fh-campuswien.ac.at/", "fh campus", "fh campus",
                        new ArrayList<String>() {{
                            add("http://www.fh-campuswien.ac.at/");
                            add("http://moodle.fh-campuswien.ac.at/");
                            add("http://portal.fh-campuswien.ac.at/");
                        }}
                )
        );
    }
}
