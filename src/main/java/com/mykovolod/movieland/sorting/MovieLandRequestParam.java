package com.mykovolod.movieland.sorting;

import java.util.HashMap;
import java.util.Map;

public class MovieLandRequestParam {
    private Map<String, SortDirection> sort = new HashMap<>();

    public void addSortingParam(final String field, final SortDirection sortDirection) {
        if (sortDirection != null) {
            sort.put(field, sortDirection);
        }
    }

    public Map<String, SortDirection> getSort() {
        return sort;
    }
}
