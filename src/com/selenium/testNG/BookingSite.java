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
    @FindBy(xpath = "//a[@data-ga-track='click|Product Expansion|cars|rentalcars (index)']")
    WebElement rentCarLink;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\rychu\\IdeaProjects\\selenium-kurs\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
        driver.get("https://www.booking.com/");
        PageFactory.initElements(driver, this);
    }

    @Test
    public void chceckDestinationPlaceholder() {
        String placeholder = destinationInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Where are you going?");
    }

    @Test
    public void findDestination() {
        destinationInput.sendKeys("Zakopane");
        searchButton.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("searchresult"));
    }

    @Test
    public void clickCarRentals() {
        rentCarLink.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("cars"));
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
