package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookmarkingTool {

    private List<Url> urlList = new ArrayList<>();

    public void bookmarkUrl(Url url) {
        if (url == null) throw new IllegalArgumentException("Url must not be null");
        try {
            new URL(url.getUrl()).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        urlList.add(url);
    }

    public List<Url> getUrlList() {
        return urlList;
    }
}
