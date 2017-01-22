package com.epam.as;

import com.epam.as.test.CalculatorTest;
import org.testng.TestNG;

public class CustomRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener(new MyTestListener());
        testNG.setTestClasses(new Class[]{CalculatorTest.class});
        testNG.run();
    }
}
