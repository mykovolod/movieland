package com.mykovolod.movieland.service;

import com.mykovolod.movieland.sorting.MovieLandRequestParam;
import com.mykovolod.movieland.sorting.SortDirection;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryBuilder {

    public String build(String query, MovieLandRequestParam movieLandRequestParam) {
        StringBuilder stringBuilder = new StringBuilder(query);

//        build sorting
        Map<String, SortDirection> sortDirection = movieLandRequestParam.getSort();
        for (Map.Entry<String, SortDirection> stringSortDirectionEntry : sortDirection.entrySet()) {
            stringBuilder.append(" order by ");
            stringBuilder.append(stringSortDirectionEntry.getKey());
            stringBuilder.append(" ");
            stringBuilder.append(stringSortDirectionEntry.getValue());
        }

        return stringBuilder.toString();
    }
}
