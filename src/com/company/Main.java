package com.company;

public class Main {

    public static void main(String[] args) {

        String fileName = args[0];
        String allData = new FileIO().readFile(fileName);

        ProcessingControlAction processingControlAction = new ProcessingControlAction();
        processingControlAction.createCollectionControlAction(allData);
        processingControlAction.writeCollectionToConsole();
        processingControlAction.reorderCollection();
        processingControlAction.writeCollectionToConsole();
    }
}

