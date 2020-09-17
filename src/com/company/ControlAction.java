package com.company;

import java.util.ArrayList;
import java.util.List;

class ControlAction {
    private int controlActionNumber;

    private List<Exam> examList = new ArrayList<>();
    private List<Test> testList = new ArrayList<>();
    private ResultExamination requiredResult;
    private ResultExamination currentResult;
    private boolean controlActionPassed;

    void setCurrentResult(ResultExamination currentResult) {
        this.currentResult = currentResult;
    }

    ResultExamination getCurrentResult() {
        return currentResult;
    }

    void setRequiredResult(ResultExamination requiredResult) {
        this.requiredResult = requiredResult;
    }

    ResultExamination getRequiredResult() {
        return requiredResult;
    }

    void setControlActionNumber(int controlActionNumber) {
        this.controlActionNumber = controlActionNumber;
    }

    void setControlActionPassed(boolean controlActionPassed) {
        this.controlActionPassed = controlActionPassed;
    }

    boolean isControlActionPassed() {
        return controlActionPassed;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Контрольное мероприятие №").append(controlActionNumber)
                .append("\nВ состав контрольного мероприятия входят:")
                .append("\n\tКоличество зачетов: ").append(testList.size())
                .append("\n\tКоличество экзаменов: ").append(examList.size());

        examList.forEach(sb::append);
        testList.forEach(sb::append);
        sb.append(requiredResult);
        sb.append(currentResult);

        sb.append("\nВывод: контрольное мероприятие ")
                .append(controlActionPassed ? "ПРОЙДЕНО." : "НЕ ПРОЙДЕНО.")
                .append(System.lineSeparator());

        return sb.toString();
    }
}
