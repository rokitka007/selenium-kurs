package com.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingSite {
// Atrybuty klasy (driver, destinationInput)
    WebDriver driver;

    @FindBy(className = "sb-destination__input")
    WebElement destinationInput;

    @FindBy(className = "sb-searchbox__button")
    WebElement searchButton;

    @FindBy(xpath = "//a[@data-ga-track='click|Product Expansion|cars|rentalcars (index)']")
    WebElement rentCarLink;

    @BeforeTest
    public void setup(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\kpopiela\\IdeaProjects\\selenium-kurs2\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://booking.com");

        //Inicjalizujemy wszystkie elementy strony opisane w atrybutach klasy
        PageFactory.initElements(driver, this);
    }

    @Test
    public void checkDestinationPlaceholder(){
        //WebElement destinationInput = driver.findElement(By.className("sb_destination__input"));
        String placeholder = destinationInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Where are you going?");
    }

    @Test
    public void findDestination() {
        destinationInput.sendKeys("Zakopane");
        searchButton.click();
        driver.findElement(By.id("basiclayout"));
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("searchresult"));
    }

    @Test
    public void goToRentalCars(){
        rentCarLink.click();
        String newUrl = driver.getCurrentUrl();
        Assert.assertTrue(newUrl.contains("cars"));
    }


    @AfterTest
    public void cleanUp(){
        driver.quit();
    }
}
