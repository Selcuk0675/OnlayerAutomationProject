package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/rerun.txt", // Yeniden çalıştırılacak testleri raporlamak için
                "timeline:target/timeline-report" // Zaman çizelgesi raporu
        },
        monochrome = true,//raporlarin consolda okunakli hale getirmek icin
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@RDM",//"@Demo",//
        dryRun = false
)
public class Runner {


}
