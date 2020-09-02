package com.company;

import java.io.File;
import java.util.Scanner;

class FileIO {

    String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        return sb.toString();
    }
}
