package com.company;

import java.util.ArrayList;
import java.util.List;

class TestHandler extends DataHandler<Test> {

    private String eventKeyword = "Test";

    TestHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
        super.createEventStringList();
    }

    @Override
    void createEventList() {
        int i = 1;
        for (String eventString : createEventStringList()) {
            Test test = new Test();
            test.setTestNumber(i);
            test.setTestPassed(eventString.matches(".*yes.*"));
            addEventToList(test);
            i++;
        }
    }
}
