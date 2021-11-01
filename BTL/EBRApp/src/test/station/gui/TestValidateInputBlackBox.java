package test.station.gui;

import abstractdata.controller.IDataManageController;
import com.ebr.bean.Station;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import station.gui.StationEditDialog;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestValidateInputBlackBox {
    private StationEditDialog stationEditDialog;
    private boolean expectedResult;

    public TestValidateInputBlackBox(String name, String address, String numOfDocks, boolean expectedResult) {
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
        StringBuilder string15Chars = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            string15Chars.append("a");
        }

        StringBuilder string16Chars = new StringBuilder();
        for (int i = 1; i <= 16; i++) {
            string16Chars.append("a");
        }

        StringBuilder string100Chars = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            string100Chars.append("a");
        }

        StringBuilder string101Chars = new StringBuilder();
        for (int i = 1; i <= 101; i++) {
            string101Chars.append("a");
        }

        return Arrays.asList(new Object[][] {
                {"A", "B", "1", true},
                {null, "B", "1", false},
                {string15Chars, "B", "1", true},
                {string16Chars, "B", "1", false},
                {"A", null, "1", false},
                {"A", string100Chars, "1", true},
                {"A", string101Chars, "1", true},
                {"A", "B", "0", false},
        });
    }

    @Test
    public void testValidateInput() {
        Object res = stationEditDialog.validateInput();
        assertEquals("error", expectedResult, res);
    }
}
