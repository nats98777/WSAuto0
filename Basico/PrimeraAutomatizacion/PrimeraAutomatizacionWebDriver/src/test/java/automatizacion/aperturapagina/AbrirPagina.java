package automatizacion.aperturapagina;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirPagina {
    public static void main(String[] args) throws InterruptedException {
        //Paso 1. Configurar driver de chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Natalia Martinez\\Desktop\\PrimeraAutomatizacion\\PrimeraAutomatizacionWebDriver\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Paso2. Maximizar página
        driver.manage().window().maximize();

        //Paso 3. Abrir la URL
        driver.get("https://automationtesting.in/");

        //Paso 4. Clic en un link
        driver.findElement(By.linkText("Demo Site")).click();

        //driver.switchTo().frame("aswift_4");
        //driver.switchTo().frame("ad_frame");
        //driver.findElement(By.id("dismiss-button")).click();
        //driver.switchTo().defaultContent()

        //Paso mañoso - Espera
        Thread.sleep(5000);

        //Paso final. Cerrar driver
        driver.close();
        driver.quit();
    }
}
