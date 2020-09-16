package com.company;

import java.util.List;

class RequirementsHandler extends DataHandler<Requirements> {

    private String eventKeyword = "Required";

    RequirementsHandler(String controlActionString) {
        super(controlActionString);
        super.setKeywordFind(this.eventKeyword);
        super.createEventStringList();
    }

    @Override
    void createEventList() {
        Requirements requirements = new Requirements();
        List<String> list = createEventStringList();
        requirements.setNumberPoints(parseValue(list.get(0), "examPoints"));
        requirements.setNumberTests((int) parseValue(list.get(0), "passedTests"));
        addEventToList(requirements);
    }
}
