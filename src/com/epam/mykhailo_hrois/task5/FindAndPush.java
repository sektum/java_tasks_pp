package com.epam.mykhailo_hrois.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindAndPush extends Thread {
    private List<Integer> listOfLengths;
    private int currentFirst;
    private int currentSecond;

    public FindAndPush() {
        super("FindThread");
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            synchronized (Holder.class) {
                try {
                    while (Holder.isFileWasReadCompletely()) {
                        Holder.class.wait();
                    }
                    readFile(Holder.pathName);
                    findAndPush();
                } catch (InterruptedException e) {
                    System.out.println("2nd interrupted");
                    interrupt();
                }
            }
        }
    }

    private void readFile(String pathName) {
        listOfLengths = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();
            while (line != null) {
                listOfLengths.add(line.getBytes().length);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findAndPush() throws InterruptedException {
        for (int i = 0; i < listOfLengths.size() - 1; i++) {
            currentFirst += listOfLengths.get(i);
            currentSecond = currentFirst;
            for (int j = i + 1; j < listOfLengths.size(); j++) {
                currentSecond += listOfLengths.get(j);
                if (listOfLengths.get(i).equals(listOfLengths.get(j))) {
                    LengthWithIndexes e = new LengthWithIndexes(listOfLengths.get(i), currentFirst, currentSecond);
                    synchronized (Holder.class) {
                        while (!Holder.isValueWasAlreadyRead()) {
                            Holder.class.wait();
                        }
                        Holder.put(e);
                        Holder.setValueWasAlreadyRead(false);
                        Holder.class.notify();
                        Holder.class.wait();
                    }
                    break;
                }
            }
        }
        Holder.setFileWasReadCompletely(true);
        clear();
        synchronized (Holder.class) {
            Holder.class.notify();
        }
    }

    private void clear() {
        this.currentFirst = 0;
        this.currentSecond = 0;
        this.listOfLengths.clear();
    }
}
