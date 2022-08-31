package automatizacion.autenticacion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automatizacion.Constantes.*;
import static automatizacion.Utilidades.esperar;

public class AutenticacionPaginaWebDriverManager {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void autenticacionExitosa() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_LOGIN);
        driver.findElement(By.id(TXT_USERNAME_AUTOMATION_ID)).sendKeys("namaga12@gmail.com");
        driver.findElement(By.id(TXT_PASSWORD_AUTOMATION_ID)).sendKeys("12345678*Natalia");
        driver.findElement(By.name(BTN_LOGIN_AUTOMATION_NAME)).click();
        Assert.assertEquals(MENS_EXITO_AUTOMATION, driver.findElement(By.xpath(TXT_MSG_EXITO_AUTOMATION_XPATH)).getText());
        esperar(5);
    }

    @Test
    public void autenticacionFallida() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_LOGIN);
        driver.findElement(By.id(TXT_USERNAME_AUTOMATION_ID)).sendKeys("namaga12@gmail.com");
        driver.findElement(By.id(TXT_PASSWORD_AUTOMATION_ID)).sendKeys("claveErronea");
        driver.findElement(By.name(BTN_LOGIN_AUTOMATION_NAME)).click();
        Assert.assertEquals(MENS_ERROR_AUTOMATION, driver.findElement(By.xpath(TXT_MSG_ERROR_AUTOMATION_XPATH)).getText());
        //Assert.assertTrue(MENSAJE_ESPERADO.contains(driver.findElement(By.xpath(xpath de una parte).getText())))
        esperar(5);
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
