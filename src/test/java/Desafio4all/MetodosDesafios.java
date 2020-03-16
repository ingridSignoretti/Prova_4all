package Desafio4all;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MetodosDesafios {

    private WebDriver driver;
    WebElement categoriaLista;

    public MetodosDesafios(WebDriver driver) {
        this.driver = driver;
    }


    @Test
    public void consultaCarrinho() {
        WebElement buttonCarrinho = driver.findElement(By.id("cart-products-qtd"));
        buttonCarrinho.click();
    }

    @Test
    public void finalizaCompra() {
        WebElement buttonFinalizaCompra = driver.findElement(By.id("finish-checkout-button"));
        buttonFinalizaCompra.click();

        String textoEsperado = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2")).getText();
        Assert.assertEquals("Pedido realizado com sucesso!", textoEsperado);

        WebElement buttonFechar = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button"));
        //String texto = buttonFechar.getText();
        buttonFechar.click();
    }

    @Test
    public void categoriaTodos() {

        categoriaLista = driver.findElement(By.id("open-categories-btn"));
        categoriaLista.click();
        WebElement todos = driver.findElement(By.id("category-all"));
        todos.click();
    }



}
