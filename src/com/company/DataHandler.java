package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class DataHandler<T> {

    abstract T getEventFromString(int i, String eventString);

    float parseValue(String str, String substr) {
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
}
