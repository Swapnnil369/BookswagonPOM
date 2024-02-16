package com.bookswagon.pages;

import com.bookswagon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(id="inputbar")
    WebElement searchBar;

    @FindBy(id="btnTopSearch")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id='listSearchResult']/div[1]/div[4]/div[5]/input[1]")
    WebElement buyNow;

    @FindBy(id="ctl00_lblTotalCartItems")
    WebElement cart;

    @FindBy(id="ctl00_phBody_BookCart_lvCart_ctrl0_btnMovetoWishlist")
    WebElement wishList;

    @FindBy(xpath="//a[text()='Your Wishlist']")
    WebElement viewWishList;

    @FindBy(id="ctl00_phBody_BookCart_lvCart_imgPayment")
    WebElement buy;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public void searchBook(){
        searchBar.sendKeys(prop.getProperty("book"));
        searchBtn.click();
    }

    public void addToCart(){
       buyNow.click();
    }

    public void viewAddCartItem(){
        cart.click();
    }

    public ShippingAddress buyBook(){
        buy.click();
        return new ShippingAddress(driver);
    }
}
