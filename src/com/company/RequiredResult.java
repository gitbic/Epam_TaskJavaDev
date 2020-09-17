package com.company;

class RequiredResult extends ResultExamination {
    @Override
    public String toString() {
        return "\nТребования для прохождения контрольного испытания:" +
                "\n\tНеобходимо набрать всего баллов:  " + getNumberPoints() +
                "\n\tНеобходимо сдать всего зачетов: " + getNumberTests();
    }
}
