package returnbike.caculatingmethod.first;

/**
 * @author phong.cv173298
 * @created 19/12/2020 - 3:54 PM
 * @project EBRApp
 */
public class FirstCalcSingleBike implements FirstMethod {
    @Override
    public float count(long seconds) {
        if (seconds<600) return 0;

        float amount = 10000f;
        float minute = seconds/60.0f;
        if (minute<=30) return amount;

        minute-=30;

        int sodu = (int) (minute%15==0?minute/15:(minute/15+1));

        amount+=sodu*3000;

        return amount;
    }
}
