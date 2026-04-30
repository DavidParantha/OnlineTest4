package org.example;

public abstract class Delivery implements Trackable {
    protected String id;
    protected String name;
    protected double distance;
    protected Status status;
    public Delivery(String id, String name, double distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.status = Status.CREATED;
    }
    public abstract double calculateCost();
    public abstract int getPriority();
    public void updateStatus(String s) {
        status = Status.valueOf(s);
    }
    public String getStatus() {
        return status.name();
    }
    public String toString() {
        return id + " | Cost: " + calculateCost() +
                " | Priority: " + getPriority() +
                " | Status: " + status;
    }
}