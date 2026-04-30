package org.example;

import java.util.*;
public class MainApp {
    public static void main(String[] args) {
        List<Delivery> list = new ArrayList<>();

        list.add(new StandardDelivery("D101",   "John", 12.5));
         list.add(new ExpressDelivery("D102", "Alice", 10.0));
        list.add(new FragileDelivery("D103", "Bob", 8.0));

        for (Delivery d : list) {
            System.out.println(d);
        }
    }
}