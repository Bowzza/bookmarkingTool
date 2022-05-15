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
        throw new UnsupportedOperationException();
    }

    public void setKeyword(String keyword) {
        throw new UnsupportedOperationException();
    }
}
