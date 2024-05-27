package org.geradorPF.Selenium4Devs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.geradorPF.Selenium4Devs.model.GeneratedPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class WebCrawlerGeneratorTest {
    private static final ObjectMapper mapper = new ObjectMapper();

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
            Assertions.fail("Foi capturada uma excessão no teste 'testWebCrawlingIfNull' !",e);
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
            Assertions.fail("Foi capturada uma excessão no teste 'testWebCrawlingIfNumEquals' !",e);
        }
        Assertions.assertEquals(peopleNum,resultPeople.size());
    }

    @Test
    @Description("Test arquivo escrito")
    public void testWrittenFile(){
        final int peopleNum = (int) (Math.random() * 30) + 1;
        Set<GeneratedPerson> resultPeople = null;
        try {
            resultPeople = WebCrawlerFourDevsGenerator.genPeople(peopleNum);
        }catch (Exception e){
            Assertions.fail("Foi capturada uma excessão no teste 'testWebCrawling' !",e);
        }

        TypeReference<HashSet<GeneratedPerson>> reference = new TypeReference<>(){};
        Set<GeneratedPerson> filePeople = null;
        try {
            filePeople = mapper.readValue(
                    new File(WebCrawlerFourDevsGenerator.OUTPUT_FILE)
                    ,reference);
        } catch (IOException e) {
            Assertions.fail("Foi capturada uma excessão no teste 'testWrittenFile' !",e);
        }


        Assertions.assertEquals(filePeople,resultPeople);

    }



}