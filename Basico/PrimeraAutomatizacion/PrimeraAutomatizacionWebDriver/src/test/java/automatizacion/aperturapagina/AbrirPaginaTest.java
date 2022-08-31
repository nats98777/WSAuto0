package automatizacion.aperturapagina;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirPaginaTest {
    public static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void abrirPaginaTest(){
        driver.manage().window().maximize();
        driver.get("https://automationtesting.in/");
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
