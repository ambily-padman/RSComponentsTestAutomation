package com.rscomponents.rscomponentsUI.steps;

import com.rscomponents.configuration.TestConfiguration;
import com.rscomponents.rscomponentsUI.utilities.PageInitialization;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import static junit.framework.Assert.assertTrue;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;

public class LoginSteps {
    @Autowired
    private WebDriver driver;
    @Autowired
    private PageInitialization page;

    @Autowired
    private TestConfiguration testConfiguration;

    @Given("^I am navigated to in RS component web page$")
    public void I_am_navigated_to_in_RS_componant_web_page() {

        page.getHomePage().initialzeHome();
    }

    @And("^I log into the website$")
    public void I_log_into_the_website() {
        page.getMainPage().clickLoginLink();
        page.getAuthHomePage().logIntoWebSite(testConfiguration.getUserName(),testConfiguration.getPassword());
        info("Log into the web site\n");
    }

    @Then("^I am in the Rs componant home page$")
    public void I_am_in_the_Rs_componant_home_page() {
        boolean status = page.getHomePage().isAt();
        assertTrue("The Login Failed !!!", status);
        info("Is login Success? ");
    }


}