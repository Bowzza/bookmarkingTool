package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolFilterByMultipleKeywordsTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void ensureFilteringByMultipleKeywords(String firstParam, List<String> firstKeyword, String secondParam,
                                            List<String> secondKeyword, String thirdParam, List<String> thirdKeyword,
                                            List<String> filterKeyword, List<String> expectedResult) {

        // Arrange
        Url firstUrl = new Url(firstParam);
        Url secondUrl = new Url(secondParam);
        Url thirdUrl = new Url(thirdParam);
        List<String> result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        firstUrl.addKeywords(firstKeyword);
        secondUrl.addKeywords(secondKeyword);
        thirdUrl.addKeywords(thirdKeyword);
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        result = bookmarkingTool.filterByMultipleKeywords(filterKeyword);

        // Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("http://www.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("fh");
                            add("campus");
                        }}, "http://moodle.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                        }}, "http://portal.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("portal");
                            add("campus");
                        }}, new ArrayList<String>() {{
                            add("fh campus");
                            add("wien");
                        }}, new ArrayList<String>()
                ),

                Arguments.of("http://www.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("fh");
                            add("campus");
                        }}, "http://moodle.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                        }}, "http://portal.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("portal");
                            add("campus");
                        }}, new ArrayList<String>() {{
                            add("portal");
                            add("wien");
                        }}, new ArrayList<String>() {{
                            add("http://portal.fh-campuswien.ac.at/");
                        }}
                ),

                Arguments.of("http://www.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("ac");
                            add("at");
                        }}, "http://moodle.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                            add("fh");
                        }}, "http://portal.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("ac");
                            add("at");
                        }}, new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                            add("fh");
                        }}, new ArrayList<String>() {{
                            add("http://moodle.fh-campuswien.ac.at/");
                        }}
                ),

                Arguments.of("http://www.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("fh");
                            add("campus");
                        }}, "http://moodle.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                        }}, "http://portal.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("portal");
                            add("campus");
                        }}, new ArrayList<String>() {{
                            add("fh");
                            add("moodle");
                            add("portal");
                        }}, new ArrayList<String>() {{
                            add("http://moodle.fh-campuswien.ac.at/");
                            add("http://portal.fh-campuswien.ac.at/");
                            add("http://www.fh-campuswien.ac.at/");
                        }}
                ),

                Arguments.of("http://www.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("fh");
                            add("campus");
                        }}, "http://moodle.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("moodle");
                            add("campus");
                        }}, "http://portal.fh-campuswien.ac.at/", new ArrayList<String>() {{
                            add("portal");
                            add("campus");
                        }}, new ArrayList<String>(), new ArrayList<String>()
                )
        );
    }
}
