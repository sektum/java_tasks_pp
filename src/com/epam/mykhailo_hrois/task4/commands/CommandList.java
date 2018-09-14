package com.epam.mykhailo_hrois.task4.commands;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandList {
    private static LinkedHashMap commandList = new LinkedHashMap();

    public CommandList() {
        feelCommands();
    }

    public static Map<String, Command> getCommandList() {
        return commandList;
    }

    private void feelCommands() {
        commandList.put(DisplayGoodsCommand.NAME, new NoCommand());
        commandList.put(PrintBasketCommand.NAME, new NoCommand());
        commandList.put(AddToBasketCommand.NAME, new NoCommand());
        commandList.put(FiveLastGoodsCommand.NAME, new NoCommand());
        commandList.put(BuyAllFromBasketCommand.NAME, new NoCommand());
        commandList.put(ExceptionCommand.NAME, new NoCommand());
        commandList.put(StartCommand.NAME, new StartCommand());
        commandList.put(NoCommand.NAME, new NoCommand());
    }
}
