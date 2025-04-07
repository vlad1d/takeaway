package vlad.takeawaybackend.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuisineTest {
    @Test
    void cuisineDeserializationTest() throws Exception {
        String json = """
                {
                "name": "Pizza"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Cuisine cuisine = mapper.readValue(json, Cuisine.class);
        assertEquals("Pizza", cuisine.getName());
    }
}
