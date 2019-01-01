package com.rscomponents.rscomponentsUI.models;

public class EndToEnd {
    String Scenario;
    String ProductType;
    String Brand;
    String Catagory;
    String SubCatagory;
    String Item;

    public EndToEnd(String scenario, String productType, String brand,
                    String catagory, String subCatagory, String item) {
        Scenario = scenario;
        ProductType = productType;
        Brand = brand;
        Catagory = catagory;
        SubCatagory = subCatagory;
        Item = item;
    }

    public String getScenario() {
        return Scenario;
    }

    public void setScenario(String scenario) {
        Scenario = scenario;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
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

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }
}
