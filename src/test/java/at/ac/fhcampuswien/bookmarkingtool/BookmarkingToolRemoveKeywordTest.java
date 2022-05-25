package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolRemoveKeywordTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void ensureRemovingKeyword(String firstKeyword, String secondKeyword, String removeKeyword, List<String> expectedResult) {

        //Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        List<String> result;

        //Act
        url.addKeyword(firstKeyword);
        url.addKeyword(secondKeyword);
        url.removeKeyword(removeKeyword);
        result = url.getKeyword();

        //Assert
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("fh campus", "moodle", "moodle",
                          new ArrayList<String>() {{add("fh campus");}}
                ),

                Arguments.of("fh campus", "moodle", "github",
                        new ArrayList<String>() {{
                            add("fh campus");
                            add("moodle");
                        }}
                )
        );
    }
}
