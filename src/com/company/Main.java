package com.company;

public class Main {

    public static void main(String[] args) {

        String fileName = args[0];
        String allData = new FileIO().readFile(fileName);

        ProcessingData processingData = new ProcessingData();
        processingData.createCollectionControlAction(allData);







    }
}

