package returnbike.caculatingmethod;

import returnbike.caculatingmethod.first.FirstCalcElectronicBike;
import returnbike.caculatingmethod.first.FirstCalcTwinBike;
import returnbike.caculatingmethod.first.FirstMethod;
import returnbike.caculatingmethod.first.FirstCalcSingleBike;

import java.util.HashMap;

public class FirstCalculatingMethod implements CalculatingMethod {
    private HashMap<String, FirstMethod> map;

    public FirstCalculatingMethod() {
        map = new HashMap<>();
        map.put("bike", new FirstCalcSingleBike());
        map.put("twinbike", new FirstCalcTwinBike());
        map.put("ebike", new FirstCalcElectronicBike());
    }

    @Override
    public float count(long seconds, String type) {
        if (type==null) return 0;
        type = type.toLowerCase();

        if (map.get(type) == null) return 0;

        return map.get(type).count(seconds);
    }
}
