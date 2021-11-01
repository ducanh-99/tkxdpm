package test.bikedetail;

import api.EBRApi;
import com.ebr.bean.Bike;

import java.util.*;;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestBikeSearchWhiteBox {
    private int expectedResult;
    private Map<String, String> params;

    public TestBikeSearchWhiteBox(Map<String, String> params, int expectedResult){
        super();
        this.params = params;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {

        Map<String, String> params7 = new HashMap<>();
        params7.put("id", "0");
        params7.put("type", "bike");

        Map<String, String> params8 = new HashMap<>();
        params8.put("id", "0");
        params8.put("status", "avaiable");

        Map<String, String> params9 = new HashMap<>();
        params9.put("name", "honda");

        return Arrays.asList(new Object[][] {
                {params7, 0},
                {params8, 0},
                {params9, 0},
        });
    }

    @Test
    public void testBikeSearch(){
        EBRApi api = new EBRApi();
        List<? extends Bike> list = api.searchBikes(this.params, 1);
        Assert.assertEquals(expectedResult, list.size(), 0.0);
    }
}
