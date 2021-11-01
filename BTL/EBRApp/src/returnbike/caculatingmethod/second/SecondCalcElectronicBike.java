package returnbike.caculatingmethod.second;

/**
 * @author phong.cv173298
 * @created 19/12/2020 - 4:50 PM
 * @project EBRApp
 */
public class SecondCalcElectronicBike implements SecondMethod {
    @Override
    public float count(long second) {
        return new SecondCalcSingleBike().count(second)*1.5f;
    }
}
