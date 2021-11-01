package returnbike.caculatingmethod.second;

/**
 * @author phong.cv173298
 * @created 19/12/2020 - 4:05 PM
 * @project EBRApp
 */
public class SecondCalcSingleBike implements SecondMethod {

    @Override
    public float count(long seconds) {
        float amount = 200000;

        long hours = seconds/3600;

        if (hours == 24) {
            if (hours*3600<seconds) hours++;
        }

        if (hours>=12 && hours<=24) return amount;

        if (hours<12) {
            int sodu = (int) (12 - hours);
            amount -= sodu*10000;
        } else {
            seconds -= 24*3600;

            long minute = seconds/60;
            minute += minute*60<seconds?1:0;

            int sodu = (int) minute/15;
            sodu += sodu*15<minute?1:0;

            amount += sodu*2000;
        }

        return amount;
    }
}
