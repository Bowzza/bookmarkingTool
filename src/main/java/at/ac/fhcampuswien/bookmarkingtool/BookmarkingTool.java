package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;

import java.util.ArrayList;
import java.util.List;

public class BookmarkingTool {

    private List<Url> urlList = new ArrayList<>();

    public void bookmarkUrl(Url url) {
        if (url == null) throw new IllegalArgumentException("Url must not be null");
        urlList.add(url);
    }

    public List<Url> getUrlList() {
        return urlList;
    }
}
