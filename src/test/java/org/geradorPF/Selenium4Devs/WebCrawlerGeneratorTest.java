package org.geradorPF.Selenium4Devs;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.geradorPF.Selenium4Devs.model.GeneratedPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

class WebCrawlerGeneratorTest {
    // TODO TESTAR ARQUIVO
    private final String OUTPUT_FILE = WebCrawlerFourDevsGenerator.OUTPUT_FILE;

    public WebCrawlerGeneratorTest() {

    }

    @Test
    @Description("Test retorno null")
    public void testWebCrawlingIfNull(){
        final int peopleNum = (int) (Math.random() * 30) + 1;
        Set<GeneratedPerson> resultPeople = null;
        try {
            resultPeople = WebCrawlerFourDevsGenerator.genPeople(peopleNum);
        }catch (Exception e){
            Assertions.fail("Foi capturada uma excessão no teste 'testWebCrawling' !",e);
        }
        Assertions.assertFalse(resultPeople == null);
    }

    @Test
    @Description("Test retorno com numero igual ao parametro")
    public void testWebCrawlingIfNumEquals(){
        final int peopleNum = (int) (Math.random() * 30) + 1;
        Set<GeneratedPerson> resultPeople = null;
        try {
            resultPeople = WebCrawlerFourDevsGenerator.genPeople(peopleNum);
        }catch (Exception e){
            Assertions.fail("Foi capturada uma excessão no teste 'testWebCrawling' !",e);
        }
        Assertions.assertEquals(peopleNum,resultPeople.size());
    }



}