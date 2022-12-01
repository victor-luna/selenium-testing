import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
@TestInstance(Lifecycle.PER_CLASS)
public class Tests {

    WebDriver webdriver;
    Actions action;



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



    @Test
    public void openNewPage(){
        webdriver.get("https://www.modab.com.br/");
        Assertions.assertEquals("https://www.modab.com.br/",
                webdriver.getCurrentUrl());
    }

    @Test
    public void openBlogOnHeaderTest(){
        webdriver.get("https://www.modab.com.br/");
        WebElement botao = webdriver.findElement(
                By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div/nav/ul/li[1]"));
        botao.click();
    }

    @Test
    public void openAndGetURLTest(){
        webdriver.get("https://www.modab.com.br/");
        WebElement botaoContato = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[1]/div/div[1]/div/div/nav/ul/li[2]"));
        botaoContato.click();
        Assertions.assertEquals("https://www.modab.com.br/contato",
                webdriver.getCurrentUrl());
    }

    @Test
    public void findElementsQuantityTest (){
        webdriver.get("https://www.modab.com.br/");
        List<WebElement> elements = webdriver.findElements(By.cssSelector("body > div.render-container.render-route-store-home > div > div.vtex-store__template.bg-base > div > div.vtex-sticky-layout-0-x-wrapper.vtex-sticky-layout-0-x-wrapper--header__sticky > div > div.vtex-flex-layout-0-x-flexRow.vtex-flex-layout-0-x-flexRow--header__main > div > div:nth-child(2)"));
        Assertions.assertTrue(elements.size() == 1);

    }

    @Test
    public void openSearchAndFill () {
        webdriver.get("https://www.modab.com.br/");
        action = new Actions(webdriver);

        WebElement search = webdriver.findElement(By.id("newsletter-input-email"));
        action.moveToElement(search);
        search.sendKeys("email@email.com.br");
    }

    @Test
    public void confereNovaURL (){
        webdriver.get("https://www.modab.com.br/entrega-e-frete");

        WebElement search = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[7]/div/div[2]/form/div/div/div[3]/div/div/div/div/a[1]"));
        search.click();

        String newURL = "https://www.facebook.com/lojamodab/";
        Assertions.assertFalse(newURL.equals(webdriver.getCurrentUrl()));
    }

    @Test
    public void submitFormInfo (){
        webdriver.get("https://modab.delivery.after.sale/login?order=&confirmation=");

        WebElement searchNumeroPedido = webdriver.findElement(By.id("order"));
        WebElement searchEmail = webdriver.findElement(By.id("confirmation"));

        searchNumeroPedido.sendKeys("123456789");
        searchEmail.sendKeys("email@email.com.br");

        searchEmail.submit();
    }

    @Test
    public void addToCartTest (){
        webdriver.get("https://www.modab.com.br/agua-perfumada-modab-para-tecido/p");

        WebElement botaoComprar = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div[4]/div/div[3]/div/div/div[2]/div/div/div[5]/div[1]/div/div/div/div/div/button"));
        botaoComprar.click();

        String productURL = "https://www.modab.com.br/agua-perfumada-modab-para-tecido/p";

        Assertions.assertTrue(productURL.equals(webdriver.getCurrentUrl()));
    }

    @Test
    public void selectByIndexTest (){
        webdriver.get("https://whiplash.net/materias/whiplash/027002.html");

        WebElement search = webdriver.findElement(By.id("inputFormato"));

        Select select= new Select(search);
        select.selectByIndex(4);

        WebElement searchCopy = webdriver.findElement(By.xpath("/html/body/div[1]/div[2]/main/article/div/p[10]/button"));
        searchCopy.click();

        String whiplash = "https://whiplash.net/materias/whiplash/027002.html";

        Assertions.assertTrue(whiplash.equals(webdriver.getCurrentUrl()));
    }

    @Test
    public void findsByTextTest(){
        webdriver.get("https://www.modab.com.br/politicas-de-privacidade");

        WebElement search = webdriver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[7]/div/div[2]/div[1]/section/div/div[1]/nav/ul/li[4]/div/a"));
        search.click();

    }
}
