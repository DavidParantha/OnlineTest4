package org.example;

public class ExpressDelivery extends Delivery {

    public ExpressDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    public double calculateCost() {
        return distance * 10 + 50;
    }

    public int getPriority() {
        return 3;
    }
}