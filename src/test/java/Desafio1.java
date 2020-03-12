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
    AcessaPagina access;
    RealizaAcoes acoes;

    public Desafio1(AcessaPagina access, RealizaAcoes acoes){
        access = new AcessaPagina(driver);
        acoes = new RealizaAcoes(driver);

    }

    @Before
    public void configuraAcessoBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\18190406\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://shopcart-challenge.4all.com/");
    }

    @Test
    public void realizaDesafio1(){
        access.acessoLink("https://shopcart-challenge.4all.com/");
        acoes.categoriaDoces();
        acoes.adicionarItens();
        acoes.consultaCarrinho();
        acoes.aumentaQuantidadeItens();
        acoes.finalizaCompra();

    }

    @Test
    public void realizaDesafio2(){
        access = new AcessaPagina(driver);

    }

   // @After
    //public void fechaNavegador(){
      //  driver.quit();
    //}
}
