package automatizacion.diligenciarFormulario;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static automatizacion.Constantes.*;
import static automatizacion.Utilidades.esperar;

public class FormularioKatalon {
    public static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty(CHROME_DRIVER,RUTA_DRIVER);
        this.driver = new ChromeDriver();
    }

    @Test
    public void diligenciarFormularioKatalon() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL_KATALON);
        esperar(2);
        driver.findElement(By.id(TXT_FIRST_NAME_ID)).sendKeys("Natalia");
        driver.findElement(By.id(TXT_LAST_NAME_ID)).sendKeys("Martinez");
        driver.findElement(By.xpath(RDB_FEMALE_XPATH)).click();
        driver.findElement(By.id(TXT_BIRTHDATE_ID)).sendKeys("01/23/1998");
        driver.findElement(By.id(TXT_ADDRESS_ID)).sendKeys("Cra 5a #6-3");
        driver.findElement(By.id(TXT_EMAIL_ID)).sendKeys("correo@mail.com");
        driver.findElement(By.id(TXT_PASSWORD_ID)).sendKeys("Clave12345");
        driver.findElement(By.id(TXT_COMPANY_ID)).sendKeys("Proyectos SAS");

        Select Role = new Select(driver.findElement(By.id(CMB_ROL_ID)));
        Role.selectByVisibleText("Manager");

        Select Expectation = new Select(driver.findElement(By.id(LST_JOB_ID)));
        Expectation.selectByVisibleText("Good teamwork");
        //Expectation.selectByIndex(4);

        driver.findElement(By.xpath(CHK_ONLINE_XPATH)).click();
        driver.findElement(By.id(TXT_COMMENT_ID)).sendKeys("Comentario de prueba");
        driver.findElement(By.id(BTN_SUBMIT_ID)).click();

        Assert.assertEquals(MENS_EXITOSO, driver.findElement(By.id(TXT_MSG_EXITO_ID)).getText());
        esperar(5);
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
