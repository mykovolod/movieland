package com.mykovolod.movieland.service.impl;

import com.mykovolod.movieland.sorting.MovieLandRequestParam;
import com.mykovolod.movieland.sorting.SortDirection;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QueryBuilder {

    public String addSorting(String query, MovieLandRequestParam movieLandRequestParam) {

        Map<String, SortDirection> sortDirection = movieLandRequestParam.getSort();
        String sortParam = sortDirection.entrySet().stream().map(e -> e.getKey() + " " + e.getValue().toString())
                .collect(Collectors.joining(", "));

        if (!sortParam.isEmpty()) {
            query = query + " order by " + sortParam;
        }

        return query;
    }
}
