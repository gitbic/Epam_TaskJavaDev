package com.company;

public class CurrentResult extends ResultExamination {
    @Override
    public String toString() {
        return "\nТекущие результаты кандидата:" +
                "\n\tКоличество баллов набрано: " + getNumberPoints() +
                "\n\tКоличество зачетов сдано: " + getNumberTests();
    }
}
