package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Cuisine class to create cuisine objects. They seem to only contain a name.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class Cuisine {
    private String name;

    @JsonCreator
    public Cuisine(
            @JsonProperty("name") String name
    ) {
        this.name = name;
    }
}
