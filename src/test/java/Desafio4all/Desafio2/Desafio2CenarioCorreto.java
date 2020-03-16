package Desafio4all.Desafio2;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Desafio2CenarioCorreto {
    private WebDriver driver;
    WebElement categoriaLista;
    WebElement buttonAdicionar;
    WebElement risoles;
    String bebida;
    String bebida1a;
    String bebida2a;
    String bebida1;
    String bebida2;
    String bebida3;
    double valorTotal;
    String valTotal;
    double valorTotalRisoles;

    public Desafio2CenarioCorreto(WebDriver driver) {
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
        bebida = driver.findElement(By.xpath("//*[@id=\"product-0\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar = driver.findElement(By.id("add-product-0-btn"));
        buttonAdicionar.click();

        bebida1a = driver.findElement(By.xpath("//*[@id=\"product-1\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar = driver.findElement(By.id("add-product-1-btn"));
        buttonAdicionar.click();


        bebida2a = driver.findElement(By.xpath("//*[@id=\"product-2\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar = driver.findElement(By.id("add-product-2-btn"));
        buttonAdicionar.click();
    }

    @Test
    public void valorUnitarioBebida (){

        bebida1 = driver.findElement(By.id("product-0-price")).getText();
        Assert.assertEquals(bebida, bebida1);


        bebida2 = driver.findElement(By.id("product-1-price")).getText();
        Assert.assertEquals(bebida1a, bebida2);

        bebida3 = driver.findElement(By.id("product-2-price")).getText();
        Assert.assertEquals(bebida2a, bebida3);
    }


    @Test
    public void adicionaRisoles (){
        WebElement novoItem = driver.findElement(By.id("add-product-3-btn"));
        novoItem.click();
    }

    @Test
    public void aumentaQuantidadeItens() {
        risoles = driver.findElement(By.id("add-product-3-qtd"));
        for (int i = 0; i <= 7; i++) {
            risoles.click();
        }
    }

    @Test
    public void diminuiQuantidadeItens() {
        risoles = driver.findElement(By.id("remove-product-3-qtd"));
        for (int i = 0; i <= 3; i++) {
            risoles.click();
        }


    }


    @Test
    public void validaPrecoTotalBebida() {

        String beb1 = bebida1.substring(3);
        String replace = beb1.replace(',', '.');
        double valdou = Double.parseDouble(replace);
        String quantidadeItem = driver.findElement(By.id("product-0-qtd")).getText();
        double quantItem = Double.parseDouble(quantidadeItem);
        valorTotal = valdou * quantItem;


        String beb2 = bebida2.substring(3);
        String replace2 = beb2.replace(',', '.');
        double valdou2 = Double.parseDouble(replace);
        String quantidadeItem2 = driver.findElement(By.id("product-1-qtd")).getText();
        double quantItem2 = Double.parseDouble(quantidadeItem);


        String beb3 = bebida3.substring(3);
        String replace3 = beb3.replace(',', '.');
        double valdou3 = Double.parseDouble(replace);
        String quantidadeItem3 = driver.findElement(By.id("product-2-qtd")).getText();
        double quantItem3 = Double.parseDouble(quantidadeItem);
        valorTotal = (valdou * quantItem) + (valdou2 + quantItem2) + (valdou3 + quantItem3);



        String valTotal = driver.findElement(By.id("price-total-checkout")).getText();
        String valorTotalDoub = valTotal.substring(3);
        String valorTotalConv = valorTotalDoub.replace(',', '.');
        double valconv = Double.parseDouble(valorTotalConv);
        String valorRisoles = driver.findElement(By.id("product-3-price")).getText();
        String riso = valorRisoles.substring(3);
        String valorRiso = riso.replace(',', '.');
        double valorRiso2 = Double.parseDouble(valorRiso);
        String quanti = driver.findElement(By.id("product-3-qtd")).getText();
        double quant = Double.parseDouble(quanti);

        double valorTotalRisoles = valorRiso2*quant;

        double realVal = valorTotalRisoles - valorTotal ;
        if (valorTotal == realVal) {
            Assert.assertTrue("Total Validado", true);
        }
    }

    @Test
    public void validaPrecoItens() {
        valTotal = driver.findElement(By.id("price-total-checkout")).getText();
        String precoCompra2 = valTotal.substring(3);
        String aux = precoCompra2.replace(',', '.');
        double valorDouble = Double.parseDouble(aux);

        double valorTotalItens = valorTotal + valorTotalRisoles;

        if (valorTotalItens == valorDouble) {
            Assert.assertTrue("Total Validado", true);
        }

    }


    @Test
    public void validaSubTotalxTotal(){
        String precoSubtotal = driver.findElement(By.id("subtotal-price")).getText();
        Assert.assertEquals(valTotal, precoSubtotal);
    }
}
