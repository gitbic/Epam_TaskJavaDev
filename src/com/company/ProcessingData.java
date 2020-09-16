package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProcessingData {
    private ControlAction controlAction;
    private List<ControlAction> controlActionList = new ArrayList<>();
    private DataHandler<Exam> examHandler = new ExamHandler();
    private DataHandler<Test> testHandler = new TestHandler();
    private DataHandler<Requirements> requirementsHandler = new RequirementsHandler();

    void createCollectionControlAction(String allData) {
        allData = allData.replaceAll("\\s", "");

        // iterate for each control action
        for (String controlActionString : allData.split("[^^]ControlAction")) {
            controlAction = new ControlAction();

            // divide Control Action in to parts
            List<String> examStringList = getPartOfControlAction(controlActionString, "Exam");
            List<String> testStingList = getPartOfControlAction(controlActionString, "Test");
            List<String> requiredStringList = getPartOfControlAction(controlActionString, "Required");

            // collect exam results
            for (int i = 0; i < examStringList.size(); i++) {
                Exam exam = examHandler.getEventFromString(i + 1, examStringList.get(i));
                controlAction.addExamToList(exam);
                System.out.println(exam);
            }

            // collect test results
            for (int i = 0; i < testStingList.size(); i++) {
                Test test = testHandler.getEventFromString(i + 1, testStingList.get(i));
                controlAction.addTestToList(test);
                System.out.println(test);
            }

            // collect requirements
            Requirements requirements = requirementsHandler.getEventFromString(0, requiredStringList.get(0));
            controlAction.setRequirements(requirements);
            System.out.println(requirements);



            // count passed tests and score points
//            controlAction.setCurrentNumberPoints(countNumberOfPoints());
//            controlAction.setCurrentNumberTests(countPassedTests());

            // check whether the control action has passed
            boolean passedAllExam = controlAction.getCurrentNumberPoints() >= controlAction.getRequiredNumberPoints();
            boolean passedAllTests = controlAction.getCurrentNumberTests() >= controlAction.getRequiredNumberTests();
            controlAction.setEventPassed(passedAllExam && passedAllTests);

            controlActionList.add(controlAction);
        }
    }

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

    private List<String> getPartOfControlAction(String str, String substr) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(substr + "\\{(.*?)}");
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list;
    }
}
