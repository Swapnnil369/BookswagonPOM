package com.bookswagon.pages;

import com.bookswagon.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddress extends TestBase {

    @FindBy(name = "ctl00$cpBody$txtNewRecipientName")
    WebElement reciptName;

    @FindBy(name = "ctl00$cpBody$txtNewAddress")
    WebElement address;

    @FindBy(name = "ctl00$cpBody$ddlNewCountry")
    WebElement country;

    @FindBy(name = "ctl00$cpBody$ddlNewState")
    WebElement state;

    @FindBy(name = "ctl00$cpBody$ddlNewCities")
    WebElement city;

    @FindBy(name = "ctl00$cpBody$txtNewPincode")
    WebElement pincode;

    @FindBy(name = "ctl00$cpBody$txtNewMobile")
    WebElement mobile;

    @FindBy(name = "ctl00$cpBody$chkUseAddress")
    WebElement sameAddress;

    @FindBy(name = "ctl00$cpBody$imgSaveNew")
    WebElement save;

    @FindBy(id = "ctl00_lnkbtnLogout")
    WebElement logout;

    @FindBy(name="ctl00$cpBody$ShoppingCart$lvCart$savecontinue")
    WebElement saveAndContinue;


    public ShippingAddress(WebDriver driver) {
        PageFactory.initElements(TestBase.driver, this);
    }

    public void addressDetail() throws InterruptedException {
        reciptName.click();

        reciptName.sendKeys("Swapnil Patil");
        address.sendKeys("Panvel");
        Select selec = new Select(country);
        selec.selectByValue("India");
        Select select = new Select(state);
        select.selectByValue("Maharashtra");
        Thread.sleep(2000);
        Select select1 = new Select(city);
        select1.selectByValue("Navi Mumbai Panvel");
        pincode.sendKeys("123456");
        mobile.sendKeys("9967891679");
        save.click();
        Thread.sleep(5000);
        saveAndContinue.click();
    }



}
