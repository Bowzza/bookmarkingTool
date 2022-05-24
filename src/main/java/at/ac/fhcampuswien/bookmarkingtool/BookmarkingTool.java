package at.ac.fhcampuswien.bookmarkingtool;

import at.ac.fhcampuswien.bookmarkingtool.model.Url;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class BookmarkingTool {

    private List<Url> urlList = new ArrayList<>();

    public void bookmarkUrl(Url url) {
        if (url == null) throw new IllegalArgumentException("Url must not be null");
        for (Url urlItem: urlList) {
            if(urlItem.getUrl().equals(url.getUrl())) {
                urlItem.setRating(url.getRating() + 1);
                return;
            }
        }
        try {
            new URL(url.getUrl()).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        urlList.add(url);
    }

    public int countSecureUrls() {
        int count = 0;
        for (Url urlItem: urlList) {
            if(urlItem.getUrl().startsWith("https")) count++;
        }
        return count;
    }

    public List<String> associateDomain() {
        Set<String> set = new HashSet<>();
        int firstIndex = 0;
        int secondIndex = 0;
        for (Url firstUrl: urlList) {
            for (Url secondUrl: urlList) {
                if(firstUrl.getDomain().equals(secondUrl.getDomain()) && firstIndex != secondIndex) {
                    set.add(firstUrl.getUrl());
                }
                secondIndex++;
            }
            firstIndex++;
            secondIndex=0;
        }
        List<String> returnList = new ArrayList<>(set);
        Collections.sort(returnList);
        return returnList;
    }

    public List<String> filterByKeyword(String keyword) {
        List<String> filteredList = new ArrayList<>();
        for (Url urlItem: urlList) {
            if(urlItem.getKeyword().contains(keyword)) filteredList.add(urlItem.getUrl());
        }
        return filteredList;
    }

    public List<String> filterByMultipleKeywords(List<String> keywords) {
        Set<String> set = new HashSet<>();
        for (Url urlItem: urlList) {
            for (String keyword: keywords) {
                if(urlItem.getKeyword().contains(keyword)) set.add(urlItem.getUrl());
            }
        }
        List<String> returnList = new ArrayList<>(set);
        Collections.sort(returnList);
        return returnList;
    }

    public List<Url> getUrlList() {
        return urlList;
    }
}
