package com.rscomponents.rscomponentsUI.pages;

import com.rscomponents.configuration.TestConfiguration;
import com.rscomponents.rscomponentsUI.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


public  class MainPage {
    @Autowired
    DriverUtils driverUtils;

    @Autowired
    protected TestConfiguration testConfiguration;

    protected WebDriver driver;

    @FindBy(xpath = "//*[contains(@title, 'Log In')]")
    WebElement logInLink;

    @FindBy(id = "searchTerm")
    WebElement searchInput;

    @FindBy(id = "btnSearch")
    WebElement searchButon;

    @FindBy(xpath = "//a[@title='All Products']")
    WebElement allProductMenu;

    @FindBy(xpath = "//a[@title='Our Brands']")
    WebElement ourBrandsMenu;

    @FindBy(id = "js-basketQty")
    WebElement basketLink;

    @FindBy(id = "acsMainInvite")
    WebElement feedbackInviteForm;

    public MainPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickLoginLink() {
        logInLink.click();

    }

    public void enterTheTextAndSearch(String searchKey) {
        driverUtils.sendKeys(searchInput, searchKey);
        driverUtils.click(driver, searchButon);
    }

    public void clickAllProductMenu() {
        driverUtils.click(driver, allProductMenu);
    }

    public void selectTheProductType(String productType) {
        WebElement productTypeMenuItem = driver.findElement(By.linkText(productType));
        driverUtils.click(driver, productTypeMenuItem);
    }

    public void clickOnBasket() {
        driverUtils.click(driver, basketLink);
    }

    public void clickOurBrandMenu() {
        driverUtils.click(driver, ourBrandsMenu);
    }

    public void selectTheBrand(String brandName) {
        WebElement brandLink = driver.findElement(By.xpath("//a[@title='" + brandName + "']"));
        driverUtils.click(driver, brandLink);
    }
}
