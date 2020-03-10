import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AcessaPagina {

    private WebDriver driver;
    public AcessaPagina(WebDriver driver){
        this.driver = driver;

    }

    public AcessaPagina acessoLink(String link){
        driver.get(link);
        return this;
    }



}
