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
            Expression expression = new Expression("5+ 2 +1");
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

        @Test
        public void withLongExpression_returnsCorrectNumber() {
            Expression expression = new Expression("1+1+2--3-2*2/1+1+2--3-2*2+1+1+2--3-2*2");
            Double result = expression.getResult();
            Assert.assertEquals(737, result, 0);
        }

        @Test
        public void withDecimalNumbers_returnsCorrectNumber() {
            Expression expression = new Expression("345.03*200.1102/2.3+123");
            Double result = expression.getResult();
            Assert.assertEquals(551.029707150838, result, 0);
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

    public static class getSteps {
        @Test
        public void withSimpleExpression_returnsCorrectString() {
            Expression expression = new Expression("(5 * 2) * 1");
            String result = expression.getSteps();
            Assert.assertEquals("5 * 2 = 10\n" +
                    "10 * 1 = 10\n", result);
        }

        @Test
        public void expressionWithNegativeNumber_returnsCorrectString() {
            Expression expression = new Expression("1--1");
            String result = expression.getSteps();
            Assert.assertEquals("1 - -1 = 2\n", result);
        }
    }

    public static class getAllExprStr{
        @Test
        public void simpleExpression_returnsCorrectString() {
            Expression expression = new Expression("(5 * 2) * 1");
            String result = expression.getAllExprStr();
            Assert.assertEquals("(5 * 2) * 1\n" +
                    "10.0 * 1\n" +
                    "10\n", result);
        }
        @Test
        public void expressionWithOnlyOneNumber_returnsCorrectString() {
            Expression expression = new Expression("2");
            String result = expression.getAllExprStr();
            Assert.assertEquals("2\n", result);
        }
    }
}