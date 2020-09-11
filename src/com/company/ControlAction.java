package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ControlAction {

    private List<Map<String, Float>> examList = new ArrayList<>();
    private List<Boolean> testList = new ArrayList<>();

    private float currentNumberPoints;
    private int currentNumberTests;

    private float requiredNumberPoints;
    private int requiredNumberTests;

    private boolean eventPassed;

    boolean isEventPassed() {
        return eventPassed;
    }

    void setEventPassed(boolean eventPassed) {
        this.eventPassed = eventPassed;
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

    float getRequiredNumberPoints() {
        return requiredNumberPoints;
    }

    void setRequiredNumberPoints(float requiredNumberPoints) {
        this.requiredNumberPoints = requiredNumberPoints;
    }

    int getRequiredNumberTests() {
        return requiredNumberTests;
    }

    void setRequiredNumberTests(int requiredNumberTests) {
        this.requiredNumberTests = requiredNumberTests;
    }

    void addExamToList(Map<String, Float> map) {
        examList.add(map);
    }

    void addTestToList(boolean bool) {
        testList.add(bool);
    }

    List<Map<String, Float>> getExamList() {
        return examList;
    }

    List<Boolean> getTestList() {
        return testList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В состав контрольного мероприятия входят: \n" +
                "\tКоличество зачетов: " + testList.size() + "\n" +
                "\tКоличество экзаменов: " + examList.size() + "\n");


        for (Map<String, Float> examMap : examList) {
            sb.append("Экзамен № " + (examList.indexOf(examMap) + 1) + "\n" +
                    "\tМинимальный балл: " + examMap.get("minValue") + "\n" +
                    "\tМаксимальный балл: " + examMap.get("maxValue") + "\n" +
                    "\tШаг балла: " + examMap.get("stepValue") + "\n" +
                    "\tКандидат набрал баллов: " + examMap.get("currentValue") + "\n");
        }

        for (int i = 0; i < testList.size(); i++) {
            sb.append("Зачет № " + (i + 1) + "\n" +
                    "\tКандидат сдал зачет: " + (testList.get(i) ? "да" : "нет") + "\n");
        }

        sb.append("Требования для прохождения контрольного испытания:\n");
        if (examList.size() > 0) {
            sb.append("\tНеобходимо набрать баллов в совокупности за все экзамены: " + requiredNumberPoints + "\n");
        }
        if (testList.size() > 0) {
            sb.append("\tНеобходимо сдать всего зачетов: " + requiredNumberTests + "\n");
        }

        sb.append("Текущие результаты кандидата:\n");
        if (examList.size() > 0) {
            sb.append("\tКоличество баллов набрано: " + currentNumberPoints + "\n");
        }
        if (testList.size() > 0) {
            sb.append("\tКоличество зачетов сдано: " + requiredNumberTests + "\n");
        }

        sb.append("Вывод: контрольное мероприятие ")
                .append(eventPassed ? "ПРОЙДЕНО." : "НЕ ПРОЙДЕНО.");

        return sb.toString();
    }
}
