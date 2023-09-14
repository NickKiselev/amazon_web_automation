package com.amazon.testlistener;

import com.amazon.base.classes.BrowserDriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
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
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("ALL " + testName + " FINISHED");
    }

    private void makeScreenshot(){
        File screenCapture = ((TakesScreenshot) BrowserDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }


}
