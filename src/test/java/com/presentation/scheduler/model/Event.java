package com.presentation.scheduler.model;

public class Event {
    String title;
    String type;

    int breaks;
    int ammount;
    String currency;

    public String getTitle() {
        return title;
    }

    public Event withTitle(String title) {
        this.title = title;
        return  this;

    }

    public String getType() {
        return type;
    }

    public Event withType(String type) {
        this.type = type;
        return  this;
    }

    public int getBreaks() {
        return breaks;
    }

    public Event withBreaks(int breaks) {
        this.breaks = breaks;
        return  this;
    }

    public int getAmmount() {
        return ammount;
    }

    public Event withAmmount(int ammount) {
        this.ammount = ammount;
        return  this;

    }

    public String getCurrency() {
        return currency;
    }

    public Event withCurrency(String currency) {
        this.currency = currency;
        return  this;
    }
}
