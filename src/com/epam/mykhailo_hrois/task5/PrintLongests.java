package com.epam.mykhailo_hrois.task5;

import java.util.Scanner;

public class PrintLongests extends Thread {
    private Scanner scanner = new Scanner(System.in);
    private Integer maxLength = 0;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                if (Holder.pathName.isEmpty()) {
                    System.out.println("In this file max repetitive string was - " + maxLength + ". firstIndex: " + Holder.firstIndex + " secondIndex: " + Holder.secondIndex);
                    readPathName();
                }
                if (Holder.length != -1) {
                    System.out.println(Holder.length);
                    if (Holder.length > maxLength) {
                        maxLength = Holder.length;
                    }
                    Holder.length = -1;
                }
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    private void readPathName() throws InterruptedException {
        synchronized (Holder.class) {
            Holder.pathName = scanner.next();
            Holder.class.notifyAll();
            if (Holder.pathName.equals("stop")) {
                throw new InterruptedException();
            }
        }
    }
}
