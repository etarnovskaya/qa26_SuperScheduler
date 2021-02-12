package com.presentation.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchAppTest extends  TestBase{
    @Test
    public void launchTest(){
        System.out.println("app is runned");
        Assert.assertEquals(app.getAppVersion(), "0.0.3");
    }
}
