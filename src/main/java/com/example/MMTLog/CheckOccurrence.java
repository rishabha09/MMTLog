package com.example.MMTLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckOccurrence {

    public int findOccurrenceOnSingleValue(String value) {
        if(value == null ) return 0;
        int keyOccurrence = 0;
        for(Map<String, Object> map  : ProcessLog.fileData) {
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                if(entry.getValue() != null  && (entry.getValue().equals(value))){
                    ++keyOccurrence;
                }
            }
        }
        return keyOccurrence;
    }

    public int findOccurrenceOfValuesOnAnd(String[] values) {
        if(values.length ==0) {
            return 0;
        }
        int keyOccurrence = 0;
        List<Object> mapValues = null;
        for(Map<String, Object> map  : ProcessLog.fileData) {
            mapValues = new ArrayList<>();
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                mapValues.add(entry.getValue());
            }
            boolean found = true;
            for(String value : values) {
                if(!mapValues.contains(value)) {
                    found = false;
                    break;
                }
            }

            if(found) {
                ++keyOccurrence;
            }

        }
        return keyOccurrence;
    }

    public int findOccurrenceOfValuesOnOr(String[] values) {
        if(values.length ==0) {
            return 0;
        }
        int keyOccurrence = 0;
        List<Object> mapValues = null;
        for(Map<String, Object> map  : ProcessLog.fileData) {
            mapValues = new ArrayList<>();
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                mapValues.add(entry.getValue());
            }
            boolean found = false;
            for(String value : values) {
                if(mapValues.contains(value)) {
                    found = true;
                    break;
                }
            }

            if(found) {
                ++keyOccurrence;
            }

        }
        return keyOccurrence;
    }
}
