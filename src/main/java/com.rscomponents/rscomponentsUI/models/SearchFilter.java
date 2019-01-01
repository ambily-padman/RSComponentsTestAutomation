package com.rscomponents.rscomponentsUI.models;

public class SearchFilter {
    String scenario;
    String mainProductType;
    String Catagory;
    String SubCatagory;
    String FilterType1;
    String Filter1;
    String FilterType2;
    String FIlter2;

    public SearchFilter(String scenario, String mainProductType,
                        String catagory, String subCatagory, String filterType1,
                        String filter1, String filterType2, String FIlter2) {
        this.scenario = scenario;
        this.mainProductType = mainProductType;
        Catagory = catagory;
        SubCatagory = subCatagory;
        FilterType1 = filterType1;
        Filter1 = filter1;
        FilterType2 = filterType2;
        this.FIlter2 = FIlter2;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getMainProductType() {
        return mainProductType;
    }

    public void setMainProductType(String mainProductType) {
        this.mainProductType = mainProductType;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public String getSubCatagory() {
        return SubCatagory;
    }

    public void setSubCatagory(String subCatagory) {
        SubCatagory = subCatagory;
    }

    public String getFilterType1() {
        return FilterType1;
    }

    public void setFilterType1(String filterType1) {
        FilterType1 = filterType1;
    }

    public String getFilter1() {
        return Filter1;
    }

    public void setFilter1(String filter1) {
        Filter1 = filter1;
    }

    public String getFilterType2() {
        return FilterType2;
    }

    public void setFilterType2(String filterType2) {
        FilterType2 = filterType2;
    }

    public String getFIlter2() {
        return FIlter2;
    }

    public void setFIlter2(String FIlter2) {
        this.FIlter2 = FIlter2;
    }
}