import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

    public class BaseTest {
        public static WebDriver driver;
        public static WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://test.woahstork.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 4);
        }

        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
    }
