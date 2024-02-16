package com.bookswagon.testcases;

import com.bookswagon.base.TestBase;
import com.bookswagon.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupPageTest extends TestBase {
        SignUpPage signupPage;
        public SignupPageTest(){
            super();
        }
        @BeforeMethod
        public void setup(){
            initialization();
            signupPage=new SignUpPage();
        }
        @Test
        public void login(){
            signupPage.login();
        }

        @Test
        public void signupTest(){
            signupPage.SignUpPage(prop.getProperty("name"),prop.getProperty("mobile"),prop.getProperty("password"),prop.getProperty("confirmPassword"));
        }
}
