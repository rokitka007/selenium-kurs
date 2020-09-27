package com.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingSite {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver",
                "D:\\KURS Tester Autom\\20 Selenium\\projektSelenium\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkDestinationPlaceholder() {
        driver.get("https://booking.com");
        WebElement destinationInput = driver.findElement(By.className("sb-destination__input"));
        String placeholder = destinationInput.getAttribute("placeholder");
        Assert.assertEquals(placeholder, "Dokąd się wybierasz?");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}