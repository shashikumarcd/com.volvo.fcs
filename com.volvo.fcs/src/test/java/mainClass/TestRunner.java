package mainClass;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
//@Cucumber.Options(features="features")
@Cucumber.Options(features="features",glue="cucumberClasses")

public class TestRunner {
    
    
}
