package automatizacion.datosExcel;

import automatizacion.ExcelManager;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeerDatosExcelSql {
    //Se crea la variable del driver, y el atributo del ExcelManager
    public static WebDriver driver;
    private ExcelManager excelManager;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Se agrega también la instancia del excel
        excelManager = new ExcelManager();
    }

    @Test
    public void LeerDatosDesdeExcel() throws FilloException {
        driver.manage().window().maximize();

        // Conexión al excel (BD) a través de la ruta, a la hoja (Tabla), y captura datos en Recordset
        excelManager.strRutaArchivo("src/test/resources/datadriven/datos.xlsx");
        String strSQL = "SELECT * FROM Hoja1";
        Recordset objRecord = excelManager.leerExcel(strSQL);
        System.out.println("Cantidad de registros del archivo: " + objRecord.getCount());
    }

    @After
    public void shutDown() {
        driver.close();
        driver.quit();
    }
}
