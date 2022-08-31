package automatizacion.tablas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static automatizacion.Constantes.URL_AUTOMATION_TESTING_TABLE;
import static automatizacion.Utilidades.esperar;

public class TablasTest {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void validarCantFilasColumnas(){
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_TABLE);

        //Me entrega una lista, al ser Elements, que guardo en List
        //Se construye el xpath manual, empezando con //. <tr> es fila, <th> es columna
        List columnas = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("La cantidad de columnas de la tabla es: " + columnas.size());

        List filas = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("La cantidad de filas de la tabla es: " + filas.size());
    }

    @Test
    public void consultarValorTabla() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_TABLE);

        WebElement tabla = driver.findElement(By.xpath("//table[@class='dataTable']"));
        WebElement fila = tabla.findElement(By.xpath("//tbody/tr[2]"));
        WebElement celdaEspecifica = tabla.findElement(By.xpath("//tbody/tr[2]/td[1]"));

        System.out.println("Los datos de la fila 2 son: " + fila.getText());
        System.out.println("El dato de una celda de la fila 2 es: " + celdaEspecifica.getText());
        esperar(3);
    }

    @Test
    public void imprimirValoresTabla() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(URL_AUTOMATION_TESTING_TABLE);

        WebElement tabla = driver.findElement(By.xpath("//table[@class='dataTable']"));

        List empresas = tabla.findElements(By.xpath("//tbody/tr/td[1]"));

        for(int i=1 ; i<empresas.size() ; i++){
            System.out.println(tabla.findElement(By.xpath("//tbody/tr["+ i +"]/td[1]")).getText());
        }
        esperar(3);
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
