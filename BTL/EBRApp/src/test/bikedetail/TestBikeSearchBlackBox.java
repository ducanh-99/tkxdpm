package test.bikedetail;

import api.EBRApi;
import com.ebr.bean.Bike;

import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestBikeSearchBlackBox {
    private int expectedResult;
    private Map<String, String> params;

    public TestBikeSearchBlackBox (Map<String, String> params, int expectedResult){
        super();
        this.params = params;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        Map<String, String> params0 = new HashMap<>();

        Map<String,String> params1 = new HashMap<>();
        params1.put("ID", "1");

        Map<String,String> params2 = new HashMap<>();
        params2.put("ID", "2");

        Map<String,String> params3 = new HashMap<>();
        params3.put("ID", "1");
        params3.put("type", "bike");

        Map<String,String> params4 = new HashMap<>();
        params4.put("ID", "1");
        params4.put("status", "avaiable");

        return Arrays.asList(new Object[][] {
            {params0, 2},
            {params1, 1},
                {params2, 1},
                {params3, 1},
                {params4, 0},
        });
    }

    @Test
    public void testBikeSearch(){
        EBRApi api = new EBRApi();
        List<? extends Bike> list = api.searchBikes(this.params, 1);
        Assert.assertEquals(expectedResult, list.size(), 0.0);
    }
}
