package org.example;

class FragileDelivery extends Delivery {

    public FragileDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    @Override
    public double calculateCost() {
        return distance * 8 + 100;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}