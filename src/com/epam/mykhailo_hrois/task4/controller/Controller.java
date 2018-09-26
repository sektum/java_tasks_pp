package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.commands.*;
import com.epam.mykhailo_hrois.task4.shop.Basket;
import com.epam.mykhailo_hrois.task4.shop.Orders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    private boolean session;
    private boolean settingGood;
    private boolean nearest;
    private boolean ordering;
    private boolean between;
    private Long enteredDate;
    private Long enteredSecondDate;
    private int enterId = -1;
    private String value;
    private Basket basket = new Basket();
    private Orders orders = new Orders();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String executeCommand(String commandName) {
        try {
            setValue(commandName);
            if (isSettingGood()) {
                return CommandList.getCommandList().get(AddTargetCommand.NAME).execute(this);
            }
            if (isNearest()) {
                return CommandList.getCommandList().get(AddDateCommand.NAME).execute(this);
            }
            if (isOrdering()) {
                return CommandList.getCommandList().get(OrderGoodsCommand.NAME).execute(this);
            }
            if (isBetween()) {
                if (getEnteredDate() == null) {
                    return CommandList.getCommandList().get(BetweenSetFirstCommand.NAME).execute(this);
                }
                return CommandList.getCommandList().get(BetweenSetSecondCommand.NAME).execute(this);

            } else {
                return CommandList.getCommandList().get(AssociativeMap.getMap().get(commandName)).execute(this);
            }
        } catch (NullPointerException e) {
            return CommandList.getCommandList().get(NoCommand.NAME).execute(this);
        } catch (Exception e) {
            return CommandList.getCommandList().get(ExceptionCommand.NAME).execute(this);
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public int getEnterId() {
        return enterId;
    }

    public void setEnterId(int enterId) {
        this.enterId = enterId;
    }

    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

    public boolean isSettingGood() {
        return settingGood;
    }

    public void setSettingGood(boolean settingGood) {
        this.settingGood = settingGood;
    }

    public boolean isNearest() {
        return nearest;
    }

    public void setNearest(boolean nearest) {
        this.nearest = nearest;
    }

    public Orders getOrders() {
        return orders;
    }

    public Long getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(String enteredDate) {
        if (enteredDate != null) {
            this.enteredDate = convertDate(enteredDate);
        } else {
            this.enteredDate = null;
        }
    }

    private Long convertDate(String enteredDate) {
        String exp = "^([0-9]{4})-([0-1][0-9])-([0-3][0-9]);([0-1][0-9]|[2][0-3]):([0-5][0-9]):([0-5][0-9])$";
        if (enteredDate.matches(exp)) {
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd;HH:mm:ss");
            try {
                Date date = simpleDate.parse(enteredDate);
                return date.getTime();
            } catch (ParseException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isBetween() {
        return between;
    }

    public void setBetween(boolean between) {
        this.between = between;
    }

    public Long getEnteredSecondDate() {
        return enteredSecondDate;
    }

    public void setEnteredSecondDate(String enteredSecondDate) {
        this.enteredSecondDate = convertDate(enteredSecondDate);
    }

    public boolean isOrdering() {
        return ordering;
    }

    public void setOrdering(boolean ordering) {
        this.ordering = ordering;
    }
}
