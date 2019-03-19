package com.mykovolod.movieland.service;

import com.mykovolod.movieland.sorting.MovieSortParam;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieSortQueryBuilderTest {
    MovieSortQueryBuilder movieSortQueryBuilder = new MovieSortQueryBuilder();


    @Test
    public void whenRatingSortAsc_thanItIsCorrect() {
        MovieSortParam movieSortParam = new MovieSortParam(MovieSortParam.SortDirection.asc, MovieSortParam.SortDirection.desc);
        String builderQuery = movieSortQueryBuilder.build("select * from table", movieSortParam);

        assertEquals("select * from table order by rating asc", builderQuery);
    }

    @Test
    public void whenRatingSortDesc_thanItIsCorrect() {
        MovieSortParam movieSortParam = new MovieSortParam(MovieSortParam.SortDirection.desc, MovieSortParam.SortDirection.desc);
        String builderQuery = movieSortQueryBuilder.build("select * from table", movieSortParam);

        assertEquals("select * from table order by rating desc", builderQuery);
    }

    @Test
    public void whenPriceSortDesc_thanItIsCorrect() {
        MovieSortParam movieSortParam = new MovieSortParam(null, MovieSortParam.SortDirection.desc);
        String builderQuery = movieSortQueryBuilder.build("select * from table", movieSortParam);

        assertEquals("select * from table order by price desc", builderQuery);
    }

    @Test
    public void whenPriceSorAsc_thanItIsCorrect() {
        MovieSortParam movieSortParam = new MovieSortParam(null, MovieSortParam.SortDirection.asc);
        String builderQuery = movieSortQueryBuilder.build("select * from table", movieSortParam);

        assertEquals("select * from table order by price asc", builderQuery);
    }
}
