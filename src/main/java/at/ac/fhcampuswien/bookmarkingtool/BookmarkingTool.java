package at.ac.fhcampuswien.bookmarkingtool;

import java.util.ArrayList;
import java.util.List;

public class BookmarkingTool {

    private List<String> urlList = new ArrayList<>();

    public void bookmarkUrl(String url) {
        urlList.add(url);
    }

    public List<String> getUrlList() {
        return urlList;
    }

}
