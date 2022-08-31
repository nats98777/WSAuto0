package automatizacion.navegacionFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static automatizacion.Constantes.PRIMER_FRAME_ID;
import static automatizacion.Constantes.URL_AUTOMATION_TESTING_FRAMES;
import static automatizacion.Utilidades.esperar;

public class OneFrameTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void ingresoOneFrame() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.navigate().to(URL_AUTOMATION_TESTING_FRAMES);

        //Paso 2. Se debe navegar (switch) entre los frames. Pararse en el primer frame
        //  ctrl+f en f12 iframe
        driver.switchTo().frame(PRIMER_FRAME_ID);
        esperar(3);

        //Paso 3. Encontrar el campo de texto y escribir en él.
        // Xpath absoluto no es bueno. Ese xpath lo tenían 2 objetos pero por hacer switch al iframe
        // solo se encontrará lo que esté en él
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frame1");
        esperar(3);
    }

    @Test
    public void ingresoTwoFrames() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.navigate().to(URL_AUTOMATION_TESTING_FRAMES);

        //Paso 2. Hacer clic en opción de 2 frames
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();

        //Paso 3. Se debe navegar (switch) entre los frames. Pararse en el primer frame, y luego en el otro
        //  ctrl+f en f12 iframe
        WebElement frame1 = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(frame2);

        //Paso 4. Encontrar el campo de texto. Xpath absoluto no es bueno. Ese xpath lo tenían 2 objetos
        // pero por hacer switch al iframe solo se encontrará lo que esté en él
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frame2");
        esperar(3);

        //Paso 5. Salir de todos los iframes para verificar un texto en la pantalla principal
        driver.switchTo().defaultContent();
        Assert.assertEquals("Automation Demo Site", driver.findElement(By.xpath(
                "//*[@id='header']/div/div/div/div[2]")).getText());
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
