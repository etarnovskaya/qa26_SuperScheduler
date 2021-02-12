package com.presentation.scheduler.tests;


import com.presentation.scheduler.fw.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws IOException {
        app.start();
    }

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m) {
        logger.info("Stop test " + m.getName() + "\n************************************************");
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
