package com.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingSite {

    WebDriver driver;

    @FindBy(className = "sb-destination__input")
    WebElement destinationInput;

    @FindBy(className = "sb-searchbox__button")
    WebElement searchButton;

    @BeforeTest
    public void setup() {
//        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver", "C:\\mahnamahna\\selenium-kurs\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://booking.com");

        PageFactory.initElements(driver, this);
    }

    @AfterTest
    public void cleaner() {
        driver.quit();
    }

    @Test
    public void checkDestinationPlaceholder() {
        String placeholder = destinationInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Where are you going?");
    }

    @Test
    public void findDestination() throws Exception {
        destinationInput.sendKeys("Zakopane");
        searchButton.click();
        driver.findElement(By.id("basiclayout"));
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("searchresults"));
    }



}


