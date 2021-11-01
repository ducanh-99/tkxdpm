package com.ebr.bean;

import java.util.Date;

public class ABike {

	private String id;
	private String stationID;
	private String name;
	private int cost;
	private String licensePlate;
	private String producer;
	private Float weight;
	private Date manufacturingDate;
	private String status;

	public ABike() {

	}

	public ABike(String id,String stationID, String name, int cost, String licensePlate, String producer, Float weight,
			Date manufacturingDate, String status) {
		this.stationID = stationID;
		this.id=id;
		this.name = name;
		this.cost = cost;
		this.licensePlate = licensePlate;
		this.producer = producer;
		this.weight = weight;
		this.manufacturingDate = manufacturingDate;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
