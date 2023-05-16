package model;

import model.House;

import java.util.Random;

public class Penthouses extends House {
    public Penthouses(){
        Random random = new Random();
        setPriceOfRent((random.nextInt(5) + 2) * 100);
        setDistanceToKindergarten((random.nextInt(12) + 2) + 100);
        setDistanceToSchool((random.nextInt(9) + 2) * 100);
        setDinstanceToPlayground((random.nextInt(6) + 2) * 100);
    }
    @Override
    public String toString() {
        return "Penthouse: " +
                "priceOfRent = " + getPriceOfRent() +
                "$, distanceToKindergarten = " + getDistanceToKindergarten() +
                ", distanceToSchool = " + getDistanceToSchool() +
                ", dinstanceToPlayground = " + getDinstanceToPlayground();
    }
}
