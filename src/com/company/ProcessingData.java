package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessingData {
    private ControlAction controlAction;
    private List<ControlAction> controlActionList = new ArrayList<>();
    private Set<String> examSet = createExamSet();
    private Map<String, Float> examMap;

//    private Examination<Boolean> test = new Test();
//    private Examination<Map<String, Float>> exam = new Exam();

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
            System.out.println("Контрольное мероприятие № " + (controlActionList.indexOf(action) + 1));
            System.out.println(action.toString());
            System.out.println();
        }
        System.out.println("==================================================");
    }

    void createCollectionControlAction(String allData) {
        allData = allData.replaceAll("\\s", "");

        // iterate for each control action
        for (String controlAction : allData.split("[^^]ControlAction")) {
            this.controlAction = new ControlAction();

            DataHandler examHandler = new ExamHandler(controlAction);
            examHandler.createEventList();



            DataHandler testHandler = new TestHandler(controlAction);
            testHandler.createEventList();
            testHandler.printEvents();






            List<String> requiredStringList = getPartOfEvent(controlAction, "Required");

            // read requirements
            this.controlAction.setRequiredNumberPoints(parseValue(requiredStringList.get(0), "examPoints"));
            this.controlAction.setRequiredNumberTests((int) parseValue(requiredStringList.get(0), "passedTests"));

//            // count passed tests and score points
//            this.controlAction.setCurrentNumberPoints(countNumberOfPoints());
//            this.controlAction.setCurrentNumberTests(countPassedTests());

            // check whether the control action has passed
            boolean passedAllExam = this.controlAction.getCurrentNumberPoints() >= this.controlAction.getRequiredNumberPoints();
            boolean passedAllTests = this.controlAction.getCurrentNumberTests() >= this.controlAction.getRequiredNumberTests();
            this.controlAction.setEventPassed(passedAllExam && passedAllTests);

            controlActionList.add(this.controlAction);
        }
    }

//    private float countNumberOfPoints() {
//        int numberPoints = 0;
////        for (Map<String, Float> exam : controlAction.getExamList()) {
//        for (Map<String, Float> exam : controlAction.getExamList()) {
//            numberPoints += exam.get("currentValue");
//        }
//        return numberPoints;
//    }
//
//    private int countPassedTests() {
//        int numberTests = 0;
//        for (Boolean testPass : controlAction.getTestList()) {
//            if (testPass) {
//                numberTests++;
//            }
//        }
//        return numberTests;
//    }

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
