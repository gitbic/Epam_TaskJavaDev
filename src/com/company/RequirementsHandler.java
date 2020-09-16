package com.company;

class RequirementsHandler extends DataHandler<Requirements> {

    @Override
    Requirements getEventFromString(int i, String eventString) {
        Requirements requirements = new Requirements();
        requirements.setExamPoints(parseValue(eventString, "examPoints"));
        requirements.setPassedTests((int) parseValue(eventString, "passedTests"));
        return requirements;
    }
}
