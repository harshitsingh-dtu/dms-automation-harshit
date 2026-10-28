package stepDefinations;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class cookies {
    // Path where the browser session will be stored as a serialized file
    private static final String COOKIE_FILE_PATH = "src/test/resources/cookies.ser";

    // Saves current browser cookies to a file after a successful login
    public static void saveCookies(WebDriver driver) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(COOKIE_FILE_PATH)))) {
            oos.writeObject(driver.manage().getCookies());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads saved cookies into the browser to bypass the login screen
    @SuppressWarnings("unchecked")
    public static void loadCookies(WebDriver driver, String domainUrl) {
        File cookieFile = new File(COOKIE_FILE_PATH);
        if (!cookieFile.exists()) return; // Exit if no saved session is found

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(cookieFile.toPath()))) {
            Set<Cookie> cookies = (Set<Cookie>) ois.readObject();
            driver.get(domainUrl); // Must navigate to the domain first before injecting cookies

            for (Cookie cookie : cookies) {
                try {
                    driver.manage().addCookie(cookie); // Inject each saved cookie into the session
                } catch (Exception e) {
                    System.out.println("Skipping invalid cookie: " + cookie.getName());
                }
            }
            // Refresh the page to apply the injected cookies and load the dashboard
            driver.navigate().refresh();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}