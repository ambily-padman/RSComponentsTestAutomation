package com.rscomponents.rscomponentsUI.utilities;

import com.rscomponents.rscomponentsUI.helpers.EndToEndHelper;
import com.rscomponents.rscomponentsUI.helpers.GenericHelper;
import com.rscomponents.rscomponentsUI.helpers.SearchFilterHelper;
import com.rscomponents.rscomponentsUI.pages.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PageInitialization {

    @Autowired
    private EndToEndHelper endToEndHelper;

    @Autowired
    private  GenericHelper genericHelper;

    @Autowired
    private MainPage mainPage;
    @Autowired
    private HomePage homePage;
    @Autowired
    private AuthHomePage authHomePage;
    @Autowired
    private TestData testData;

    @Autowired
    private ProductPage productPage;

    @Autowired
    private ProductTypePage productTypePage;

    @Autowired
    private SubCategoryPage subCategoryPage;

    @Autowired
    private SearchResultPage searchResultPage;

    @Autowired
    private  MyBasketPage myBasketPage;

    @Autowired
    private  DeliveryPage deliveryPage;

    @Autowired
    private BrandPage brandPage;


    @Autowired
    private SearchFilterHelper searchFilterHelper;

    public GenericHelper getGenericHelper() {
        return genericHelper;
    }

    public void setGenericHelper(GenericHelper genericHelper) {
        this.genericHelper = genericHelper;
    }

    public SearchFilterHelper getSearchFilterHelper() {
        return searchFilterHelper;
    }

    public void setSearchFilterHelper(SearchFilterHelper searchFilterHelper) {
        this.searchFilterHelper = searchFilterHelper;
    }

    public EndToEndHelper getEndToEndHelper() {
        return endToEndHelper;
    }

    public void setEndToEndHelper(EndToEndHelper endToEndHelper) {
        this.endToEndHelper = endToEndHelper;
    }

    public TestData getTestData() {
        return testData;
    }

    public void setTestData(TestData testData) {
        this.testData = testData;
    }

    public ProductPage getProductPage() {
        return productPage;
    }

    public void setProductPage(ProductPage productPage) {
        this.productPage = productPage;
    }

    public ProductTypePage getProductTypePage() {
        return productTypePage;
    }

    public void setProductTypePage(ProductTypePage productTypePage) {
        this.productTypePage = productTypePage;
    }

    public SubCategoryPage getSubCategoryPage() {
        return subCategoryPage;
    }

    public void setSubCategoryPage(SubCategoryPage subCategoryPage) {
        this.subCategoryPage = subCategoryPage;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }

    public void setSearchResultPage(SearchResultPage searchResultPage) {
        this.searchResultPage = searchResultPage;
    }

    public MyBasketPage getMyBasketPage() {
        return myBasketPage;
    }

    public void setMyBasketPage(MyBasketPage myBasketPage) {
        this.myBasketPage = myBasketPage;
    }

    public DeliveryPage getDeliveryPage() {
        return deliveryPage;
    }

    public void setDeliveryPage(DeliveryPage deliveryPage) {
        this.deliveryPage = deliveryPage;
    }

    public BrandPage getBrandPage() {
        return brandPage;
    }

    public void setBrandPage(BrandPage brandPage) {
        this.brandPage = brandPage;
    }

    public AuthHomePage getAuthHomePage() {
        return authHomePage;
    }

    public void setAuthHomePage(AuthHomePage authHomePage) {
        this.authHomePage = authHomePage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
}
