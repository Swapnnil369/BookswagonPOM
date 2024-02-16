package com.bookswagon.datadriven;

import com.bookswagon.base.TestBase;
import com.bookswagon.pages.LoginPage;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenTest extends TestBase {

    LoginPage loginPage;
    Logger log = Logger.getLogger(LoginPage.class);

    public DataDrivenTest() {
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


    @Test(dataProvider = "Excel")
    public void loginTest(String mobileNumber, String password) {
        loginPage.login(mobileNumber, password);
        log.info("Login successful with mobileNumber: " + mobileNumber);
    }

    @DataProvider(name = "Excel")
    public Object[][] testDataGenerator() throws IOException {
        FileInputStream file = new FileInputStream("D:\\CFP-251\\BooksWagonPOM\\TestData\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet loginSheet = workbook.getSheet("Sheet1");
        int numberOfData = loginSheet.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][2];

        for (int i = 0; i < numberOfData; i++) {
            XSSFRow row = loginSheet.getRow(i);
            XSSFCell mobileNumber = row.getCell(0);
            XSSFCell password = row.getCell(1);
            double mobile = mobileNumber.getNumericCellValue();
            String mobileNumberString = String.valueOf((long) mobile);
            String passwordValue = password.getStringCellValue();
            testData[i][0] = mobileNumberString;
            testData[i][1] = passwordValue;
        }
        return testData;
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}

