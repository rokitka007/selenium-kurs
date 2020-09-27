package com.selenium.pageObject;

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
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Łukasz\\Desktop\\BDDsda\\selenium-kurs\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void checkHotelView(){
        BookingHome home = new BookingHome(driver);
        Assert.assertEquals(home.getSiteTitle(),"Booking.com | Oficjalna strona | Najlepsze hotele i nie tylko");
        String destination = "Urowo";
        String hotel = "Domek u Mira";
        home.searchDestination(String.format("%s %s", destination,hotel));
        BookingResult result = new BookingResult(driver);


        Assert.assertTrue(result.checkHeader(destination));
        Assert.assertEquals(result.getCoronavirusInfo(),"Koronawirus (COVID-19) – wsparcie");
        result.enterHotelLink(hotel);
    }


    @AfterTest
    public void cleanUp(){
        driver.quit();
    }
}
