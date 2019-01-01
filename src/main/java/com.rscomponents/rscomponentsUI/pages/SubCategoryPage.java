package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;

public class SubCategoryPage extends MainPage {

    @FindBy(xpath = "//button[text()='Apply filters']")
    WebElement applyFilterButton;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickFilter(String filterType) {
        WebElement filterTypeLink = driver.findElement(By.xpath("//a[text()='" + filterType + "']"));
        driverUtils.click(driver, filterTypeLink);
    }

    public String applyFilter(String filter) {
        String filteredResultCount= getSearchResultCountFromFilter(filter);
        WebElement filterCheckBox = driver.findElement(By.xpath("//span[text()='" + filter + "']"));
        driverUtils.click(driver, filterCheckBox);
        return filteredResultCount;
    }

    public void clickApply() {
        driverUtils.waitForElementByPolling(driver,applyFilterButton);
        driverUtils.click(driver, applyFilterButton);

    }

    public boolean isFiltersApplied(List<String> filters) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isFilterApplied = false;
        Boolean status=false;
        for(String filter:filters){
            status= (driverUtils.isElementPresent(driver, By.xpath("//div[text()='" + filter + "']")));
            info("Is the filter ' "+filter+" ' Applied? "+status);
            if(!status){
                isFilterApplied=false;
               // break;
            }
        }
        boolean isTheAppliedFilterMessageShown=driverUtils.isElementPresent(driver, By.xpath("//a[text()='Applied filters']"));
        info("Is the applied filter msg shown? "+isTheAppliedFilterMessageShown);
        return (isTheAppliedFilterMessageShown&& isFilterApplied );
    }

    public void addToCartTheItem(String itemName) {
        WebElement rsStockNumberLink = driver.findElement(By.xpath("//a[text()='" + itemName + "']/parent::div/following-sibling::div[@class='row']/a"));
        String rsStockNumber = rsStockNumberLink.getAttribute("innerText");
        WebElement addButton = driver.findElement(By.xpath("//button[contains(@data-rsstocknumber, '" + rsStockNumber + "')]"));
        driverUtils.click(driver, addButton);

    }

    public String getSearchResultCountFromFilter(String filter) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement filterCheckBoxSearchCount = driver.findElement(By.xpath("//span[text()='" + filter + "']/span"));

        return driverUtils.getInnerText(filterCheckBoxSearchCount).replaceAll("[^\\d.]", "");
    }
}
