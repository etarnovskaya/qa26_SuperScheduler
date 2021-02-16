package com.presentation.scheduler.fw;

import com.presentation.scheduler.model.Event;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
//
public class EventHelper extends HelperBase {
    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initCreationNew() {
        tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/fab_main']"));
        tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/fab_add_event']"));

    }

    public void fillCreationForm(Event event) {
type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']"), event.getTitle());
type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']"), event.getType());
driver.hideKeyboard();
int breaks = event.getBreaks();
if(breaks>0){
    for(int i =0; i<= breaks-1; i++){
      tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']"));
    }
}
tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']"));
type(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']"), String.valueOf(event.getAmmount()));
tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']"));
    }

    public void confirmCreation() {
        tap(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']"));
    }

    public void selectNextDay() {
        moveElementToLeft(
                By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/date_container_layout']"));
    }
}
