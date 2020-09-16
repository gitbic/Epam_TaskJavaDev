package com.company;

class Requirements {

    private float examPoints;
    private int passedTests;

    float getExamPoints() {
        return examPoints;
    }

    void setExamPoints(float examPoints) {
        this.examPoints = examPoints;
    }

    int getPassedTests() {
        return passedTests;
    }

    void setPassedTests(int passedTests) {
        this.passedTests = passedTests;
    }

    @Override
    public String toString() {
        return "Требования для прохождения контрольного испытания\n" +
                "\tНеобходимо набрать всего баллов:  " + examPoints + "\n" +
                "\tНеобходимо сдать всего зачетов: " + passedTests + "\n";
    }
}
