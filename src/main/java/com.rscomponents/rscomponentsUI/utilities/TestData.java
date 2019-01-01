package com.rscomponents.rscomponentsUI.utilities;

import com.rscomponents.rscomponentsUI.models.EndToEnd;
import com.rscomponents.rscomponentsUI.models.SearchFilter;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    private  String RSSStockNumber;
    private List<String> filters =new ArrayList<>();
    private  String searchCountFromFilter;
    private List<SearchFilter> searchFilters;
    private List<EndToEnd> endToEnds;
    private  SearchFilter searchFilter;
    private EndToEnd endToEnd;

    public String getRSSStockNumber() {
        return RSSStockNumber;
    }


    public EndToEnd getEndToEnd() {
        return endToEnd;
    }

    public void setEndToEnd(EndToEnd endToEnd) {
        this.endToEnd = endToEnd;
    }

    public String getSearchCountFromFilter() {
        return searchCountFromFilter;
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public SearchFilter getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(SearchFilter searchFilter) {
        this.searchFilter = searchFilter;
    }

    public void addFilters(String filter){
        filters.add(filter);
    }

    public void setSearchCountFromFilter(String searchCountFromFilter) {
        this.searchCountFromFilter = searchCountFromFilter;
    }

    public void setSearchFilters(List<SearchFilter> searchFilters) {
        this.searchFilters = searchFilters;
    }

    public List<EndToEnd> getEndToEnds() {
        return endToEnds;
    }

    public void setEndToEnds(List<EndToEnd> endToEnds) {
        this.endToEnds = endToEnds;
    }

    public List<SearchFilter> getSearchFilters() {
        return searchFilters;
    }


    public void setRSSStockNumber(String RSSStockNumber) {
        this.RSSStockNumber = RSSStockNumber;
    }
}
