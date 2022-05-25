package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookmarkingToolAddDateTimeTest {

    @Test
    public void ensureAddingDateTime() {

        // Arrange
        Url url = new Url("https://www.fh-campuswien.ac.at/");
        BookmarkingTool bookmarkingTool = new BookmarkingTool();
        LocalDateTime result;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime expectedResult = LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter);

        //Act
        bookmarkingTool.bookmarkUrl(url);
        result = bookmarkingTool.getUrlList().get(0).getDate();

        // Assert
        assertEquals(expectedResult, result);
    }
}
