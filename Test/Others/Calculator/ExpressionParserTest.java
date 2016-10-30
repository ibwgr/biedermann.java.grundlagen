package Others.Calculator;

import Others.Calculator.exceptions.ExpressionFormatException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Created by dieterbiedermann on 29.10.16.
 */
@RunWith(Enclosed.class)
public class ExpressionParserTest {

    /**
     * Test: getResult
     */
    public static class getFirstParenthesis {
        @Test
        public void returnsWithResult() throws Exception {
            String result = ExpressionParser.getFirstParentheses("(test(hello))(world)");
            Assert.assertEquals("test(hello)", result);
        }

        @Test
        public void returnsEmpty() throws Exception {
            String result = ExpressionParser.getFirstParentheses("5 + 3");
            Assert.assertEquals("", result);
        }
    }

    public static class validate {
        @Test
        public void returnsExceptionWithUnevenParenthesis() throws Exception {
            try {
                Boolean result = ExpressionParser.validate("(1 + 2) * (3 / 5");
                Assert.fail("No Exception was thrown");
            } catch (ExpressionFormatException ex) {
                Assert.assertEquals("uneven number of parentheses in expression", ex.getMessage());
            }
        }
        @Test
        public void returnsExceptionWithWrongCharacter() throws Exception {
            try {
                Boolean result = ExpressionParser.validate("(1 plus 2) * 3 / 5");
                Assert.fail("No Exception was thrown");
            } catch (ExpressionFormatException ex) {
                Assert.assertEquals("wrong characters in expression", ex.getMessage());
            }
        }
        @Test
        public void returnsExceptionWithWrongOrder() throws Exception {
            try {
                Boolean result = ExpressionParser.validate("(1 ++ 2) ** 3 / 5");
                Assert.fail("No Exception was thrown");
            } catch (ExpressionFormatException ex) {
                Assert.assertEquals("wrong order of operators in expression", ex.getMessage());
            }
        }
        @Test
        public void returnsTrueWithCorrectExpression() throws Exception {
            Boolean result = ExpressionParser.validate("(1 + 2) * 3 / 5");
            Assert.assertTrue(result);
        }
        @Test
        public void returnsTrueWithCorrectExpressionNegativeNumber() throws Exception {
            Boolean result = ExpressionParser.validate("(1 + 2) * 3 - -5");
            Assert.assertTrue(result);
        }
    }
}