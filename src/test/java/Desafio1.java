import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.System.*;

public class Desafio1 {

    WebDriver driver;


    @Before
    public void configuraAcessoBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\18190406\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://shopcart-challenge.4all.com/");
    }

    @Test
    public void realizaDesafio(){
        AcessaPagina access = new AcessaPagina(driver);
        RealizaAcoes acoes = new RealizaAcoes(driver);
        acoes.categoriaDoces();
        acoes.adicionarItens();
        acoes.consultaCarrinho();
        acoes.aumentaQuantidadeItens();
        acoes.finalizaCompra();

    }

   // @After
    //public void fechaNavegador(){
      //  driver.quit();
    //}
}
