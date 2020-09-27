package com.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingResult {
    WebDriver driver;

    @FindBy(className = "sr_header")
    WebElement header;

    @FindBy(className = "js-coronavirus-banner")
    WebElement coronavirusInfo;

    @FindBy(className = "hotel_name_link")
    WebElement hotelLinks;


    public BookingResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean checkHeader(String destination) {
        return header.getText().contains(destination);
    }

    public String getCoronavirusInfo() {
        return coronavirusInfo.getText();
    }

    public void enterHotelLink(String hotelname) {
        WebElement element = hotelLinks.findElement(By.xpath(String.format("//*[contains(text(), %s)]", hotelname)));
        element.click();
    }
}
