package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Rating class holds only the star rating of the restaurant for simplicity.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class Rating {
    private double starRating;

    @JsonCreator
    public Rating(
            @JsonProperty ("starRating") double starRating
    ) {
        this.starRating = starRating;
    }
}
