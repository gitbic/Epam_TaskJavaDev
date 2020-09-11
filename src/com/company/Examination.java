package com.company;

import java.util.ArrayList;
import java.util.List;

abstract class Examination<T> {
    List<T> examinationList = new ArrayList<>();

    void addExaminationToList(T object) {
        examinationList.add(object);
    }

    List<T> getExaminationList() {
        return examinationList;
    }



}
