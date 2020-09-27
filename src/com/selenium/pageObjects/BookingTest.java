package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\kpopiela\\IdeaProjects\\selenium-kurs2\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkHotelView(){
        BookingHome home = new BookingHome(driver);
        Assert.assertEquals(home.getSiteTitle(), "Booking.com | Official site | The best hotels & accommodations");
        String destination = "Urowo";
        String hotel = "Domek u Mira";
        //home.searchDestination(destination + " " + hotel);
        home.searchDestination(String.format("%s %s", destination, hotel));
        BookingResult results = new BookingResult(driver);

        Assert.assertTrue(results.checkHeader(destination));
        Assert.assertEquals(results.getCoronavirusInfo(), "Coronavirus (COVID-19) support");
        results.enterHotelLink(hotel);
    }

    @AfterTest
    public void cleanUp(){
    //    driver.quit();
    }
}
