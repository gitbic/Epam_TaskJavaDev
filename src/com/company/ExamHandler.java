package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExamHandler extends DataHandler<Exam> {

    private String eventKeyword = "Exam";
    private Set<String> examSet = createExamSet();

    ExamHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
        super.createEventStringList();
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

    private float parseValue(String str, String substr) {
        String result = "";
        Pattern p = Pattern.compile(substr + "\\s?=\\s?(\\d+\\.?\\d?)");
        Matcher m = p.matcher(str);
        if (m.find()) {
            result = m.group(1);
        } else {
            System.out.println("Error: incorrect input.");
            System.exit(0);
        }
        return Float.parseFloat(result);
    }

    private Set<String> createExamSet() {
        return Set.of("minValue",
                "maxValue",
                "stepValue",
                "currentValue");
    }
}
