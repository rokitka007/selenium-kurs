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
    public void setup(){
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver" , "C:\\Users\\Daniel\\Desktop\\mmm\\selenium-kurs\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void checkDestinationPlaceHolder(){
        driver.get("https://booking.com");
        WebElement destinationInput = driver.findElement(By.className("sb-destination__input"));
        String placeHolder = destinationInput.getAttribute("placeholder");
        Assert.assertEquals(placeHolder, "Dokąd się wybierasz?");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }



}
