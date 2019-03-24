package com.mykovolod.movieland.sorting;

import java.beans.PropertyEditorSupport;

public class SortParamConverter extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        String capitalized = text.toUpperCase();
        SortDirection currency = SortDirection.valueOf(capitalized);
        setValue(currency);
    }
}
