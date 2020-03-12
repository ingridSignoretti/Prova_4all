import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class Desafio2 {
    private WebDriver driver;
    WebElement categoriaLista;
    WebElement buttonAdicionar;
    WebElement risoles;

    public Desafio2(WebDriver driver) {
        this.driver = driver;
    }
    @Test
    public void categoriaBebidas() {
        categoriaLista = driver.findElement(By.id("open-categories-btn"));
        categoriaLista.click();
        WebElement bebida = driver.findElement(By.id("category-0"));
        bebida.click();
    }

    @Test
    public void adicionarBebida() {
        buttonAdicionar = driver.findElement(By.id("add-product-0-btn"));
        buttonAdicionar.click();

        buttonAdicionar = driver.findElement(By.id("add-product-1-btn"));
        buttonAdicionar.click();

        buttonAdicionar = driver.findElement(By.id("add-product-2-btn"));
        buttonAdicionar.click();
    }

    @Test
    public void adicionaRisoles (){
        WebElement novoItem = driver.findElement(By.id("add-product-3-btn"));
        novoItem.click();
    }

    @Test
    public void aumentaQuantidadeItens() {
        risoles = driver.findElement(By.id("add-product-3-qtd"));
        for (int i = 0; i <= 8; i++) {
            risoles.click();
        }
    }

    @Test
    public void diminuiQuantidadeItens() {
        risoles = driver.findElement(By.id("remove-product-4-qtd"));
        for (int i = 0; i <= 4; i++) {
            risoles.click();
        }


    }
}
