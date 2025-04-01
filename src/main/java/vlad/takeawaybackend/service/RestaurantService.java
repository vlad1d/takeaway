package vlad.takeawaybackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import vlad.takeawaybackend.model.ApiResponse;
import vlad.takeawaybackend.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService {
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public RestaurantService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public List<Restaurant> fetchRestaurants(String postcode) {
        String url = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/" + postcode;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        List<Restaurant> restaurants = new ArrayList<>();

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            try {
                ApiResponse apiResponse = objectMapper.readValue(responseBody, ApiResponse.class);
                restaurants = apiResponse.getRestaurants();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException("Error parsing JSON response", e);
            }
        }
        return restaurants.stream().limit(10).collect(Collectors.toList());
    }

}
