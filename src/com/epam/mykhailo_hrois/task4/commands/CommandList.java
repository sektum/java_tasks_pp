package com.epam.mykhailo_hrois.task4.commands;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandList {
    private static LinkedHashMap<String, Command> commandList = new LinkedHashMap<>();

    static {
        feelCommands();
    }

    public static Map<String, Command> getCommandList() {
        return commandList;
    }

    private static void feelCommands() {
        commandList.put(DisplayGoodsCommand.NAME, new DisplayGoodsCommand());
        commandList.put(PrintBasketCommand.NAME, new PrintBasketCommand());
        commandList.put(AddToBasketCommand.NAME, new AddToBasketCommand());
        commandList.put(FiveLastGoodsCommand.NAME, new FiveLastGoodsCommand());
        commandList.put(BuyAllFromBasketCommand.NAME, new BuyAllFromBasketCommand());
        commandList.put(ExceptionCommand.NAME, new ExceptionCommand());
        commandList.put(StartCommand.NAME, new StartCommand());
        commandList.put(NoCommand.NAME, new NoCommand());
        commandList.put(PrintCommand.NAME, new PrintCommand());
        commandList.put(SetGoodCommand.NAME, new SetGoodCommand());
        commandList.put(NearestOrderCommand.NAME, new NearestOrderCommand());
        commandList.put(OrderOnDateCommand.NAME, new OrderOnDateCommand());
        commandList.put(BetweenDatesCommand.NAME, new BetweenDatesCommand());
        commandList.put(ExitCommand.NAME, new ExitCommand());
    }
}
