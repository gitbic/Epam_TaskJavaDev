package com.company;

class Test extends Examination {

    private int testNumber;
    private boolean testPassed;

    int getTestNumber() {
        return testNumber;
    }

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
        return "Зачет №" + testNumber + "\n" +
                "\tКандидат сдал зачет: " + (testPassed ? "да" : "нет") + "\n";
    }
}
