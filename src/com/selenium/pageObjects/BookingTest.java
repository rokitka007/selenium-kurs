package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.setProperty("webdriver.gecko.driver",
                "D:\\KURS Tester Autom\\20 Selenium\\projektSelenium\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    @Test
    public void checkHotelView() {
        BookingHome home = new BookingHome(driver);
        //pod F12 w Console wklejamy takie coś:
        //$x('//title')[0].text
        Assert.assertEquals(home.getSiteTitle(), "Booking.com | Oficjalna strona | Najlepsze hotele i nie tylko");
        String destination = "Urowo";
        String hotel = "Domek u Mira";
        home.searchDestination(String.format("%s %s", destination, hotel));
        //lub
        //home.searchDestination(destination + " " + hotel);
        BookingResult results = new BookingResult(driver);

        Assert.assertTrue(results.checkHeader(destination));
        Assert.assertEquals(results.getCoronavirusInfo(), "Coronavirus (COVID-19) support");
        //results.hotelLinks;
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
