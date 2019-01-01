package com.rscomponents.rscomponentsUI.steps;

import com.rscomponents.rscomponentsUI.models.TestDataType;
import com.rscomponents.rscomponentsUI.utilities.PageInitialization;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;
import static org.junit.Assert.assertTrue;

public class EndToEndTestSteps {

    @Autowired
    private PageInitialization page;

    @Given("^I click the All Product  menu$")
    public void I_click_the_All_Product_menu() {
        info("Selecting 'All Product Menu'\n");
        page.getMainPage().clickAllProductMenu();
    }

    @And("^I select The Product Type from the menu$")
    public void I_select_The_Product_Type_from_the_menu() {
        info("Selecting the product type\n");
        setTestDataForEndToEndTest("CheckOut From Product");
        page.getMainPage().selectTheProductType(page.getTestData().getEndToEnd().getProductType());
    }

    private void setTestDataForEndToEndTest(String keyword) {
        page.getTestData().setEndToEnds(page.getGenericHelper().readTestDataFromCSV(TestDataType.END_TO_END));
        page.getTestData().setEndToEnd(page.getEndToEndHelper().getTheEndToEndTestData(page.getTestData().getEndToEnds(), keyword));
    }


    @When("^I add the Item to cart$")
    public void I_add_the_Item_to_cart() {
        info("Adding the item to cart\n");
      page.getSubCategoryPage().addToCartTheItem(page.getTestData().getEndToEnd().getItem());
    }

    @And("^click on the basket$")
    public void click_on_the_basket() {
        info("Opening the shopping basket\n");
       page.getMainPage().clickOnBasket();
    }

    @And("^check out securely$")
    public void check_out_securely() {
        info("Checking Out....\n");
      page.getMyBasketPage().checkOutSecurely();
    }

    @Then("^I can see the delivery information page$")
    public void I_can_see_the_delivery_information_page() {
        boolean status = page.getDeliveryPage().isAt();
        assertTrue("Not in delivery Page!!", status);
        info("Is in delivery info page ? " + status + "\n");
    }

    @Given("^I Click the  Our Brands Menu$")
    public void I_Click_the_Our_Brands_Menu() {
        info("Selecting 'Our Brands' menu\n");
        page.getMainPage().clickOurBrandMenu();
    }

    @And("^I select the Brand from the menu list$")
    public void I_select_the_Brand_from_the_menu_list() {
        setTestDataForEndToEndTest("Checkout From Brands");
        info("Selecting the brand name : " + page.getTestData().getEndToEnd().getBrand() + "\n");
        page.getMainPage().selectTheBrand(page.getTestData().getEndToEnd().getBrand());
    }

    @And("^I Select the Category from the brand page$")
    public void I_Select_the_Category_from_the_brand_page() {
        info("Seleting the product category of the brand :" + page.getTestData().getEndToEnd().getCatagory());
        page.getBrandPage().selectTheProductCategoryOfBrand(page.getTestData().getEndToEnd().getCatagory());
    }

    @And("^I click the given category On the Product type page$")
    public void iClickTheGivenCategoryOnTheProductTypePage() {
        info("Selecting the Category\n");
        page.getProductTypePage().clickOnTheGivenCategory(page.getTestData().getEndToEnd().getCatagory());
    }

    @And("^I Click the given Sub Category On the Product type page$")
    public void iClickTheGivenSubCategoryOnTheProductTypePage() {
        info("Selecting sub category\n");
        page.getProductTypePage().clickOnTheGivenCategory(page.getTestData().getEndToEnd().getSubCatagory());
    }

}
