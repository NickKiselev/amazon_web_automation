package com.amazon.base.classes;

import com.amazon.browser.factory.DriverManager;
import com.amazon.browser.factory.DriverManagerFactory;
import com.amazon.testlistener.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
@Listeners({TestListener.class})
public class BaseTest {
    protected Logger logger;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browser, ITestContext ctx){
        logger = LogManager.getLogger(ctx.getCurrentXmlTest().getName());
        logger.info("Starting test with browser: " + browser);

        driver = DriverManagerFactory.getManager(browser).getDriver();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = ctx.getCurrentXmlTest().getName();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        this.testMethodName = method.getName();
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver(){
        logger.info("Driver closed...");
        DriverManager.closeDriver();
    }


}
