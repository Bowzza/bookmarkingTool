package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolAssociateBookmarksTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void ensureAssociatingDomains(String firstParam, String secondParam, String thirdParam, List<String> expectedResult) {

        // Arrange
        Url firstUrl = new Url(firstParam);
        Url secondUrl = new Url(secondParam);
        Url thirdUrl = new Url(thirdParam);
        List<String> result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        result = bookmarkingTool.associateDomain();

        // Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("http://www.fh-campuswien.ac.at/",
                        "http://moodle.fh-campuswien.ac.at/",
                        "http://portal.fh-campuswien.ac.at/",
                        new ArrayList<String>()),

                Arguments.of("http://www.fh-campuswien.ac.at/",
                        "http://moodle.fh-campuswien.ac.at/",
                        "http://www.fh-campuswien.ac.at/dd",
                        new ArrayList<String>(){{
                            add("http://www.fh-campuswien.ac.at/");
                            add("http://www.fh-campuswien.ac.at/dd");}}
                ),

                Arguments.of("http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot.html",
                        "http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot/detail/bioengineering-bachelor.html",
                        "http://www.fh-campuswien.ac.at/studium-weiterbildung/bewerbung-und-aufnahme.html",
                        new ArrayList<String>(){{
                            add("http://www.fh-campuswien.ac.at/studium-weiterbildung/bewerbung-und-aufnahme.html");
                            add("http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot.html");
                            add("http://www.fh-campuswien.ac.at/studium-weiterbildung/studien-und-lehrgangsangebot/detail/bioengineering-bachelor.html");}}
                ),

                Arguments.of("https://www.fh-campuswien.ac.at",
                        "http://moodle.fh-campuswien.ac.at",
                        "http://www.fh-campuswien.ac.at",
                        new ArrayList<String>(){{
                            add("http://www.fh-campuswien.ac.at");
                            add("https://www.fh-campuswien.ac.at");}}
                )
        );
    }
}
