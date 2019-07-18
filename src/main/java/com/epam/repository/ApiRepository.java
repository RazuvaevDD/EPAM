package com.epam.repository;

import com.epam.data.*;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class ApiRepository {
    private static final String URL = "https://api.themoviedb.org/3/search/movie";
    private static final String TOKEN = "748998fd3047279443fd976cf5cd627f";

    private final RestTemplate restTemplate;

    public ApiRepository() {
        this.restTemplate = new RestTemplate();
    }

    public ApiRecord findByQuery(String query) {
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("api_key", TOKEN)
                .queryParam("language", "ru-RU")
                //.queryParam("page", "1")
                .queryParam("include_adult", "false")
                .queryParam("query", query)
                .build();
        return restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, null, ApiRecord.class).getBody();
    }
}
