package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Address class with a few relevant fields about the address of a restaurant.
 * Not all fields were used here.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class Address {
    private String city;
    private String firstLine;
    private String postalCode;

    @JsonCreator
    public Address(
            @JsonProperty ("city") String city,
            @JsonProperty ("firstLine") String firstLine,
            @JsonProperty ("postalCode") String postalCode
    ) {
        this.city = city;
        this.firstLine = firstLine;
        this.postalCode = postalCode;
    }
}
