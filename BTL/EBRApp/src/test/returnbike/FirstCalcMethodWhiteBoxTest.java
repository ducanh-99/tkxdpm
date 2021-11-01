package test.returnbike;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import returnbike.caculatingmethod.CalculatingMethod;
import returnbike.caculatingmethod.FirstCalculatingMethod;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author phong.cv173298
 * @created 22/12/2020 - 9:03 AM
 * @project EBRApp
 */
@RunWith(value = Parameterized.class)
public class FirstCalcMethodWhiteBoxTest {
    private String type;
    private long seconds;
    private float expectedResult;

    public FirstCalcMethodWhiteBoxTest(String type, long seconds, float expectedResult) {
        this.type = type;
        this.seconds = seconds;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                {null, 600, 0},
                {"SomeBike", 600, 0},
                {"Bike", 600, 10000}
        });
    }

    @Test
    public void testAmount() {
        CalculatingMethod method = new FirstCalculatingMethod();
        Assert.assertTrue("fail: "+method.count(seconds, type)+"<>"+expectedResult+"::"+seconds, method.count(seconds, type)==expectedResult);
    }
}
