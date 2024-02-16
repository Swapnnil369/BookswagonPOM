package com.bookswagon.pages;

import com.bookswagon.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {
        @FindBy(name="ctl00$phBody$SignUp$txtName")
        WebElement name;
        @FindBy(name="ctl00$phBody$SignUp$txtEmail")
        WebElement mobile;

        @FindBy(name="ctl00$phBody$SignUp$btnContinue")
        WebElement continueBtn;
        @FindBy(name="ctl00$phBody$SignUp$txtPassword")
        WebElement password;

        @FindBy(name="ctl00$phBody$SignUp$txtConfirmPwd")
        WebElement confirmPassword;

        @FindBy(id="ctl00_phBody_SignUp_btnSubmit")
        WebElement signUp;
        @FindBy(xpath = "//a[@class='btn btn-block  themebackground text-white loginlink']")
        WebElement login;
        public SignUpPage(){
            PageFactory.initElements(driver,this);
        }
        public LoginPage login(){
            login.click();
            return new LoginPage();

        }

        public void SignUpPage(String name1,String mobile1,String password1,String confirmPassword1 ){
            name.sendKeys(name1);
            mobile.sendKeys(mobile1);
            continueBtn.click();
            password.sendKeys(password1);
            confirmPassword.sendKeys(confirmPassword1);
            signUp.click();

    }
}
