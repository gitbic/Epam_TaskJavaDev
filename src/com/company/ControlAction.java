package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ControlAction {

    private List<Map<String, Float>> examineList = new ArrayList<>();
    private List<Boolean> testList = new ArrayList<>();

    private float currentNumberPoints;
    private int currentNumberTests;

    private float requiredNumberPoints;
    private int requiredNumberTests;

    List<Map<String, Float>> getExamineList() {
        return examineList;
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

    float getCurrentNumberTests() {
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

    float getRequiredNumberTests() {
        return requiredNumberTests;
    }

    void setRequiredNumberTests(int requiredNumberTests) {
        this.requiredNumberTests = requiredNumberTests;
    }

    void addExamToList(Map<String, Float> map) {
        examineList.add(map);
    }

    void addTestToList(boolean bool) {
        testList.add(bool);
    }
}
