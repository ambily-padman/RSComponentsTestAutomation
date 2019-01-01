package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends MainPage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

public void initialzeHome(){

        driverUtils.navigateToURL(driver,testConfiguration.getUrl());

}

    public boolean isAt() {
        return driverUtils.isElementPresent(driver, By.xpath("//*[contains(@title, 'Log Out')]"));
    }
}
