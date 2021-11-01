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
 * @created 21/12/2020 - 11:01 PM
 * @project EBRApp
 */
@RunWith(value = Parameterized.class)
public class FirstCalcMethodBlackBoxTest {
    private String type;
    private long seconds;
    private float expectedResult;

    public FirstCalcMethodBlackBoxTest(String type, long seconds, float expectedResult) {
        this.type = type;
        this.seconds = seconds;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "Bike", -1, 0f },//0
                { "Bike", 0, 0f },//1
                { "Bike", 1, 0f },//2
                { "Bike", 599, 0f },//3
                { "Bike", 600, 10000f },//4
                { "Bike", 601, 10000f },//5
                { "Bike", 1799, 10000f },//6
                { "Bike", 1800, 10000f },//7
                { "Bike", 1801, 13000f },//8
                { "Bike", 2699, 13000f },//9
                { "Bike", 2700, 13000f },//10
                { "Bike", 2701, 16000f },//11
                { "TwinBike", -1, 0f },//12
                { "TwinBike", 0, 0f },//13
                { "TwinBike", 1, 0f },//14
                { "TwinBike", 599, 0f },//15
                { "TwinBike", 600, 15000f },//16
                { "TwinBike", 601, 15000f },//17
                { "TwinBike", 1799, 15000f },//18
                { "TwinBike", 1800, 15000f },//19
                { "TwinBike", 1801, 19500f },//20
                { "TwinBike", 2699, 19500f },//21
                { "TwinBike", 2700, 19500f },//22
                { "TwinBike", 2701, 24000f },//23
                { "EBike", -1, 0f },//24
                { "EBike", 0, 0f },//25
                { "EBike", 1, 0f },//26
                { "EBike", 599, 0f },//27
                { "EBike", 600, 15000f },//28
                { "EBike", 601, 15000f },//29
                { "EBike", 1799, 15000f },//30
                { "EBike", 1800, 15000f },//31
                { "EBike", 1801, 19500f },//32
                { "EBike", 2699, 19500f },//33
                { "EBike", 2700, 19500f },//34
                { "EBike", 2701, 24000f },//35
                { "SomeBike", 1, 0f},//36
        });
    }

    @Test
    public void testAmount() {
        CalculatingMethod method = new FirstCalculatingMethod();
        Assert.assertTrue("fail: "+method.count(seconds, type)+"<>"+expectedResult+"::"+seconds, method.count(seconds, type)==expectedResult);
    }
}
