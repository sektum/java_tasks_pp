package com.epam.mykhailo_hrois.task5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindAndPush extends Thread {
    private List<Integer> listOfLengths;
    private int currentFirst;
    private int currentSecond;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            synchronized (Holder.class) {
                try {
                    Holder.class.wait();
                    readFile(Holder.pathName);
                    findAndPush();
                    Holder.pathName = "";
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
                    Holder.queue.put(new LengthWithIndexes(listOfLengths.get(i), currentFirst, currentSecond));
                    break;
                }
            }
        }
    }
}
