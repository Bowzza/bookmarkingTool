package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolListBookmarksSortedByRatingTest {

    @Test
    public void ensureListingBookmarksSortedByRating() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url thirdUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url fourthUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url fifthUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url sixthUrl = new Url("https://moodle.fh-campuswien.ac.at/");
        List<String> result;
        List<String> expectedResult = new ArrayList<String>()  {{
            add("https://www.fh-campuswien.ac.at/");
            add("http://moodle.fh-campuswien.ac.at/");
            add("https://moodle.fh-campuswien.ac.at/");
        }};
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        bookmarkingTool.bookmarkUrl(fourthUrl);
        bookmarkingTool.bookmarkUrl(fifthUrl);
        bookmarkingTool.bookmarkUrl(sixthUrl);
        result = bookmarkingTool.getUrlListByRating();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureListingBookmarksSortedByRatingWithEmptyList() {

        // Arrange
        List<String> result;
        List<String> expectedResult = new ArrayList<>();
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        result = bookmarkingTool.getUrlListByRating();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureListingBookmarksSortedByRatingWithOneEntry() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        List<String> result;
        List<String> expectedResult = new ArrayList<String>()  {{
            add("https://www.fh-campuswien.ac.at/");
        }};
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        result = bookmarkingTool.getUrlListByRating();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureListingBookmarksSortedByRatingAddedRandom() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url thirdUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url fourthUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url fifthUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url sixthUrl = new Url("https://moodle.fh-campuswien.ac.at/");
        List<String> result;
        List<String> expectedResult = new ArrayList<String>()  {{
            add("https://www.fh-campuswien.ac.at/");
            add("http://moodle.fh-campuswien.ac.at/");
            add("https://moodle.fh-campuswien.ac.at/");
        }};
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        bookmarkingTool.bookmarkUrl(fourthUrl);
        bookmarkingTool.bookmarkUrl(fifthUrl);
        bookmarkingTool.bookmarkUrl(sixthUrl);
        result = bookmarkingTool.getUrlListByRating();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureListingBookmarksSortedByRatingAddedHighestRatingLast() {

        // Arrange
        Url firstUrl = new Url("https://moodle.fh-campuswien.ac.at/");
        Url secondUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url thirdUrl = new Url("http://moodle.fh-campuswien.ac.at/");
        Url fourthUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url fifthUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url sixthUrl = new Url("https://www.fh-campuswien.ac.at/");
        List<String> result;
        List<String> expectedResult = new ArrayList<String>()  {{
            add("https://www.fh-campuswien.ac.at/");
            add("http://moodle.fh-campuswien.ac.at/");
            add("https://moodle.fh-campuswien.ac.at/");
        }};
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        bookmarkingTool.bookmarkUrl(thirdUrl);
        bookmarkingTool.bookmarkUrl(fourthUrl);
        bookmarkingTool.bookmarkUrl(fifthUrl);
        bookmarkingTool.bookmarkUrl(sixthUrl);
        result = bookmarkingTool.getUrlListByRating();

        // Assert
        assertEquals(expectedResult, result);
    }
}
