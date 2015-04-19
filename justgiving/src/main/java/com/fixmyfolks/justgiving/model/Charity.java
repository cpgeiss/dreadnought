package com.fixmyfolks.justgiving.model;

import java.util.List;

public class Charity {
    private Link suggestedQuery;
    private List<SearchResult> charitySearchResults;
    private Link categories;
    private String query;
    private int numberOfHits;
    private int totalPages;
    private Link prev;
    private Link next;

    public Link getSuggestedQuery() {
        return suggestedQuery;
    }

    public List<SearchResult> getCharitySearchResults() {
        return charitySearchResults;
    }

    public Link getCategories() {
        return categories;
    }

    public String getQuery() {
        return query;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public Link getPrev() {
        return prev;
    }

    public Link getNext() {
        return next;
    }

    public void setSuggestedQuery(Link suggestedQuery) {
        this.suggestedQuery = suggestedQuery;
    }

    public void setCharitySearchResults(List<SearchResult> charitySearchResults) {
        this.charitySearchResults = charitySearchResults;
    }

    public void setCategories(Link categories) {
        this.categories = categories;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setPrev(Link prev) {
        this.prev = prev;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}
