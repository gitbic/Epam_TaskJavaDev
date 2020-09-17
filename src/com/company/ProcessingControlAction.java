package com.company;

import java.util.*;

class ProcessingControlAction {
    private ControlAction controlAction;
    private List<ControlAction> controlActionList = new ArrayList<>();

    void createCollectionControlAction(String allData) {
        allData = allData.replaceAll("\\s", "");

        // iterate for each control action
        int n = 1;
        for (String controlActionString : allData.split("[^^]ControlAction")) {
            controlAction = new ControlAction();
            controlAction.setControlActionNumber(n);

            // collect exam
            DataHandler<Exam> examHandler = new ExamHandler(controlActionString);
            examHandler.createEventList();
            controlAction.setExamList(examHandler.getEventList());

            // collect test
            DataHandler<Test> testHandler = new TestHandler(controlActionString);
            testHandler.createEventList();
            controlAction.setTestList(testHandler.getEventList());

            // collect requirements
            DataHandler<RequiredResult> requirementsHandler = new RequirementsHandler(controlActionString);
            requirementsHandler.createEventList();
            controlAction.setRequiredResult(requirementsHandler.getEventList().get(0));

            // count passed tests and score points
            ResultExamination currentResult = new CurrentResult();
            currentResult.setNumberPoints(countNumberPoints());
            currentResult.setNumberTests(countPassedTests());
            controlAction.setCurrentResult(currentResult);

            // check whether the control action has passed
            controlAction.setControlActionPassed(checkIsControlActionPassed());

            controlActionList.add(controlAction);
            n++;
        }
    }

    void reorderCollection() {
        Deque<ControlAction> controlActionDeque = new ArrayDeque<>();
        for (ControlAction controlAction : controlActionList) {
            if (controlAction.isControlActionPassed()) {
                controlActionDeque.offerFirst(controlAction);
            } else {
                controlActionDeque.offerLast(controlAction);
            }
        }
        controlActionList = new ArrayList<>(controlActionDeque);
    }

    void writeCollectionToConsole() {
        System.out.println("==================================================");
        controlActionList.forEach(System.out::println);
        System.out.println("==================================================");
    }

    private float countNumberPoints() {
        int numberPoints = 0;
        for (Exam exam : controlAction.getExamList()) {
            numberPoints += exam.getExamMap().get("currentValue");
        }
        return numberPoints;
    }

    private int countPassedTests() {
        int numberTests = 0;
        for (Test test : controlAction.getTestList()) {
            if (test.isTestPassed()) {
                numberTests++;
            }
        }
        return numberTests;
    }

    private boolean checkIsControlActionPassed() {
        ResultExamination requiredResult = controlAction.getRequiredResult();
        ResultExamination currentResult = controlAction.getCurrentResult();
        boolean passedAllExam = currentResult.getNumberPoints() >= requiredResult.getNumberPoints();
        boolean passedAllTests = currentResult.getNumberTests() >= requiredResult.getNumberTests();
        return passedAllExam && passedAllTests;
    }
}
