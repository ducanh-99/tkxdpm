package com.ebr.bean;

public class NumOfABike {
	private int numOfBike;
	private int numOfEBike;
	private int numOfTBike;

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

	public int getNumOfBike() {
		return numOfBike;
	}

	public void setNumOfBike(int numOfBike) {
		this.numOfBike = numOfBike;
	}
	
	public int getTotalVehicles() {
		return this.numOfBike + this.numOfEBike + this.numOfTBike;	
	}
}
