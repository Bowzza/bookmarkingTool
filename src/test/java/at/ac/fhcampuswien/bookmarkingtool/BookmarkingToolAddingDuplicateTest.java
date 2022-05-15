package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolAddingDuplicateTest {

    @Test
    public void ensureBookmarkingDuplicateUrlIsNotInList() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("https://www.fh-campuswien.ac.at/");
        int expectedResult = 1;
        int result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        result = bookmarkingTool.getUrlList().size();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureRatingIsIncreasedWhenBookmarkingDuplicateUrl() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("https://www.fh-campuswien.ac.at/");
        int expectedResult = 1;
        int result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        result = bookmarkingTool.getUrlList().get(0).getRating();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureBookmarkingDuplicateUrlIsInList() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("https://moodle.fh-campuswien.ac.at/");
        String expectedResult = "https://moodle.fh-campuswien.ac.at/";
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        result = bookmarkingTool.getUrlList().get(1).getUrl();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureRatingIsNotIncreasedWhenBookmarkingDifferentUrl() {

        // Arrange
        Url firstUrl = new Url("https://www.fh-campuswien.ac.at/");
        Url secondUrl = new Url("https://moodle.fh-campuswien.ac.at/");
        int expectedResult = 0;
        int result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(firstUrl);
        bookmarkingTool.bookmarkUrl(secondUrl);
        result = bookmarkingTool.getUrlList().get(0).getRating();

        // Assert
        assertEquals(expectedResult, result);
    }
}
