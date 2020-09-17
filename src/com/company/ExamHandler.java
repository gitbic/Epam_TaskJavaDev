package com.company;

import java.util.*;

class ExamHandler extends DataHandler<Exam> {

    private String eventKeyword = "Exam";
    private Set<String> examSet = createExamSet();


    ExamHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
    }

    private Set<String> createExamSet() {
        return Set.of("minValue",
                "maxValue",
                "stepValue",
                "currentValue");
    }

    @Override
    void createEventList() {
        int i = 1;
        for (String eventString : createEventStringList()) {
            Exam exam = new Exam();
            exam.setExamNumber(i);

            Map<String, Float> examMap = new HashMap<>();
            for (String key : examSet) {
                examMap.put(key, parseValue(eventString, key));
            }
            exam.setExamMap(examMap);
            addEventToList(exam);
            i++;
        }
    }
}
