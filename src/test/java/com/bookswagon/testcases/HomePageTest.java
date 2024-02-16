package com.bookswagon.testcases;

import com.bookswagon.base.TestBase;
import com.bookswagon.pages.HomePage;
import com.bookswagon.pages.LoginPage;
import com.bookswagon.pages.ShippingAddress;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ShippingAddress shippingAddress;


    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();

    }

    @Test(priority = 1)
    public void searchBookTest() throws InterruptedException {
        loginPage.login(prop.getProperty("mobile"),prop.getProperty("password"));
        Thread.sleep(4000);
        homePage.searchBook();
    }

    @Test(priority = 2)
    public void addToCartTest() throws InterruptedException {

         searchBookTest();
        Thread.sleep(4000);
         homePage.addToCart();
    }

    @Test
    public void viewAddCartItemTest() throws InterruptedException {
        addToCartTest();
        Thread.sleep(4000);
        homePage.viewAddCartItem();
    }

    @Test
    public void buyBook() throws InterruptedException {
        viewAddCartItemTest();
        Thread.sleep(4000);
        homePage.buyBook();
    }

    @Test
    public void shippingAddress() throws InterruptedException {
       shippingAddress = new ShippingAddress(driver);
        buyBook();
        Thread.sleep(5000);
        shippingAddress.addressDetail();

    }







}
