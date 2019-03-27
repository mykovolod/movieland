package com.mykovolod.movieland.service.impl;

import com.mykovolod.movieland.sorting.MovieLandRequestParam;
import com.mykovolod.movieland.sorting.SortDirection;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QueryBuilder {

    public String addSorting(final String query, final MovieLandRequestParam movieLandRequestParam) {
        String result = query;

        Map<String, SortDirection> sortDirection = movieLandRequestParam.getSort();
        String sortParam = sortDirection.entrySet().stream().map(e -> e.getKey() + " " + e.getValue().toString())
                .collect(Collectors.joining(", "));

        if (!sortParam.isEmpty()) {
            result = query + " order by " + sortParam;
        }

        return result;
    }
}
