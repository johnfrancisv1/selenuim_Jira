/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;

import java.time.Duration;


public class MainTest_temp {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();


        // String proxy = "104.37.188.74:37";
        // ChromeOptions options = new ChromeOptions().addArguments("--proxy-server=http://" + proxy);



        driver = new ChromeDriver();





        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By bodyLocator = By.tagName("body");
    private final By searchTogglerLocator = By.className("search-bar-toggler");
    private final By searchLocator = By.xpath("//div[@class='sliding-search-wrapper']/form/input[@name='search']");



    private WebElement waitVisibiiltyAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    @Test
    public void multiplicationTest() {
        this.driver.get("https://www.inf.elte.hu/en/");

        WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator );
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("2021 ELTE Faculty of Informatics"));


        WebElement searchTogglerElement = waitVisibiiltyAndFindElement(searchTogglerLocator);
        searchTogglerElement.click();

        WebElement searchBarElement = waitVisibiiltyAndFindElement(searchLocator);
        searchBarElement.sendKeys("Student \n");

        WebElement bodyElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(bodyElement.getText());
        Assert.assertTrue(bodyElement.getText().contains("Student Support Centre"));




    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}



*/
