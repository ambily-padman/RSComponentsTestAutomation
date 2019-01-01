package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthHomePage extends MainPage {

    public AuthHomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@name='j_password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='loginBtn']")
    WebElement logInButton;


    public void logIntoWebSite(String userName, String password) {
        driverUtils.sendKeys(userNameInput, userName);
        driverUtils.sendKeys(passwordInput, password);
        driverUtils.click(driver, logInButton);
    }


}
