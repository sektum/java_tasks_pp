package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.commands.CommandList;
import com.epam.mykhailo_hrois.task4.commands.ExceptionCommand;
import com.epam.mykhailo_hrois.task4.commands.NoCommand;
import com.epam.mykhailo_hrois.task4.entities.Goods;
import com.epam.mykhailo_hrois.task4.shop.Basket;

public class Controller {
    private Goods good;
    private int enterId;
    private String exception;
    private AssociativeMap map = new AssociativeMap();
    private CommandList commandList = new CommandList();
    private Basket basket = new Basket();

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String executeCommand(String commandName) {
        try {
            return CommandList.getCommandList().get(AssociativeMap.getMap().get(commandName)).execute(this);
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
}
