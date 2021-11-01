package com.ebr.bean;

public class Station extends StationGeneral{
	private int numOfBike;
	private int numOfEBike;
	private int numOfTBike;

	public Station() {
		super();
	}

	

	public Station(String id, String name, String address, int numbOfDocks, int numOfVehicle, int numOfBike,
			int numOfEBike, int numOfTBike) {
		super(id, name, address,numbOfDocks,numOfVehicle);
		this.numOfBike = numOfBike;
		this.numOfEBike = numOfEBike;
		this.numOfTBike = numOfTBike;
	}

	public int getNumOfBike() {
		return numOfBike;
	}

	public void setNumOfBike(int numOfBike) {
		this.numOfBike = numOfBike;
	}

	public int getNumOfEBike() {
		return numOfEBike;
	}

	public void setNumOfEBike(int numOfEBike) {
		this.numOfEBike = numOfEBike;
	}

	public int getNumOfTBike() {
		return numOfTBike;
	}

	public void setNumOfTBike(int numOfTBike) {
		this.numOfTBike = numOfTBike;
	}
}
