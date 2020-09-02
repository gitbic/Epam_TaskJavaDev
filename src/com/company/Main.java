package com.company;

public class Main {

    public static void main(String[] args) {

        String fileName = args[0];
        String allData = new FileIO().readFile(fileName);

        ProcessData processData = new ProcessData();
        processData.processingInputData(allData);







    }
}

