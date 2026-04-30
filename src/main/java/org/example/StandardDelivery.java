
package org.example;

class StandardDelivery extends Delivery {

    public StandardDelivery(String id, String name, double distance) {
        super(id, name, distance);
    }

    @Override
    public double calculateCost() {
        return distance * 5;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}