package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.Log;

public class Hooks {


    @Before
    public void setUp(Scenario scenario){
        //Driver başlatılmalı
        Log.info("***** Starting scenario =>> " + scenario.getName());
        DriverManager.initializeDriver();
    }

    @After
    public void afterDown(){
        DriverManager.quitDriver();
        Log.info("****** SEnaryo sonlandi ***********");
    }
}
