package org.example;

import java.io.Serializable;

abstract class Delivery implements Serializable, Trackable {
    private static final long serialVersionUID = 1L;
    protected String deliveryId;
    protected String customerName;
    protected double distance;
    protected Status status;
    public Delivery(String deliveryId, String customerName, double distance) {
        this.deliveryId = deliveryId;
        this.customerName = customerName;
        this.distance = distance;
        this.status = Status.CREATED;
    }

    public abstract double calculateCost();
    public abstract int getPriority();

    @Override
    public void updateStatus(String newStatus) {
        Status next = Status.valueOf(newStatus);

        if ((status == Status.CREATED && next == Status.IN_TRANSIT) ||
            (status == Status.IN_TRANSIT && next == Status.DELIVERED)) {

            status = next;

        } else {
            throw new IllegalArgumentException("Invalid status transition");
        }
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    public String getId() {
        return deliveryId;
    }

    public double getDistance() {
        return distance;
    }

    public String getType() {
        return this.getClass().getSimpleName().replace("Delivery", "");
    }

    @Override
    public String toString() {
        return deliveryId + " | " + getType() +
               " | Cost: " + calculateCost() +
               " | Priority: " + getPriority() +
               " | Status: " + status;
    }
}