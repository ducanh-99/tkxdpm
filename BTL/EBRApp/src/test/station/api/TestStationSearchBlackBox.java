package test.station.api;

import api.EBRApi;
import com.ebr.bean.StationGeneral;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class TestStationSearchBlackBox {
    private int expectedResult; //check so phan tu trong list
    private Map<String, String> params;

    public TestStationSearchBlackBox (Map<String, String> params, int expectedResult) {
        super();
        this.params = params;
        this.expectedResult = expectedResult;
    }
    //	String productId, String productTitle, int productQuantity, float productCost, float weight
    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {

        Map<String,String> params0 = new HashMap<>();
        params0.put("id","");

        Map<String,String> params1 = new HashMap<>();
        params1.put("id", "1");
        params1.put("name","");
        params1.put("address","");

        Map<String,String> params2 = new HashMap<>();
        params2.put("name", "station");

        Map<String,String> params3 = new HashMap<>();
        params3.put("address", "kinh te quoc dan");


        Map<String,String> params4 = new HashMap<>();
        params4.put("id","1");
        params4.put("name", "station5");

        Map<String,String> params5 = new HashMap<>();
        params5.put("id","1");
        params5.put("address", "kinh te quoc dan5");

        Map<String,String> params6 = new HashMap<>();
        params6.put("name", "station");
        params6.put("address", "kinh te quoc dan");

        Map<String,String> params7 = new HashMap<>();
        params7.put("id","10");
        params7.put("name", "station");
        params7.put("address", "kinh te quoc dan");


        return Arrays.asList(new Object[][] {
                {params0, 4},
                {params1, 1},
                {params2, 4},
                {params3, 4},
                {params4, 0},
                {params5, 0},
                {params6, 4},
                {params7, 0},
        });
    }

    @Test
    public void testStationSearch() {
        EBRApi api = new EBRApi();
        List<? extends StationGeneral> list = api.getStations(this.params);
        Assert.assertEquals(expectedResult, list.size(), 0.0);
    }
}
