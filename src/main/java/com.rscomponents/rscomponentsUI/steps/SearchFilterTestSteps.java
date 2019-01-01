package com.rscomponents.rscomponentsUI.steps;

import com.rscomponents.rscomponentsUI.models.TestDataType;
import com.rscomponents.rscomponentsUI.utilities.PageInitialization;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;
import static junit.framework.TestCase.assertTrue;

public class SearchFilterTestSteps {

    @Autowired
    private PageInitialization page;


    @Given("^I enter the RS Stock Number in the search box$")
    public void iEnterTheRSStockNumberInTheSearchBox()  {
        setTestDataAndSearch("Direct Search");

    }

    @Given("^I enter the Main Product Type in the search box$")
    public void I_enter_the_MainProductType_in_the_search_box() {
        setTestDataAndSearch("Single Filter");
    }

    @Given("^I enter the keyword in the search box for multifilter$")
    public void iEnterTheKeywordInTheSearchBoxForMultifilter()  {
        setTestDataAndSearch("Multi Filter");
    }

    private void setTestDataAndSearch(String keyword) {
        page.getTestData().setSearchFilters(page.getGenericHelper().readTestDataFromCSV(TestDataType.SEARCH_FILTER));
        page.getTestData().setSearchFilter(page.getSearchFilterHelper().getTheSearchData(page.getTestData().getSearchFilters(), keyword));
        page.getHomePage().enterTheTextAndSearch(page.getTestData().getSearchFilter().getMainProductType());
        info("Search  the product with the keyword " + page.getTestData().getSearchFilter().getMainProductType() + "\n");
    }


    @Then("^I can see the product is listed in the product page$")
    public void I_can_see_the_product_is_listed_in_the_product_page() {
        boolean status = page.getProductPage().isRsStockNumberOfProductMatches(page.getTestData().getSearchFilter().getMainProductType());
        assertTrue("The product is not displayed in the product page!!", status);
        info("Is the product displayed? " + status);
    }

    @And("^I Click on Category On the Product type page$")
    public void I_Click_on_Category_On_the_Product_type_page() {
        info("Selecting the Category\n");
        page.getProductTypePage().clickOnTheGivenCategory(page.getTestData().getSearchFilter().getCatagory());
    }


    @And("^I click on Category On the SearchResultPage$")
    public void iClickOnCategoryOnTheSearchResultPage() {
       info("Selecting the Category");
       page.getSearchResultPage().selectTheCategory(page.getTestData().getSearchFilter().getCatagory());
    }

    @And("^I Click on Sub Category On the sub category page$")
    public void iClickOnSubCategoryOnTheSubCategoryPage()  {
      info("Selecting sub category\n");
      page.getProductTypePage().clickOnTheGivenCategory(page.getTestData().getSearchFilter().getSubCatagory());
    }

    @When("^I Select the Filter Type1 on the sub category page$")
    public void I_Select_the_Filter_Type_on_the_sub_category_page() {
        info("Selecting the filter Type\n");
        page.getSubCategoryPage().clickFilter(page.getTestData().getSearchFilter().getFilterType1());
    }

    @When("^I Select Filter Type2 on the sub category page$")
    public void iSelectFilterTypeOnTheSubCategoryPage() {
        info("Selecting the filter Type\n");
        page.getSubCategoryPage().clickFilter(page.getTestData().getSearchFilter().getFilterType2());
    }


    @And("^I select Filter1$")
    public void I_select_the_Filter_and_apply() {
        info("Selecting the filter\n");
       String filter1=page.getTestData().getSearchFilter().getFilter1();
        page.getTestData().setSearchCountFromFilter(page.getSubCategoryPage().applyFilter(filter1));
        page.getTestData().addFilters(filter1);

    }
    @And("^I select  Filter2$")
    public void iSelectFilterFilter()  {
        info("Selecting the filter\n");
        String filter2=page.getTestData().getSearchFilter().getFIlter2();
        page.getTestData().setSearchCountFromFilter(page.getSubCategoryPage().applyFilter(filter2));
        page.getTestData().addFilters(filter2);
    }


    @And("^I apply the filter$")
    public void iApplyTheFilter() {
        page.getSubCategoryPage().clickApply();
    }


    @Then("^I can see the filter applied and number of result displayed are correct$")
    public void iCanSeeTheFilterAppliedAndNumberOfResultDisplayedAreCorrect() {

        Boolean status = page.getSearchResultPage().isTheNumberOfResultDispalyedAreCorrect(   page.getTestData().getSearchCountFromFilter());
        info("Is the search result count matches? "+ status +"\n");
        boolean status1 = page.getSubCategoryPage().isFiltersApplied(   page.getTestData().getFilters());
        boolean isFilterAppliedAndCountMatches= status && status;
        assertTrue("The filters are not applied!!", isFilterAppliedAndCountMatches);
        info("Are the filters applied? " + isFilterAppliedAndCountMatches  + "\n");
    }


    @Then("^I can see the correct products are listed$")
    public void iCanSeeTheCorrectProductsAreListed()  {
        boolean status = page.getSubCategoryPage().isFiltersApplied(   page.getTestData().getFilters());
        assertTrue("The filters are not applied!!", status);
        info("Are the filters applied? " + status + "\n");
    }


}
