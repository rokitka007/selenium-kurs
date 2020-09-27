package com.selenium.pageObject;

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
    WebElement hotelLink;

    public BookingResult(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public Boolean checkHeader(String destination){
        if(header.getText().contains(destination)) {
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    public String getCoronavirusInfo(){
        return coronavirusInfo.getText();
    }

    public void enterHotelLink(String hotelName){
        WebElement hotel = hotelLink.findElement(By.xpath("//*[contains(text()," + hotelName + ")]"));
        System.out.println(hotel.getText());
        //WebElement hotel = hotelLink.findElement(By.xpath(String.format("//*[contains(text(), %s)]", hotelName)));
        hotel.click();
    }



}
