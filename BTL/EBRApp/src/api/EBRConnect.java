package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class EBRConnect {
//	public static final String PATH = "http://localhost:5000/";
	public static final String PATH = "https://server-ebr.herokuapp.com/";
	protected Client client;

	public EBRConnect() {
		client = ClientBuilder.newClient();
	}
}
