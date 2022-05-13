package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;

import java.util.ArrayList;
import java.util.List;

public class BookmarkingTool {

    private List<Url> urlList = new ArrayList<>();

    public void bookmarkUrl(Url url) {
        urlList.add(url);
    }

    public List<Url> getUrlList() {
        return urlList;
    }

    public Url findUrl(Url url) {
        return urlList.get(urlList.indexOf(url));
    }
}
