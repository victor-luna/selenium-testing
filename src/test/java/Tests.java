import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
@TestInstance(Lifecycle.PER_CLASS)
public class Tests {

    WebDriver webdriver;

    @BeforeAll
    public void setupAll(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver_linux64/chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver(){
        webdriver.close();
    }

}
