package automatizacion.ventanas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automatizacion.Constantes.URL_AUTOMATION_TESTING_WINDOW;
import static automatizacion.Utilidades.esperar;

public class VentanasTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openNewTabWindows() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.navigate().to(URL_AUTOMATION_TESTING_WINDOW);

        //Paso 2. Hacer clic en el botón que abre la nueva pestaña
        driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();

        //A pesar de abrir la otra pestaña, driver seguirá siendo la original, hasta decirle switcTo

        //Paso 3. For sobre las pestañas abiertas, que imprime título e identificador de cada una
        for(String manejadorDeVentanas: driver.getWindowHandles()){
            driver.switchTo().window(manejadorDeVentanas);
            System.out.println("Titulo de la ventana: " + driver.getTitle());
            System.out.println("Identificador de la ventana: " + manejadorDeVentanas);
        }

        //Paso 4. Validar que en la pestaña que quedó (2da) aparezca ese texto
        Assert.assertEquals("Selenium automates browsers. That's it!", driver.findElement
                (By.xpath("//*[@id='td-cover-block-0']/div/div/div/div/h1")).getText());
        //esperar(3);
    }

    @Test
    public void openNewSeparateWindows() throws InterruptedException {
        //Paso 1. Abrir explorador y entrar a la URL
        driver.manage().window().maximize();
        driver.navigate().to(URL_AUTOMATION_TESTING_WINDOW);

        //Paso 2. Hacer clic en la opción de New Separate Windows, y luego en el botón que abre la nueva ventana
        driver.findElement(By.xpath("//a[@href='#Seperate']")).click();
        driver.findElement(By.xpath("//*[@id='Seperate']/button")).click();

        //A pesar de abrir la otra pestaña, driver seguirá siendo la original, hasta decirle switcTo

        //Paso 3. Verificar texto en la ventana original
        Assert.assertEquals("Automation Demo Site", driver.findElement(By.xpath
                ("//*[@id='header']/div/div/div/div[2]/h1")));

        //Paso 4. For sobre las ventanas abiertas, para que quede ubicado en la última
        for(String manejadorDeVentanas: driver.getWindowHandles()){
            driver.switchTo().window(manejadorDeVentanas);
        }

        //Paso 4. Validar que en la ventana que quedó (2da) aparezca ese texto
        Assert.assertEquals("Selenium automates browsers. That's it!", driver.findElement
                (By.xpath("//*[@id='td-cover-block-0']/div/div/div/div/h1")).getText());
        //esperar(3);
    }

    @Test
    public void openSeparateMulWindows() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to(URL_AUTOMATION_TESTING_WINDOW);

        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        driver.findElement(By.xpath("//*[@id='Multiple']/button")).click();

        int i = 1;
        for(String manejadorDeVentanas: driver.getWindowHandles()){
            driver.switchTo().window(manejadorDeVentanas);
            System.out.println("La url de la ventana " + i +" es: "+ driver.getCurrentUrl());
            i++;
        }
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
