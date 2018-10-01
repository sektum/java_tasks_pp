package com.epam.mykhailo_hrois.task4.controller;

import com.epam.mykhailo_hrois.task4.commands.CommandList;
import com.epam.mykhailo_hrois.task4.commands.ExceptionCommand;
import com.epam.mykhailo_hrois.task4.commands.NoCommand;
import com.epam.mykhailo_hrois.task4.shop.Basket;
import com.epam.mykhailo_hrois.task4.shop.Orders;

public class Controller {
    private boolean session;
    private Basket basket = new Basket();
    private Orders orders = new Orders();

    public String executeCommand(String input) {
        String[] strings = input.split(" ");
        String commandName = strings[0];
        try {
            return CommandList.getCommandList().get(AssociativeMap.getMap().get(commandName)).execute(this, strings);
        } catch (NullPointerException e) {
            return CommandList.getCommandList().get(NoCommand.NAME).execute(this, strings);
        } catch (Exception e) {
            return CommandList.getCommandList().get(ExceptionCommand.NAME).execute(this, strings);
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

    public Orders getOrders() {
        return orders;
    }

}
