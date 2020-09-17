package com.company;

import java.util.List;

class RequirementsHandler extends DataHandler<RequiredResult> {

    private String eventKeyword = "Required";

    RequirementsHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
    }

    @Override
    void createEventList() {
        RequiredResult requiredResult = new RequiredResult();
        List<String> eventList = createEventStringList();
        requiredResult.setNumberPoints(parseValue(eventList.get(0), "examPoints"));
        requiredResult.setNumberTests((int) parseValue(eventList.get(0), "passedTests"));
        addEventToList(requiredResult);
    }
}
