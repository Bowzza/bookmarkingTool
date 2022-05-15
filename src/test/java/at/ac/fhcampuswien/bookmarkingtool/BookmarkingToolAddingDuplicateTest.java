package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolAddingDuplicateTest {

    @Test
    public void ensureBookmarkingDuplicateUrl() {

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
}
