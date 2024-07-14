package com.company.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber/reports-my-project.html",
                "rerun:target/rerun.txt",
                "junit:target/junit/junit-report.xml",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/company/step_definitions",
        dryRun = false,
        tags = "@smoke",
        publish = true

)
public class CukesRunner {

}
