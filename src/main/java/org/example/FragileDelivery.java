package org.example;

public class FragileDelivery extends Delivery {

    public FragileDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    public double calculateCost() {
        return distance * 8 + 100;
    }

    public int getPriority() {
        return 2;
    }
}