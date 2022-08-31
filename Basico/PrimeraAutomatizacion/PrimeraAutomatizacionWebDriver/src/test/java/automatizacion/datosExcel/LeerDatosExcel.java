package automatizacion.datosExcel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static automatizacion.Constantes.TXT_FIRST_NAME_ID;
import static automatizacion.Constantes.URL_KATALON;
import static automatizacion.Utilidades.esperar;

public class LeerDatosExcel {

    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void leerDatosExcel() throws IOException, InterruptedException {
        //Definir ruta de datos dentro de archivo de Excel que se quieren usar en el test
        String rutaArchivo = "src/test/resources/datadriven/datos.xlsx";

        //Variable que abre archivo
        FileInputStream archivo = new FileInputStream(rutaArchivo);

        //Tomar libro del archivo
        Workbook libro = new XSSFWorkbook(archivo);

        //Definir hoja en la que se va a trabajar. Empieza desde el cero (0)
        Sheet hoja = libro.getSheetAt(0);

        //Definir fila con la que se va a interactuar (0,1,2...). Desde la 1 porque la 0 son los encabezados
        Row fila = hoja.getRow(1);

        //Conocer número de filas
        int rowCount = hoja.getLastRowNum() + hoja.getFirstRowNum();

        //Usar datos en la pantalla
        driver.manage().window().maximize();
        driver.navigate().to(URL_KATALON);
        //Concatena espacio en blanco para forzar que la cell sea string
        driver.findElement(By.id(TXT_FIRST_NAME_ID)).sendKeys("" + fila.getCell(0));
        esperar(3);

        ////// TAREA 1: TERMINAR DE DILIGENCIAR EL FORMULARIO CON LOS DATOS DE LA PRIMERA FILA

        //Al final siempre se debe cerrar el archivo
        archivo.close();

    }

    /////// TAREA 2: Intentar hacer iteraciones de llenar el formulario con varias filas de datos
    @Test
    public void leerDatosExcel2() throws IOException, InterruptedException {
        //Definir ruta de datos dentro de archivo de Excel que se quieren usar en el test
        String rutaArchivo = "src/test/resources/datadriven/datos.xlsx";

        //Variable que abre archivo
        FileInputStream archivo = new FileInputStream(rutaArchivo);

        //Tomar libro del archivo
        Workbook libro = new XSSFWorkbook(archivo);

        //Definir hoja en la que se va a trabajar. Empieza desde el cero (0)
        Sheet hoja = libro.getSheetAt(0);

        //Definir fila con la que se va a interactuar (0,1,2...). Desde la 1 porque la 0 son los encabezados
        Row fila = hoja.getRow(1);

        //Conocer número de filas
        int rowCount = hoja.getLastRowNum() + hoja.getFirstRowNum();

        //Usar datos en la pantalla
        driver.manage().window().maximize();
        driver.navigate().to(URL_KATALON);
        //Concatena espacio en blanco para forzar que la cell sea string
        driver.findElement(By.id(TXT_FIRST_NAME_ID)).sendKeys("" + fila.getCell(0));
        esperar(3);

        ////// TAREA 1: TERMINAR DE DILIGENCIAR EL FORMULARIO CON LOS DATOS DE LA PRIMERA FILA

        //Al final siempre se debe cerrar el archivo
        archivo.close();

    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
