package com.presentation.scheduler.fw;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HelperBase {
    AppiumDriver driver;;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void typeByCss(String cssSelector, String text) {
        if(text!=null){
            clickByCss(cssSelector);
            driver.findElement(By.cssSelector(cssSelector)).clear();
            driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
        }

    }

    public void clickByCss(String cssSelector) {
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!=null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void clickYallaButton() {
        tap(By.cssSelector("[type='submit']"));
    }

    public String getPageUrl(){
        return
                driver.getCurrentUrl();
    }

   public void takeScreenshot(String pathToFile){
       File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       File screenshot = new
               File(pathToFile);

       try {
           Files.copy(tmp, screenshot);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void moveElementToLeft(By locator){
       TouchAction action = new TouchAction(driver);

       Dimension size = driver.manage().window().getSize();

       int leftPoint = (int) (size.width*0.2);
       int middlePoint = (int) (size.width*0.5);

       WebElement element = driver.findElement(locator);

       int leftX = (int) (element.getLocation().getX()*0.2);
       int rightX = (int) ((leftX + element.getSize().getWidth()) * 0.8);
       int upperY = element.getLocation().getY();
       int lowerY = upperY + element.getSize().getHeight();
       int middleY = (upperY + lowerY) / 2;

       action
               .longPress(PointOption.point(rightX, middlePoint))
               .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
               .moveTo(PointOption.point(leftPoint,middleY)).release().perform();



   }
}
