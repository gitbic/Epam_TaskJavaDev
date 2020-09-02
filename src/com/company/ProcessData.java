package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessData {
    private ControlAction controlAction = new ControlAction();
    private List<ControlAction> controlActionList = new ArrayList<>();
    private Set<String> examSet = createExamSet();
    private Map<String, Float> examineMap;

    void processingInputData(String allData) {
        allData = allData.replaceAll("\r\n\t\t", " "); // useful format

        for (String str : allData.split(System.lineSeparator())) {
//            System.out.println(str);

            if (str.matches(".*\\[.*")) {
                controlAction = new ControlAction();
                controlAction.setNameControlAction(str.replaceAll("\\W", ""));

            } else if (str.matches(".*Exam.*")) {
                examineMap = new TreeMap<>();

                for (String key : examSet) {
                    float value = parseValue(str, key);
                    examineMap.put(key, value);
                }
                controlAction.addExamineToList(examineMap);

            } else if (str.matches(".*Required.*")) {
                controlAction.setRequiredNumberPoints(parseValue(str, "examPoints"));
                controlAction.setRequiredNumberTests(parseValue(str, "passedTests"));

            } else if (str.matches(".*Test.*")) {
                controlAction.addTestToList(str.matches(".*yes.*"));
            } else if (str.matches("\t\\}")) {
                controlActionList.add(controlAction);
            }
        }
    }

    private Float parseValue(String str, String substr) {
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

    private Set<String> createExamSet() {
        Set<String> set = new TreeSet<>();
        set.add("minValue");
        set.add("maxValue");
        set.add("stepValue");
        set.add("currentValue");
        return set;
    }

}
