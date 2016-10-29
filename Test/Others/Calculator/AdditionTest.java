package Others.Calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class AdditionTest {

    /**
     * Test: getResult
     */
    @Test
    public void getResultReturns5For2And3() {
        double[] operands = new double[] {2,3};
        Addition addition = new Addition(operands);
        double result = addition.getResult();
        Assert.assertEquals(5, result, 2);
    }

    @Test
    public void getResultReturns10For2And3And5() {
        double[] operands = new double[] {2,3,5};
        Addition addition = new Addition(operands);
        double result = addition.getResult();
        Assert.assertEquals(10, result, 2);
    }

    /**
     * Test: getOperation
     */
    @Test
    public void getOperationReturns2And3For2And3() {
        double[] operands = new double[] {2,3};
        Addition addition = new Addition(operands);
        String result = addition.toString();
        Assert.assertEquals("2 + 3", result);
    }

}