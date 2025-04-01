package vlad.takeawaybackend.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Restaurant class to create restaurant objects.
 */
@Getter @Setter
public class Restaurant {
    private String name;
    private String[] cuisines;
    private double rating;
    private String address;

    /**
     * Constructor to initialize the restaurant.
     * @param name of the restaurant
     * @param cuisines is a list of strings to support multiple cuisines
     * @param rating double value to keep the rating number
     * @param address of the restaurant
     */
    public Restaurant(String name, String[] cuisines, double rating, String address) {
        this.name = name;
        this.cuisines = cuisines;
        this.rating = rating;
        this.address = address;
    }
}
