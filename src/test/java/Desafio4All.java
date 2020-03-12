import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Desafio4All extends JUnitTestReporter {

    WebDriver driver;
    Desafio1CenarioCorreto desafio1CenarioCorreto;
    Desafio2 desafio2;
    MetodosDesafios desafioTodos;
    Desafio1CenarioAlternativo desafCenAlt;
    public static int random = 1;
    private String baseURL;

    @BeforeClass
    public static void setting_SystemProperties() {
        System.out.println("System Properties seting Key value.");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Wagner\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");  // Chrome Driver Location.

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Wagner\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");

    }

    // @Before      : To execute once before ever Test.
    @Before
    public void test_Setup() {
        System.out.println("Launching Browser");
        if (random == 1) {
            driver = new ChromeDriver(); // Creates new SessionID & opens the Browser.
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Session ID : " + ((RemoteWebDriver) driver).getSessionId());
    }

    @Before
    public void configuraAcessoBrowser() throws Exception {
        driver.get("https://shopcart-challenge.4all.com/");
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\test.png");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Test
    public void realizaDesafio1() throws Exception {
        desafio1CenarioCorreto = new Desafio1CenarioCorreto(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio1CenarioCorreto.categoriaDoces();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaDoces.png");
        desafio1CenarioCorreto.adicionarItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\addItem.png");
        desafioTodos.categoriaTodos();
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\consultarCarrinho.png");
        desafio1CenarioCorreto.validaPrecoUnitario();
        desafio1CenarioCorreto.aumentaQuantidadeBrigadeiro();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\quanti.png");
        desafio1CenarioCorreto.validaPrecoTotalBrigadeiro();
        desafio1CenarioCorreto.validaPrecoItens();
        desafio1CenarioCorreto.validaSubTotalxTotal();
        desafioTodos.finalizaCompra();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\finalizaCompra.png");

    }

    @Test
    public void realizaDesafio2() throws Exception {
        desafio2 = new Desafio2(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio2.categoriaBebidas();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png");
        desafio2.adicionarBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\bebidas.png");
        desafioTodos.categoriaTodos();
        desafio2.adicionaRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaTodos.png");
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\consultaCarrinho.png");
        desafio2.aumentaQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\aumenta.png");
        desafio2.diminuiQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\diminui.png");

        desafioTodos.finalizaCompra();
    }

    @Test
    public void realizaDesafio1CenAlt() throws Exception {
        desafCenAlt = new Desafio1CenarioAlternativo(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio1CenarioCorreto = new Desafio1CenarioCorreto(driver);
        desafCenAlt.categoriaDoces();
        desafCenAlt.adicaoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaDoces.png");
        desafioTodos.consultaCarrinho();
        desafCenAlt.validaPrecoUnitarioC();
        desafCenAlt.validaPrecoTotalBrigadeiro();
        desafCenAlt.validaPrecoItens();
        desafCenAlt.validaSubTotalxTotal();

        desafioTodos.finalizaCompra();
    }

    @Test
    //se espera que apareça popup de remoção do item, porém não aparece
    public void realizaDesafioCenarioErro(){
    desafioTodos = new MetodosDesafios(driver);
    Desafio1CenarioErro desafErro = new Desafio1CenarioErro(driver);
    desafErro.categoriaDoces();
    desafErro.adicionaItens();
    desafioTodos.consultaCarrinho();
    desafErro.validaExclusaoItens();
    }

    @After
    public void fechaNavegador() {
        driver.quit();
    }
}
