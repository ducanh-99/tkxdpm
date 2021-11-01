package test.station.gui;

import abstractdata.controller.IDataManageController;
import com.ebr.bean.Station;
import org.junit.Test;
import org.junit.runners.Parameterized;
import station.gui.StationEditDialog;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class TestValidateInputWhiteBox {
    private StationEditDialog stationEditDialog;
    private boolean expectedResult;

    public TestValidateInputWhiteBox(String name, String address, String numOfDocks, boolean expectedResult) {
        this.stationEditDialog = new StationEditDialog(new Station(), new IDataManageController<Station>() {
            @Override
            public void onAct(Station station) {

            }
        });
        this.stationEditDialog.getNameField().setText(name);
        this.stationEditDialog.getAddressField().setText(address);
        this.stationEditDialog.getNumOfDocksField().setText(numOfDocks);

        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                {"A", "B", "1", true},
                {"A", "B", null, false},
                {null, "B", "1", false},
                {"A", null, "1", false},
                {"A", "B", "0", false},
        });
    }

    @Test
    public void testValidateInput() {
        Object res = stationEditDialog.validateInput();
        assertEquals("error", expectedResult, res);
    }
}
