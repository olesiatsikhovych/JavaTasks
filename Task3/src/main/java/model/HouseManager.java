package model;

import model.comparator.DistanceToKindergartenComparator;
import model.comparator.DistanceToPlaygroundComparator;
import model.comparator.DistanceToSchoolComparator;
import model.comparator.PriceComparator;

import java.util.*;


public class HouseManager  {
    LinkedList<House> houseList = new LinkedList<>();

    public HouseManager() {
        fillHouseList();
    }

    public LinkedList<House> getHouseList() {
        return houseList;
    }

    public LinkedList<House> sortHousesByPrice(int maximumPrice) {
        LinkedList<House> sortedHouses = new LinkedList<>();
        for (House house : houseList){
             if(house.getPriceOfRent() <= maximumPrice){
             sortedHouses.add(house);
    }
         PriceComparator priceComparator = new PriceComparator();
         sortedHouses.sort(priceComparator);
}
        return sortedHouses;
    }

    public LinkedList<House> sortHousesByDistanceToKindergarten(int maximumDisToKindergarten){
        LinkedList<House> sortedHouses = new LinkedList<>();
        for (House house : houseList){
            if (house.getDistanceToKindergarten() <= maximumDisToKindergarten){
                sortedHouses.add(house);
            }
            DistanceToKindergartenComparator distanceToKindergartenComparator = new DistanceToKindergartenComparator();
            sortedHouses.sort(distanceToKindergartenComparator);
        }
        return sortedHouses;
    }

    public LinkedList<House> sortHousesByDistanceToSchool(int maximumDisToSchool){
        LinkedList<House> sortedHouses = new LinkedList<>();
        for (House house : houseList){
            if (house.getDistanceToSchool() <= maximumDisToSchool){
                sortedHouses.add(house);
            }
            DistanceToSchoolComparator distanceToSchoolComparator = new DistanceToSchoolComparator();
            sortedHouses.sort(distanceToSchoolComparator);
        }
        return sortedHouses;
    }

    public LinkedList<House> sortHousesByDistanceToPlayground( int maximumDisToPlaydround){
        LinkedList<House> sortedHouses = new LinkedList<>();
        for (House house : houseList){
            if(house.getDinstanceToPlayground() <= maximumDisToPlaydround){
                sortedHouses.add(house);
            }
            DistanceToPlaygroundComparator distanceToPlaygroundComparator = new DistanceToPlaygroundComparator();
            sortedHouses.sort(distanceToPlaygroundComparator);
        }
        return sortedHouses;
    }


    private void fillHouseList() {
        for (int i = 0; i < 5; i++) {
            houseList.add(new Apartments());
            houseList.add(new Mansions());
            houseList.add(new Penthouses());
        }
    }
}
