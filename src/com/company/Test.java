package com.company;

class Test {

    private int testNumber;
    private boolean testPassed;

    void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    boolean isTestPassed() {
        return testPassed;
    }

    void setTestPassed(boolean testPassed) {
        this.testPassed = testPassed;
    }

    @Override
    public String toString() {
        return "\nЗачет №" + testNumber +
                "\n\tКандидат сдал зачет: " + (testPassed ? "да" : "нет");
    }
}
