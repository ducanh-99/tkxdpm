package api.crud.station;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebr.bean.Station;

import api.EBRConnect;
import api.inteface.IEBRApiGet;

public class EBRGetStationApi extends EBRConnect implements IEBRApiGet {
	private static EBRGetStationApi instance;


	private EBRGetStationApi() {
		super();
	}

	public static synchronized EBRGetStationApi getInstance() {
		if (instance == null)
			instance = new EBRGetStationApi();
		return instance;
	}

	public ArrayList<Station> getStations(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("stations");

		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.accept("application/json").get();
		ArrayList<Station> res = response.readEntity(new GenericType<ArrayList<Station>>() {
		});
		System.out.println(res);
		return res;
	}

}
