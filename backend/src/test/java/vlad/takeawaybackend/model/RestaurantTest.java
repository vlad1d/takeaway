package vlad.takeawaybackend.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantTest {
    @Test
    void restaurantDeserializationTest() throws Exception {
        String json = """
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
                """;
        ObjectMapper mapper = new ObjectMapper();
        Restaurant restaurant = mapper.readValue(json, Restaurant.class);
        assertEquals("PizzaBros", restaurant.getName());
        assertEquals("Japanese", restaurant.getCuisines().get(0).getName());
        assertEquals(4.8, restaurant.getRating().getStarRating());
        assertEquals("Amsterdam", restaurant.getAddress().getCity());
        assertEquals("StreetTwo 2", restaurant.getAddress().getFirstLine());
        assertEquals("JUST EAT", restaurant.getAddress().getPostalCode());
    }
}
