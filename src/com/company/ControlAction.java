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
        sb.append("� ������ ������������ ����������� ������: \n" +
                "\t���������� �������: " + testList.size() + "\n" +
                "\t���������� ���������: " + examList.size() + "\n");


        for (Map<String, Float> examMap : examList) {
            sb.append("������� � " + (examList.indexOf(examMap) + 1) + "\n" +
                    "\t����������� ����: " + examMap.get("minValue") + "\n" +
                    "\t������������ ����: " + examMap.get("maxValue") + "\n" +
                    "\t��� �����: " + examMap.get("stepValue") + "\n" +
                    "\t�������� ������ ������: " + examMap.get("currentValue") + "\n");
        }

        for (int i = 0; i < testList.size(); i++) {
            sb.append("����� � " + (i + 1) + "\n" +
                    "\t�������� ���� �����: " + (testList.get(i) ? "��" : "���") + "\n");
        }

        sb.append("���������� ��� ����������� ������������ ���������:\n");
        if (examList.size() > 0) {
            sb.append("\t���������� ������� ������ � ������������ �� ��� ��������: " + requiredNumberPoints + "\n");
        }
        if (testList.size() > 0) {
            sb.append("\t���������� ����� ����� �������: " + requiredNumberTests + "\n");
        }

        sb.append("������� ���������� ���������:\n");
        if (examList.size() > 0) {
            sb.append("\t���������� ������ �������: " + currentNumberPoints + "\n");
        }
        if (testList.size() > 0) {
            sb.append("\t���������� ������� �����: " + requiredNumberTests + "\n");
        }

        sb.append("�����: ����������� ����������� ")
                .append(eventPassed ? "��������." : "�� ��������.");

        return sb.toString();
    }
}
