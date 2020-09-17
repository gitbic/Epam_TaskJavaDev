package com.company;

import java.util.List;

class RequirementsHandler extends DataHandler<Requirements> {

    private String eventKeyword = "Required";

    RequirementsHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
    }

    @Override
    void createEventList() {
        Requirements requirements = new Requirements();
        List<String> eventList = createEventStringList();
        requirements.setNumberPoints(parseValue(eventList.get(0), "examPoints"));
        requirements.setNumberTests((int) parseValue(eventList.get(0), "passedTests"));
        addEventToList(requirements);
    }
}
