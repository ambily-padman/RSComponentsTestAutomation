package com.rscomponents.rscomponentsUI.utilities;

import com.rscomponents.configuration.SystemConfiguration;
import com.rscomponents.rscomponentsUI.helpers.EndToEndHelper;
import com.rscomponents.rscomponentsUI.helpers.SearchFilterHelper;
import com.rscomponents.rscomponentsUI.helpers.GenericHelper;
import com.rscomponents.rscomponentsUI.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Configuration
@ComponentScan("com.rscomponents.rscomponentsUI")
public class SpringBeanProcessor {
    File framework_folder;
    private static WebDriver driver;

    @Autowired
    private SystemConfiguration systemConfiguration;

    @Bean
    @Scope("cucumber-glue")
    public EndToEndHelper endToEndHelper() {
        return new EndToEndHelper();
    }

    @Bean
    @Scope("cucumber-glue")
    public GenericHelper generichelper() {
        return new GenericHelper();
    }

    @Bean
    @Scope("cucumber-glue")
    public SearchFilterHelper searchFilterHelper() {
        return new SearchFilterHelper();
    }
    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriver() {
        framework_folder = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile().getParentFile();
        switch (systemConfiguration.getSelectedBrowser()) {
            case "chrome":
                return getLocalChromeDriver();
            default:
                return getLocalFirefoxDriver();
        }


        // return a driver with desired capabilities
    }

    @Bean
    @Scope("cucumber-glue")
    public DriverUtils driverUtils() {
        return new DriverUtils();
    }

    @Bean
    @Scope("cucumber-glue")
    public TestData testData() {
        return new TestData();
    }

    @Bean
    @Scope("cucumber-glue")
    public HomePage homePage() {
        return new HomePage(driver);
    }


    @Bean
    @Scope("cucumber-glue")
    public PageInitialization pageInitialization() {
        return new PageInitialization();
    }

    @Bean
    @Scope("cucumber-glue")
    public MainPage mainPage() {
        return new MainPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public AuthHomePage authHomePage() {
        return new AuthHomePage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public ProductPage productPage() {
        return new ProductPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public ProductTypePage productTypePage() {
        return new ProductTypePage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public SubCategoryPage subCategoryPage() {
        return new SubCategoryPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public SearchResultPage searchResultPage() {
        return new SearchResultPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public MyBasketPage myBasketPage() {
        return new MyBasketPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public DeliveryPage deliveryPage() {
        return new DeliveryPage(driver);
    }

    @Bean
    @Scope("cucumber-glue")
    public BrandPage brandPage() {
        return new BrandPage(driver);
    }


    private WebDriver getLocalFirefoxDriver() {

        System.setProperty("webdriver.gecko.driver", framework_folder + "/" + systemConfiguration.getBrowserFolder() + "/geckodriver.exe");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.tabs.remote.force-enable", true);
        profile.setPreference("accessibility.force_disabled", 1);
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(Level.OFF);
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver getLocalChromeDriver() {
        System.out.println("Chrome SpringBeanProcessor initialized");
        System.setProperty("webdriver.chrome.driver", framework_folder + "/" + systemConfiguration.getBrowserFolder() + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("useAutomationExtension", false);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("http.proxyHost", "107.15.42.4");
        System.setProperty("http.proxyPort", "8080");
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;
    }
}