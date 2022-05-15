package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmarkingToolTagUrlWithKeywordTest {

    @Test
    public void ensureAddingValidKeywordToUrl() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        String expectedResult = "fh campus";
        String result;
        BookmarkingTool bookmarkingTool = new BookmarkingTool();

        // Act
        bookmarkingTool.bookmarkUrl(url);
        bookmarkingTool.getUrlList().get(0).setKeyword("fh campus");
        result = bookmarkingTool.getUrlList().get(0).getKeyword();
        // Assert
        assertEquals(expectedResult, result);
    }
}
