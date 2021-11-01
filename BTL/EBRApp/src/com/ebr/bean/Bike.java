package com.ebr.bean;

import java.util.Date;

public class Bike extends ABike {
	private String type;

	public Bike() {
		super();
	}

	public Bike(String id,String stationID, String name, int cost, String licensePlate, String producer, Float weight,
			Date manufacturingDate, String status , String type) {
		super();
		this.type=type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
