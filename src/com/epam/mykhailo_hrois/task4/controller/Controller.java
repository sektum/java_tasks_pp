package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.commands.AddTargetCommand;
import com.epam.mykhailo_hrois.task4.commands.CommandList;
import com.epam.mykhailo_hrois.task4.commands.ExceptionCommand;
import com.epam.mykhailo_hrois.task4.commands.NoCommand;
import com.epam.mykhailo_hrois.task4.shop.Basket;

public class Controller {
    private boolean session;
    private boolean settingGood;
    private int enterId = -1;
    private String exception;
    private Basket basket = new Basket();

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String executeCommand(String commandName) {
        try {
            if(isSettingGood()){
                this.setEnterId(Integer.valueOf(commandName) - 1);
                return CommandList.getCommandList().get(AddTargetCommand.NAME).execute(this);
            }
            else {
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
}
