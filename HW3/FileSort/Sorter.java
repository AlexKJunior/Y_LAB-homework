package HW3.FileSort;

import java.io.*;
import java.util.*;

public class Sorter {
    private static final int SIZE = 10000;

    public File sortFile(File dataFile) throws IOException {
        File outputFile = new File("HW3/FileSort/newfile.txt");
        List<File> dataFileList = new ArrayList<>();
        try (Scanner scanner = new Scanner(dataFile)) {
            int i = 0;
            while (scanner.hasNextInt()) {
                dataFileList.add(sortChunk(scanner, i));
                i++;
            }
        }

        mergeChunksFile(dataFileList, outputFile);
        return outputFile;
    }

    private static File sortChunk(Scanner scanner, int chunkNumber) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt() && numbers.size() < SIZE) {
            numbers.add(scanner.nextInt());
        }
        Collections.sort(numbers);

        File chunkFile = new File("HW3/FileSort/chunk" + chunkNumber + ".txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(chunkFile))) {
            for (int i : numbers) {
                writer.println(i);
            }
        }
        return chunkFile;
    }

    private static void mergeChunksFile(List<File> dataFileList, File outputFile) throws IOException {
        PriorityQueue<Scanner> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.nextInt()));
        for (File chunk : dataFileList) {
            pq.add(new Scanner(chunk));
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            while (!pq.isEmpty()) {
                Scanner scanner = pq.poll();
                writer.println(scanner.nextInt());
                if (scanner.hasNextInt()) {
                    pq.add(scanner);
                } else {
                    scanner.close();
                }
            }
        }
    }
}