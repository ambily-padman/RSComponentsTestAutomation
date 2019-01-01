package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandPage extends MainPage {

    public BrandPage(WebDriver driver)
    {
        super(driver);
    }


    public void selectTheProductCategoryOfBrand(String category) {
        WebElement categoryLink = driver.findElement(By.xpath("//a[contains(@title, '" + category + "')]"));
        driverUtils.click(driver, categoryLink);
    }
}
