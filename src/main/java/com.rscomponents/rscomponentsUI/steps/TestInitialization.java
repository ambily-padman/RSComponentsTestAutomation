package com.rscomponents.rscomponentsUI.steps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestInitialization {
    //this class is required to  init spring cucumber
    @Before
    public void setUp() {
        System.out.println("TestInitialization init");
    }

    }
