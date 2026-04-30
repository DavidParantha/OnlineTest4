package org.example;

class ExpressDelivery extends Delivery {

    public ExpressDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    @Override
    public double calculateCost() {
        return distance * 10 + 50;
    }

    @Override
    public int getPriority() {
        return 3;
    }
}