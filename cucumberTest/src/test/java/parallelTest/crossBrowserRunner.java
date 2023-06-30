package parallelTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		tags="@tag1",
		monochrome = true,
		glue = { "parallelTest" },
		features = { "src/test/resources/parallelTest" }
)

public class crossBrowserRunner extends AbstractTestNGCucumberTests {
	
	public final static ThreadLocal<String> BROWSER= new ThreadLocal<>();
	
	@BeforeTest
	@Parameters({"Browser"})
	public void defineBrowser(String browser) {
		crossBrowserRunner.BROWSER.set(browser);
	}

}
