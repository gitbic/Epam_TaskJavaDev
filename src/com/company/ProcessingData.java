package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessingData {
    private ControlAction controlAction;
    private List<ControlAction> controlActionList = new ArrayList<>();
    private Set<String> examSet = createExamSet();
    private Map<String, Float> examineMap;

    void createCollectionControlAction(String allData) {
        allData = allData.replaceAll("\\s", "");

        for (String event : allData.split("[^^]Event")) {
            controlAction = new ControlAction();

            List<String> examList = getPartOfEvent(event, "Exam");
            List<String> testList = getPartOfEvent(event, "Test");
            List<String> requiredList = getPartOfEvent(event, "Required");

            for (String exam : examList) {
                examineMap = new TreeMap<>();
                for (String key : examSet) {
                    float value = parseValue(exam, key);
                    examineMap.put(key, value);
                }
                controlAction.addExamToList(examineMap);
            }

            for (String test : testList) {
                controlAction.addTestToList(test.matches(".*yes.*"));
            }

            controlAction.setRequiredNumberPoints(parseValue(requiredList.get(0), "examPoints"));
            controlAction.setRequiredNumberTests(parseValue(requiredList.get(0), "passedTests"));

            controlActionList.add(controlAction);
        }
    }

    private List<String> getPartOfEvent(String str, String substr) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(substr + "\\{(.*?)\\}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
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
