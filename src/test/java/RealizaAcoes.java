import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RealizaAcoes {
    private WebDriver driver;
    public RealizaAcoes(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    public void categoriaDoces(){
        WebElement categoriaLista = driver.findElement(By.id("open-categories-btn"));
        categoriaLista.click();
        WebElement doces = driver.findElement(By.id("category-1"));
        doces.click();
    }

    @Test
    public void adicionarItens(){
        WebElement buttonAdicionar = driver.findElement(By.id("add-product-4-btn"));
        buttonAdicionar.click();

        buttonAdicionar = driver.findElement(By.id("add-product-5-btn"));
        buttonAdicionar.click();
    }

    @Test
    public void consultaCarrinho(){
        WebElement buttonCarrinho = driver.findElement(By.id("cart-products-qtd"));
        buttonCarrinho.click();
    }

    @Test
    public void aumentaQuantidadeItens(){
        WebElement brigadeiro = driver.findElement(By.id("add-product-4-qtd"));
        brigadeiro.click();
        brigadeiro.click();
        brigadeiro.click();

    }

    @Test
    public void finalizaCompra(){
        WebElement buttonFinalizaCompra = driver.findElement(By.id("finish-checkout-button"));
        buttonFinalizaCompra.click();

        String textoEsperado = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2")).getText();
        Assert.assertEquals("Pedido realizado com sucesso!", textoEsperado);

        WebElement buttonFechar = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button"));
        //String texto = buttonFechar.getText();
        buttonFechar.click();
    }

}
