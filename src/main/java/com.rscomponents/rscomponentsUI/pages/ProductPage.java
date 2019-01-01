package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MainPage {

    public ProductPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='RS Stock No.']//following-sibling::span")
    WebElement rsStockNumberValueSpan;

    public boolean isRsStockNumberOfProductMatches(String currentRSStockNumber) {
        return rsStockNumberValueSpan.getAttribute("innerText").equals(currentRSStockNumber);
    }
}
