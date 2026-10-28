package Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.Cookie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CookieReader {
    private String domain;
    private double expirationDate;
    private boolean hostOnly;
    private boolean httpOnly;
    private String name;
    private String path;
    private String sameSite;
    private boolean secure;
    private boolean session;
    private String storeId;
    private String value;

    public static List<Cookie> readCookie() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("src/test/resources/cookies.json"));

        // Iterate over each object in the array
        for (JsonNode node : jsonNode) {
            // Print the value of the "name" field
            System.out.println(node.get("name").asText());
        }
        List<Cookie> cookies = new ArrayList<>();

        for (JsonNode cookieNode : jsonNode) {
            String name = cookieNode.get("name").asText();
            String value = cookieNode.get("value").asText();
            String domain = cookieNode.get("domain").asText();
            String path = cookieNode.get("path").asText();
            boolean secure = cookieNode.get("secure").asBoolean();
            boolean httpOnly = cookieNode.get("httpOnly").asBoolean();
            long expiry = cookieNode.get("expirationDate").asLong();


            cookies.add(new Cookie.Builder(name, value)
                    .domain(domain)
                    .path(path)
                    .isSecure(secure)
                    .isHttpOnly(httpOnly)
                    .expiresOn(new Date(expiry * 1000))
                    .build());
        }
        System.out.println("Cookies are generated" + cookies);
        return cookies;
    }


}
