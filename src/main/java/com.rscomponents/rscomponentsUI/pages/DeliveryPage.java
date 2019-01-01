package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryPage extends MainPage {
    public DeliveryPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isAt() {
        return driverUtils.isElementPresent(driver, By.xpath("//span[text()='Delivery']"));
    }
}
