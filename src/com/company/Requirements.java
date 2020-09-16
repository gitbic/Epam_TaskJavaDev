package com.company;

class Requirements {

    private float numberPoints;
    private int numberTests;

    float getNumberPoints() {
        return numberPoints;
    }

    void setNumberPoints(float numberPoints) {
        this.numberPoints = numberPoints;
    }

    int getNumberTests() {
        return numberTests;
    }

    void setNumberTests(int numberTests) {
        this.numberTests = numberTests;
    }

    @Override
    public String toString() {
        return "Требования для прохождения контрольного испытания:\n" +
                "\tНеобходимо набрать всего баллов:  " + numberPoints + "\n" +
                "\tНеобходимо сдать всего зачетов: " + numberTests + "\n";
    }
}
