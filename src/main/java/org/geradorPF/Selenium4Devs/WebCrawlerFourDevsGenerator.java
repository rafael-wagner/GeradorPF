package org.geradorPF.Selenium4Devs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geradorPF.Selenium4Devs.model.GeneratedPerson;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;


public class WebCrawlerFourDevsGenerator {

    WebDriver driver;
    private static final ObjectMapper mapper = new ObjectMapper();
    public static final String OUTPUT_FILE = "./fileOutput/jsonFile";
    private static final Logger logger
            = LoggerFactory.getLogger(WebCrawlerFourDevsGenerator.class);

    private void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // options.addArguments("--headless=new");// para abrir sem GUI
        this.driver = new ChromeDriver(options);
    }

    public void genPerson(int numPeople){

        if(numPeople < 1 || numPeople > 29){
            logger.error("Foi colocado uma quantidade incorreta");
            throw new RuntimeException();
        }

        setupChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.4devs.com.br/gerador_de_pessoas");
        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("app-wrapper")));
        WebElement inputQtd = driver.findElement(By.id("txt_qtde"));
        inputQtd.clear();
        new Actions(driver)
                .sendKeys(inputQtd, String.valueOf(numPeople))
                .perform();

        driver.findElement(By.id("bt_gerar_pessoa"))
                .click();

        wait.until(nav -> !nav.findElement(By.id("dados_json")).getText().contains("Gerando"));

        String generatedJson = driver.findElement(By.id("dados_json"))
                .getText();

        TypeReference<HashSet<GeneratedPerson>> reference = new TypeReference<>(){};
        Set<GeneratedPerson> generatedPeopleList;
        try {
            generatedPeopleList = mapper.readValue(generatedJson,reference);
        } catch (JsonProcessingException e) {
            logger.error("Não foi possivel mapear o texto no elemento id = 'dados_json'");
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }

        this.saveToFile(generatedPeopleList);
        driver.quit();
        //https://www.4devs.com.br/gerador_de_pessoas
    }

    void saveToFile(Set<GeneratedPerson> peopleList){
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(
                        new File(OUTPUT_FILE),
                        peopleList
                );

                logger.debug("arquivo json escrito");
            } catch (IOException e) {
                logger.error("Falha ao escrever arquivo :", e);
            }
    }

}
