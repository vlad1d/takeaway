package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ApiResponse class to create a response object for the API.
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class ApiResponse {
    private List<Restaurant> restaurants;
}
