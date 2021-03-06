package com.company;

class TestHandler extends DataHandler<Test> {

    private String eventKeyword = "Test";

    TestHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
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
