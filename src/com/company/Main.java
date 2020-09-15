package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String fileName = args[0];
        String allData = new FileIO().readFile(fileName);


        ProcessingData processingData = new ProcessingData();
        processingData.createCollectionControlAction(allData);
//        processingData.writeCollectionToConsole();
//        processingData.reorderCollection();
//        processingData.writeCollectionToConsole();


    }
}

