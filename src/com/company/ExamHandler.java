package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExamHandler extends DataHandler<Exam> {

    private Set<String> examSet = createExamSet();

    private Set<String> createExamSet() {
        return Set.of("minValue",
                "maxValue",
                "stepValue",
                "currentValue");
    }

    @Override
    Exam getEventFromString(int i, String eventString) {
        Exam exam = new Exam();
        exam.setExamNumber(i);

        Map<String, Float> examMap = new HashMap<>();
        for (String key : examSet) {
            examMap.put(key, parseValue(eventString, key));
        }
        exam.setExamMap(examMap);
        return exam;
    }
}
