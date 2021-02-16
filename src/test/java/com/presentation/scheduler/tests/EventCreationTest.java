package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.Event;
import com.presentation.scheduler.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventCreationTest extends TestBase {
    @BeforeClass
    public void preconditions(){
        if(!app.getUserHelper().isIntoAccount()){
            app.getUserHelper().logIn(new User()
                    .withEmail("lena@telran.com")
                    .withPassword("123456Aa"));
        }
    }


    @Test
    public void testEventCreation() {
        app.event().initCreationNew();
        app.event().selectNextDay();
       app.event().fillCreationForm(new Event()
               .withTitle("new Event")
               .withType("meeting")
               .withBreaks(2)
               .withAmmount(50));
       app.event().confirmCreation();
//        app.event().getCount();


    }
}
