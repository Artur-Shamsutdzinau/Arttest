package com.epam.as;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Artur_Shamsutdzinau on 1/23/2017.
 */
public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void setup() {
        System.out.println("com.epam.as.CalculatorTest is started");
        calculator = new Calculator();
    }

    @Test(groups = "sum", dataProvider = "test1")
    public void testSum_long(long a, long b) {
        Assert.assertEquals(calculator.sum(a, b), a + b);
    }

    @Test(groups = "sum")
    public void testSum_double() {
        Assert.assertEquals(calculator.sum(4.5, 9.8), 4.5 + 9.8);
    }

    @Test(dependsOnGroups = "sum")
    public void testSub_long() {
        Assert.assertEquals(calculator.sub(17L, 11L), 17L - 11L);
    }

    @Test(dependsOnGroups = "sum")
    public void testSub_double() {
        Assert.assertEquals(calculator.sub(17.32, 11.44), 17.32 - 11.44);
    }

    @Test
    public void testMult_long() {
        Assert.assertEquals(calculator.mult(9L, 10L), 10L * 9L);
    }

    @Test
    public void testMult_double() {
        Assert.assertEquals(calculator.mult(9.7, 1.2), 1.2 * 9.7);
    }

    @Test
    public void testDiv_long() {
        Assert.assertEquals(calculator.div(90L, 13L), 90L / 13L);
    }

    @Test
    public void testDiv_double1() {
        Assert.assertEquals(calculator.div(-4.7, 1.5), -4.7 / 1.5);
    }

    @Test
    public void testDiv_double2() {
        Assert.assertEquals(calculator.div(-4.7, 0), -4.7 / 0);
    }

    @Test
    public void testPow_double() {
        Assert.assertEquals(calculator.pow(3.5, 9.2), Math.pow(3.5, 9.2));
    }

    @Test
    public void testSqrt_positive() {
        Assert.assertEquals(calculator.sqrt(7.8), Math.sqrt(7.8));
    }

    @Test
    public void testSqrt_negative() {
        Assert.assertEquals(calculator.sqrt(-7.8), Math.sqrt(-7.8));
    }

    @Test
    public void testSin() {
        Assert.assertEquals(calculator.sin(5.6), Math.sin(5.6));
    }

    @Test
    public void testCos() {
        Assert.assertEquals(calculator.cos(-3.8), Math.cos(-3.8));
    }

    @Test
    public void testCtg() {
        Assert.assertEquals(calculator.ctg(2.6), 1 / Math.tan(2.8));
    }

    @Test
    public void testTg() {
        Assert.assertEquals(calculator.tg(19.3), Math.tan(19.3));
    }

    @Test
    public void testIsPositive_positive() {
        Assert.assertTrue(calculator.isPositive(17L));
    }

    @Test
    public void testIsPositive_zero() {
        Assert.assertFalse(calculator.isPositive(0L));
    }

    @Test
    public void testIsPositive_negative() {
        Assert.assertFalse(calculator.isPositive(-15L));
    }

    @Test
    public void testIsNegative_positive() {
        Assert.assertTrue(calculator.isNegative(-17L));
    }

    @Test
    public void testIsNegative_zero() {
        Assert.assertFalse(calculator.isNegative(0L));
    }

    @Test
    public void testIsNegative_negative() {
        Assert.assertFalse(calculator.isNegative(35L));
    }

    @Test(expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "Attempt to divide by zero")
    public void testDiv_long_exc() {
        calculator.div(4L, 0);
    }

    @AfterClass
    public void teardown() {
        System.out.println("com.epam.as.CalculatorTest is finished");
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {5L, 4L},
                {10L, 20L},
        };
    }
}
