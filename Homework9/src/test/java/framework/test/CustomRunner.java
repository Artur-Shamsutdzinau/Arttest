package framework.test;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

public class CustomRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener(new MyTestListener());

        final XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("testconfig.xml");
        xmlSuite.setSuiteFiles(
                new ArrayList<String>() {{
                    add("./src/test/resources/suites/testconfig.xml");
                }}
        );
        testNG.setXmlSuites(new ArrayList<XmlSuite>() {{
            add(xmlSuite);
        }});
        testNG.run();
    }
}
