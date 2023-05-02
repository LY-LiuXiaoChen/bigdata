package com.cj.flightmanager.domain;

public class Order {
    private int orderId;    //订单id
    private int flightId;   // 航班id
    private int userId;     // 用户id
    private int orderStatus;    // 订单状态

    public Order() {
    }

    public Order(int orderId, int flightId, int userId, int orderStatus) {
        this.orderId = orderId;
        this.flightId = flightId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", flightId=" + flightId +
                ", userId=" + userId +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
