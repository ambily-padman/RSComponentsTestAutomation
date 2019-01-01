package com.rscomponents;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/features",plugin = {"pretty","html:target/cucumber"},glue=
        {"com.rscomponents.rscomponentsUI.steps"},tags = "@Test4")

public class TestRunner {
}
