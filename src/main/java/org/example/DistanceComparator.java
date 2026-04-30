package org.example;

import java.util.Comparator;

class DistanceComparator implements Comparator<Delivery> {

    @Override
    public int compare(Delivery d1, Delivery d2) {
        return Double.compare(d1.getDistance(), d2.getDistance());
    }
}