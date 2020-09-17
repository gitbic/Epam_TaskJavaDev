package com.company;

import java.util.Map;

class Exam {

    private int examNumber;
    private Map<String, Float> examMap;

    void setExamNumber(int examNumber) {
        this.examNumber = examNumber;
    }

    Map<String, Float> getExamMap() {
        return examMap;
    }

    void setExamMap(Map<String, Float> examMap) {
        this.examMap = examMap;
    }

    @Override
    public String toString() {
        return "\nЭкзамен №" + examNumber +
                "\n\tМинимальный балл: " + examMap.get("minValue") +
                "\n\tМаксимальный балл: " + examMap.get("maxValue") +
                "\n\tШаг балла: " + examMap.get("stepValue") +
                "\n\tКандидат набрал баллов: " + examMap.get("currentValue");
    }
}
