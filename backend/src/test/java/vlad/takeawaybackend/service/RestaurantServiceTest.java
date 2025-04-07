package vlad.takeawaybackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import vlad.takeawaybackend.model.ApiResponse;
import vlad.takeawaybackend.model.Restaurant;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantServiceTest {
    @Test
    void parseRestaurants_shouldCorrectlyDeserializePizzaBrosJson() throws Exception {
        String json = """
                {
                  "restaurants": [
                    {
                      "name": "PizzaBros",
                      "cuisines": [
                        { "name": "Japanese" }
                      ],
                      "rating": {
                        "starRating": 4.8
                      },
                      "address": {
                        "city": "Amsterdam",
                        "firstLine": "StreetTwo 2",
                        "postalCode": "JUST EAT"
                      }
                    }
                  ]
                }
            """;
        ObjectMapper mapper = new ObjectMapper();
        ApiResponse response = mapper.readValue(json, ApiResponse.class);
        List<Restaurant> restaurants = response.getRestaurants();

        assertEquals(1, restaurants.size());
        Restaurant restaurant = restaurants.get(0);
        assertEquals("PizzaBros", restaurant.getName());
        assertEquals("Japanese", restaurant.getCuisines().get(0).getName());
        assertEquals(4.8, restaurant.getRating().getStarRating());
        assertEquals("Amsterdam", restaurant.getAddress().getCity());
        assertEquals("StreetTwo 2", restaurant.getAddress().getFirstLine());
        assertEquals("JUST EAT", restaurant.getAddress().getPostalCode());
    }
}
