package com.epam.mykhailo_hrois.task4.view;

import com.epam.mykhailo_hrois.task4.controller.Controller;

import java.util.Scanner;

public class EnterPoint {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        System.out.println(controller.executeCommand("start"));
        while (scanner.hasNext()) {
            String result = scanner.next();
            if (result.equals("exit")) {
                System.out.println("Have a good day!");
                break;
            }
            if (result.equals("set")) {
                System.out.println("Please, enter ID of good you want to work with ->");
                String enterId = scanner.next();
                controller.setEnterId(Integer.valueOf(enterId) - 1);
            }
            System.out.println(controller.executeCommand(result));
        }
    }
}
