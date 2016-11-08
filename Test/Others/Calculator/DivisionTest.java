package Others.Calculator;

import com.sun.org.apache.xpath.internal.operations.Div;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dieterbiedermann on 27.10.16.
 */
public class DivisionTest {
    @Test
    public void getResultReturns10For20And2() throws Exception {
        double[] operands = new double[] {20,2};
        Division division = new Division(operands);
        double result = division.getResult();
        Assert.assertEquals(10, result, 0);
    }

    @Test
    public void getResultReturns10For100And2And5() throws Exception {
        double[] operands = new double[] {100,2,5};
        Division division = new Division(operands);
        double result = division.getResult();
        Assert.assertEquals(10, result, 0);
    }
}