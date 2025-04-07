package vlad.takeawaybackend.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingTest {
    @Test
    void ratingDeserializationTest() throws Exception {
        String json = """
                {
                "starRating": "5.0"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Rating rating = mapper.readValue(json, Rating.class);
        assertEquals(5.0, rating.getStarRating());
    }
}
