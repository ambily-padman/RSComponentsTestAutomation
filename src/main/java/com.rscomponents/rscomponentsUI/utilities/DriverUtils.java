package com.rscomponents.rscomponentsUI.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.TimeUnit;
import static com.rscomponents.rscomponentsUI.utilities.Log.info;

public class DriverUtils {

    @Autowired
    WebDriver driver;
    public void sendKeys(WebElement element, String text) {
        handleTheSurveypopUp(driver);
        element.sendKeys(text);
        info(" Entering the text: " + text + " in the textbox");
    }

    public String getInnerText(WebElement element){
        handleTheSurveypopUp(driver);
        String innerText=element.getAttribute("innerText");
        info("The inner Text is :"+innerText);
        return innerText;
    }

    public void click(WebDriver driver, WebElement element) {
        handleTheSurveypopUp(driver);
        if (isElementClickable(driver, element)) {
            element.click();
            info("Clicking of element : " + element);
        }
    }

    private void handleTheSurveypopUp(WebDriver driver) {
        info("Checking the feedback invite pop up presents...");
        if (isElementPresent(driver, By.id("acsMainInvite"))) {
            WebElement noThankButton = driver.findElement(By.xpath("//a[contains(@title,'No, thanks')]"));
            noThankButton.click();
            info("Clicking of element : " + noThankButton);
        }
    }


    public boolean isElementClickable(WebDriver driver, WebElement element) {
        boolean status = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            status = true;
        } catch (Exception e) {
            status = false;
        }
        info("Is the element " + element + "clickable? " + status);
        return status;
    }
    public void navigateToURL(WebDriver driver,String url)
    {
        driver.get(url);
        System.out.println("Navigated to URL:"+url);
    }
    public void quitBrowser(WebDriver driver)
    {
        driver.quit();
        driver=null;
    }

    public WebElement waitForElementByPolling(WebDriver driver,final By by)
    {
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(1,TimeUnit.SECONDS)
                .ignoring(java.util.NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementByPolling(WebDriver driver,WebElement webElement)
    {
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(1,TimeUnit.SECONDS)
                .ignoring(java.util.NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public boolean isElementPresent(WebDriver driver, By locator) {
        boolean status = false;
        try {
            driver.findElement(locator);
            status = true;
        } catch (NoSuchElementException e) {
            status = false;
        }
        info("Is the element Present ? " + status);
        return status;
    }
}
