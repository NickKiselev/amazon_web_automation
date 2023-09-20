package com.amazon.testlistener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ScreenshotMaker implements ITestListener {
    private String testMethodName;
    private String testName;
    private Logger logger;

    public void onTestStart(ITestResult result) {
        this.logger =  LogManager.getLogger(testName);
        this.testMethodName = result.getMethod().getMethodName();
        logger.info("Starting " + testMethodName);
    }

    @Override
    public void onStart(ITestContext context) {
        this.testName = context.getCurrentXmlTest().getName();
        this.logger =  LogManager.getLogger(testName);
        logger.info("SUITE " + testName + " STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test " + testMethodName + " passed");
        makeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("ALL " + testName + " FINISHED");
    }




}
