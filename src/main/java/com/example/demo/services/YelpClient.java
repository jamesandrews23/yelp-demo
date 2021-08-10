package com.example.demo.services;

import com.example.demo.models.BusinessResults;
import com.example.demo.models.ReviewsResult;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class YelpClient {
    private final WebClient client;
    private static final String AUTH_TOKEN = "vIvDccV01WR0Vj_ameVPTPOiivEBzMNj21zxHywUW1rH1IdpZxKmQcBY9vKHLBlahVs0q3-WvytbJD7pZ6MJB8rtU8nzjHXBCqhKw5ez2MAv1Hij-gmiJCeIO5ESYXYx";

    public YelpClient(WebClient.Builder builder){
        this.client = builder.baseUrl("https://api.yelp.com/v3/businesses/").build();
    }

    public String getRestaurantByNameAndLocation(String name, String location){
        return this.client
                .get()
                .uri(uriBuilder -> uriBuilder
                    .path("/search")
                    .queryParam("term", name)
                    .queryParam("location", location)
                    .build())
                .headers(h -> h.setBearerAuth(AUTH_TOKEN))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public BusinessResults getRestaurantByPhone(String phone){
        return this.client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/phone")
                        .queryParam("phone", phone)
                        .build())
                .headers(h -> h.setBearerAuth(AUTH_TOKEN))
                .retrieve()
                .bodyToMono(BusinessResults.class)
                .block();
    }

    public ReviewsResult getReviewsById(String id){
        return this.client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/{id}/reviews")
                        .build(id))
                .headers(h -> h.setBearerAuth(AUTH_TOKEN))
                .retrieve()
                .bodyToMono(ReviewsResult.class)
                .block();
    }
}
