package com.company;

class TestHandler extends DataHandler<Test> {

    @Override
    Test getEventFromString(int i, String eventString) {
        Test test = new Test();
        test.setTestNumber(i);
        test.setTestPassed(eventString.matches(".*yes.*"));
        return test;
    }
}
