package at.ac.fhcampuswien.bookmarkingtool.model;

public class Url {
    private String url;
    private String keyword;

    public Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
