package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ControlAction {

    private String nameControlAction;
    private List<Map<String, Float>> examineList = new ArrayList<>();
    private List<Boolean> testList = new ArrayList<>();

    private float currentNumberPoints;
    private float currentNumberTests;

    private float requiredNumberPoints;
    private float requiredNumberTests;

    String getNameControlAction() {
        return nameControlAction;
    }

    void setNameControlAction(String nameControlAction) {
        this.nameControlAction = nameControlAction;
    }

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

    void setCurrentNumberTests(float currentNumberTests) {
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

    void setRequiredNumberTests(float requiredNumberTests) {
        this.requiredNumberTests = requiredNumberTests;
    }

    void addExamineToList(Map<String, Float> map) {
        examineList.add(map);
    }

    void addTestToList(boolean bool) {
        testList.add(bool);
    }
}
