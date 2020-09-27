package com.selenium.podstawy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hej selenium");

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Łukasz\\Desktop\\BDDsda\\selenium-kurs\\resources\\geckodriver.exe");
        // Uruchomienie silnika przeglądarki
        WebDriver driver = new FirefoxDriver();

        // Wejście na stronę (URL)
        driver.get("https://booking.com");

        //Informacje o stronie
        System.out.println(driver.getTitle());

        //Deklaracja elementu strony
        WebElement element;
        element = driver.findElement(By.className("sb-destination__input"));
        System.out.println(element.getAttribute("placeholder"));

        //Wyjście z przeglądarki
        driver.quit();
    }
}
