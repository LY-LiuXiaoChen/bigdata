package com.cj.flightmanager.domain;

import java.util.Date;

public class FlightInformation {
    private int flightId; //  航班号
    private String airplaneModel; //飞机型号
    private String roomClass;  //机舱等级
    private String fromCity;   //起飞城市
    private String toCity;     //目的城市
    private String startTime;    //起飞时间
    private String endTime;      //降落时间
    private double price;       //票价
    private int sumVotes;      //总票数
    private int remainingVotes;    //余票

    public FlightInformation() {
    }

    public FlightInformation(int flightId, String airplaneModel, String roomClass, String fromCity, String toCity, String startTime, String endTime, double price, int sumVotes, int remainingVotes) {
        this.flightId = flightId;
        this.airplaneModel = airplaneModel;
        this.roomClass = roomClass;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.sumVotes = sumVotes;
        this.remainingVotes = remainingVotes;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSumVotes() {
        return sumVotes;
    }

    public void setSumVotes(int sumVotes) {
        this.sumVotes = sumVotes;
    }

    public int getRemainingVotes() {
        return remainingVotes;
    }

    public void setRemainingVotes(int remainingVotes) {
        this.remainingVotes = remainingVotes;
    }

    @Override
    public String toString() {
        return "FlightInformation{" +
                "flightId=" + flightId +
                ", airplaneModel='" + airplaneModel + '\'' +
                ", roomClass='" + roomClass + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", sumVotes=" + sumVotes +
                ", remainingVotes=" + remainingVotes +
                '}';
    }
}
