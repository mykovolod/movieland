package com.mykovolod.movieland.service;

import com.mykovolod.movieland.service.impl.QueryBuilder;
import com.mykovolod.movieland.sorting.MovieLandRequestParam;
import com.mykovolod.movieland.sorting.SortDirection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieSortQueryBuilderTest {
    QueryBuilder queryBuilder = new QueryBuilder();


    @Test
    public void whenRatingSortAsc_thanItIsCorrect() {

        MovieLandRequestParam movieLandRequestParam = new MovieLandRequestParam();
        movieLandRequestParam.addSortingParam("rating", SortDirection.ASC);
        String builderQuery = queryBuilder.addSorting("select * from table", movieLandRequestParam);

        assertEquals("select * from table order by rating ASC", builderQuery);
    }

    @Test
    public void whenRatingSortDesc_thanItIsCorrect() {
        MovieLandRequestParam movieLandRequestParam = new MovieLandRequestParam();
        movieLandRequestParam.addSortingParam("rating", SortDirection.DESC);
        String builderQuery = queryBuilder.addSorting("select * from table", movieLandRequestParam);

        assertEquals("select * from table order by rating DESC", builderQuery);
    }

    @Test
    public void whenPriceSortDesc_thanItIsCorrect() {
        MovieLandRequestParam movieLandRequestParam = new MovieLandRequestParam();
        movieLandRequestParam.addSortingParam("price", SortDirection.DESC);
        String builderQuery = queryBuilder.addSorting("select * from table", movieLandRequestParam);

        assertEquals("select * from table order by price DESC", builderQuery);
    }

    @Test
    public void whenPriceSorAsc_thanItIsCorrect() {
        MovieLandRequestParam movieLandRequestParam = new MovieLandRequestParam();
        movieLandRequestParam.addSortingParam("price", SortDirection.ASC);
        String builderQuery = queryBuilder.addSorting("select * from table", movieLandRequestParam);

        assertEquals("select * from table order by price ASC", builderQuery);
    }
}
