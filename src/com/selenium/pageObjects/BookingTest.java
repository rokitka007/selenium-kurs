package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BookingTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Basia\\Desktop\\liveTesting BDD\\selenium-kurs\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void checkHotelView(){
        BookingHome home = new BookingHome(driver);
        Assert.assertEquals(home.getSiteTitle(), "Booking.com | Oficjalna strona | Najlepsze hotele i nie tylko");
        String destination = "Urowo";
        String hotel = "Domek u Mira";
        home.searchDestination(String.format("%s %s",destination, hotel));
        BookingResult results = new BookingResult(driver);

        Assert.assertTrue(results.checkHeader(destination));
        Assert.assertEquals(results.getCoronavirusInfo(), "Koronawirus (COVID-19) - wsparcie");
        results.enterHotelLink(hotel);
    }



    @AfterTest
    public void cleanUp(){
        driver.quit();
    }
}
