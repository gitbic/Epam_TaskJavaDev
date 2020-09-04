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

    public boolean isEventPassed() {
        return eventPassed;
    }

    void setEventPassed(boolean eventPassed) {
        this.eventPassed = eventPassed;
    }

    List<Map<String, Float>> getExamList() {
        return examList;
    }

    List<Boolean> getTestList() {
        return testList;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("В состав контрольного мероприятия входят: \n\t" +
                "Количество тестов: " + testList.size() + "\n\t" +
                "Количество экзаменов: " + examList.size() + "\n");


        for (Map<String, Float> examMap : examList) {
            sb.append("Экзамен № " + (examList.indexOf(examMap) + 1) + "\n\t" +
                    "Минимальный балл: " + examMap.get("minValue") + "\n\t" +
                    "Максимальный балл: " + examMap.get("maxValue") + "\n\t" +
                    "Шаг балла: " + examMap.get("stepValue") + "\n\t" +
                    "Кандидат набрал баллов: " + examMap.get("currentValue") + "\n");
        }

        for (int i = 0; i < testList.size(); i++) {
            sb.append("Зачет № " + (i + 1) + "\n\t" +
                    "Кандидат сдал зачет: " + (testList.get(i) ? "да" : "нет") + "\n");
        }

        // required
        // current

        return sb.toString();
    }
}
