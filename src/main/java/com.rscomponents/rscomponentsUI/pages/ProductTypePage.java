package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductTypePage extends MainPage {

    public ProductTypePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickOnTheGivenCategory(String productCategory) {
        WebElement categoryElement = driver.findElement(By.xpath("//h2[@title='" + productCategory + "']"));
        driverUtils.click(driver, categoryElement);
    }
}
