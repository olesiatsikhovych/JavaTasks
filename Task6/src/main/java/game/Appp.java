package game;

import game.view.View;

public class Appp {
    public static void main(String[] args) {
        View view = new View();

        view.printDoors();
        view.printDeadDoorsCount();
        view.printSafeDoorOrder();
    }
}
