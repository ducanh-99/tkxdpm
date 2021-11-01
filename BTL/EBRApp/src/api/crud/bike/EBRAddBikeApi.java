package api.crud.bike;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;
import com.ebr.bean.Station;

import api.EBRConnect;
import api.inteface.IEBRApiAdd;

public class EBRAddBikeApi extends EBRConnect implements IEBRApiAdd<ABike> {
	private static EBRAddBikeApi instance;

	private EBRAddBikeApi() {
		super();
	}

	public static synchronized IEBRApiAdd<ABike> getInstance() {
		if (instance == null)
			instance = new EBRAddBikeApi();
		return instance;
	}

	@Override
	public void add(ABike abike) {
		if(abike instanceof Bike) {
			Bike bike = (Bike) abike;
			WebTarget webTarget = client.target(PATH).path("bike");

	        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	        System.out.println("test");
	        invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
		}
		
	}
}
