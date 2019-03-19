package com.mykovolod.movieland.service;

import com.mykovolod.movieland.sorting.MovieSortParam;
import org.springframework.stereotype.Service;

@Service
public class MovieSortQueryBuilder {

    public String build(String query, MovieSortParam movieSortParam) {
        StringBuilder stringBuilder = new StringBuilder(query);
        if (movieSortParam.getRating() != null) {
            if (movieSortParam.getRating().isAscending()) {
                stringBuilder.append(" order by rating asc");
            } else if (movieSortParam.getRating().isDescending()) {
                stringBuilder.append(" order by rating desc");
            }
        } else if (movieSortParam.getPrice() != null) {
            if (movieSortParam.getPrice().isAscending()) {
                stringBuilder.append(" order by price asc");
            } else if (movieSortParam.getPrice().isDescending()) {
                stringBuilder.append(" order by price desc");
            }
        }
        return stringBuilder.toString();
    }
}
