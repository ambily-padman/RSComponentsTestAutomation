package com.rscomponents.rscomponentsUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    public class MyBasketPage extends MainPage {

        public MyBasketPage(WebDriver driver)
        {
            super(driver);
        }

        @FindBy(id = "checkoutSecurelyAndPuchBtn")
        WebElement checkOutButton;

        public void checkOutSecurely() {
            driverUtils.click(driver, checkOutButton);
        }

    }
