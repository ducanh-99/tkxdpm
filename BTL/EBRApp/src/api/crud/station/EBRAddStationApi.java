package api.crud.station;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.ebr.bean.Station;

import api.EBRConnect;
import api.inteface.IEBRApiAdd;

public class EBRAddStationApi extends EBRConnect implements IEBRApiAdd<Station> {
	private static EBRAddStationApi instance;

	private EBRAddStationApi() {
		super();
	}

	public static synchronized EBRAddStationApi getInstance() {
		if (instance == null)
			instance = new EBRAddStationApi();
		return instance;
	}

	@Override
	public void add(Station station) {
		WebTarget webTarget = client.target(PATH).path("stations");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		System.out.println("test");
		invocationBuilder.post(Entity.entity(station, MediaType.APPLICATION_JSON));
	}
}
