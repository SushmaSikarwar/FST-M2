package Examples;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
// With single package name
@SelectPackages("Examples")
// With multiple packages
@SelectPackages({"SmokeTests", "CalculatorTests"})

public class TestSuiteExampleWithSelectPackages {
}