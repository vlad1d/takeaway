package vlad.takeawaybackend.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    @Test
    void addressDeserializationTest() throws Exception {
        String json = """
                {
                "city": "Amsterdam",
                "firstLine": "StreetOne 12",
                "postalCode": "9743SS"
                }
                """;
        ObjectMapper mapper = new ObjectMapper();
        Address address = mapper.readValue(json, Address.class);
        assertEquals("Amsterdam", address.getCity());
        assertEquals("StreetOne 12", address.getFirstLine());
        assertEquals("9743SS", address.getPostalCode());
    }
}
