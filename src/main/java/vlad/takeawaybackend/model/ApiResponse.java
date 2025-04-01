package vlad.takeawaybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter
public class ApiResponse {
    private List<Restaurant> restaurants;
}
