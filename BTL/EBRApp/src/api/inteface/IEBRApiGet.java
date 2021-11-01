package api.inteface;

import java.util.ArrayList;
import java.util.Map;

import com.ebr.bean.Station;

public interface IEBRApiGet {
	public ArrayList<Station> getStations(Map<String, String> queryParams);
}
