package com.epam.mykhailo_hrois.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndPush extends Thread {
    private File file;
    private Scanner scanner;
    private List<Integer> listOfLengths;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            synchronized (Holder.class) {
                try {
                    Holder.class.wait();
                    readFile(Holder.pathName);
                    findAndPush();
                    Holder.pathName = "";
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
        }
    }

    private void readFile(String pathName) throws FileNotFoundException {
        file = new File(pathName);
        scanner = new Scanner(file);
        listOfLengths = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            listOfLengths.add(line.toCharArray().length);
        }
    }

    private void findAndPush() {
        for (int i = 0; i < listOfLengths.size() - 1; i++) {
            for (int j = i + 1; j < listOfLengths.size(); j++) {
                if (listOfLengths.get(i).equals(listOfLengths.get(j))) {
                    System.out.println("puted");
                    Holder.length = listOfLengths.get(i);
                    Holder.firstIndex = i;
                    Holder.secondIndex = j;
                    break;
                }
            }
        }
    }
}
