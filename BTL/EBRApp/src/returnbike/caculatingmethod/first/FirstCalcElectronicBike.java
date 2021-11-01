package returnbike.caculatingmethod.first;

/**
 * @author phong.cv173298
 * @created 19/12/2020 - 3:55 PM
 * @project EBRApp
 */
public class FirstCalcElectronicBike implements FirstMethod {
    @Override
    public float count(long seconds) {
        return new FirstCalcSingleBike().count(seconds)*1.5f;
    }
}
