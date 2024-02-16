package com.bookswagon.testcases;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustumListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test start "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test success "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test fail "+result.getName());
    }
}
