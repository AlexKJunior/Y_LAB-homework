package io.ylab.intensive.lesson05;

import messagefilter.DataProcessor;

import java.io.*;

public class FileUtil {
    public static void main(String[] args) {
        transfer("filter.txt", "fileFilter.txt");
    }

    public static void transfer(String fromFile, String toFile) {
        try (BufferedReader fromReader = new BufferedReader(new FileReader(fromFile));
             BufferedWriter toWriter = new BufferedWriter(new FileWriter(toFile))) {
            String line = null;
            while ((line = fromReader.readLine()) != null) {
                String[] arr = line.split(", |,");
                for (String word : arr) {
                    toWriter.write(word);
                    toWriter.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}