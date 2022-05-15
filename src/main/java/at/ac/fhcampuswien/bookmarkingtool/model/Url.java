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
        if (keyword == null) throw new IllegalArgumentException("Keyword must not be null");
        this.keyword = keyword;
    }
}
