package at.ac.fhcampuswien.bookmarkingtool.model;

public class Url {
    private String url;
    private String keyword;
    private int rating;

    public Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getRating() {
        throw new UnsupportedOperationException();
    }

    public void setRating(int rating) {
        throw new UnsupportedOperationException();
    }

    public void setKeyword(String keyword) {
        if (keyword == null) throw new IllegalArgumentException("Keyword must not be null");
        if (keyword.isEmpty() || keyword.trim().isEmpty()) throw new IllegalArgumentException("Keyword must not be empty");
        this.keyword = keyword;
    }
}
