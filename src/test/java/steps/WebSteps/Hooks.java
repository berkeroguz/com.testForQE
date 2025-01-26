package steps.WebSteps;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static utils.DriverManager.getDriver;

public class Hooks {


    public static ThreadLocal<String> scenarioName = new ThreadLocal<>();
    public static List<String> failedScenarios = new ArrayList<>();
    @Before
    public void setUp(Scenario scenario){
        scenarioName.set(scenario.getName().replace(" ","_"));
        //Driver başlatılmalı
        Log.info("***** Senaryo Başlatiliyor =>> " + scenario.getName());
        DriverManager.initializeDriver(System.getProperty("browser"));
    }

    @After
    public void afterDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenarioName.get()+"-screenshots");
            Log.info("Hatalı yerin ekran görüntüsü alındı !");
            //failedScenarios.add(scenarioName.get()+".mp4");

        }
        failedScenarios.add(scenarioName.get()+".mp4");
        DriverManager.quitDriver();
        Log.info("***********  "+ scenarioName.get() +" isimli senaryo sonlandi ***********");
    }

    @AfterAll
    public static void afterAll(){
        if(System.getProperty("browser").equals("remote")){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(String each : failedScenarios){
                try {
                    String commandLine = "docker cp mySelenoid:/opt/selenoid/video/"+each+ " ./videos/";
                    System.out.println(commandLine);
                    ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",commandLine);
                    Process process = pb.start();

                    // Hata varsa çıktısını konsola yazdıracağız.
                    String line;
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    while ((line = errorReader.readLine()) != null) {
                        System.err.println(line);
                    }
                    process.waitFor();
                } catch (IOException | InterruptedException e) {
                }
            }
        }
        else{
            Log.info("----- Localde çalışıldığı için video kaydedilmedi !! --------");
        }

    }

}
