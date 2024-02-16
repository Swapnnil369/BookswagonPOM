package com.bookswagon.pages;

import com.bookswagon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

        //Page Object Repository

        @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
        WebElement username;

        @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
        WebElement password;

        @FindBy(xpath = "//a[@onclick='return ValidateLoginPassword();']")
        WebElement loginBtn;

        @FindBy(xpath = "//img[@class='logonew']")
        WebElement booksWagonLogo;

        //Initializing Page Object
        public LoginPage() {

            PageFactory.initElements(driver, this);
        }

        public String validateLoginPage() {
            return driver.getTitle();
        }

        public Boolean validateBookWagonLogo() {
            return booksWagonLogo.isDisplayed();
        }

        public HomePage login(String un, String pass) {
            username.sendKeys(un);
            password.sendKeys(pass);
            loginBtn.click();
            return new HomePage();
    }

}
