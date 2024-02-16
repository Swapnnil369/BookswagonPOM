package com.bookswagon.testcases;

import com.bookswagon.base.TestBase;
import com.bookswagon.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
@Listeners(CustumListener.class)
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    Logger log=Logger.getLogger(LoginPage.class);

    public LoginPageTest() {

        super();


    }

    @BeforeMethod
    public void setup() {
        log.info("Start execution");
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPage();
        Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }

    @Test
    public void booksWagonLogoTest() {
        Boolean flag = loginPage.validateBookWagonLogo();
        Assert.assertTrue(flag);
        log.info("logo test successful");
    }

    @Test
    public void loginTest() {
//        loginPage.login(prop.getProperty("mobile"), prop.getProperty("password"));
//        log.info("login successful");
        Assert.assertTrue(false);

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
