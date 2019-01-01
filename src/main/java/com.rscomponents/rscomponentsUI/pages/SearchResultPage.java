package com.rscomponents.rscomponentsUI.pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;

public class SearchResultPage extends MainPage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()[contains(.,'Viewing 1 -')]]")
    private WebElement totalResultCountDiv;

    @FindAll(@FindBy(how = How.XPATH, using = "//table[@id='results-table']/tbody/tr"))
    List<WebElement> searchResultTableRow;

    @FindAll(@FindBy(how = How.XPATH, using = "//ul[@class='pagination pull-left']/li"))
    List<WebElement> pageNavigationPageNumberLinks;

    @FindAll(@FindBy(how = How.XPATH, using = "//table[@id='results-table']/tbody/tr"))
    List<WebElement> resultRowPerPage;

    @FindBy(id = "rpp-button")
    WebElement resultPerPageButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='recordsPerPage pull-left']//ul[@class='dropdown-menu headerDropDown']/li"))
    List<WebElement> resultPerPageSelects;

    @FindBy(xpath = "//a[@title='Last']")
    WebElement lastResultPageSelect;

    public void selectTheCategory(String category) {

        WebElement resultCategory = driver.findElement(By.xpath("//img[contains(@alt,'" + category + "')]"));
        driverUtils.click(driver, resultCategory);
    }

    public Boolean isTheNumberOfResultDispalyedAreCorrect(String searchCountFromFilter) {
        String displayedSearchResultCount = StringUtils.substringBetween(driverUtils.getInnerText(totalResultCountDiv), "f", "p").replace(" ", "");
        info("The search Result Count from Filter :"+searchCountFromFilter);
        info("The search Result Count from Search Page :"+displayedSearchResultCount);
        return (searchCountFromFilter.equals(displayedSearchResultCount));

    }
}
