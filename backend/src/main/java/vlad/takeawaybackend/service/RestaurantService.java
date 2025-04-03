package vlad.takeawaybackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vlad.takeawaybackend.model.ApiResponse;
import vlad.takeawaybackend.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Restaurant Service handles the logic for fetching restaurant data from an external API.
 */
@Service
public class RestaurantService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    // use spring's @value to inject the base url (from application.properties)
    @Value("${justeat.api.url}")
    private String baseUrl;

    /**
     * Constructor for RestaurantService. Uses RestTemplate to make HTTP requests and ObjectMapper to parse JSON.
     */
    public RestaurantService() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }

    /**
     * Uses the RestTemplate to make a GET request to the API with the given postcode.
     * @param postcode to search for
     * @return the response body as a string
     */
    private String fetchApi(String postcode) {
        // Make a get request to the API with the postcode, get the response as a string
        String url = baseUrl + postcode;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Check if the response is successful
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error fetching data from API: " + response.getStatusCode());
        }
        return response.getBody();
    }

    /**
     * Parses the JSON response from the API into a list of Restaurant objects using ObjectMapper.
     * @param responseBody the response body as a string
     * @return a list of Restaurant objects
     */
    private List<Restaurant> parseRestaurants(String responseBody) {
        try {
            ApiResponse apiResponse = objectMapper.readValue(responseBody, ApiResponse.class);
            return apiResponse.getRestaurants();
        } catch (JsonProcessingException e) {
            // Handle JSON parsing error
            throw new RuntimeException("Error parsing JSON response.", e);
        }
    }

    /**
     * Fetches restaurants from the API using the given postcode.
     * @param postcode the postcode to search for
     * @return a list of restaurants
     */
    public List<Restaurant> fetchRestaurants(String postcode) {
        String responseBody = fetchApi(postcode);
        List<Restaurant> restaurants = parseRestaurants(responseBody);
        return restaurants.stream().limit(10).collect(Collectors.toList()); // Limit to 10 restaurants
    }
}
