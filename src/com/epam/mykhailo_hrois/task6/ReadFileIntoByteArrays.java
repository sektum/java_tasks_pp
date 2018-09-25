package com.epam.mykhailo_hrois.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileIntoByteArrays {
    private static List<byte[]> listOfLengths;

    public static List<byte[]> readFile(String pathName) {
        listOfLengths = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();
            while (line != null) {
                listOfLengths.add(line.getBytes());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLengths;
    }
}
