package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingHome {

    WebDriver driver;

    @FindBy(className = "sb-destination__input")
    WebElement destinationInput;

    @FindBy(className = "sb-searchbox__button")
    WebElement searchButton;

    public BookingHome(WebDriver driver) {
        this.driver = driver;
        driver.get("https://booking.com");
        PageFactory.initElements(driver, this);
    }

    public void searchDestination(String destination) {
        destinationInput.sendKeys(destination);
        searchButton.click();
    }

    public String getSiteTitle() {
        return this.driver.getTitle();
    }
}