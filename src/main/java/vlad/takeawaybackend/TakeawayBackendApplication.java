package vlad.takeawaybackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import vlad.takeawaybackend.model.Restaurant;
import vlad.takeawaybackend.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TakeawayBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TakeawayBackendApplication.class, args);
        // Initialize the RestaurantService with a RestTemplate and ObjectMapper

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        RestaurantService restaurantService = new RestaurantService(restTemplate, objectMapper);
        List<Restaurant> restaurants = restaurantService.fetchRestaurants("BT7 1NN");
    }

}
