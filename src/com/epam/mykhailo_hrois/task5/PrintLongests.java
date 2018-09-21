package com.epam.mykhailo_hrois.task5;

import java.util.Scanner;

public class PrintLongests extends Thread {
    private Scanner scanner = new Scanner(System.in);
    private Integer maxLength;
    private Integer first;
    private Integer second;

    public PrintLongests() {
        super("PrintLongests");
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                if (Holder.isFileWasReadCompletely()) {
                    System.out.println("In this file max repetitive string was - " + maxLength + ". First index - " + first + ", second - " + second);
                    clear();
                    readPathName();
                } else {
                    synchronized (Holder.class) {
                        while (Holder.isValueWasAlreadyRead()) {
                            Holder.class.wait();
                        }
                        printValue();
                        Holder.setValueWasAlreadyRead(true);
                        Holder.class.notify();
                        Holder.class.wait();
                    }
                }


            } catch (InterruptedException e) {
                System.out.println("1st interrupted");
                interrupt();
            }
        }
        System.out.println("dosvidos");
    }

    private void readPathName() throws InterruptedException {
        synchronized (Holder.class) {
            Holder.pathName = scanner.next();
            if (Holder.pathName.equals("stop")) {
                throw new InterruptedException();
            }
            Holder.setFileWasReadCompletely(false);
            Holder.class.notifyAll();
        }
    }

    private void clear() {
        this.maxLength = 0;
        this.first = 0;
        this.second = 0;
    }

    private void printValue() {
        LengthWithIndexes current = Holder.get();
        if (current.getLength() > maxLength) {
            maxLength = current.getLength();
            first = current.getFirstIndex();
            second = current.getSecondIndex();
            System.out.println(current.getLength());
        }
    }
}
