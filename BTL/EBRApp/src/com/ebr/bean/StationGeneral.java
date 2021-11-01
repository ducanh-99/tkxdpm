package com.ebr.bean;

public class StationGeneral {
    private String id;
    private String name;
    private String address;
    private int numbOfDocks;
    private int numOfVehicle;

    public StationGeneral(){

    }
    public StationGeneral(String id, String name, String address, int numbOfDocks, int numOfVehicle){
        setId(id);
        setAddress(address);
        setName(name);
        setNumbOfDocks(numbOfDocks);
        setNumOfVehicle(numOfVehicle);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumbOfDocks() {
        return numbOfDocks;
    }

    public void setNumbOfDocks(int numbOfDocks) {
        this.numbOfDocks = numbOfDocks;
    }

    public int getNumOfVehicle() {
        return numOfVehicle;
    }

    public void setNumOfVehicle(int numOfVehicle) {
        this.numOfVehicle = numOfVehicle;
    }
}
