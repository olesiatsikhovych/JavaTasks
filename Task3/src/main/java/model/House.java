package model;

import java.util.ArrayList;

public abstract class House {
    private int priceOfRent;
    private int distanceToKindergarten;
    private int distanceToSchool;
    private int dinstanceToPlayground;



    public int getPriceOfRent() {
        return priceOfRent;
    }

    public void setPriceOfRent(int priceOfRent) {
        this.priceOfRent = priceOfRent;
    }

    public int getDistanceToKindergarten() {
        return distanceToKindergarten;
    }

    public void setDistanceToKindergarten(int distanceToKindergarten) {
        this.distanceToKindergarten = distanceToKindergarten;
    }

    public int getDistanceToSchool() {
        return distanceToSchool;
    }

    public void setDistanceToSchool(int distanceToSchool) {
        this.distanceToSchool = distanceToSchool;
    }

    public int getDinstanceToPlayground() {
        return dinstanceToPlayground;
    }

    public void setDinstanceToPlayground(int dinstanceToPlayground) {
        this.dinstanceToPlayground = dinstanceToPlayground;
    }

}
