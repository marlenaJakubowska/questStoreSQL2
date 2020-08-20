package com.codecool.queststore.model;

public class Order {
    private int id;
    private int student_id;
    private int reward_id;
    private OrderStatus orderStatus;

    public Order(int id, int student_id, int reward_id, OrderStatus orderStatus) {
        this.id = id;
        this.student_id = student_id;
        this.reward_id = reward_id;
        this.orderStatus = orderStatus;
    }
    public Order(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getReward_id() {
        return reward_id;
    }

    public void setReward_id(int reward_id) {
        this.reward_id = reward_id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", reward_id=" + reward_id +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
