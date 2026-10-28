package Utilities;

import de.taimos.totp.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondaryUserLogin {

    private WebDriver incognitoDriver;
    private ConfigFileReader configfileReader;

    public SecondaryUserLogin() {
        configfileReader = new ConfigFileReader();
    }

    public WebDriver loginSecondaryUserIncognito(String user) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("remote-allow-origins=*");
        incognitoDriver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(incognitoDriver, Duration.ofSeconds(15));

        String username="";
        String password="";
        String secretKey="";


        switch(user){
            case "NonAdminOsttraPB":
                username = configfileReader.getDataFromConfigFile("userNonAdminOsttraPb");
                password = configfileReader.getDataFromConfigFile("passwordNonAdminOsttraPb");
                secretKey = configfileReader.getDataFromConfigFile("secretKeyNonAdminOsttraPb");
                break;

            case "NonAdminOsttraEB":
                username = configfileReader.getDataFromConfigFile("userNonAdminOsttraEb");
                password = configfileReader.getDataFromConfigFile("passwordNonAdminOsttraEb");
                secretKey = configfileReader.getDataFromConfigFile("secretKeyNonAdminOsttraEb");
                break;

            case "Admin":
                username = configfileReader.getDataFromConfigFile("username");
                password = configfileReader.getDataFromConfigFile("password");
                secretKey = configfileReader.getDataFromConfigFile("secretKey");
                break;

            case "BarclaysPB":
                username = configfileReader.getDataFromConfigFile("userbarclaysPb");
                password = configfileReader.getDataFromConfigFile("passwordbarclaysPb");
                secretKey = configfileReader.getDataFromConfigFile("secretKeybarclaysPb");
                break;

            case "BarclaysEB":
                username = configfileReader.getDataFromConfigFile("userbarclaysEb");
                password = configfileReader.getDataFromConfigFile("passwordbarclaysEb");
                secretKey = configfileReader.getDataFromConfigFile("secretKeybarclaysEb");
                break;

            case "CitigroupPB":
                username = configfileReader.getDataFromConfigFile("usercitigroupPb");
                password = configfileReader.getDataFromConfigFile("passwordcitigroupPb");
                break;

            default:
                System.out.println("Error: Unknown user provided.");
                break;

        }

        try {
            incognitoDriver.get(configfileReader.getDataFromConfigFile("webdriver.base.url"));
            
            // --- START: Added logic to handle cookie consent ---
            try {
                // Wait for the banner container to be visible first, identified from the error log.
                WebDriverWait cookieWait = new WebDriverWait(incognitoDriver, Duration.ofSeconds(10));
                WebElement bannerContainer = cookieWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ketch-banner-content")));
                
                // Now find the button within the banner. This is a more reliable approach.
                // Looking for a button with text like 'Accept', 'Agree', 'Allow'.
                WebElement cookieButton = bannerContainer.findElement(By.xpath(
                    ".//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'accept')] | " +
                    ".//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'agree')] | " +
                    ".//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'allow')]"
                ));

                System.out.println("Cookie consent button found within 'ketch-banner-content'. Clicking it now.");
                cookieButton.click();
                // Add a short pause to allow the banner to animate and disappear.
                Thread.sleep(1000); 
                
            } catch (Exception e) {
                System.out.println("Cookie consent banner ('ketch-banner-content') not found or button not clickable within 10 seconds. Continuing with login...");
                // Log the actual exception for better debugging
                System.out.println("Cookie Exception Details: " + e.getMessage());
            }
            // --- END: Added logic to handle cookie consent ---

            WebElement usernameBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter email address']")));
            usernameBox.click();
            usernameBox.sendKeys(username);
            incognitoDriver.findElement(By.xpath("//button[text()='Login']")).click();
            Thread.sleep(5000); // Wait for the next screen to load
            boolean isPopupVisible = !incognitoDriver.findElements(By.xpath("//h2[text()='Important Information']")).isEmpty();
            if (isPopupVisible) {
                System.out.println("Important Info pop-up detected.");
                incognitoDriver.findElement(By.xpath("//div[@class='t-checkbox']")).click();
                Thread.sleep(2000);
                incognitoDriver.findElement(By.xpath("//button[contains(text(),'I understand')]")).click();
                Thread.sleep(2000);
                WebElement passBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
                passBox.sendKeys(password);
                incognitoDriver.findElement(By.xpath("//*[@type='submit']")).click();
            } else {
                System.out.println("No pop-up detected. Proceeding with standard login.");
                WebElement passBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
                passBox.sendKeys(password);
                incognitoDriver.findElement(By.xpath("//*[@type='submit']")).click();
                try {
                    WebDriverWait shortWait = new WebDriverWait(incognitoDriver, Duration.ofSeconds(8));
                    WebElement totpBox = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Code']")));
                    System.out.println("TOTP screen detected. Entering code...");
                    totpBox.sendKeys(secretKey);
                    incognitoDriver.findElement(By.xpath("//*[@type='submit']")).click();
                } catch (Exception e) {
                    System.out.println("TOTP screen did not appear (SSO likely bypassed it). Proceeding to dashboard.");
                }
            }
            Thread.sleep(7000);
            return incognitoDriver;
        } catch (Exception e) {
            System.out.println("Failed to login secondary user: " + e.getMessage());
            if (incognitoDriver != null) {
                incognitoDriver.quit();
            }
            throw new RuntimeException(e);
        }
    }

    private String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    public void closeIncognitoBrowser() {
        if (incognitoDriver != null) {
            incognitoDriver.quit();
        }
    }
}