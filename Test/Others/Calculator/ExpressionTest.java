package Others.Calculator;

import Others.Calculator.exceptions.ExpressionFormatException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by dieterbiedermann on 26.10.16.
 */
@RunWith(Enclosed.class)
public class ExpressionTest {

    /**
     * Test: getResult
     */
    public static class getResult {
        @Test
        public void withSimpleMulitilication_returnsCorrectNumber() {
            Expression expression = new Expression("5 * 2");
            Double result = expression.getResult();
            Assert.assertEquals(10, result, 0);
        }

        @Test
        public void withSimpleDivision_returnsCorrectNumber() {
            Expression expression = new Expression("5 / 2");
            Double result = expression.getResult();
            Assert.assertEquals(2.5, result, 0);
        }

        @Test
        public void withSimpleAddition_returnsCorrectNumber() {
            Expression expression = new Expression("5 + 2");
            Double result = expression.getResult();
            Assert.assertEquals(7, result, 0);
        }

        @Test
        public void withSimpleSubtraction_returnsCorrectNumber() {
            Expression expression = new Expression("5 - 2");
            Double result = expression.getResult();
            Assert.assertEquals(3, result, 0);
        }

        @Test
        public void withSimpleAdditionWithNegativeNumber_returnsCorrectNumber() {
            Expression expression = new Expression("5 + -2");
            Double result = expression.getResult();
            Assert.assertEquals(3, result, 0);
        }

        @Test
        public void withSimpleAdditionWithNegativeNumberFirst_returnsCorrectNumber() {
            Expression expression = new Expression("-5 + 2");
            Double result = expression.getResult();
            Assert.assertEquals(-3, result, 0);
        }

        @Test
        public void withMultipleAdditions_returnsCorrectNumber() {
            Expression expression = new Expression("5 + 2 + 1");
            Double result = expression.getResult();
            Assert.assertEquals(8, result, 0);
        }

        @Test
        public void withSimpleBrackets_returnsCorrectNumber() {
            Expression expression = new Expression("((5 + 2) * 2) + (4 - 2)");
            Double result = expression.getResult();
            Assert.assertEquals(16, result, 0);
        }

        @Test
        public void withMultipleBrackets_returnsCorrectNumber() {
            Expression expression = new Expression("(5 + 2) + (4 - 2)");
            Double result = expression.getResult();
            Assert.assertEquals(9, result, 0);
        }

        @Test
        public void withNestedBrackets_returnsCorrectNumber() {
            Expression expression = new Expression("((5 + 2) * 2) + (4 - 2) / 2 * (2 + 3)");
            Double result = expression.getResult();
            Assert.assertEquals(75, result, 0);
        }

        @Test
        public void withMultipleOperations_returnsCorrectNumber() {
            Expression expression = new Expression("5 + 2 + 2 * 2 - 3");
            Double result = expression.getResult();
            Assert.assertEquals(8, result, 0);
        }

        @Test
        public void withNegativeNumbers_returnsCorrectNumber() {
            Expression expression = new Expression("5 + -2 + 2 * -2 - 3");
            Double result = expression.getResult();
            Assert.assertEquals(-4, result, 0);
        }
    }

    public static class toString {
        @Test
        public void withSimpleExpression_returnsCorrectString() {
            Expression expression = new Expression("(5 * 2) * 1");
            String result = expression.toString();
            Assert.assertEquals("(5 * 2) * 1 = 10", result);
        }

        @Test
        public void withInvalidExpression_returnsExceptionParentheses() {
            try {
                Expression expression = new Expression("(5 * 2( * 1");
                Assert.fail("No exception thrown");
            } catch (IllegalArgumentException ex) {
                // check message
                Assert.assertEquals("uneven number of parentheses in expression", ex.getMessage());
            }
        }
    }
}