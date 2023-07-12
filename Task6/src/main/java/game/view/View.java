package game.view;


import game.model.Door;
import game.model.Room;

import java.util.List;

public class View {
    Room room =new Room();

    public void printDoors(){
        System.out.println("Двері і їхній вміст: ");
        System.out.println(room.describeDoors());
    }

    public void printDeadDoorsCount(){
        System.out.println("Кількість дверей, де можуть вбити героя: " + room.countDeadlyDoors());
    }

    public void printSafeDoorOrder(){
        if (!room.getSafeDoorOrder().isEmpty()) {
            System.out.println("Порядок відкривання дверей, щоб герой вижив: " + room.getSafeDoorOrder());
        }
        else {
            System.out.println("Герой помер");
        }
    }
}

