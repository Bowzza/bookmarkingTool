package at.ac.fhcampuswien.bookmarkingtool.model;

import java.util.ArrayList;
import java.util.List;

public class Url {
    private String url;
    private List<String> keywordList;
    private int rating;

    public Url(String url) {
        this.url = url;
        this.keywordList = new ArrayList<>();
    }

    public String getUrl() {
        return url;
    }

    public List<String> getKeyword() {
        return keywordList;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addKeyword(String keyword) {
        if (keyword == null) throw new IllegalArgumentException("Keyword must not be null");
        if (keyword.isEmpty() || keyword.trim().isEmpty()) throw new IllegalArgumentException("Keyword must not be empty");
        keywordList.add(keyword);
    }
}
