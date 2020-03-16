package Desafio4all.Desafio2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Desafio2CenarioErro {

    WebDriver driver;
    WebElement categoriaLista;

    public Desafio2CenarioErro(WebDriver driver) {
        this.driver = driver;
    }


    @Test
    public void selecionaRisoles() {

        categoriaLista = driver.findElement(By.id("open-categories-btn"));
        categoriaLista.click();
        WebElement salgados = driver.findElement(By.id("category-2"));
        salgados.click();

        WebElement salgado = driver.findElement(By.id("add-product-3-btn"));
        salgado.click();

    }

    @Test
    public void validaExclusaoItens() {
        WebElement risolesAdd = driver.findElement(By.id("add-product-3-qtd"));
        for (int i = 0; i <= 3; i++) {
            risolesAdd.click();
        }

        WebElement risolesSub = driver.findElement(By.id("remove-product-3-qtd"));
        for (int i = 0; i <= 4; i++) {
            risolesSub.click();
        }
        String msg = driver.switchTo().alert().getText();
        Assert.assertEquals("Você deseja realmente remover o produto do carrinho?", msg);
    }
}

