package at.ac.fhcampuswien.bookmarkingtool.model;

import java.util.ArrayList;
import java.util.List;

public class Url {
    private String url;
    private List<String> keywordList;
    private int rating;
    private String domain;

    public Url(String url) {
        this.url = url;
        this.keywordList = new ArrayList<>();
        this.domain = getDomainFromUrl(url);
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

    public void addKeywords(List<String> keywords) {
        for (String keyword: keywords) {
            addKeyword(keyword);
        }
    }

    public void removeKeyword(String keyword) {
        keywordList.remove(keyword);
    }

    public String getDomain() {
        return domain;
    }

    private String getDomainFromUrl(String url) {
        if(!url.contains("/")) return "";
        String[] parts = url.split("/");
        if(parts.length >= 3) return parts[2];
        return "";
    }
}
