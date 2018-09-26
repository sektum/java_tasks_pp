package com.epam.mykhailo_hrois.task4.view;

import com.epam.mykhailo_hrois.task4.controller.Controller;

import java.util.Scanner;

public class EnterPoint {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        System.out.println(controller.executeCommand("start set 1 3"));
        while (controller.isSession()) {
            String result = scanner.nextLine();
            System.out.println(controller.executeCommand(result));
        }
    }
}
