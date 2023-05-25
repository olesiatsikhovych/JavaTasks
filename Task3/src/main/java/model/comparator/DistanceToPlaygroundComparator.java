package model.comparator;

import model.House;

import java.util.Comparator;

public class DistanceToPlaygroundComparator implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        return Integer.compare(o1.getDinstanceToPlayground(), o2.getDinstanceToPlayground());
    }
}
