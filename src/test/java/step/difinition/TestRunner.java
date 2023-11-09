package step.difinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {("C:\\Users\\Dell\\IdeaProjects\\Api\\src\\test\\resources\\Post.feature")}, plugin = {"pretty", "html:target/Api-report.html"},glue = {
        "step.difinition"})
public class TestRunner {

}
