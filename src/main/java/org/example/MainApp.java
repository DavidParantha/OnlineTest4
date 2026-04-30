package org.example;
public class MainApp {

    public static void main(String[] args) {

        DeliveryManager manager = new DeliveryManager();

        manager.loadFromFile("C:\\Users\\Hemant\\Desktop\\input.txt");

        System.out.println("===== All Deliveries =====");
        manager.printAll();

        System.out.println("\n===== Sorted by Cost =====");
        manager.sortByCost();
        manager.printAll();

        System.out.println("\n===== Processing Queue =====");
        manager.processDeliveries();

        System.out.println("\n===== Revenue =====");
        System.out.println("Total Revenue: " + manager.getTotalRevenue());

        System.out.println("\n===== Delivery Count =====");
        System.out.println(manager.getDeliveryCountByType());

        System.out.println("\n===== Serialization =====");
        manager.serialize("deliveries.ser");

        System.out.println("\n===== Deserialization =====");
        manager.deserialize("deliveries.ser");
    }
}