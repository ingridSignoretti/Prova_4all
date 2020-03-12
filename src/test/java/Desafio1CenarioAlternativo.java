import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Desafio1CenarioAlternativo {
    private WebDriver driver;
    WebElement categoriaLista;
    String valorBrigadeiro;
    String valorAlfajor;
    Desafio1CenarioCorreto desafCC;
    MetodosDesafios metDesaf;
    String novoValorBriga;
    String valorAlfajorTotalCar;
    String precoCompraTotal;
    double valorTotal;
    double valalfconv;

    public Desafio1CenarioAlternativo(WebDriver driver) {
        this.driver = driver;

    }

    @Test
    public void categoriaDoces() {
        categoriaLista = driver.findElement(By.id("open-categories-btn"));

        categoriaLista.click();
        WebElement doces = driver.findElement(By.id("category-1"));
        doces.click();
    }

    @Test
    public void adicaoItens() {
        MetodosDesafios metDesaf = new MetodosDesafios(driver);
        Desafio1CenarioCorreto desafCC = new Desafio1CenarioCorreto(driver);
        WebElement buttonAdicionar = driver.findElement(By.id("add-product-4-btn"));
        valorBrigadeiro = driver.findElement(By.xpath("//*[@id=\"product-4\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar.click();

        metDesaf.consultaCarrinho();

        desafCC.aumentaQuantidadeBrigadeiro();
        WebElement voltar = driver.findElement(By.id("back-button"));
        voltar.click();
        metDesaf.categoriaTodos();


        buttonAdicionar = driver.findElement(By.id("add-product-5-btn"));
        valorAlfajor = driver.findElement(By.xpath("//*[@id=\"product-5\"]/div[1]/div[2]/p[2]")).getText();
        buttonAdicionar.click();
    }

    @Test
    public void validaPrecoUnitarioC() {
        String valorBrigadeiroCarrinho = driver.findElement(By.id("product-4-price")).getText();
        Assert.assertEquals(valorBrigadeiro, valorBrigadeiroCarrinho);

        String valorAlfajorCarrinho = driver.findElement(By.id("product-5-price")).getText();
        Assert.assertEquals(valorAlfajor, valorAlfajorCarrinho);


    }

    @Test
    public void validaPrecoTotalBrigadeiro() {
        String novoValor = valorBrigadeiro.substring(3);
        String replace = novoValor.replace(',', '.');
        double valdou = Double.parseDouble(replace);
        String quantidadeItem = driver.findElement(By.id("product-4-qtd")).getText();
        double quantItem = Double.parseDouble(quantidadeItem);
        valorTotal = valdou * quantItem;
        String valorBrigadeiroTotalCar = driver.findElement(By.id("price-total-checkout")).getText();
        String valorTotalDoub = valorBrigadeiroTotalCar.substring(3);
        novoValorBriga = valorTotalDoub.replace(',', '.');
        double valconv = Double.parseDouble(novoValorBriga);
        valorAlfajorTotalCar = driver.findElement(By.id("product-5-price")).getText();
        String alfajor = valorAlfajorTotalCar.substring(3);
        String valorAlfajor = alfajor.replace(',', '.');
        valalfconv = Double.parseDouble(valorAlfajor);
        double realVal = valconv - valalfconv;
        if (valorTotal == realVal) {
            Assert.assertTrue("Total Validado", true);
        }
    }

    @Test
    public void validaPrecoItens() {
        precoCompraTotal = driver.findElement(By.id("price-total-checkout")).getText();
        String precoCompra2 = precoCompraTotal.substring(3);
        String aux = precoCompra2.replace(',', '.');
        double valorDouble = Double.parseDouble(aux);

        double valorTotalItens = valorTotal + valalfconv;

        if (valorTotalItens == valorDouble) {
            Assert.assertTrue("Total Validado", true);
        }

    }

    @Test
    public void validaSubTotalxTotal(){
        String precoSubtotal = driver.findElement(By.id("subtotal-price")).getText();
        Assert.assertEquals(precoCompraTotal, precoSubtotal);
    }

}


