package model;

import model.House;

import java.util.Random;

public class Mansions extends House {
    public Mansions(){
        Random random = new Random();
        setPriceOfRent((random.nextInt(6) + 2) * 100);
        setDistanceToKindergarten((random.nextInt(10) + 2) * 100);
        setDistanceToSchool((random.nextInt(7) + 2) * 100);
        setDinstanceToPlayground((random.nextInt(3) + 2) * 100);
    }
    @Override
    public String toString() {
        return "Mansion: " +
                "priceOfRent = " + getPriceOfRent() +
                "$, distanceToKindergarten = " + getDistanceToKindergarten() +
                ", distanceToSchool = " + getDistanceToSchool() +
                ", dinstanceToPlayground = " + getDinstanceToPlayground();
    }
}
