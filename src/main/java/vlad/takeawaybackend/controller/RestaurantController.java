package vlad.takeawaybackend.controller;

import lombok.Getter;
import vlad.takeawaybackend.model.Restaurant;

import java.util.List;

@Getter
public class RestaurantController {
    private List<Restaurant> restaurants;

    /**
     * Constructor to initialize the restaurant list. Use filler values for now.
      */
    public RestaurantController() {
        this.restaurants = List.of(
                new Restaurant("R1", new String[]{"Pizza", "Italian"}, 4, "Diamantlaan"),
                new Restaurant("R2", new String[]{"Chicken", "Mexican"}, 3.2, "Grote Tuin")
        );
    }
}