package com.amazon.base.classes;

import com.amazon.testlistener.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
@Listeners({TestListener.class})
public class AbstractTest {
    protected Logger logger;
    protected WebDriver driver;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser, ITestContext ctx, Method method){
        logger = LogManager.getLogger(ctx.getCurrentXmlTest().getName());
        logger.info("Starting test with browser: " + browser);

        driver = BrowserDriverFactory.getDriverInstance(browser);
        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = ctx.getCurrentXmlTest().getName();
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        logger.info("Driver closed...");
        BrowserDriverFactory.closeDriver();
    }


}
