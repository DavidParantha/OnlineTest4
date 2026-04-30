package org.example;

import java.io.*;
import java.util.*;

class DeliveryManager {

    private List<Delivery> deliveries = new ArrayList<>();
    private Map<String, Delivery> deliveryMap = new HashMap<>();

    private PriorityQueue<Delivery> queue =
            new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority());

    public void loadFromFile(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                try {
                    String[] parts = line.split(",");

                    String id = parts[0];
                    String type = parts[1];
                    String name = parts[2];
                    double distance = Double.parseDouble(parts[3]);

                    Delivery delivery =
                            DeliveryFactory.createDelivery(id, type, name, distance);

                    deliveries.add(delivery);
                    deliveryMap.put(id, delivery);
                    queue.add(delivery);

                } catch (Exception e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        for (Delivery d : deliveries) {
            System.out.println(d);
        }
    }

    public void sortByCost() {
        deliveries.sort(new CostComparator());
    }

    public void processDeliveries() {
        while (!queue.isEmpty()) {
            Delivery d = queue.poll();
            System.out.println("Processing: " + d.getId());
        }
    }

    public double getTotalRevenue() {
        double total = 0;

        for (Delivery d : deliveries) {
            total += d.calculateCost();
        }

        return total;
    }

    public Map<String, Integer> getDeliveryCountByType() {

        Map<String, Integer> countMap = new HashMap<>();

        for (Delivery d : deliveries) {
            String type = d.getType();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        return countMap;
    }

    public void serialize(String fileName) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(deliveries);
            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Delivery> deserialize(String fileName) {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            deliveries = (List<Delivery>) in.readObject();
            System.out.println("Restored " + deliveries.size() + " deliveries.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return deliveries;
    }
}