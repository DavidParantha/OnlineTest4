
package org.example;

class DeliveryFactory {

    public static Delivery createDelivery(String id, String type,
                                          String name, double distance) {

        switch (type.toLowerCase()) {

            case "standard":
                return new StandardDelivery(id, name, distance);

            case "express":
                return new ExpressDelivery(id, name, distance);

            case "fragile":
                return new FragileDelivery(id, name, distance);

            default:
                throw new IllegalArgumentException("Invalid delivery type");
        }
    }
}