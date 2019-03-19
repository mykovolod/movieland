package com.mykovolod.movieland.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieSortParam {
    private SortDirection rating;
    private SortDirection price;

    public enum SortDirection {
        asc, desc;

        public boolean isAscending() {
            return this.equals(asc);
        }

        public boolean isDescending() {
            return this.equals(desc);
        }
    }
}
