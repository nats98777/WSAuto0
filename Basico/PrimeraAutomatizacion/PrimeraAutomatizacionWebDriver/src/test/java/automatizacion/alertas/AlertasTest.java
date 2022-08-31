package automatizacion.alertas;

import automatizacion.Utilidades;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automatizacion.Constantes.MENS_EN_ALERTA;
import static automatizacion.Constantes.URL_AUTOMATION_TESTING_ALERT;
import static automatizacion.Utilidades.esperar;

public class AlertasTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void gestionarAlertaWithOk() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_ALERT);

        //Paso 2. Ya está en pestaña Alert with OK. Hacer clic en botón que despliega alerta
        driver.findElement(By.xpath("//*[@id='OKTab']/button")).click();

        //Paso 3. Muestra la ventana, entonces toca pararse en ella, y hacer clic en Aceptar
        Alert alerta = driver.switchTo().alert();
        alerta.accept();
        esperar(3);
    }

    @Test
    public void gestionarAlertaWithOkAndCancel() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_ALERT);

        //Paso 2. Hacer clic en pestaña Alert with Ok & Cancel
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();

        //Paso 3. Hacer clic en botón que despliega alerta
        driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();

        //Paso 4. Hacer clic en Aceptar. (Primero debo pararme en ella)
        Alert alerta = driver.switchTo().alert();
        esperar(3);
        alerta.accept();

        //Paso 5. Verificar mensaje "You pressed OK"
        Assert.assertEquals("You pressed Ok", driver.findElement(By.id("demo")).getText());

        //Paso 6. Desplegar la alerta otra vez (igual que Paso 3), y hacer clic ahora en Cancelar
        driver.findElement(By.xpath("//*[@id='CancelTab']/button")).click();
        esperar(3);
        alerta.dismiss();

        //Paso 7. Verificar mensaje "You Pressed Cancel"
        Assert.assertEquals("You Pressed Cancel", driver.findElement(By.id("demo")).getText());
    }

    @Test
    public void gestionarAlertaWithTextbox() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_ALERT);

        //Paso 2. Hacer clic en pestaña Alert with Textbox
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();

        //Paso 3. Hacer clic en botón que despliega alerta
        driver.findElement(By.xpath("//*[@id='Textbox']/button")).click();

        //Paso 4. Escribir en el textbox, y hacer clic en Aceptar. (Primero debo pararme en ella)
        Alert alerta = driver.switchTo().alert();
        alerta.sendKeys(MENS_EN_ALERTA);
        alerta.accept();
        esperar(3);

        //Paso 5. Verificar mensaje "Hello *** How are you today"
        Assert.assertEquals("Hello " + MENS_EN_ALERTA + " How are you today",
                driver.findElement(By.id("demo1")).getText());
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}