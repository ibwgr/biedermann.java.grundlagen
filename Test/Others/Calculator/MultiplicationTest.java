package Others.Calculator;

import Buch.Kapitel9.Aufgabe914.Mahlzeit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dieterbiedermann on 27.10.16.
 */
public class MultiplicationTest {
    @Test
    public void getResultReturns10For5And2() throws Exception {
        double[] operands = new double[] {5,2};
        Multiplication multiplication = new Multiplication(operands);
        double result = multiplication.getResult();
        Assert.assertEquals(10, result, 1);
    }

}