package Others.Calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dieterbiedermann on 27.10.16.
 */
public class SubtractionTest {
    @Test
    public void getResultReturns10For13And3() throws Exception {
        double[] operands = new double[] {13,3};
        Subtraction subtraction = new Subtraction(operands);
        double result = subtraction.getResult();
        Assert.assertEquals(10, result, 1);
    }

}