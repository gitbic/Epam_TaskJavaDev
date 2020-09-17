package com.company;

import java.util.ArrayList;
import java.util.List;

class ControlAction {
    private int controlActionNumber;

    private List<Exam> examList = new ArrayList<>();
    private List<Test> testList = new ArrayList<>();
    private Requirements requirements;

    private float currentNumberPoints;
    private int currentNumberTests;

    void setControlActionNumber(int controlActionNumber) {
        this.controlActionNumber = controlActionNumber;
    }

    private boolean controlActionPassed;

    void setControlActionPassed(boolean controlActionPassed) {
        this.controlActionPassed = controlActionPassed;
    }

    boolean isControlActionPassed() {
        return controlActionPassed;
    }

    Requirements getRequirements() {
        return requirements;
    }

    void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    List<Exam> getExamList() {
        return examList;
    }

    List<Test> getTestList() {
        return testList;
    }

    void setRequirements(Requirements requirements) {
        this.requirements = requirements;
    }

    float getCurrentNumberPoints() {
        return currentNumberPoints;
    }

    void setCurrentNumberPoints(float currentNumberPoints) {
        this.currentNumberPoints = currentNumberPoints;
    }

    int getCurrentNumberTests() {
        return currentNumberTests;
    }

    void setCurrentNumberTests(int currentNumberTests) {
        this.currentNumberTests = currentNumberTests;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Контрольное мероприятие №").append(controlActionNumber)
                .append("\nВ состав контрольного мероприятия входят:")
                .append("\n\tКоличество зачетов: ").append(testList.size())
                .append("\n\tКоличество экзаменов: ").append(examList.size())
                .append(System.lineSeparator());

        examList.forEach(sb::append);
        testList.forEach(sb::append);
        sb.append(requirements);

        sb.append("Текущие результаты кандидата:")
                .append("\n\tКоличество баллов набрано: ").append(currentNumberPoints)
                .append("\n\tКоличество зачетов сдано: ").append(currentNumberTests);

        sb.append("\nВывод: контрольное мероприятие ")
                .append(controlActionPassed ? "ПРОЙДЕНО." : "НЕ ПРОЙДЕНО.")
                .append(System.lineSeparator());

        return sb.toString();
    }
}
