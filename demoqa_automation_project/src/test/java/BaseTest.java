import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected WebDriver driver;
    String browser = System.getProperty("browser", "chrome");
    PracticeFormPage practiceFormPage;

    @BeforeAll
    public void setUp() {
        System.out.println("Test initiated with browser: " + browser);
        if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
        } else if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
        } else {
            System.out.println("Unsupported browser: " + browser);
        }
        System.out.println("Test initiated.");
    }

    @BeforeEach
    public void beforeMethod() {
        if ("firefox".equalsIgnoreCase(browser)) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("dom.webnotifications.enabled", false);  // Bildirimleri devre dışı bırak
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setProfile(profile);
            driver = new FirefoxDriver(firefoxOptions);
        } else if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--allowed-ips");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        if (driver != null) {
            driver.get("https://demoqa.com/automation-practice-form");
            practiceFormPage = new PracticeFormPage(driver);
        } else {
            System.out.println("Driver başlatılamadı.");
        }
    }

    @AfterEach
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test finished.");
        }
    }
}




