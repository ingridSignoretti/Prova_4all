import com.gargoylesoftware.htmlunit.WebWindow;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Desafio1CenarioErro {
    WebDriver driver;
    public Desafio1CenarioErro(WebDriver driver){
        this.driver = driver;
    }

    public void categoriaDoces() {
        WebElement categoriaLista = driver.findElement(By.id("open-categories-btn"));

        categoriaLista.click();
        WebElement doces = driver.findElement(By.id("category-1"));
        doces.click();
    }

    @Test
    public void adicionaItens() {
        WebElement buttonAdicionar = driver.findElement(By.id("add-product-4-btn"));
        String valorBrigadeiro = driver.findElement(By.xpath("//*[@id=\"product-4\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar.click();

        buttonAdicionar = driver.findElement(By.id("add-product-5-btn"));
        String valorAlfajor = driver.findElement(By.xpath("//*[@id=\"product-5\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar.click();
    }

    @Test
    public void validaExclusaoItens(){
        WebElement brigadeiroAdd = driver.findElement(By.id("add-product-4-qtd"));
        for (int i = 0; i <= 3; i++) {
            brigadeiroAdd.click();
        }

        WebElement brigadeiroSub = driver.findElement(By.id("remove-product-4-qtd"));
        for (int i = 0; i <= 4; i++) {
            brigadeiroSub.click();
        }
        String msg =  driver.switchTo().alert().getText();
        Assert.assertEquals("Você deseja realmente remover o produto do carrinho?", msg);

    }
}
