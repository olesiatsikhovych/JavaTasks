package model;

import model.House;

import java.util.Random;

public class Apartments extends House {
    public Apartments(){
        Random random = new Random();
setPriceOfRent((random.nextInt(8) + 2) * 100);
setDistanceToKindergarten((random.nextInt(5) + 2) * 100);
setDistanceToSchool((random.nextInt(3) + 2) * 100);
setDinstanceToPlayground((random.nextInt(7)+ 2) * 100);
    }
    @Override
    public String toString() {
        return "Apartment: " +
                "priceOfRent = " + getPriceOfRent() +
                "$, distanceToKindergarten = " + getDistanceToKindergarten() +
                ", distanceToSchool = " + getDistanceToSchool() +
                ", dinstanceToPlayground = " + getDinstanceToPlayground();
    }
}
