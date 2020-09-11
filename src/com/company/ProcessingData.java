package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessingData {
    private ControlAction controlAction;
    private List<ControlAction> controlActionList = new ArrayList<>();
    private Set<String> examSet = createExamSet();
    private Map<String, Float> examMap;

    void reorderCollection() {
        Deque<ControlAction> controlActionDeque = new ArrayDeque<>();
        for (ControlAction controlAction : controlActionList) {
            if (controlAction.isEventPassed()) {
                controlActionDeque.offerFirst(controlAction);
            } else {
                controlActionDeque.offerLast(controlAction);
            }
        }
        controlActionList = new ArrayList<>(controlActionDeque);
    }

    void writeCollectionToConsole() {
        System.out.println("==================================================");

        for (ControlAction action : controlActionList) {
            System.out.println("����������� ����������� � " + (controlActionList.indexOf(action) + 1));
            System.out.println(action.toString());
            System.out.println();
        }
        System.out.println("==================================================");
    }

    void createCollectionControlAction(String allData) {
        allData = allData.replaceAll("\\s", "");

        // iterate for each control action
        for (String event : allData.split("[^^]Event")) {
            controlAction = new ControlAction();

            // divide event in to parts
            List<String> examList = getPartOfEvent(event, "Exam");
            List<String> testList = getPartOfEvent(event, "Test");
            List<String> requiredList = getPartOfEvent(event, "Required");

            // collect exam results
            for (String exam : examList) {
                examMap = new HashMap<>();

                for (String key : examSet) {
                    float value = parseValue(exam, key);
                    examMap.put(key, value);
                }
                controlAction.addExamToList(examMap);
            }

            // collect test results and count the passed tests
            for (String test : testList) {
                controlAction.addTestToList(test.matches(".*yes.*"));
            }

            // read requirements
            controlAction.setRequiredNumberPoints(parseValue(requiredList.get(0), "examPoints"));
            controlAction.setRequiredNumberTests((int) parseValue(requiredList.get(0), "passedTests"));

            // count passed tests and score points
            controlAction.setCurrentNumberPoints(countNumberOfPoints());
            controlAction.setCurrentNumberTests(countPassedTests());

            // check whether the control action has passed
            boolean passedAllExam = controlAction.getCurrentNumberPoints() >= controlAction.getRequiredNumberPoints();
            boolean passedAllTests = controlAction.getCurrentNumberTests() >= controlAction.getRequiredNumberTests();
            controlAction.setEventPassed(passedAllExam && passedAllTests);

            controlActionList.add(controlAction);
        }
    }

    private float countNumberOfPoints() {
        int numberPoints = 0;
        for (Map<String, Float> exam : controlAction.getExamList()) {
            numberPoints += exam.get("currentValue");
        }
        return numberPoints;
    }

    private int countPassedTests() {
        int numberTests = 0;
        for (Boolean testPass : controlAction.getTestList()) {
            if (testPass) {
                numberTests++;
            }
        }
        return numberTests;
    }

    private List<String> getPartOfEvent(String str, String substr) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(substr + "\\{(.*?)}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }

    private float parseValue(String str, String substr) {
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
        Set<String> set = new HashSet<>();
        set.add("minValue");
        set.add("maxValue");
        set.add("stepValue");
        set.add("currentValue");
        return set;
    }
}
