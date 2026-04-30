package org.example;

public class StandardDelivery extends Delivery {

    public StandardDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    public double calculateCost() {
        return distance * 5;
    }

    public int getPriority() {
        return 1;
    }
}