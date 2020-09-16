package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class DataHandler<T> {

    private String eventKeyword;
    private String controlActionString;
    private List<T> eventList = new ArrayList<>();

    DataHandler(String controlActionString) {
        this.controlActionString = controlActionString;
    }

    void printEvents() {
        eventList.forEach(System.out::println);
    }

    void setKeywordFind(String keywordFind) {
        this.eventKeyword = keywordFind;
    }

    List<T> getEventList() {
        return eventList;
    }

    void addEventToList(T event) {
        eventList.add(event);
    }

    List<String> createEventStringList() {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(eventKeyword + "\\{(.*?)}");
        Matcher m = p.matcher(controlActionString);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    float parseValue(String str, String substr) {
        String result = "";
        Pattern p = Pattern.compile(substr + "\\s?=\\s?(\\d+\\.?\\d?)");
        Matcher m = p.matcher(str);
        if (m.find()) {
            result = m.group(1);
        } else {
            System.out.println("Error: incorrect input.");
            System.exit(0);
        }
        return Float.parseFloat(result);
    }

    abstract void createEventList();
}
