package returnbike.caculatingmethod;

import returnbike.caculatingmethod.second.SecondCalcElectronicBike;
import returnbike.caculatingmethod.second.SecondCalcSingleBike;
import returnbike.caculatingmethod.second.SecondCalcTwinBike;
import returnbike.caculatingmethod.second.SecondMethod;

import java.util.HashMap;

public class SecondCalculatingMethod implements CalculatingMethod {
    private HashMap<String, SecondMethod> map;

    public SecondCalculatingMethod() {
        map = new HashMap<>();
        map.put("bike", new SecondCalcSingleBike());
        map.put("twinbike", new SecondCalcTwinBike());
        map.put("ebike", new SecondCalcElectronicBike());
    }
    @Override
    public float count(long seconds, String type) {
        if (type==null) return 0;
        type = type.toLowerCase();

        if (map.get(type) == null) return 0;

        return map.get(type).count(seconds);
    }
}
