package Examples;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;

@RunWith(JUnitPlatform.class)
// With a single class
@SelectClasses(Examples.Calculator.class)

// With multiple classes
@RunWith(JUnitPlatform.class)
@SelectClasses({
        Examples.Calculator.class,
        Examples.Person.class,
        Examples.CalculatorTest.class
})
public class TestSuiteExampleWithSelectClasses {
}
