package com.epam.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiRecord {
	private Long page;
    @JsonProperty("total_pages")
    private Long totalPages;
    private List<Film> results;

    public static class Film {
        @JsonProperty("title")
        public String name;
        @JsonProperty("original_language")
        public String originalLanguage;
        @JsonProperty("original_title")
        public String originalName;
        @JsonProperty("poster_path")
        public String pictures;
        @JsonProperty("release_date")
        public String date;
        public String overview;
    }
}
