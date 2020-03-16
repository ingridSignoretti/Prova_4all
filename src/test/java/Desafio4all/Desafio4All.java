package Desafio4all;

import Desafio4all.Desafio1.Desafio1CenarioAlternativo;
import Desafio4all.Desafio1.Desafio1CenarioCorreto;
import Desafio4all.Desafio1.Desafio1CenarioErro;
import Desafio4all.Desafio2.Desafio2CenarioAlternativo;
import Desafio4all.Desafio2.Desafio2CenarioCorreto;
import Desafio4all.Desafio2.Desafio2CenarioErro;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Desafio4All extends JUnitTestReporter {

    WebDriver driver;
    Desafio1CenarioCorreto desafio1CenarioCorreto;
    Desafio2CenarioCorreto desafio2CenarioCorreto;
    MetodosDesafios desafioTodos;
    Desafio1CenarioAlternativo desafCenAlt;
    Desafio2CenarioAlternativo desafio2cenarioalt;
    private String baseURL;


    @Before
    public void test_Setup() {
        System.out.println("Launching Browser");

        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver(); // Creates new SessionID & opens the Browser.

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Session ID : " + ((RemoteWebDriver) driver).getSessionId());
    }

    @Before
    public void configuraAcessoBrowser() throws Exception {
        driver.get("https://shopcart-challenge.4all.com/");
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\test.png"); // trocar endereço do repositório local
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
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\categoriaDoces.png");  // trocar endereço do repositório local
        desafio1CenarioCorreto.adicionarItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\addItem.png");  // trocar endereço do repositório local
        desafioTodos.categoriaTodos();
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\consultarCarrinho.png");  // trocar endereço do repositório local
        desafio1CenarioCorreto.validaPrecoUnitario();
        desafio1CenarioCorreto.aumentaQuantidadeBrigadeiro();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\quanti.png");  // trocar endereço do repositório local
        desafio1CenarioCorreto.validaPrecoTotalBrigadeiro();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png");  // trocar endereço do repositório local
        desafio1CenarioCorreto.validaPrecoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png");  // trocar endereço do repositório local
        desafio1CenarioCorreto.validaSubTotalxTotal();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png");  // trocar endereço do repositório local
        desafioTodos.finalizaCompra();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\finalizaCompra.png");  // trocar endereço do repositório local

    }

    @Test
    public void realizaDesafio1CenAlt() throws Exception {
        desafCenAlt = new Desafio1CenarioAlternativo(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio1CenarioCorreto = new Desafio1CenarioCorreto(driver);
        desafCenAlt.categoriaDoces();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafCenAlt.adicaoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaDoces.png"); // trocar endereço do repositório local
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafCenAlt.validaPrecoUnitarioC();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafCenAlt.validaPrecoTotalBrigadeiro();
        desafCenAlt.validaPrecoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafCenAlt.validaSubTotalxTotal();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local

        desafioTodos.finalizaCompra();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
    }

    @Test
    //se espera que apareça popup de remoção do item, porém não aparece
    public void realizaDesafioCenarioErro() throws Exception {
        desafioTodos = new MetodosDesafios(driver);
        Desafio1CenarioErro desafErro = new Desafio1CenarioErro(driver);
        desafErro.categoriaDoces();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafErro.adicionaItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafErro.validaExclusaoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
    }

    @Test
    public void realizaDesafio2() throws Exception {
        desafio2CenarioCorreto = new Desafio2CenarioCorreto(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio2CenarioCorreto.categoriaBebidas();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.adicionarBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\bebidas.png"); // trocar endereço do repositório local
        desafioTodos.categoriaTodos();
        desafio2CenarioCorreto.adicionaRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaTodos.png"); // trocar endereço do repositório local
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.valorUnitarioBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\consultaCarrinho.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.aumentaQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\aumenta.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.diminuiQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\diminui.png"); // trocar endereço do repositório local

        desafio2CenarioCorreto.validaPrecoTotalBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.validaPrecoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.validaSubTotalxTotal();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafioTodos.finalizaCompra();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
    }

    @Test
    public void realizaDesafio2Alt() throws Exception {
        desafio2CenarioCorreto = new Desafio2CenarioCorreto(driver);
        desafioTodos = new MetodosDesafios(driver);
        desafio2cenarioalt = new Desafio2CenarioAlternativo(driver);
        desafio2CenarioCorreto.categoriaBebidas();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.adicionarBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2cenarioalt.selecionaRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2cenarioalt.excluiRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2cenarioalt.selecionaRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.aumentaQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.diminuiQuantidadeItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.valorUnitarioBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.validaPrecoTotalBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.validaPrecoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.validaSubTotalxTotal();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local


        desafioTodos.finalizaCompra();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local

    }

    @Test
    public void realizaDesafioErro() throws Exception {
        desafioTodos = new MetodosDesafios(driver);
        desafio2CenarioCorreto = new Desafio2CenarioCorreto(driver);
        Desafio2CenarioErro desaf2erro = new Desafio2CenarioErro(driver);
        desafio2CenarioCorreto.categoriaBebidas();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desafio2CenarioCorreto.adicionarBebida();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\bebidas.png"); // trocar endereço do repositório local
        desafioTodos.categoriaTodos();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desaf2erro.selecionaRisoles();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png");
        desafioTodos.consultaCarrinho();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
        desaf2erro.validaExclusaoItens();
        this.takeSnapShot(driver, "C:\\Users\\Wagner\\Documents\\prints\\categoriaBebidas.png"); // trocar endereço do repositório local
    }

    @After
    public void fechaNavegador() {
        driver.quit();
    }
}
