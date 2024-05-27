package org.geradorPF.GeradorCpf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.geradorPF.EnumRegions.UF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

class CPFGeneratorTest {

    private static WebDriver driver;

    public CPFGeneratorTest() {
    }

    private static void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // options.addArguments("--headless=new");// para abrir sem GUI
        driver = new ChromeDriver(options);
    }


    @Test
    public void testGeneratedCPF(){
        setupChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CPFNumber cpfNumber = new CPFNumber();
        driver.get("https://www.4devs.com.br/validador_cpf");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        wait.until(
//                ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("txt_cpf"))
//        );
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("bt_validar_cpf")));

        WebElement cpfInput = driver.findElement(By.id("txt_cpf"));
        new Actions(driver).sendKeys(cpfInput,cpfNumber.toString()).perform();

        driver.findElement(By.id("bt_validar_cpf")).click();


        // resposta contem numcpf - Verdadeiro/Falso
        // TODO verificar porque demora o botao trazer uma resposta no click do drive
        wait.until(ExpectedConditions.textMatches(By.id("texto_resposta"), Pattern.compile(cpfNumber.toString())));

        String resposta = driver.findElement(By.id("texto_resposta")).getText();
        Assertions.assertTrue(resposta.contains("Verdadeiro"));

    }
}