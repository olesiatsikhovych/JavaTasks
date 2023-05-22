package model;

import java.util.LinkedList;

public interface Model {
    LinkedList<House> getHouseList();
    LinkedList<House> sortHousesByPrice(int maximumPrice);
    LinkedList<House> sortHousesByDistanceToKindergarten(int maximumDisToKindergarten);
    LinkedList<House> sortHousesByDistanceToSchool(int maximumDisToSchool);
    LinkedList<House> sortHousesByDistanceToPlayground( int maximumDisToPlaydround);

}
