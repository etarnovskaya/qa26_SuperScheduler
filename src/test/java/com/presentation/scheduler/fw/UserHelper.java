package com.presentation.scheduler.fw;

import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends  HelperBase{
    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void logIn(User user)  {
       type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']"), user.getEmail());
       type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']"), user.getPassword());

       driver.hideKeyboard();

       click(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']"));


    }

    public void skipSettings(){
        String skipButton = "//*[@resource-id='com.example.svetlana.scheduler:id/wizard_settings_skip_container']";
        if(isElementPresent(By.xpath(skipButton))){
            click(By.xpath(skipButton));
        }
    }

    public boolean isLoggedIn() {
        String plusBtn = "//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']";
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(plusBtn)));
        return isElementPresent(By.xpath(plusBtn));
    }
}
