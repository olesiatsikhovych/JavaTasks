package model.comparator;

import model.House;

import java.util.Comparator;

public class DistanceToSchoolComparator implements Comparator<House> {

    @Override
    public int compare(House o1, House o2) {
        return Integer.compare(o1.getDistanceToSchool(), o2.getDistanceToSchool()) ;
    }
}
