package vlad.takeawaybackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import vlad.takeawaybackend.model.Restaurant;
import vlad.takeawaybackend.service.RestaurantService;

import java.util.List;

/**
 * RestaurantController is the entry point for the restaurant API.
 */
@RestController @RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    /**
     * Constructor to initialize the service.
     * @param restaurantService the service to fetch restaurant data
     */
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    /**
     * Sets a get mapping on the /restaurants endpoint to fetch restaurants.
     * @param postcode the postcode to search for restaurants
     * @return a list of restaurant objects
     */
    @GetMapping
    public List<Restaurant> getRestaurants(String postcode) {
        return restaurantService.fetchRestaurants(postcode);
    }
}