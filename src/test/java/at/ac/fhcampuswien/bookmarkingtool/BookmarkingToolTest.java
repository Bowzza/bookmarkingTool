package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkingToolTest {

    @Test
    public void ensureBookmarkingValidUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        Url expectedResult = new Url("https://www.fh-campuswien.ac.at/");
        Url result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.findUrl(url);

        // Assert
        assertEquals(expectedResult.getUrl(), result.getUrl());
    }
}
