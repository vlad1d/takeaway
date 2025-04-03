package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Restaurant class to create restaurant objects.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class Restaurant {
    private String name;
    private List<Cuisine> cuisines;
    private Rating rating;
    private Address address;

    @JsonCreator
    public Restaurant(
            @JsonProperty ("name") String name,
            @JsonProperty ("cuisines") List<Cuisine> cuisines,
            @JsonProperty ("rating") Rating rating,
            @JsonProperty ("address") Address address
    ) {
        this.name = name;
        this.cuisines = cuisines;
        this.rating = rating;
        this.address = address;
    }
}
